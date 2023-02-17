package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecProfilerUtil;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
@TargetApi(16)
public abstract class MediaCodecRenderer extends BaseRenderer {
    private static final byte[] ADAPTATION_WORKAROUND_BUFFER = Util.getBytesFromHexString("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private final DecoderInputBuffer buffer;
    private MediaCodec codec;
    private long codecHotswapDeadlineMs;
    private MediaCodecInfo codecInfo;
    private boolean codecNeedsAdaptationWorkaround;
    private boolean codecNeedsAdaptationWorkaroundBuffer;
    private boolean codecNeedsDiscardToSpsWorkaround;
    private boolean codecNeedsEosFlushWorkaround;
    private boolean codecNeedsEosOutputExceptionWorkaround;
    private boolean codecNeedsEosPropagationWorkaround;
    private boolean codecNeedsFlushWorkaround;
    private boolean codecNeedsMonoChannelCountWorkaround;
    private boolean codecReceivedBuffers;
    private boolean codecReceivedEos;
    private int codecReconfigurationState;
    private boolean codecReconfigured;
    private int codecReinitializationState;
    private final List<Long> decodeOnlyPresentationTimestamps;
    protected DecoderCounters decoderCounters;
    private DrmSession<FrameworkMediaCrypto> drmSession;
    private final DrmSessionManager<FrameworkMediaCrypto> drmSessionManager;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private Format format;
    private final FormatHolder formatHolder;
    private ByteBuffer[] inputBuffers;
    private int inputIndex;
    private boolean inputStreamEnded;
    private final MediaCodecSelector mediaCodecSelector;
    private final MediaCodec.BufferInfo outputBufferInfo;
    private ByteBuffer[] outputBuffers;
    private int outputIndex;
    private boolean outputStreamEnded;
    private DrmSession<FrameworkMediaCrypto> pendingDrmSession;
    private final boolean playClearSamplesWithoutKeys;
    protected MediaCodecProfilerUtil profiler;
    private boolean shouldSkipAdaptationWorkaroundOutputBuffer;
    private boolean shouldSkipOutputBuffer;
    private boolean waitingForFirstSyncFrame;
    private boolean waitingForKeys;

    public abstract void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format2, MediaCrypto mediaCrypto);

    public abstract boolean processOutputBuffer(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    public abstract int supportsFormat(MediaCodecSelector mediaCodecSelector2, Format format2);

    public static class DecoderInitializationException extends Exception {
        public final String decoderName;
        public final String diagnosticInfo;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(Format format, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + format, th);
            this.mimeType = format.sampleMimeType;
            this.secureDecoderRequired = z;
            this.decoderName = null;
            this.diagnosticInfo = buildCustomDiagnosticInfo(i);
        }

        public DecoderInitializationException(Format format, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + format, th);
            this.mimeType = format.sampleMimeType;
            this.secureDecoderRequired = z;
            this.decoderName = str;
            this.diagnosticInfo = Util.SDK_INT >= 21 ? getDiagnosticInfoV21(th) : null;
        }

        @TargetApi(21)
        private static String getDiagnosticInfoV21(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        private static String buildCustomDiagnosticInfo(int i) {
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }
    }

