package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaPeriodInfoSequence;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.StandaloneMediaClock;
import com.google.android.exoplayer2.util.TraceUtil;
import java.io.IOException;
final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSource.Listener {
    private int customMessagesProcessed;
    private int customMessagesSent;
    private long elapsedRealtimeUs;
    private Renderer[] enabledRenderers;
    private final Handler eventHandler;
    private final Handler handler;
    private final HandlerThread internalPlaybackThread;
    private boolean isLoading;
    private final LoadControl loadControl;
    private MediaPeriodHolder loadingPeriodHolder;
    private final MediaPeriodInfoSequence mediaPeriodInfoSequence;
    private MediaSource mediaSource;
    private int pendingInitialSeekCount;
    private SeekPosition pendingSeekPosition;
    private final Timeline.Period period;
    private boolean playWhenReady;
    private PlaybackInfo playbackInfo;
    private PlaybackParameters playbackParameters;
    private final ExoPlayer player;
    private MediaPeriodHolder playingPeriodHolder;
    private MediaPeriodHolder readingPeriodHolder;
    private boolean rebuffering;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private MediaClock rendererMediaClock;
    private Renderer rendererMediaClockSource;
    private long rendererPositionUs;
    private final Renderer[] renderers;
    private int repeatMode;
    private final StandaloneMediaClock standaloneMediaClock;
    private int state = 1;
    private Timeline timeline;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;

    public static final class PlaybackInfo {
        public volatile long bufferedPositionUs;
        public final long contentPositionUs;
        public final MediaSource.MediaPeriodId periodId;
        public volatile long positionUs;
        public final long startPositionUs;

        public PlaybackInfo(int i, long j) {
            this(new MediaSource.MediaPeriodId(i), j);
        }

        public PlaybackInfo(MediaSource.MediaPeriodId mediaPeriodId, long j) {
            this(mediaPeriodId, j, -9223372036854775807L);
        }

        public PlaybackInfo(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2) {
            this.periodId = mediaPeriodId;
            this.startPositionUs = j;
            this.contentPositionUs = j2;
            this.positionUs = j;
            this.bufferedPositionUs = j;
        }

        public PlaybackInfo copyWithPeriodIndex(int i) {
            PlaybackInfo playbackInfo = new PlaybackInfo(this.periodId.copyWithPeriodIndex(i), this.startPositionUs, this.contentPositionUs);
            playbackInfo.positionUs = this.positionUs;
            playbackInfo.bufferedPositionUs = this.bufferedPositionUs;
            return playbackInfo;
        }
    }

    public static final class SourceInfo {
        public final Object manifest;
        public final PlaybackInfo playbackInfo;
        public final int seekAcks;
        public final Timeline timeline;

        public SourceInfo(Timeline timeline2, Object obj, PlaybackInfo playbackInfo2, int i) {
            this.timeline = timeline2;
            this.manifest = obj;
            this.playbackInfo = playbackInfo2;
            this.seekAcks = i;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector2, LoadControl loadControl2, boolean z, int i, Handler handler2, PlaybackInfo playbackInfo2, ExoPlayer exoPlayer) {
        this.renderers = rendererArr;
        this.trackSelector = trackSelector2;
        this.loadControl = loadControl2;
        this.playWhenReady = z;
        this.repeatMode = i;
        this.eventHandler = handler2;
        this.playbackInfo = playbackInfo2;
        this.player = exoPlayer;
        this.rendererCapabilities = new RendererCapabilities[rendererArr.length];
        for (int i2 = 0; i2 < rendererArr.length; i2++) {
            rendererArr[i2].setIndex(i2);
            this.rendererCapabilities[i2] = rendererArr[i2].getCapabilities();
        }
        this.standaloneMediaClock = new StandaloneMediaClock();
        this.enabledRenderers = new Renderer[0];
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.mediaPeriodInfoSequence = new MediaPeriodInfoSequence();
        trackSelector2.init(this);
        this.playbackParameters = PlaybackParameters.DEFAULT;
        this.internalPlaybackThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.internalPlaybackThread.start();
        this.handler = new Handler(this.internalPlaybackThread.getLooper(), this);
    }

    public void prepare(MediaSource mediaSource2, boolean z) {
        this.handler.obtainMessage(0, z ? 1 : 0, 0, mediaSource2).sendToTarget();
    }

    public void setPlayWhenReady(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public void seekTo(Timeline timeline2, int i, long j) {
        this.handler.obtainMessage(3, new SeekPosition(timeline2, i, j)).sendToTarget();
    }

    public void stop() {
        this.handler.sendEmptyMessage(5);
    }

    public void sendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        if (this.released) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.customMessagesSent++;
        this.handler.obtainMessage(11, exoPlayerMessageArr).sendToTarget();
    }

    public synchronized void blockingSendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        if (this.released) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        int i = this.customMessagesSent;
        this.customMessagesSent = i + 1;
        this.handler.obtainMessage(11, exoPlayerMessageArr).sendToTarget();
        boolean z = false;
        while (this.customMessagesProcessed <= i) {
            try {
                wait();
            } catch (InterruptedException e) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void release() {
        if (!this.released) {
            this.handler.sendEmptyMessage(6);
            boolean z = false;
            while (!this.released) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    z = true;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            this.internalPlaybackThread.quit();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Listener
    public void onSourceInfoRefreshed(Timeline timeline2, Object obj) {
        this.handler.obtainMessage(7, Pair.create(timeline2, obj)).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(10);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    prepareInternal((MediaSource) message.obj, message.arg1 != 0);
                    return true;
                case 1:
                    setPlayWhenReadyInternal(message.arg1 != 0);
                    return true;
                case 2:
                    doSomeWork();
                    return true;
                case 3:
                    seekToInternal((SeekPosition) message.obj);
                    return true;
                case 4:
                    setPlaybackParametersInternal((PlaybackParameters) message.obj);
                    return true;
                case 5:
                    stopInternal();
                    return true;
                case 6:
                    releaseInternal();
                    return true;
                case 7:
                    handleSourceInfoRefreshed((Pair) message.obj);
                    return true;
                case 8:
                    handlePeriodPrepared((MediaPeriod) message.obj);
                    return true;
                case 9:
                    handleContinueLoadingRequested((MediaPeriod) message.obj);
                    return true;
                case 10:
                    reselectTracksInternal();
                    return true;
                case 11:
                    sendMessagesInternal((ExoPlayer.ExoPlayerMessage[]) message.obj);
                    return true;
                case 12:
                    setRepeatModeInternal(message.arg1);
                    return true;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", e);
            this.eventHandler.obtainMessage(8, e).sendToTarget();
            stopInternal();
            return true;
        } catch (IOException e2) {
            Log.e("ExoPlayerImplInternal", "Source error.", e2);
            this.eventHandler.obtainMessage(8, ExoPlaybackException.createForSource(e2)).sendToTarget();
            stopInternal();
            return true;
        } catch (RuntimeException e3) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e3);
            this.eventHandler.obtainMessage(8, ExoPlaybackException.createForUnexpected(e3)).sendToTarget();
            stopInternal();
            return true;
        }
    }

    private void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.eventHandler.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private void setIsLoading(boolean z) {
        if (this.isLoading != z) {
            this.isLoading = z;
            this.eventHandler.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private void prepareInternal(MediaSource mediaSource2, boolean z) {
        this.eventHandler.sendEmptyMessage(0);
        resetInternal(true);
        this.loadControl.onPrepared();
        if (z) {
            this.playbackInfo = new PlaybackInfo(0, -9223372036854775807L);
        }
        this.mediaSource = mediaSource2;
        mediaSource2.prepareSource(this.player, true, this);
        setState(2);
        this.handler.sendEmptyMessage(2);
    }

    private void setPlayWhenReadyInternal(boolean z) {
        this.rebuffering = false;
        this.playWhenReady = z;
        if (!z) {
            stopRenderers();
            updatePlaybackPositions();
        } else if (this.state == 3) {
            startRenderers();
            this.handler.sendEmptyMessage(2);
        } else if (this.state == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void setRepeatModeInternal(int i) {
        this.repeatMode = i;
        this.mediaPeriodInfoSequence.setRepeatMode(i);
        MediaPeriodHolder mediaPeriodHolder = this.playingPeriodHolder != null ? this.playingPeriodHolder : this.loadingPeriodHolder;
        if (mediaPeriodHolder != null) {
            while (true) {
                int nextPeriodIndex = this.timeline.getNextPeriodIndex(mediaPeriodHolder.info.id.periodIndex, this.period, this.window, i);
                while (mediaPeriodHolder.next != null && !mediaPeriodHolder.info.isLastInTimelinePeriod) {
                    mediaPeriodHolder = mediaPeriodHolder.next;
                }
                if (nextPeriodIndex == -1 || mediaPeriodHolder.next == null || mediaPeriodHolder.next.info.id.periodIndex != nextPeriodIndex) {
                    break;
                }
                mediaPeriodHolder = mediaPeriodHolder.next;
            }
            int i2 = this.loadingPeriodHolder.index;
            int i3 = this.readingPeriodHolder != null ? this.readingPeriodHolder.index : -1;
            if (mediaPeriodHolder.next != null) {
                releasePeriodHoldersFrom(mediaPeriodHolder.next);
                mediaPeriodHolder.next = null;
            }
            mediaPeriodHolder.info = this.mediaPeriodInfoSequence.getUpdatedMediaPeriodInfo(mediaPeriodHolder.info);
            if (!(i2 <= mediaPeriodHolder.index)) {
                this.loadingPeriodHolder = mediaPeriodHolder;
            }
            if (!(i3 != -1 && i3 <= mediaPeriodHolder.index) && this.playingPeriodHolder != null) {
                MediaSource.MediaPeriodId mediaPeriodId = this.playingPeriodHolder.info.id;
                this.playbackInfo = new PlaybackInfo(mediaPeriodId, seekToPeriodPosition(mediaPeriodId, this.playbackInfo.positionUs), this.playbackInfo.contentPositionUs);
            }
        }
    }

    private void startRenderers() {
        this.rebuffering = false;
        this.standaloneMediaClock.start();
        for (Renderer renderer : this.enabledRenderers) {
            renderer.start();
        }
    }

    private void stopRenderers() {
        this.standaloneMediaClock.stop();
        for (Renderer renderer : this.enabledRenderers) {
            ensureStopped(renderer);
        }
    }

    private void updatePlaybackPositions() {
        long j;
        if (this.playingPeriodHolder != null) {
            long readDiscontinuity = this.playingPeriodHolder.mediaPeriod.readDiscontinuity();
            if (readDiscontinuity != -9223372036854775807L) {
                resetRendererPosition(readDiscontinuity);
            } else {
                if (this.rendererMediaClockSource == null || this.rendererMediaClockSource.isEnded()) {
                    this.rendererPositionUs = this.standaloneMediaClock.getPositionUs();
                } else {
                    this.rendererPositionUs = this.rendererMediaClock.getPositionUs();
                    this.standaloneMediaClock.setPositionUs(this.rendererPositionUs);
                }
                readDiscontinuity = this.playingPeriodHolder.toPeriodTime(this.rendererPositionUs);
            }
            this.playbackInfo.positionUs = readDiscontinuity;
            this.elapsedRealtimeUs = SystemClock.elapsedRealtime() * 1000;
            if (this.enabledRenderers.length == 0) {
                j = Long.MIN_VALUE;
            } else {
                j = this.playingPeriodHolder.mediaPeriod.getBufferedPositionUs();
            }
            this.playbackInfo.bufferedPositionUs = j == Long.MIN_VALUE ? this.playingPeriodHolder.info.durationUs : j;
        }
    }

    private void doSomeWork() {
        boolean z;
        boolean z2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        updatePeriods();
        if (this.playingPeriodHolder == null) {
            maybeThrowPeriodPrepareError();
            scheduleNextWork(elapsedRealtime, 10);
            return;
        }
        TraceUtil.beginSection("doSomeWork");
        updatePlaybackPositions();
        this.playingPeriodHolder.mediaPeriod.discardBuffer(this.playbackInfo.positionUs);
        boolean z3 = true;
        boolean z4 = true;
        Renderer[] rendererArr = this.enabledRenderers;
        for (Renderer renderer : rendererArr) {
            renderer.render(this.rendererPositionUs, this.elapsedRealtimeUs);
            if (renderer.hasReadStreamToEnd() && !renderer.isCurrentStreamFinal()) {
                SampleStream sampleStream = null;
                int i = 0;
                while (true) {
                    if (i >= this.renderers.length) {
                        break;
                    } else if (this.renderers[i] == renderer) {
                        sampleStream = this.readingPeriodHolder.sampleStreams[i];
                        break;
                    } else {
                        i++;
                    }
                }
                if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                    renderer.setCurrentStreamFinal();
                }
            }
            z3 = z3 && renderer.isEnded();
            boolean z5 = renderer.isReady() || renderer.isEnded();
            if (!z5) {
                renderer.maybeThrowStreamError();
            }
            z4 = z4 && z5;
        }
        if (!z4) {
            maybeThrowPeriodPrepareError();
        }
        if (this.rendererMediaClock != null) {
            PlaybackParameters playbackParameters2 = this.rendererMediaClock.getPlaybackParameters();
            if (!playbackParameters2.equals(this.playbackParameters)) {
                this.playbackParameters = playbackParameters2;
                this.standaloneMediaClock.synchronize(this.rendererMediaClock);
                this.eventHandler.obtainMessage(7, playbackParameters2).sendToTarget();
            }
        }
        long j = this.playingPeriodHolder.info.durationUs;
        if (z3 && ((j == -9223372036854775807L || j <= this.playbackInfo.positionUs) && this.playingPeriodHolder.info.isFinal)) {
            setState(4);
            stopRenderers();
        } else if (this.state == 2) {
            if (this.enabledRenderers.length > 0) {
                z2 = z4 && this.loadingPeriodHolder.haveSufficientBuffer(this.rebuffering, this.rendererPositionUs);
            } else {
                z2 = isTimelineReady(j);
            }
            if (z2) {
                setState(3);
                if (this.playWhenReady) {
                    startRenderers();
                }
            }
        } else if (this.state == 3) {
            if (this.enabledRenderers.length > 0) {
                z = z4;
            } else {
                z = isTimelineReady(j);
            }
            if (!z) {
                this.rebuffering = this.playWhenReady;
                setState(2);
                stopRenderers();
            }
        }
        if (this.state == 2) {
            for (Renderer renderer2 : this.enabledRenderers) {
                renderer2.maybeThrowStreamError();
            }
        }
        if ((this.playWhenReady && this.state == 3) || this.state == 2) {
            scheduleNextWork(elapsedRealtime, 10);
        } else if (this.enabledRenderers.length == 0 || this.state == 4) {
            this.handler.removeMessages(2);
        } else {
            scheduleNextWork(elapsedRealtime, 1000);
        }
        TraceUtil.endSection();
    }

    private void scheduleNextWork(long j, long j2) {
        this.handler.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
        } else {
            this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private void seekToInternal(SeekPosition seekPosition) {
        if (this.timeline == null) {
            this.pendingInitialSeekCount++;
            this.pendingSeekPosition = seekPosition;
            return;
        }
        Pair<Integer, Long> resolveSeekPosition = resolveSeekPosition(seekPosition);
        if (resolveSeekPosition == null) {
            this.playbackInfo = new PlaybackInfo(0, 0);
            this.eventHandler.obtainMessage(4, 1, 0, this.playbackInfo).sendToTarget();
            this.playbackInfo = new PlaybackInfo(0, -9223372036854775807L);
            setState(4);
            resetInternal(false);
            return;
        }
        boolean z = seekPosition.windowPositionUs == -9223372036854775807L;
        int intValue = ((Integer) resolveSeekPosition.first).intValue();
        long longValue = ((Long) resolveSeekPosition.second).longValue();
        MediaSource.MediaPeriodId resolvePeriodPositionForAds = this.mediaPeriodInfoSequence.resolvePeriodPositionForAds(intValue, longValue);
        if (resolvePeriodPositionForAds.isAd()) {
            z = true;
            longValue = 0;
        }
        try {
            if (!resolvePeriodPositionForAds.equals(this.playbackInfo.periodId) || longValue / 1000 != this.playbackInfo.positionUs / 1000) {
                long seekToPeriodPosition = seekToPeriodPosition(resolvePeriodPositionForAds, longValue);
                boolean z2 = (longValue != seekToPeriodPosition) | z;
                this.playbackInfo = new PlaybackInfo(resolvePeriodPositionForAds, seekToPeriodPosition, longValue);
                this.eventHandler.obtainMessage(4, z2 ? 1 : 0, 0, this.playbackInfo).sendToTarget();
                return;
            }
            if (!z) {
                int i = 0;
            }
        } finally {
            this.playbackInfo = new PlaybackInfo(resolvePeriodPositionForAds, longValue, longValue);
            this.eventHandler.obtainMessage(4, z ? 1 : 0, 0, this.playbackInfo).sendToTarget();
        }
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j) {
        stopRenderers();
        this.rebuffering = false;
        setState(2);
        MediaPeriodHolder mediaPeriodHolder = null;
        if (this.playingPeriodHolder != null) {
            for (MediaPeriodHolder mediaPeriodHolder2 = this.playingPeriodHolder; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.next) {
                if (shouldKeepPeriodHolder(mediaPeriodId, j, mediaPeriodHolder2)) {
                    mediaPeriodHolder = mediaPeriodHolder2;
                } else {
                    mediaPeriodHolder2.release();
                }
            }
        } else if (this.loadingPeriodHolder != null) {
            this.loadingPeriodHolder.release();
        }
        if (!(this.playingPeriodHolder == mediaPeriodHolder && this.playingPeriodHolder == this.readingPeriodHolder)) {
            for (Renderer renderer : this.enabledRenderers) {
                renderer.disable();
            }
            this.enabledRenderers = new Renderer[0];
            this.rendererMediaClock = null;
            this.rendererMediaClockSource = null;
            this.playingPeriodHolder = null;
        }
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.next = null;
            this.loadingPeriodHolder = mediaPeriodHolder;
            this.readingPeriodHolder = mediaPeriodHolder;
            setPlayingPeriodHolder(mediaPeriodHolder);
            if (this.playingPeriodHolder.hasEnabledTracks) {
                j = this.playingPeriodHolder.mediaPeriod.seekToUs(j);
            }
            resetRendererPosition(j);
            maybeContinueLoading();
        } else {
            this.loadingPeriodHolder = null;
            this.readingPeriodHolder = null;
            this.playingPeriodHolder = null;
            resetRendererPosition(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private boolean shouldKeepPeriodHolder(MediaSource.MediaPeriodId mediaPeriodId, long j, MediaPeriodHolder mediaPeriodHolder) {
        if (!mediaPeriodId.equals(mediaPeriodHolder.info.id) || !mediaPeriodHolder.prepared) {
            return false;
        }
        this.timeline.getPeriod(mediaPeriodHolder.info.id.periodIndex, this.period);
        int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(j);
        if (adGroupIndexAfterPositionUs == -1 || this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs) == mediaPeriodHolder.info.endPositionUs) {
            return true;
        }
        return false;
    }

    private void resetRendererPosition(long j) {
        long j2;
        if (this.playingPeriodHolder == null) {
            j2 = 60000000 + j;
        } else {
            j2 = this.playingPeriodHolder.toRendererTime(j);
        }
        this.rendererPositionUs = j2;
        this.standaloneMediaClock.setPositionUs(this.rendererPositionUs);
        for (Renderer renderer : this.enabledRenderers) {
            renderer.resetPosition(this.rendererPositionUs);
        }
    }

    private void setPlaybackParametersInternal(PlaybackParameters playbackParameters2) {
        PlaybackParameters playbackParameters3;
        if (this.rendererMediaClock != null) {
            playbackParameters3 = this.rendererMediaClock.setPlaybackParameters(playbackParameters2);
        } else {
            playbackParameters3 = this.standaloneMediaClock.setPlaybackParameters(playbackParameters2);
        }
        this.playbackParameters = playbackParameters3;
        this.eventHandler.obtainMessage(7, playbackParameters3).sendToTarget();
    }

    private void stopInternal() {
        resetInternal(true);
        this.loadControl.onStopped();
        setState(1);
    }

    private void releaseInternal() {
        resetInternal(true);
        this.loadControl.onReleased();
        setState(1);
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    private void resetInternal(boolean z) {
        this.handler.removeMessages(2);
        this.rebuffering = false;
        this.standaloneMediaClock.stop();
        this.rendererMediaClock = null;
        this.rendererMediaClockSource = null;
        this.rendererPositionUs = 60000000;
        Renderer[] rendererArr = this.enabledRenderers;
        for (Renderer renderer : rendererArr) {
            try {
                ensureStopped(renderer);
                renderer.disable();
            } catch (ExoPlaybackException | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.enabledRenderers = new Renderer[0];
        releasePeriodHoldersFrom(this.playingPeriodHolder != null ? this.playingPeriodHolder : this.loadingPeriodHolder);
        this.loadingPeriodHolder = null;
        this.readingPeriodHolder = null;
        this.playingPeriodHolder = null;
        setIsLoading(false);
        if (z) {
            if (this.mediaSource != null) {
                this.mediaSource.releaseSource();
                this.mediaSource = null;
            }
            this.mediaPeriodInfoSequence.setTimeline(null);
            this.timeline = null;
        }
    }

    private void sendMessagesInternal(ExoPlayer.ExoPlayerMessage[] exoPlayerMessageArr) {
        try {
            for (ExoPlayer.ExoPlayerMessage exoPlayerMessage : exoPlayerMessageArr) {
                exoPlayerMessage.target.handleMessage(exoPlayerMessage.messageType, exoPlayerMessage.message);
            }
            if (this.state == 3 || this.state == 2) {
                this.handler.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.customMessagesProcessed++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.customMessagesProcessed++;
                notifyAll();
                throw th;
            }
        }
    }

    private void ensureStopped(Renderer renderer) {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private void reselectTracksInternal() {
        if (this.playingPeriodHolder != null) {
            MediaPeriodHolder mediaPeriodHolder = this.playingPeriodHolder;
            boolean z = true;
            while (mediaPeriodHolder != null && mediaPeriodHolder.prepared) {
                if (mediaPeriodHolder.selectTracks()) {
                    if (z) {
                        boolean z2 = this.readingPeriodHolder != this.playingPeriodHolder;
                        releasePeriodHoldersFrom(this.playingPeriodHolder.next);
                        this.playingPeriodHolder.next = null;
                        this.loadingPeriodHolder = this.playingPeriodHolder;
                        this.readingPeriodHolder = this.playingPeriodHolder;
                        boolean[] zArr = new boolean[this.renderers.length];
                        long updatePeriodTrackSelection = this.playingPeriodHolder.updatePeriodTrackSelection(this.playbackInfo.positionUs, z2, zArr);
                        if (updatePeriodTrackSelection != this.playbackInfo.positionUs) {
                            this.playbackInfo.positionUs = updatePeriodTrackSelection;
                            resetRendererPosition(updatePeriodTrackSelection);
                        }
                        int i = 0;
                        boolean[] zArr2 = new boolean[this.renderers.length];
                        for (int i2 = 0; i2 < this.renderers.length; i2++) {
                            Renderer renderer = this.renderers[i2];
                            zArr2[i2] = renderer.getState() != 0;
                            SampleStream sampleStream = this.playingPeriodHolder.sampleStreams[i2];
                            if (sampleStream != null) {
                                i++;
                            }
                            if (zArr2[i2]) {
                                if (sampleStream != renderer.getStream()) {
                                    if (renderer == this.rendererMediaClockSource) {
                                        if (sampleStream == null) {
                                            this.standaloneMediaClock.synchronize(this.rendererMediaClock);
                                        }
                                        this.rendererMediaClock = null;
                                        this.rendererMediaClockSource = null;
                                    }
                                    ensureStopped(renderer);
                                    renderer.disable();
                                } else if (zArr[i2]) {
                                    renderer.resetPosition(this.rendererPositionUs);
                                }
                            }
                        }
                        this.eventHandler.obtainMessage(3, mediaPeriodHolder.trackSelectorResult).sendToTarget();
                        enableRenderers(zArr2, i);
                    } else {
                        this.loadingPeriodHolder = mediaPeriodHolder;
                        for (MediaPeriodHolder mediaPeriodHolder2 = this.loadingPeriodHolder.next; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.next) {
                            mediaPeriodHolder2.release();
                        }
                        this.loadingPeriodHolder.next = null;
                        if (this.loadingPeriodHolder.prepared) {
                            this.loadingPeriodHolder.updatePeriodTrackSelection(Math.max(this.loadingPeriodHolder.info.startPositionUs, this.loadingPeriodHolder.toPeriodTime(this.rendererPositionUs)), false);
                        }
                    }
                    maybeContinueLoading();
                    updatePlaybackPositions();
                    this.handler.sendEmptyMessage(2);
                    return;
                }
                if (mediaPeriodHolder == this.readingPeriodHolder) {
                    z = false;
                }
                mediaPeriodHolder = mediaPeriodHolder.next;
            }
        }
    }

    private boolean isTimelineReady(long j) {
        return j == -9223372036854775807L || this.playbackInfo.positionUs < j || (this.playingPeriodHolder.next != null && (this.playingPeriodHolder.next.prepared || this.playingPeriodHolder.next.info.id.isAd()));
    }

    private void maybeThrowPeriodPrepareError() {
        if (!(this.loadingPeriodHolder == null || this.loadingPeriodHolder.prepared)) {
            if (this.readingPeriodHolder == null || this.readingPeriodHolder.next == this.loadingPeriodHolder) {
                for (Renderer renderer : this.enabledRenderers) {
                    if (!renderer.hasReadStreamToEnd()) {
                        return;
                    }
                }
                this.loadingPeriodHolder.mediaPeriod.maybeThrowPrepareError();
            }
        }
    }

    private void handleSourceInfoRefreshed(Pair<Timeline, Object> pair) {
        MediaPeriodHolder mediaPeriodHolder;
        Timeline timeline2 = this.timeline;
        this.timeline = (Timeline) pair.first;
        this.mediaPeriodInfoSequence.setTimeline(this.timeline);
        Object obj = pair.second;
        if (timeline2 != null) {
            int i = this.playbackInfo.periodId.periodIndex;
            MediaPeriodHolder mediaPeriodHolder2 = this.playingPeriodHolder != null ? this.playingPeriodHolder : this.loadingPeriodHolder;
            if (mediaPeriodHolder2 != null || i < timeline2.getPeriodCount()) {
                int indexOfPeriod = this.timeline.getIndexOfPeriod(mediaPeriodHolder2 == null ? timeline2.getPeriod(i, this.period, true).uid : mediaPeriodHolder2.uid);
                if (indexOfPeriod == -1) {
                    int resolveSubsequentPeriod = resolveSubsequentPeriod(i, timeline2, this.timeline);
                    if (resolveSubsequentPeriod == -1) {
                        handleSourceInfoRefreshEndedPlayback(obj);
                        return;
                    }
                    Pair<Integer, Long> periodPosition = getPeriodPosition(this.timeline.getPeriod(resolveSubsequentPeriod, this.period).windowIndex, -9223372036854775807L);
                    int intValue = ((Integer) periodPosition.first).intValue();
                    long longValue = ((Long) periodPosition.second).longValue();
                    this.timeline.getPeriod(intValue, this.period, true);
                    if (mediaPeriodHolder2 != null) {
                        Object obj2 = this.period.uid;
                        mediaPeriodHolder2.info = mediaPeriodHolder2.info.copyWithPeriodIndex(-1);
                        while (mediaPeriodHolder2.next != null) {
                            mediaPeriodHolder2 = mediaPeriodHolder2.next;
                            if (mediaPeriodHolder2.uid.equals(obj2)) {
                                mediaPeriodHolder2.info = this.mediaPeriodInfoSequence.getUpdatedMediaPeriodInfo(mediaPeriodHolder2.info, intValue);
                            } else {
                                mediaPeriodHolder2.info = mediaPeriodHolder2.info.copyWithPeriodIndex(-1);
                            }
                        }
                    }
                    MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(intValue);
                    this.playbackInfo = new PlaybackInfo(mediaPeriodId, seekToPeriodPosition(mediaPeriodId, longValue));
                    notifySourceInfoRefresh(obj);
                    return;
                }
                if (indexOfPeriod != i) {
                    this.playbackInfo = this.playbackInfo.copyWithPeriodIndex(indexOfPeriod);
                }
                if (this.playbackInfo.periodId.isAd()) {
                    MediaSource.MediaPeriodId resolvePeriodPositionForAds = this.mediaPeriodInfoSequence.resolvePeriodPositionForAds(indexOfPeriod, this.playbackInfo.contentPositionUs);
                    if (!resolvePeriodPositionForAds.isAd() || resolvePeriodPositionForAds.adIndexInAdGroup != this.playbackInfo.periodId.adIndexInAdGroup) {
                        this.playbackInfo = new PlaybackInfo(resolvePeriodPositionForAds, seekToPeriodPosition(resolvePeriodPositionForAds, this.playbackInfo.contentPositionUs), resolvePeriodPositionForAds.isAd() ? this.playbackInfo.contentPositionUs : -9223372036854775807L);
                        notifySourceInfoRefresh(obj);
                        return;
                    }
                }
                if (mediaPeriodHolder2 == null) {
                    notifySourceInfoRefresh(obj);
                    return;
                }
                MediaPeriodHolder updatePeriodInfo = updatePeriodInfo(mediaPeriodHolder2, indexOfPeriod);
                while (true) {
                    if (updatePeriodInfo.next == null) {
                        break;
                    }
                    mediaPeriodHolder = updatePeriodInfo.next;
                    indexOfPeriod = this.timeline.getNextPeriodIndex(indexOfPeriod, this.period, this.window, this.repeatMode);
                    if (indexOfPeriod == -1 || !mediaPeriodHolder.uid.equals(this.timeline.getPeriod(indexOfPeriod, this.period, true).uid)) {
                        break;
                    }
                    updatePeriodInfo = updatePeriodInfo(mediaPeriodHolder, indexOfPeriod);
                }
                if (!(this.readingPeriodHolder != null && this.readingPeriodHolder.index < mediaPeriodHolder.index)) {
                    this.playbackInfo = new PlaybackInfo(this.playingPeriodHolder.info.id, seekToPeriodPosition(this.playingPeriodHolder.info.id, this.playbackInfo.positionUs), this.playbackInfo.contentPositionUs);
                } else {
                    this.loadingPeriodHolder = updatePeriodInfo;
                    this.loadingPeriodHolder.next = null;
                    releasePeriodHoldersFrom(mediaPeriodHolder);
                }
                notifySourceInfoRefresh(obj);
                return;
            }
            notifySourceInfoRefresh(obj);
        } else if (this.pendingInitialSeekCount > 0) {
            Pair<Integer, Long> resolveSeekPosition = resolveSeekPosition(this.pendingSeekPosition);
            int i2 = this.pendingInitialSeekCount;
            this.pendingInitialSeekCount = 0;
            this.pendingSeekPosition = null;
            if (resolveSeekPosition == null) {
                handleSourceInfoRefreshEndedPlayback(obj, i2);
                return;
            }
            int intValue2 = ((Integer) resolveSeekPosition.first).intValue();
            long longValue2 = ((Long) resolveSeekPosition.second).longValue();
            MediaSource.MediaPeriodId resolvePeriodPositionForAds2 = this.mediaPeriodInfoSequence.resolvePeriodPositionForAds(intValue2, longValue2);
            this.playbackInfo = new PlaybackInfo(resolvePeriodPositionForAds2, resolvePeriodPositionForAds2.isAd() ? 0 : longValue2, longValue2);
            notifySourceInfoRefresh(obj, i2);
        } else if (this.playbackInfo.startPositionUs != -9223372036854775807L) {
            notifySourceInfoRefresh(obj);
        } else if (this.timeline.isEmpty()) {
            handleSourceInfoRefreshEndedPlayback(obj);
        } else {
            Pair<Integer, Long> periodPosition2 = getPeriodPosition(0, -9223372036854775807L);
            int intValue3 = ((Integer) periodPosition2.first).intValue();
            long longValue3 = ((Long) periodPosition2.second).longValue();
            MediaSource.MediaPeriodId resolvePeriodPositionForAds3 = this.mediaPeriodInfoSequence.resolvePeriodPositionForAds(intValue3, longValue3);
            this.playbackInfo = new PlaybackInfo(resolvePeriodPositionForAds3, resolvePeriodPositionForAds3.isAd() ? 0 : longValue3, longValue3);
            notifySourceInfoRefresh(obj);
        }
    }

    private MediaPeriodHolder updatePeriodInfo(MediaPeriodHolder mediaPeriodHolder, int i) {
        while (true) {
            mediaPeriodHolder.info = this.mediaPeriodInfoSequence.getUpdatedMediaPeriodInfo(mediaPeriodHolder.info, i);
            if (mediaPeriodHolder.info.isLastInTimelinePeriod || mediaPeriodHolder.next == null) {
                break;
            }
            mediaPeriodHolder = mediaPeriodHolder.next;
        }
        return mediaPeriodHolder;
    }

    private void handleSourceInfoRefreshEndedPlayback(Object obj) {
        handleSourceInfoRefreshEndedPlayback(obj, 0);
    }

    private void handleSourceInfoRefreshEndedPlayback(Object obj, int i) {
        this.playbackInfo = new PlaybackInfo(0, 0);
        notifySourceInfoRefresh(obj, i);
        this.playbackInfo = new PlaybackInfo(0, -9223372036854775807L);
        setState(4);
        resetInternal(false);
    }

    private void notifySourceInfoRefresh(Object obj) {
        notifySourceInfoRefresh(obj, 0);
    }

    private void notifySourceInfoRefresh(Object obj, int i) {
        this.eventHandler.obtainMessage(6, new SourceInfo(this.timeline, obj, this.playbackInfo, i)).sendToTarget();
    }

    private int resolveSubsequentPeriod(int i, Timeline timeline2, Timeline timeline3) {
        int i2 = -1;
        int periodCount = timeline2.getPeriodCount();
        for (int i3 = 0; i3 < periodCount && i2 == -1; i3++) {
            i = timeline2.getNextPeriodIndex(i, this.period, this.window, this.repeatMode);
            if (i == -1) {
                break;
            }
            i2 = timeline3.getIndexOfPeriod(timeline2.getPeriod(i, this.period, true).uid);
        }
        return i2;
    }

    private Pair<Integer, Long> resolveSeekPosition(SeekPosition seekPosition) {
        Timeline timeline2 = seekPosition.timeline;
        if (timeline2.isEmpty()) {
            timeline2 = this.timeline;
        }
        try {
            Pair<Integer, Long> periodPosition = timeline2.getPeriodPosition(this.window, this.period, seekPosition.windowIndex, seekPosition.windowPositionUs);
            if (this.timeline == timeline2) {
                return periodPosition;
            }
            int indexOfPeriod = this.timeline.getIndexOfPeriod(timeline2.getPeriod(((Integer) periodPosition.first).intValue(), this.period, true).uid);
            if (indexOfPeriod != -1) {
                return Pair.create(Integer.valueOf(indexOfPeriod), periodPosition.second);
            }
            int resolveSubsequentPeriod = resolveSubsequentPeriod(((Integer) periodPosition.first).intValue(), timeline2, this.timeline);
            if (resolveSubsequentPeriod != -1) {
                return getPeriodPosition(this.timeline.getPeriod(resolveSubsequentPeriod, this.period).windowIndex, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalSeekPositionException(this.timeline, seekPosition.windowIndex, seekPosition.windowPositionUs);
        }
    }

    private Pair<Integer, Long> getPeriodPosition(int i, long j) {
        return this.timeline.getPeriodPosition(this.window, this.period, i, j);
    }

    private void updatePeriods() {
        if (this.timeline == null) {
            this.mediaSource.maybeThrowSourceInfoRefreshError();
            return;
        }
        maybeUpdateLoadingPeriod();
        if (this.loadingPeriodHolder == null || this.loadingPeriodHolder.isFullyBuffered()) {
            setIsLoading(false);
        } else if (this.loadingPeriodHolder != null && !this.isLoading) {
            maybeContinueLoading();
        }
        if (this.playingPeriodHolder != null) {
            while (this.playingPeriodHolder != this.readingPeriodHolder && this.rendererPositionUs >= this.playingPeriodHolder.next.rendererPositionOffsetUs) {
                this.playingPeriodHolder.release();
                setPlayingPeriodHolder(this.playingPeriodHolder.next);
                this.playbackInfo = new PlaybackInfo(this.playingPeriodHolder.info.id, this.playingPeriodHolder.info.startPositionUs, this.playingPeriodHolder.info.contentPositionUs);
                updatePlaybackPositions();
                this.eventHandler.obtainMessage(5, this.playbackInfo).sendToTarget();
            }
            if (this.readingPeriodHolder.info.isFinal) {
                for (int i = 0; i < this.renderers.length; i++) {
                    Renderer renderer = this.renderers[i];
                    SampleStream sampleStream = this.readingPeriodHolder.sampleStreams[i];
                    if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                        renderer.setCurrentStreamFinal();
                    }
                }
                return;
            }
            for (int i2 = 0; i2 < this.renderers.length; i2++) {
                Renderer renderer2 = this.renderers[i2];
                SampleStream sampleStream2 = this.readingPeriodHolder.sampleStreams[i2];
                if (renderer2.getStream() != sampleStream2) {
                    return;
                }
                if (sampleStream2 != null && !renderer2.hasReadStreamToEnd()) {
                    return;
                }
            }
            if (this.readingPeriodHolder.next != null && this.readingPeriodHolder.next.prepared) {
                TrackSelectorResult trackSelectorResult = this.readingPeriodHolder.trackSelectorResult;
                this.readingPeriodHolder = this.readingPeriodHolder.next;
                TrackSelectorResult trackSelectorResult2 = this.readingPeriodHolder.trackSelectorResult;
                boolean z = this.readingPeriodHolder.mediaPeriod.readDiscontinuity() != -9223372036854775807L;
                for (int i3 = 0; i3 < this.renderers.length; i3++) {
                    Renderer renderer3 = this.renderers[i3];
                    if (trackSelectorResult.selections.get(i3) != null) {
                        if (z) {
                            renderer3.setCurrentStreamFinal();
                        } else if (!renderer3.isCurrentStreamFinal()) {
                            TrackSelection trackSelection = trackSelectorResult2.selections.get(i3);
                            RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i3];
                            RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[i3];
                            if (trackSelection == null || !rendererConfiguration2.equals(rendererConfiguration)) {
                                renderer3.setCurrentStreamFinal();
                            } else {
                                Format[] formatArr = new Format[trackSelection.length()];
                                for (int i4 = 0; i4 < formatArr.length; i4++) {
                                    formatArr[i4] = trackSelection.getFormat(i4);
                                }
                                renderer3.replaceStream(formatArr, this.readingPeriodHolder.sampleStreams[i3], this.readingPeriodHolder.getRendererOffset());
                            }
                        }
                    }
                }
            }
        }
    }

    private void maybeUpdateLoadingPeriod() {
        MediaPeriodInfoSequence.MediaPeriodInfo mediaPeriodInfo;
        long j;
        if (this.loadingPeriodHolder == null) {
            mediaPeriodInfo = this.mediaPeriodInfoSequence.getFirstMediaPeriodInfo(this.playbackInfo);
        } else if (!this.loadingPeriodHolder.info.isFinal && this.loadingPeriodHolder.isFullyBuffered() && this.loadingPeriodHolder.info.durationUs != -9223372036854775807L) {
            if (this.playingPeriodHolder == null || this.loadingPeriodHolder.index - this.playingPeriodHolder.index != 100) {
                mediaPeriodInfo = this.mediaPeriodInfoSequence.getNextMediaPeriodInfo(this.loadingPeriodHolder.info, this.loadingPeriodHolder.getRendererOffset(), this.rendererPositionUs);
            } else {
                return;
            }
        } else {
            return;
        }
        if (mediaPeriodInfo == null) {
            this.mediaSource.maybeThrowSourceInfoRefreshError();
            return;
        }
        if (this.loadingPeriodHolder == null) {
            j = 60000000;
        } else {
            j = this.loadingPeriodHolder.getRendererOffset() + this.loadingPeriodHolder.info.durationUs;
        }
        MediaPeriodHolder mediaPeriodHolder = new MediaPeriodHolder(this.renderers, this.rendererCapabilities, j, this.trackSelector, this.loadControl, this.mediaSource, this.timeline.getPeriod(mediaPeriodInfo.id.periodIndex, this.period, true).uid, this.loadingPeriodHolder == null ? 0 : this.loadingPeriodHolder.index + 1, mediaPeriodInfo);
        if (this.loadingPeriodHolder != null) {
            this.loadingPeriodHolder.next = mediaPeriodHolder;
        }
        this.loadingPeriodHolder = mediaPeriodHolder;
        this.loadingPeriodHolder.mediaPeriod.prepare(this, mediaPeriodInfo.startPositionUs);
        setIsLoading(true);
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod) {
        if (this.loadingPeriodHolder != null && this.loadingPeriodHolder.mediaPeriod == mediaPeriod) {
            this.loadingPeriodHolder.handlePrepared();
            if (this.playingPeriodHolder == null) {
                this.readingPeriodHolder = this.loadingPeriodHolder;
                resetRendererPosition(this.readingPeriodHolder.info.startPositionUs);
                setPlayingPeriodHolder(this.readingPeriodHolder);
            }
            maybeContinueLoading();
        }
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (this.loadingPeriodHolder != null && this.loadingPeriodHolder.mediaPeriod == mediaPeriod) {
            maybeContinueLoading();
        }
    }

    private void maybeContinueLoading() {
        boolean shouldContinueLoading = this.loadingPeriodHolder.shouldContinueLoading(this.rendererPositionUs);
        setIsLoading(shouldContinueLoading);
        if (shouldContinueLoading) {
            this.loadingPeriodHolder.continueLoading(this.rendererPositionUs);
        }
    }

    private void releasePeriodHoldersFrom(MediaPeriodHolder mediaPeriodHolder) {
        while (mediaPeriodHolder != null) {
            mediaPeriodHolder.release();
            mediaPeriodHolder = mediaPeriodHolder.next;
        }
    }

    private void setPlayingPeriodHolder(MediaPeriodHolder mediaPeriodHolder) {
        if (this.playingPeriodHolder != mediaPeriodHolder) {
            int i = 0;
            boolean[] zArr = new boolean[this.renderers.length];
            for (int i2 = 0; i2 < this.renderers.length; i2++) {
                Renderer renderer = this.renderers[i2];
                zArr[i2] = renderer.getState() != 0;
                TrackSelection trackSelection = mediaPeriodHolder.trackSelectorResult.selections.get(i2);
                if (trackSelection != null) {
                    i++;
                }
                if (zArr[i2] && (trackSelection == null || (renderer.isCurrentStreamFinal() && renderer.getStream() == this.playingPeriodHolder.sampleStreams[i2]))) {
                    if (renderer == this.rendererMediaClockSource) {
                        this.standaloneMediaClock.synchronize(this.rendererMediaClock);
                        this.rendererMediaClock = null;
                        this.rendererMediaClockSource = null;
                    }
                    ensureStopped(renderer);
                    renderer.disable();
                }
            }
            this.playingPeriodHolder = mediaPeriodHolder;
            this.eventHandler.obtainMessage(3, mediaPeriodHolder.trackSelectorResult).sendToTarget();
            enableRenderers(zArr, i);
        }
    }

    private void enableRenderers(boolean[] zArr, int i) {
        this.enabledRenderers = new Renderer[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.renderers.length; i3++) {
            Renderer renderer = this.renderers[i3];
            TrackSelection trackSelection = this.playingPeriodHolder.trackSelectorResult.selections.get(i3);
            if (trackSelection != null) {
                i2++;
                this.enabledRenderers[i2] = renderer;
                if (renderer.getState() == 0) {
                    RendererConfiguration rendererConfiguration = this.playingPeriodHolder.trackSelectorResult.rendererConfigurations[i3];
                    boolean z = this.playWhenReady && this.state == 3;
                    boolean z2 = !zArr[i3] && z;
                    Format[] formatArr = new Format[trackSelection.length()];
                    for (int i4 = 0; i4 < formatArr.length; i4++) {
                        formatArr[i4] = trackSelection.getFormat(i4);
                    }
                    renderer.enable(rendererConfiguration, formatArr, this.playingPeriodHolder.sampleStreams[i3], this.rendererPositionUs, z2, this.playingPeriodHolder.getRendererOffset());
                    MediaClock mediaClock = renderer.getMediaClock();
                    if (mediaClock != null) {
                        if (this.rendererMediaClock != null) {
                            throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                        this.rendererMediaClock = mediaClock;
                        this.rendererMediaClockSource = renderer;
                        this.rendererMediaClock.setPlaybackParameters(this.playbackParameters);
                    }
                    if (z) {
                        renderer.start();
                    }
                } else {
                    continue;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class MediaPeriodHolder {
        public boolean hasEnabledTracks;
        public final int index;
        public MediaPeriodInfoSequence.MediaPeriodInfo info;
        private final LoadControl loadControl;
        public final boolean[] mayRetainStreamFlags;
        public final MediaPeriod mediaPeriod;
        private final MediaSource mediaSource;
        public MediaPeriodHolder next;
        private TrackSelectorResult periodTrackSelectorResult;
        public boolean prepared;
        private final RendererCapabilities[] rendererCapabilities;
        public final long rendererPositionOffsetUs;
        private final Renderer[] renderers;
        public final SampleStream[] sampleStreams;
        private final TrackSelector trackSelector;
        public TrackSelectorResult trackSelectorResult;
        public final Object uid;

        public MediaPeriodHolder(Renderer[] rendererArr, RendererCapabilities[] rendererCapabilitiesArr, long j, TrackSelector trackSelector2, LoadControl loadControl2, MediaSource mediaSource2, Object obj, int i, MediaPeriodInfoSequence.MediaPeriodInfo mediaPeriodInfo) {
            this.renderers = rendererArr;
            this.rendererCapabilities = rendererCapabilitiesArr;
            this.rendererPositionOffsetUs = j;
            this.trackSelector = trackSelector2;
            this.loadControl = loadControl2;
            this.mediaSource = mediaSource2;
            this.uid = Assertions.checkNotNull(obj);
            this.index = i;
            this.info = mediaPeriodInfo;
            this.sampleStreams = new SampleStream[rendererArr.length];
            this.mayRetainStreamFlags = new boolean[rendererArr.length];
            MediaPeriod createPeriod = mediaSource2.createPeriod(mediaPeriodInfo.id, loadControl2.getAllocator());
            if (mediaPeriodInfo.endPositionUs != Long.MIN_VALUE) {
                ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(createPeriod, true);
                clippingMediaPeriod.setClipping(0, mediaPeriodInfo.endPositionUs);
                createPeriod = clippingMediaPeriod;
            }
            this.mediaPeriod = createPeriod;
        }

        public long toRendererTime(long j) {
            return getRendererOffset() + j;
        }

        public long toPeriodTime(long j) {
            return j - getRendererOffset();
        }

        public long getRendererOffset() {
            return this.index == 0 ? this.rendererPositionOffsetUs : this.rendererPositionOffsetUs - this.info.startPositionUs;
        }

        public boolean isFullyBuffered() {
            return this.prepared && (!this.hasEnabledTracks || this.mediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE);
        }

        public boolean haveSufficientBuffer(boolean z, long j) {
            long j2;
            if (!this.prepared) {
                j2 = this.info.startPositionUs;
            } else {
                j2 = this.mediaPeriod.getBufferedPositionUs();
            }
            if (j2 == Long.MIN_VALUE) {
                if (this.info.isFinal) {
                    return true;
                }
                j2 = this.info.durationUs;
            }
            return this.loadControl.shouldStartPlayback(j2 - toPeriodTime(j), z);
        }

        public void handlePrepared() {
            this.prepared = true;
            selectTracks();
            this.info = this.info.copyWithStartPositionUs(updatePeriodTrackSelection(this.info.startPositionUs, false));
        }

        public boolean shouldContinueLoading(long j) {
            long nextLoadPositionUs = !this.prepared ? 0 : this.mediaPeriod.getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                return false;
            }
            return this.loadControl.shouldContinueLoading(nextLoadPositionUs - toPeriodTime(j));
        }

        public void continueLoading(long j) {
            this.mediaPeriod.continueLoading(toPeriodTime(j));
        }

        public boolean selectTracks() {
            TrackSelectorResult selectTracks = this.trackSelector.selectTracks(this.rendererCapabilities, this.mediaPeriod.getTrackGroups());
            if (selectTracks.isEquivalent(this.periodTrackSelectorResult)) {
                return false;
            }
            this.trackSelectorResult = selectTracks;
            return true;
        }

        public long updatePeriodTrackSelection(long j, boolean z) {
            return updatePeriodTrackSelection(j, z, new boolean[this.renderers.length]);
        }

        public long updatePeriodTrackSelection(long j, boolean z, boolean[] zArr) {
            TrackSelectionArray trackSelectionArray = this.trackSelectorResult.selections;
            for (int i = 0; i < trackSelectionArray.length; i++) {
                this.mayRetainStreamFlags[i] = !z && this.trackSelectorResult.isEquivalent(this.periodTrackSelectorResult, i);
            }
            long selectTracks = this.mediaPeriod.selectTracks(trackSelectionArray.getAll(), this.mayRetainStreamFlags, this.sampleStreams, zArr, j);
            this.periodTrackSelectorResult = this.trackSelectorResult;
            this.hasEnabledTracks = false;
            for (int i2 = 0; i2 < this.sampleStreams.length; i2++) {
                if (this.sampleStreams[i2] != null) {
                    Assertions.checkState(trackSelectionArray.get(i2) != null);
                    this.hasEnabledTracks = true;
                } else {
                    Assertions.checkState(trackSelectionArray.get(i2) == null);
                }
            }
            this.loadControl.onTracksSelected(this.renderers, this.trackSelectorResult.groups, trackSelectionArray);
            return selectTracks;
        }

        public void release() {
            try {
                if (this.info.endPositionUs != Long.MIN_VALUE) {
                    this.mediaSource.releasePeriod(((ClippingMediaPeriod) this.mediaPeriod).mediaPeriod);
                } else {
                    this.mediaSource.releasePeriod(this.mediaPeriod);
                }
            } catch (RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class SeekPosition {
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline2, int i, long j) {
            this.timeline = timeline2;
            this.windowIndex = i;
            this.windowPositionUs = j;
        }
    }
}
