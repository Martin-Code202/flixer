package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.nio.ByteBuffer;
@TargetApi(16)
public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private final long allowedJoiningTimeMs;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private int currentHeight;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsAutoFrcWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private Surface dummySurface;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private final VideoFrameReleaseTimeHelper frameReleaseTimeHelper;
    private long joiningDeadlineMs;
    private long maxAheadTimedReleasUs = 45000;
    private final int maxDroppedFramesToNotify;
    private long outputStreamOffsetUs;
    private int pendingOutputStreamOffsetCount;
    private final long[] pendingOutputStreamOffsetsUs;
    private float pendingPixelWidthHeightRatio;
    private int pendingRotationDegrees;
    private boolean renderedFirstFrame;
    private int reportedHeight;
    private float reportedPixelWidthHeightRatio;
    private int reportedUnappliedRotationDegrees;
    private int reportedWidth;
    private int scalingMode;
    private Format[] streamFormats;
    private Surface surface;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        super(2, mediaCodecSelector, drmSessionManager, z);
        this.allowedJoiningTimeMs = j;
        this.maxDroppedFramesToNotify = i;
        this.context = context2.getApplicationContext();
        this.frameReleaseTimeHelper = new VideoFrameReleaseTimeHelper(context2);
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.deviceNeedsAutoFrcWorkaround = deviceNeedsAutoFrcWorkaround();
        this.pendingOutputStreamOffsetsUs = new long[10];
        this.outputStreamOffsetUs = -9223372036854775807L;
        this.joiningDeadlineMs = -9223372036854775807L;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        clearReportedVideoSize();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) {
        String str = format.sampleMimeType;
        if (!MimeTypes.isVideo(str)) {
            return 0;
        }
        boolean z = false;
        DrmInitData drmInitData = format.drmInitData;
        if (drmInitData != null) {
            for (int i = 0; i < drmInitData.schemeDataCount; i++) {
                z |= drmInitData.get(i).requiresSecureDecryption;
            }
        }
        MediaCodecInfo decoderInfo = mediaCodecSelector.getDecoderInfo(str, z);
        if (decoderInfo == null) {
            return 1;
        }
        boolean isCodecSupported = decoderInfo.isCodecSupported(format.codecs);
        if (isCodecSupported && format.width > 0 && format.height > 0) {
            if (Util.SDK_INT >= 21) {
                isCodecSupported = decoderInfo.isVideoSizeAndRateSupportedV21(format.width, format.height, (double) format.frameRate);
            } else {
                isCodecSupported = format.width * format.height <= MediaCodecUtil.maxH264DecodableFrameSize();
                if (!isCodecSupported) {
                    Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + format.width + "x" + format.height + "] [" + Util.DEVICE_DEBUG_INFO + "]");
                }
            }
        }
        return (decoderInfo.adaptive ? 16 : 8) | (decoderInfo.tunneling ? 32 : 0) | (isCodecSupported ? 4 : 3);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z) {
        super.onEnabled(z);
        this.tunnelingAudioSessionId = getConfiguration().tunnelingAudioSessionId;
        this.tunneling = this.tunnelingAudioSessionId != 0;
        this.eventDispatcher.enabled(this.decoderCounters);
        this.frameReleaseTimeHelper.enable();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j) {
        this.streamFormats = formatArr;
        if (this.outputStreamOffsetUs == -9223372036854775807L) {
            this.outputStreamOffsetUs = j;
        } else {
            if (this.pendingOutputStreamOffsetCount == this.pendingOutputStreamOffsetsUs.length) {
                Log.w("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1]);
            } else {
                this.pendingOutputStreamOffsetCount++;
            }
            this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1] = j;
        }
        super.onStreamChanged(formatArr, j);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        super.onPositionReset(j, z);
        clearRenderedFirstFrame();
        this.consecutiveDroppedFrameCount = 0;
        if (this.pendingOutputStreamOffsetCount != 0) {
            this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1];
            this.pendingOutputStreamOffsetCount = 0;
        }
        if (z) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        if (super.isReady() && (this.renderedFirstFrame || ((this.dummySurface != null && this.surface == this.dummySurface) || getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = -9223372036854775807L;
            return true;
        } else if (this.joiningDeadlineMs == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
                return true;
            }
            this.joiningDeadlineMs = -9223372036854775807L;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        this.joiningDeadlineMs = -9223372036854775807L;
        maybeNotifyDroppedFrames();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.outputStreamOffsetUs = -9223372036854775807L;
        this.pendingOutputStreamOffsetCount = 0;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.frameReleaseTimeHelper.disable();
        this.tunnelingOnFrameRenderedListener = null;
        this.tunneling = false;
        try {
            super.onDisabled();
        } finally {
            this.decoderCounters.ensureUpdated();
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.ExoPlayer.ExoPlayerComponent
    public void handleMessage(int i, Object obj) {
        if (i == 1) {
            setSurface((Surface) obj);
        } else if (i == 4) {
            this.scalingMode = ((Integer) obj).intValue();
            MediaCodec codec = getCodec();
            if (codec != null) {
                setVideoScalingMode(codec, this.scalingMode);
            }
        } else {
            super.handleMessage(i, obj);
        }
    }

    private void setSurface(Surface surface2) {
        if (surface2 == null) {
            if (this.dummySurface != null) {
                surface2 = this.dummySurface;
            } else {
                MediaCodecInfo codecInfo = getCodecInfo();
                if (codecInfo != null && shouldUseDummySurface(codecInfo.secure)) {
                    this.dummySurface = DummySurface.newInstanceV17(this.context, codecInfo.secure);
                    surface2 = this.dummySurface;
                }
            }
        }
        if (this.surface != surface2) {
            this.surface = surface2;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec codec = getCodec();
                if (Util.SDK_INT < 23 || codec == null || surface2 == null || this.codecNeedsSetOutputSurfaceWorkaround) {
                    releaseCodec();
                    maybeInitCodec();
                } else {
                    setOutputSurfaceV23(codec, surface2);
                }
            }
            if (surface2 == null || surface2 == this.dummySurface) {
                clearReportedVideoSize();
                clearRenderedFirstFrame();
                return;
            }
            maybeRenotifyVideoSizeChanged();
            clearRenderedFirstFrame();
            if (state == 2) {
                setJoiningDeadlineMs();
            }
        } else if (surface2 != null && surface2 != this.dummySurface) {
            maybeRenotifyVideoSizeChanged();
            maybeRenotifyRenderedFirstFrame();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return this.surface != null || shouldUseDummySurface(mediaCodecInfo.secure);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.codecMaxValues = getCodecMaxValues(mediaCodecInfo, format, this.streamFormats);
        MediaFormat mediaFormat = getMediaFormat(format, this.codecMaxValues, this.deviceNeedsAutoFrcWorkaround, this.tunnelingAudioSessionId);
        if (this.surface == null) {
            Assertions.checkState(shouldUseDummySurface(mediaCodecInfo.secure));
            if (this.dummySurface == null) {
                this.dummySurface = DummySurface.newInstanceV17(this.context, mediaCodecInfo.secure);
            }
            this.surface = this.dummySurface;
        }
        mediaCodec.configure(mediaFormat, this.surface, mediaCrypto, 0);
        if (Util.SDK_INT >= 23 && this.tunneling) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(mediaCodec);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void releaseCodec() {
        try {
            super.releaseCodec();
        } finally {
            if (this.dummySurface != null) {
                if (this.surface == this.dummySurface) {
                    this.surface = null;
                }
                this.dummySurface.release();
                this.dummySurface = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecInitialized(String str, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
        this.maxAheadTimedReleasUs = getMaxAheadTimedReleasUs();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onInputFormatChanged(Format format) {
        super.onInputFormatChanged(format);
        this.eventDispatcher.inputFormatChanged(format);
        this.pendingPixelWidthHeightRatio = getPixelWidthHeightRatio(format);
        this.pendingRotationDegrees = getRotationDegrees(format);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (Util.SDK_INT < 23 && this.tunneling) {
            maybeNotifyRenderedFirstFrame();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int i2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i = mediaFormat.getInteger("width");
        }
        this.currentWidth = i;
        if (z) {
            i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        this.currentHeight = i2;
        this.currentPixelWidthHeightRatio = this.pendingPixelWidthHeightRatio;
        if (Util.SDK_INT < 21) {
            this.currentUnappliedRotationDegrees = this.pendingRotationDegrees;
        } else if (this.pendingRotationDegrees == 90 || this.pendingRotationDegrees == 270) {
            int i3 = this.currentWidth;
            this.currentWidth = this.currentHeight;
            this.currentHeight = i3;
            this.currentPixelWidthHeightRatio = 1.0f / this.currentPixelWidthHeightRatio;
        }
        setVideoScalingMode(mediaCodec, this.scalingMode);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean canReconfigureCodec(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return areAdaptationCompatible(z, format, format2) && format2.width <= this.codecMaxValues.width && format2.height <= this.codecMaxValues.height && getMaxInputSize(format2) <= this.codecMaxValues.inputSize;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean processOutputBuffer(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        while (this.pendingOutputStreamOffsetCount != 0 && j3 >= this.pendingOutputStreamOffsetsUs[0]) {
            this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[0];
            this.pendingOutputStreamOffsetCount--;
            System.arraycopy(this.pendingOutputStreamOffsetsUs, 1, this.pendingOutputStreamOffsetsUs, 0, this.pendingOutputStreamOffsetCount);
        }
        long j4 = j3 - this.outputStreamOffsetUs;
        if (z) {
            skipOutputBuffer(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.surface == this.dummySurface) {
            if (!isBufferLate(j5)) {
                return false;
            }
            skipOutputBuffer(mediaCodec, i, j4);
            return true;
        } else if (!this.renderedFirstFrame) {
            if (Util.SDK_INT >= 21) {
                renderOutputBufferV21(mediaCodec, i, j4, System.nanoTime());
                return true;
            }
            renderOutputBuffer(mediaCodec, i, j4);
            return true;
        } else if (getState() != 2) {
            return false;
        } else {
            long nanoTime = System.nanoTime();
            long adjustReleaseTime = this.frameReleaseTimeHelper.adjustReleaseTime(j3, nanoTime + (1000 * (j5 - ((SystemClock.elapsedRealtime() * 1000) - j2))));
            long j6 = (adjustReleaseTime - nanoTime) / 1000;
            if (shouldDropOutputBuffer(j6, j2)) {
                dropOutputBuffer(mediaCodec, i, j4);
                return true;
            } else if (Util.SDK_INT >= 21) {
                if (j6 >= this.maxAheadTimedReleasUs) {
                    return false;
                }
                renderOutputBufferV21(mediaCodec, i, j4, adjustReleaseTime);
                return true;
            } else if (j6 >= 30000) {
                return false;
            } else {
                if (j6 > 11000) {
                    try {
                        Thread.sleep((j6 - 10000) / 1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                renderOutputBuffer(mediaCodec, i, j4);
                return true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropOutputBuffer(long j, long j2) {
        return isBufferLate(j);
    }

    /* access modifiers changed from: protected */
    public void skipOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    /* access modifiers changed from: protected */
    public void dropOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.droppedOutputBufferCount++;
        this.droppedFrames++;
        this.consecutiveDroppedFrameCount++;
        this.decoderCounters.maxConsecutiveDroppedOutputBufferCount = Math.max(this.consecutiveDroppedFrameCount, this.decoderCounters.maxConsecutiveDroppedOutputBufferCount);
        if (this.droppedFrames == this.maxDroppedFramesToNotify) {
            maybeNotifyDroppedFrames();
        }
    }

    /* access modifiers changed from: protected */
    public void renderOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public void renderOutputBufferV21(MediaCodec mediaCodec, int i, long j, long j2) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    private boolean shouldUseDummySurface(boolean z) {
        return false;
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    private void clearRenderedFirstFrame() {
        MediaCodec codec;
        this.renderedFirstFrame = false;
        if (Util.SDK_INT >= 23 && this.tunneling && (codec = getCodec()) != null) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
        }
    }

    /* access modifiers changed from: package-private */
    public void maybeNotifyRenderedFirstFrame() {
        if (!this.renderedFirstFrame) {
            this.renderedFirstFrame = true;
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedWidth = -1;
        this.reportedHeight = -1;
        this.reportedPixelWidthHeightRatio = -1.0f;
        this.reportedUnappliedRotationDegrees = -1;
    }

    private void maybeNotifyVideoSizeChanged() {
        if (this.currentWidth != -1 || this.currentHeight != -1) {
            if (this.reportedWidth != this.currentWidth || this.reportedHeight != this.currentHeight || this.reportedUnappliedRotationDegrees != this.currentUnappliedRotationDegrees || this.reportedPixelWidthHeightRatio != this.currentPixelWidthHeightRatio) {
                this.eventDispatcher.videoSizeChanged(this.currentWidth, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
                this.reportedWidth = this.currentWidth;
                this.reportedHeight = this.currentHeight;
                this.reportedUnappliedRotationDegrees = this.currentUnappliedRotationDegrees;
                this.reportedPixelWidthHeightRatio = this.currentPixelWidthHeightRatio;
            }
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        if (this.reportedWidth != -1 || this.reportedHeight != -1) {
            this.eventDispatcher.videoSizeChanged(this.reportedWidth, this.reportedHeight, this.reportedUnappliedRotationDegrees, this.reportedPixelWidthHeightRatio);
        }
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    private static boolean isBufferLate(long j) {
        return j < -30000;
    }

    @TargetApi(23)
    private static void setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface2) {
        mediaCodec.setOutputSurface(surface2);
    }

    @TargetApi(21)
    private static void configureTunnelingV21(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    /* access modifiers changed from: protected */
    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int i = format.width;
        int i2 = format.height;
        int maxInputSize = getMaxInputSize(format);
        if (formatArr.length == 1) {
            return new CodecMaxValues(i, i2, maxInputSize);
        }
        boolean z = false;
        for (Format format2 : formatArr) {
            if (areAdaptationCompatible(mediaCodecInfo.adaptive, format, format2)) {
                z |= format2.width == -1 || format2.height == -1;
                i = Math.max(i, format2.width);
                i2 = Math.max(i2, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(format2));
            }
        }
        if (z) {
            Log.w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i + "x" + i2);
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                i = Math.max(i, codecMaxSize.x);
                i2 = Math.max(i2, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(format.sampleMimeType, i, i2));
                Log.w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i + "x" + i2);
            }
        }
        return new CodecMaxValues(i, i2, maxInputSize);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    public MediaFormat getMediaFormat(Format format, CodecMaxValues codecMaxValues2, boolean z, int i) {
        MediaFormat frameworkMediaFormatV16 = format.getFrameworkMediaFormatV16();
        frameworkMediaFormatV16.setInteger("max-width", codecMaxValues2.width);
        frameworkMediaFormatV16.setInteger("max-height", codecMaxValues2.height);
        if (codecMaxValues2.inputSize != -1) {
            frameworkMediaFormatV16.setInteger("max-input-size", codecMaxValues2.inputSize);
        }
        if (z) {
            frameworkMediaFormatV16.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            configureTunnelingV21(frameworkMediaFormatV16, i);
        }
        return frameworkMediaFormatV16;
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) {
        boolean z = format.height > format.width;
        int i = z ? format.height : format.width;
        int i2 = z ? format.width : format.height;
        float f = ((float) i2) / ((float) i);
        int[] iArr = STANDARD_LONG_EDGE_VIDEO_PX;
        for (int i3 : iArr) {
            int i4 = (int) (((float) i3) * f);
            if (i3 <= i || i4 <= i2) {
                return null;
            }
            if (Util.SDK_INT >= 21) {
                Point alignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(z ? i4 : i3, z ? i3 : i4);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(alignVideoSizeV21.x, alignVideoSizeV21.y, (double) format.frameRate)) {
                    return alignVideoSizeV21;
                }
            } else {
                int ceilDivide = Util.ceilDivide(i3, 16) * 16;
                int ceilDivide2 = Util.ceilDivide(i4, 16) * 16;
                if (ceilDivide * ceilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                    return new Point(z ? ceilDivide2 : ceilDivide, z ? ceilDivide : ceilDivide2);
                }
            }
        }
        return null;
    }

    private static int getMaxInputSize(Format format) {
        if (format.maxInputSize == -1) {
            return getMaxInputSize(format.sampleMimeType, format.width, format.height);
        }
        int i = 0;
        int size = format.initializationData.size();
        for (int i2 = 0; i2 < size; i2++) {
            i += format.initializationData.get(i2).length;
        }
        return format.maxInputSize + i;
    }

    private static int getMaxInputSize(String str, int i, int i2) {
        int i3;
        int i4;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c = 0;
                    break;
                }
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c = 4;
                    break;
                }
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c = 1;
                    break;
                }
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c = 2;
                    break;
                }
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c = 3;
                    break;
                }
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                i4 = i * i2;
                i3 = 2;
                break;
            case 2:
                if (!"BRAVIA 4K 2015".equals(Util.MODEL)) {
                    i4 = Util.ceilDivide(i, 16) * Util.ceilDivide(i2, 16) * 16 * 16;
                    i3 = 2;
                    break;
                } else {
                    return -1;
                }
            case 3:
                i4 = i * i2;
                i3 = 2;
                break;
            case 4:
            case 5:
                i4 = i * i2;
                i3 = 4;
                break;
            default:
                return -1;
        }
        return (i4 * 3) / (i3 * 2);
    }

    private static void setVideoScalingMode(MediaCodec mediaCodec, int i) {
        mediaCodec.setVideoScalingMode(i);
    }

    private static boolean deviceNeedsAutoFrcWorkaround() {
        return Util.SDK_INT <= 22 && "foster".equals(Util.DEVICE) && "NVIDIA".equals(Util.MANUFACTURER);
    }

    private static boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        boolean z = ("deb".equals(Util.DEVICE) || "flo".equals(Util.DEVICE)) && "OMX.qcom.video.decoder.avc".equals(str);
        if (Util.SDK_INT == 24) {
            return ("sony".equalsIgnoreCase(Util.MANUFACTURER) && "g3313".equalsIgnoreCase(Util.MODEL)) || z || "OMX.IMG.MSVDX.Decoder.AVC".equals(str);
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public long getMaxAheadTimedReleasUs() {
        return 45000;
    }

    private static boolean areAdaptationCompatible(boolean z, Format format, Format format2) {
        return format.sampleMimeType.equals(format2.sampleMimeType) && getRotationDegrees(format) == getRotationDegrees(format2) && (z || (format.width == format2.width && format.height == format2.height));
    }

    private static float getPixelWidthHeightRatio(Format format) {
        if (format.pixelWidthHeightRatio == -1.0f) {
            return 1.0f;
        }
        return format.pixelWidthHeightRatio;
    }

    private static int getRotationDegrees(Format format) {
        if (format.rotationDegrees == -1) {
            return 0;
        }
        return format.rotationDegrees;
    }

    /* access modifiers changed from: protected */
    public static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(23)
    public final class OnFrameRenderedListenerV23 implements MediaCodec.OnFrameRenderedListener {
        private OnFrameRenderedListenerV23(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            if (this == MediaCodecVideoRenderer.this.tunnelingOnFrameRenderedListener) {
                MediaCodecVideoRenderer.this.maybeNotifyRenderedFirstFrame();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int getSurfaceValidityCode() {
        if (this.surface == null) {
            return 0;
        }
        return this.surface.isValid() ? 1 : -1;
    }
}