    public MediaCodecRenderer(int i, MediaCodecSelector mediaCodecSelector2, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, boolean z) {
        super(i);
        Assertions.checkState(Util.SDK_INT >= 16);
        this.mediaCodecSelector = (MediaCodecSelector) Assertions.checkNotNull(mediaCodecSelector2);
        this.drmSessionManager = drmSessionManager2;
        this.playClearSamplesWithoutKeys = z;
        this.buffer = new DecoderInputBuffer(0);
        this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
        this.formatHolder = new FormatHolder();
        this.decodeOnlyPresentationTimestamps = new ArrayList();
        this.outputBufferInfo = new MediaCodec.BufferInfo();
        this.codecReconfigurationState = 0;
        this.codecReinitializationState = 0;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.RendererCapabilities
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(Format format2) {
        try {
            int supportsFormat = supportsFormat(this.mediaCodecSelector, format2);
            if ((supportsFormat & 7) <= 2 || isDrmSchemeSupported(this.drmSessionManager, format2.drmInitData)) {
                return supportsFormat;
            }
            return (supportsFormat & -8) | 2;
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    public MediaCodecInfo getDecoderInfo(MediaCodecSelector mediaCodecSelector2, Format format2, boolean z) {
        return mediaCodecSelector2.getDecoderInfo(format2.sampleMimeType, z);
    }

    /* access modifiers changed from: protected */
    public final void maybeInitCodec() {
        if (this.codec == null && this.format != null) {
            this.drmSession = this.pendingDrmSession;
            String str = this.format.sampleMimeType;
            MediaCrypto mediaCrypto = null;
            boolean z = false;
            if (this.drmSession != null) {
                FrameworkMediaCrypto mediaCrypto2 = this.drmSession.getMediaCrypto();
                if (mediaCrypto2 == null) {
                    DrmSession.DrmSessionException error = this.drmSession.getError();
                    if (error != null) {
                        throw ExoPlaybackException.createForRenderer(error, getIndex());
                    }
                    return;
                }
                mediaCrypto = mediaCrypto2.getWrappedMediaCrypto();
                z = mediaCrypto2.requiresSecureDecoderComponent(str);
            }
            if (this.codecInfo == null) {
                try {
                    this.codecInfo = getDecoderInfo(this.mediaCodecSelector, this.format, z);
                    if (this.codecInfo == null && z) {
                        this.codecInfo = getDecoderInfo(this.mediaCodecSelector, this.format, false);
                        if (this.codecInfo != null) {
                            Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + str + ", but no secure decoder available. Trying to proceed with " + this.codecInfo.name + ".");
                        }
                    }
                } catch (MediaCodecUtil.DecoderQueryException e) {
                    throwDecoderInitError(new DecoderInitializationException(this.format, e, z, -49998));
                }
                if (this.codecInfo == null) {
                    throwDecoderInitError(new DecoderInitializationException(this.format, (Throwable) null, z, -49999));
                }
            }
            if (shouldInitCodec(this.codecInfo)) {
                String str2 = this.codecInfo.name;
                this.codecNeedsDiscardToSpsWorkaround = codecNeedsDiscardToSpsWorkaround(str2, this.format);
                this.codecNeedsFlushWorkaround = codecNeedsFlushWorkaround(str2);
                this.codecNeedsAdaptationWorkaround = codecNeedsAdaptationWorkaround(str2);
                this.codecNeedsEosPropagationWorkaround = codecNeedsEosPropagationWorkaround(str2);
                this.codecNeedsEosFlushWorkaround = codecNeedsEosFlushWorkaround(str2);
                this.codecNeedsEosOutputExceptionWorkaround = codecNeedsEosOutputExceptionWorkaround(str2);
                this.codecNeedsMonoChannelCountWorkaround = codecNeedsMonoChannelCountWorkaround(str2, this.format);
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    TraceUtil.beginSection("createCodec:" + str2);
                    this.codec = MediaCodec.createByCodecName(str2);
                    TraceUtil.endSection();
                    TraceUtil.beginSection("configureCodec");
                    configureCodec(this.codecInfo, this.codec, this.format, mediaCrypto);
                    TraceUtil.endSection();
                    TraceUtil.beginSection("startCodec");
                    this.codec.start();
                    TraceUtil.endSection();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    onCodecInitialized(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.inputBuffers = this.codec.getInputBuffers();
                    this.outputBuffers = this.codec.getOutputBuffers();
                } catch (Exception e2) {
                    throwDecoderInitError(new DecoderInitializationException(this.format, e2, z, str2));
                }
                this.codecHotswapDeadlineMs = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                this.inputIndex = -1;
                clearInput(false);
                this.outputIndex = -1;
                this.waitingForFirstSyncFrame = true;
                this.decoderCounters.decoderInitCount++;
            }
        }
    }

    private void throwDecoderInitError(DecoderInitializationException decoderInitializationException) {
        throw ExoPlaybackException.createForRenderer(decoderInitializationException, getIndex());
    }

    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    /* access modifiers changed from: protected */
    public final MediaCodec getCodec() {
        return this.codec;
    }

    /* access modifiers changed from: protected */
    public final MediaCodecInfo getCodecInfo() {
        return this.codecInfo;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z) {
        this.decoderCounters = new DecoderCounters();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        if (this.codec != null) {
            flushCodec();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.format = null;
        try {
            releaseCodec();
            try {
                if (this.drmSession != null) {
                    this.drmSessionManager.releaseSession(this.drmSession);
                }
                try {
                    if (!(this.pendingDrmSession == null || this.pendingDrmSession == this.drmSession)) {
                        this.drmSessionManager.releaseSession(this.pendingDrmSession);
                    }
                } finally {
                    this.drmSession = null;
                    this.pendingDrmSession = null;
                }
            } catch (Throwable th) {
                if (!(this.pendingDrmSession == null || this.pendingDrmSession == this.drmSession)) {
                    this.drmSessionManager.releaseSession(this.pendingDrmSession);
                }
                throw th;
            } finally {
                this.drmSession = null;
                this.pendingDrmSession = null;
            }
        } catch (Throwable th2) {
            try {
                if (!(this.pendingDrmSession == null || this.pendingDrmSession == this.drmSession)) {
                    this.drmSessionManager.releaseSession(this.pendingDrmSession);
                }
                throw th2;
            } finally {
                this.drmSession = null;
                this.pendingDrmSession = null;
            }
        } finally {
        }
    }

    public void releaseCodec() {
        this.codecHotswapDeadlineMs = -9223372036854775807L;
        this.inputIndex = -1;
        clearInput(false);
        this.outputIndex = -1;
        this.waitingForKeys = false;
        this.shouldSkipOutputBuffer = false;
        this.decodeOnlyPresentationTimestamps.clear();
        this.inputBuffers = null;
        this.outputBuffers = null;
        this.codecInfo = null;
        this.codecReconfigured = false;
        this.codecReceivedBuffers = false;
        this.codecNeedsDiscardToSpsWorkaround = false;
        this.codecNeedsFlushWorkaround = false;
        this.codecNeedsAdaptationWorkaround = false;
        this.codecNeedsEosPropagationWorkaround = false;
        this.codecNeedsEosFlushWorkaround = false;
        this.codecNeedsMonoChannelCountWorkaround = false;
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
        this.codecReceivedEos = false;
        this.codecReconfigurationState = 0;
        this.codecReinitializationState = 0;
        this.buffer.data = null;
        if (this.codec != null) {
            this.decoderCounters.decoderReleaseCount++;
            try {
                this.codec.stop();
                try {
                    this.codec.release();
                    this.codec = null;
                    if (this.drmSession != null && this.pendingDrmSession != this.drmSession) {
                        try {
                            this.drmSessionManager.releaseSession(this.drmSession);
                        } finally {
                            this.drmSession = null;
                        }
                    }
                } catch (Throwable th) {
                    this.codec = null;
                    if (!(this.drmSession == null || this.pendingDrmSession == this.drmSession)) {
                        this.drmSessionManager.releaseSession(this.drmSession);
                    }
                    throw th;
                } finally {
                    this.drmSession = null;
                }
            } catch (Throwable th2) {
                this.codec = null;
                if (!(this.drmSession == null || this.pendingDrmSession == this.drmSession)) {
                    try {
                        this.drmSessionManager.releaseSession(this.drmSession);
                    } finally {
                        this.drmSession = null;
                    }
                }
                throw th2;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        if (this.outputStreamEnded) {
            renderToEndOfStream();
            return;
        }
        if (this.format == null) {
            this.flagsOnlyBuffer.clear();
            int readSource = readSource(this.formatHolder, this.flagsOnlyBuffer, true);
            if (readSource == -5) {
                onInputFormatChanged(this.formatHolder.format);
            } else if (readSource == -4) {
                Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                this.inputStreamEnded = true;
                processEndOfStream();
                return;
            } else {
                return;
            }
        }
        maybeInitCodec();
        if (this.codec != null) {
            TraceUtil.beginSection("drainAndFeed");
            do {
            } while (drainOutputBuffer(j, j2));
            do {
            } while (feedInputBuffer());
            TraceUtil.endSection();
        } else {
            skipSource(j);
            this.flagsOnlyBuffer.clear();
            int readSource2 = readSource(this.formatHolder, this.flagsOnlyBuffer, false);
            if (readSource2 == -5) {
                onInputFormatChanged(this.formatHolder.format);
            } else if (readSource2 == -4) {
                Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                this.inputStreamEnded = true;
                processEndOfStream();
            }
        }
        this.decoderCounters.ensureUpdated();
    }

    /* access modifiers changed from: protected */
    public void flushCodec() {
        this.codecHotswapDeadlineMs = -9223372036854775807L;
        this.inputIndex = -1;
        this.outputIndex = -1;
        this.waitingForFirstSyncFrame = true;
        this.waitingForKeys = false;
        this.shouldSkipOutputBuffer = false;
        this.decodeOnlyPresentationTimestamps.clear();
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
        if (this.codecNeedsFlushWorkaround || (this.codecNeedsEosFlushWorkaround && this.codecReceivedEos)) {
            releaseCodec();
            maybeInitCodec();
        } else if (this.codecReinitializationState != 0) {
            releaseCodec();
            maybeInitCodec();
        } else if (this.codecReceivedBuffers) {
            clearInput(true);
            this.codecReceivedBuffers = false;
        }
        if (this.codecReconfigured && this.format != null) {
            this.codecReconfigurationState = 1;
        }
    }

    private boolean feedInputBuffer() {
        int i;
        if (this.codec == null || this.codecReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputIndex < 0) {
            this.inputIndex = getInputIndex();
            if (this.inputIndex < 0) {
                return false;
            }
            this.buffer.data = this.inputBuffers[this.inputIndex];
            this.buffer.clear();
        }
        if (this.codecReinitializationState == 1) {
            if (!this.codecNeedsEosPropagationWorkaround) {
                this.codecReceivedEos = true;
                this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0, 4);
                this.inputIndex = -1;
            }
            this.codecReinitializationState = 2;
            return false;
        } else if (this.codecNeedsAdaptationWorkaroundBuffer) {
            this.codecNeedsAdaptationWorkaroundBuffer = false;
            this.buffer.data.put(ADAPTATION_WORKAROUND_BUFFER);
            this.codec.queueInputBuffer(this.inputIndex, 0, ADAPTATION_WORKAROUND_BUFFER.length, 0, 0);
            this.inputIndex = -1;
            this.codecReceivedBuffers = true;
            return true;
        } else {
            int i2 = 0;
            if (this.waitingForKeys) {
                i = -4;
            } else {
                if (this.codecReconfigurationState == 1) {
                    for (int i3 = 0; i3 < this.format.initializationData.size(); i3++) {
                        this.buffer.data.put(this.format.initializationData.get(i3));
                    }
                    this.codecReconfigurationState = 2;
                }
                i2 = this.buffer.data.position();
                i = readSource(this.formatHolder, this.buffer, false);
            }
            if (i == -3) {
                return false;
            }
            if (i == -5) {
                if (this.codecReconfigurationState == 2) {
                    this.buffer.clear();
                    this.codecReconfigurationState = 1;
                }
                onInputFormatChanged(this.formatHolder.format);
                return true;
            } else if (this.buffer.isEndOfStream()) {
                if (this.codecReconfigurationState == 2) {
                    this.buffer.clear();
                    this.codecReconfigurationState = 1;
                }
                this.inputStreamEnded = true;
                if (!this.codecReceivedBuffers) {
                    processEndOfStream();
                    return false;
                }
                try {
                    if (this.codecNeedsEosPropagationWorkaround) {
                        return false;
                    }
                    this.codecReceivedEos = true;
                    this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0, 4);
                    this.inputIndex = -1;
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw ExoPlaybackException.createForRenderer(e, getIndex());
                }
            } else if (!this.waitingForFirstSyncFrame || this.buffer.isKeyFrame()) {
                this.waitingForFirstSyncFrame = false;
                boolean isEncrypted = this.buffer.isEncrypted();
                this.waitingForKeys = shouldWaitForKeys(isEncrypted);
                if (this.waitingForKeys) {
                    return false;
                }
                if (this.codecNeedsDiscardToSpsWorkaround && !isEncrypted) {
                    NalUnitUtil.discardToSps(this.buffer.data);
                    if (this.buffer.data.position() == 0) {
                        return true;
                    }
                    this.codecNeedsDiscardToSpsWorkaround = false;
                }
                try {
                    long j = this.buffer.timeUs;
                    if (this.buffer.isDecodeOnly()) {
                        this.decodeOnlyPresentationTimestamps.add(Long.valueOf(j));
                    }
                    this.buffer.flip();
                    onQueueInputBuffer(this.buffer);
                    if (isEncrypted) {
                        queueSecureInputBuffer(this.inputIndex, 0, getFrameworkCryptoInfo(this.buffer, i2), j, 0);
                    } else {
                        queueInputBuffer(this.inputIndex, 0, this.buffer.data.limit(), j, 0);
                    }
                    this.inputIndex = -1;
                    this.codecReceivedBuffers = true;
                    this.codecReconfigurationState = 0;
                    this.decoderCounters.inputBufferCount++;
                    return true;
                } catch (MediaCodec.CryptoException e2) {
                    throw ExoPlaybackException.createForRenderer(e2, getIndex());
                }
            } else {
                this.buffer.clear();
                if (this.codecReconfigurationState != 2) {
                    return true;
                }
                this.codecReconfigurationState = 1;
                return true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void queueSecureInputBuffer(int i, int i2, MediaCodec.CryptoInfo cryptoInfo, long j, int i3) {
        if (this.profiler != null) {
            this.profiler.invokeBegin(getTrackType(), MediaCodecProfilerUtil.ProfilerId.queInputBuffer);
        }
        this.codec.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
        if (this.profiler != null) {
            this.profiler.invokeEnd(getTrackType(), MediaCodecProfilerUtil.ProfilerId.queInputBuffer);
        }
    }

    /* access modifiers changed from: protected */
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        if (this.profiler != null) {
            this.profiler.invokeBegin(getTrackType(), MediaCodecProfilerUtil.ProfilerId.queInputBuffer);
        }
        this.codec.queueInputBuffer(i, i2, i3, j, i4);
        if (this.profiler != null) {
            this.profiler.invokeEnd(getTrackType(), MediaCodecProfilerUtil.ProfilerId.queInputBuffer);
        }
    }

    /* access modifiers changed from: protected */
    public int getInputIndex() {
        if (this.profiler != null) {
            this.profiler.invokeBegin(getTrackType(), MediaCodecProfilerUtil.ProfilerId.deqInputBuffer);
        }
        int dequeueInputBuffer = this.codec.dequeueInputBuffer(0);
        if (dequeueInputBuffer >= 0 && this.profiler != null) {
            this.profiler.invokeEnd(getTrackType(), MediaCodecProfilerUtil.ProfilerId.deqInputBuffer);
        }
        return dequeueInputBuffer;
    }

    /* access modifiers changed from: protected */
    public void clearInput(boolean z) {
        if (z && this.codec != null) {
            this.codec.flush();
        }
    }

    private static MediaCodec.CryptoInfo getFrameworkCryptoInfo(DecoderInputBuffer decoderInputBuffer, int i) {
        MediaCodec.CryptoInfo frameworkCryptoInfoV16 = decoderInputBuffer.cryptoInfo.getFrameworkCryptoInfoV16();
        if (i == 0) {
            return frameworkCryptoInfoV16;
        }
        if (frameworkCryptoInfoV16.numBytesOfClearData == null) {
            frameworkCryptoInfoV16.numBytesOfClearData = new int[1];
        }
        int[] iArr = frameworkCryptoInfoV16.numBytesOfClearData;
        iArr[0] = iArr[0] + i;
        return frameworkCryptoInfoV16;
    }

    private boolean shouldWaitForKeys(boolean z) {
        if (this.drmSession == null) {
            return false;
        }
        if (!z && this.playClearSamplesWithoutKeys) {
            return false;
        }
        int state = this.drmSession.getState();
        if (state != 1) {
            return state != 4;
        }
        throw ExoPlaybackException.createForRenderer(this.drmSession.getError(), getIndex());
    }

    public void onCodecInitialized(String str, long j, long j2) {
    }

    public void onInputFormatChanged(Format format2) {
        Format format3 = this.format;
        this.format = format2;
        if (!Util.areEqual(this.format.drmInitData, format3 == null ? null : format3.drmInitData)) {
            if (this.format.drmInitData == null) {
                this.pendingDrmSession = null;
            } else if (this.drmSessionManager == null) {
                throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
            } else {
                this.pendingDrmSession = this.drmSessionManager.acquireSession(Looper.myLooper(), this.format.drmInitData);
                if (this.pendingDrmSession == this.drmSession) {
                    this.drmSessionManager.releaseSession(this.pendingDrmSession);
                }
            }
        }
        if (this.pendingDrmSession == this.drmSession && this.codec != null && canReconfigureCodec(this.codec, this.codecInfo.adaptive, format3, this.format)) {
            this.codecReconfigured = true;
            this.codecReconfigurationState = 1;
            this.codecNeedsAdaptationWorkaroundBuffer = this.codecNeedsAdaptationWorkaround && this.format.width == format3.width && this.format.height == format3.height;
        } else if (this.codecReceivedBuffers) {
            this.codecReinitializationState = 1;
        } else {
            releaseCodec();
            maybeInitCodec();
        }
    }

    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
    }

    /* access modifiers changed from: protected */
    public void onProcessedOutputBuffer(long j) {
    }

    public boolean canReconfigureCodec(MediaCodec mediaCodec, boolean z, Format format2, Format format3) {
        return false;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.format != null && !this.waitingForKeys && (isSourceReady() || this.outputIndex >= 0 || (this.codecHotswapDeadlineMs != -9223372036854775807L && SystemClock.elapsedRealtime() < this.codecHotswapDeadlineMs));
    }

    /* access modifiers changed from: protected */
    public long getDequeueOutputBufferTimeoutUs() {
        return 0;
    }

    private boolean drainOutputBuffer(long j, long j2) {
        boolean z;
        if (this.outputIndex < 0) {
            if (!this.codecNeedsEosOutputExceptionWorkaround || !this.codecReceivedEos) {
                try {
                    this.outputIndex = this.codec.dequeueOutputBuffer(this.outputBufferInfo, getDequeueOutputBufferTimeoutUs());
                } catch (IllegalStateException e) {
                    throw ExoPlaybackException.createForUnexpected(e, getTrackType(), getSurfaceValidityCode() + "." + (hasReadStreamToEnd() ? 1 : 0) + "." + (this.codecReceivedEos ? 1 : 0));
                }
            } else {
                try {
                    this.outputIndex = this.codec.dequeueOutputBuffer(this.outputBufferInfo, getDequeueOutputBufferTimeoutUs());
                } catch (IllegalStateException e2) {
                    processEndOfStream();
                    if (!this.outputStreamEnded) {
                        return false;
                    }
                    releaseCodec();
                    return false;
                }
            }
            if (this.outputIndex >= 0) {
                if (this.shouldSkipAdaptationWorkaroundOutputBuffer) {
                    this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
                    this.codec.releaseOutputBuffer(this.outputIndex, false);
                    this.outputIndex = -1;
                    return true;
                } else if ((this.outputBufferInfo.flags & 4) != 0) {
                    processEndOfStream();
                    this.outputIndex = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.outputBuffers[this.outputIndex];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.outputBufferInfo.offset);
                        byteBuffer.limit(this.outputBufferInfo.offset + this.outputBufferInfo.size);
                    }
                    this.shouldSkipOutputBuffer = shouldSkipOutputBuffer(this.outputBufferInfo.presentationTimeUs);
                }
            } else if (this.outputIndex == -2) {
                processOutputFormat();
                return true;
            } else if (this.outputIndex == -3) {
                processOutputBuffersChanged();
                return true;
            } else if (!this.codecNeedsEosPropagationWorkaround) {
                return false;
            } else {
                if (!this.inputStreamEnded && this.codecReinitializationState != 2) {
                    return false;
                }
                processEndOfStream();
                return false;
            }
        }
        if (!this.codecNeedsEosOutputExceptionWorkaround || !this.codecReceivedEos) {
            z = processOutputBuffer(j, j2, this.codec, this.outputBuffers[this.outputIndex], this.outputIndex, this.outputBufferInfo.flags, this.outputBufferInfo.presentationTimeUs, this.shouldSkipOutputBuffer);
        } else {
            try {
                z = processOutputBuffer(j, j2, this.codec, this.outputBuffers[this.outputIndex], this.outputIndex, this.outputBufferInfo.flags, this.outputBufferInfo.presentationTimeUs, this.shouldSkipOutputBuffer);
            } catch (IllegalStateException e3) {
                processEndOfStream();
                if (!this.outputStreamEnded) {
                    return false;
                }
                releaseCodec();
                return false;
            }
        }
        if (!z) {
            return false;
        }
        onProcessedOutputBuffer(this.outputBufferInfo.presentationTimeUs);
        this.outputIndex = -1;
        return true;
    }

    private void processOutputFormat() {
        MediaFormat outputFormat = this.codec.getOutputFormat();
        if (this.codecNeedsAdaptationWorkaround && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.shouldSkipAdaptationWorkaroundOutputBuffer = true;
            return;
        }
        if (this.codecNeedsMonoChannelCountWorkaround) {
            outputFormat.setInteger("channel-count", 1);
        }
        onOutputFormatChanged(this.codec, outputFormat);
    }

    private void processOutputBuffersChanged() {
        this.outputBuffers = this.codec.getOutputBuffers();
    }

    public void renderToEndOfStream() {
    }

    public int getSurfaceValidityCode() {
        return 0;
    }

    private void processEndOfStream() {
        if (this.codecReinitializationState == 2) {
            releaseCodec();
            maybeInitCodec();
            return;
        }
        this.outputStreamEnded = true;
        renderToEndOfStream();
    }

    private boolean shouldSkipOutputBuffer(long j) {
        int size = this.decodeOnlyPresentationTimestamps.size();
        for (int i = 0; i < size; i++) {
            if (this.decodeOnlyPresentationTimestamps.get(i).longValue() == j) {
                this.decodeOnlyPresentationTimestamps.remove(i);
                return true;
            }
        }
        return false;
    }

    private static boolean isDrmSchemeSupported(DrmSessionManager drmSessionManager2, DrmInitData drmInitData) {
        if (drmInitData == null) {
            return true;
        }
        if (drmSessionManager2 == null) {
            return false;
        }
        return drmSessionManager2.canAcquireSession(drmInitData);
    }

    private static boolean codecNeedsFlushWorkaround(String str) {
        return Util.SDK_INT < 18 || (Util.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (Util.SDK_INT == 19 && Util.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private static boolean codecNeedsAdaptationWorkaround(String str) {
        return ((Util.SDK_INT < 24 && (("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(Util.DEVICE) || "flounder_lte".equals(Util.DEVICE) || "grouper".equals(Util.DEVICE) || "tilapia".equals(Util.DEVICE)))) || (Util.SDK_INT <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (Util.MODEL.startsWith("SM-T585") || Util.MODEL.startsWith("SM-A510") || Util.MODEL.startsWith("SM-A520") || Util.MODEL.startsWith("SM-J700")))) || (Util.SDK_INT == 24 && "sony".equalsIgnoreCase(Util.MANUFACTURER) && "g3223".equalsIgnoreCase(Util.MODEL) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str));
    }

    private static boolean codecNeedsDiscardToSpsWorkaround(String str, Format format2) {
        return Util.SDK_INT < 21 && format2.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean codecNeedsEosPropagationWorkaround(String str) {
        return Util.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str));
    }

    private static boolean codecNeedsEosFlushWorkaround(String str) {
        return (Util.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (Util.SDK_INT <= 19 && "hb2000".equals(Util.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)));
    }

    private static boolean codecNeedsEosOutputExceptionWorkaround(String str) {
        return Util.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean codecNeedsMonoChannelCountWorkaround(String str, Format format2) {
        return Util.SDK_INT <= 18 && format2.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }
}
