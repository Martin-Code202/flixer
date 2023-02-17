package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.WindowManager;
@TargetApi(16)
public final class VideoFrameReleaseTimeHelper {
    private long adjustedLastFrameTimeNs;
    private long frameCount;
    private boolean haveSync;
    private long lastFramePresentationTimeUs;
    private long pendingAdjustedFrameTimeNs;
    private long syncFramePresentationTimeNs;
    private long syncUnadjustedReleaseTimeNs;
    private final boolean useDefaultDisplayVsync;
    private final long vsyncDurationNs;
    private final long vsyncOffsetNs;
    private final VSyncSampler vsyncSampler;

    public VideoFrameReleaseTimeHelper() {
        this(-1.0d);
    }

    public VideoFrameReleaseTimeHelper(Context context) {
        this(getDefaultDisplayRefreshRate(context));
    }

    private VideoFrameReleaseTimeHelper(double d) {
        this.useDefaultDisplayVsync = d != -1.0d;
        if (this.useDefaultDisplayVsync) {
            this.vsyncSampler = VSyncSampler.getInstance();
            this.vsyncDurationNs = (long) (1.0E9d / d);
            this.vsyncOffsetNs = (this.vsyncDurationNs * 80) / 100;
            return;
        }
        this.vsyncSampler = null;
        this.vsyncDurationNs = -1;
        this.vsyncOffsetNs = -1;
    }

    public void enable() {
        this.haveSync = false;
        if (this.useDefaultDisplayVsync) {
            this.vsyncSampler.addObserver();
        }
    }

    public void disable() {
        if (this.useDefaultDisplayVsync) {
            this.vsyncSampler.removeObserver();
        }
    }

    public long adjustReleaseTime(long j, long j2) {
        long j3 = j * 1000;
        long j4 = j3;
        long j5 = j2;
        if (this.haveSync) {
            if (j != this.lastFramePresentationTimeUs) {
                this.frameCount++;
                this.adjustedLastFrameTimeNs = this.pendingAdjustedFrameTimeNs;
            }
            if (this.frameCount >= 6) {
                long j6 = this.adjustedLastFrameTimeNs + ((j3 - this.syncFramePresentationTimeNs) / this.frameCount);
                if (isDriftTooLarge(j6, j2)) {
                    this.haveSync = false;
                } else {
                    j4 = j6;
                    j5 = (this.syncUnadjustedReleaseTimeNs + j4) - this.syncFramePresentationTimeNs;
                }
            } else if (isDriftTooLarge(j3, j2)) {
                this.haveSync = false;
            }
        }
        if (!this.haveSync) {
            this.syncFramePresentationTimeNs = j3;
            this.syncUnadjustedReleaseTimeNs = j2;
            this.frameCount = 0;
            this.haveSync = true;
            onSynced();
        }
        this.lastFramePresentationTimeUs = j;
        this.pendingAdjustedFrameTimeNs = j4;
        if (this.vsyncSampler == null || this.vsyncSampler.sampledVsyncTimeNs == 0) {
            return j5;
        }
        return closestVsync(j5, this.vsyncSampler.sampledVsyncTimeNs, this.vsyncDurationNs) - this.vsyncOffsetNs;
    }

    /* access modifiers changed from: protected */
    public void onSynced() {
    }

    private boolean isDriftTooLarge(long j, long j2) {
        return Math.abs((j2 - this.syncUnadjustedReleaseTimeNs) - (j - this.syncFramePresentationTimeNs)) > 20000000;
    }

    private static long closestVsync(long j, long j2, long j3) {
        long j4;
        long j5;
        long j6 = j2 + (j3 * ((j - j2) / j3));
        if (j <= j6) {
            j5 = j6 - j3;
            j4 = j6;
        } else {
            j5 = j6;
            j4 = j6 + j3;
        }
        return j4 - j < j - j5 ? j4 : j5;
    }

    private static double getDefaultDisplayRefreshRate(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager.getDefaultDisplay() != null) {
            return (double) windowManager.getDefaultDisplay().getRefreshRate();
        }
        return -1.0d;
    }

    /* access modifiers changed from: package-private */
    public static final class VSyncSampler implements Choreographer.FrameCallback, Handler.Callback {
        private static final VSyncSampler INSTANCE = new VSyncSampler();
        private Choreographer choreographer;
        private final HandlerThread choreographerOwnerThread = new HandlerThread("ChoreographerOwner:Handler");
        private final Handler handler;
        private int observerCount;
        public volatile long sampledVsyncTimeNs;

        public static VSyncSampler getInstance() {
            return INSTANCE;
        }

        private VSyncSampler() {
            this.choreographerOwnerThread.start();
            this.handler = new Handler(this.choreographerOwnerThread.getLooper(), this);
            this.handler.sendEmptyMessage(0);
        }

        public void addObserver() {
            this.handler.sendEmptyMessage(1);
        }

        public void removeObserver() {
            this.handler.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.sampledVsyncTimeNs = j;
            this.choreographer.postFrameCallbackDelayed(this, 500);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    createChoreographerInstanceInternal();
                    return true;
                case 1:
                    addObserverInternal();
                    return true;
                case 2:
                    removeObserverInternal();
                    return true;
                default:
                    return false;
            }
        }

        private void createChoreographerInstanceInternal() {
            this.choreographer = Choreographer.getInstance();
        }

        private void addObserverInternal() {
            this.observerCount++;
            if (this.observerCount == 1) {
                this.choreographer.postFrameCallback(this);
            }
        }

        private void removeObserverInternal() {
            this.observerCount--;
            if (this.observerCount == 0) {
                this.choreographer.removeFrameCallback(this);
                this.sampledVsyncTimeNs = 0;
            }
        }
    }
}
