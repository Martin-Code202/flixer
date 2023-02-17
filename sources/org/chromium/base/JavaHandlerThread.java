package org.chromium.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.Thread;
import org.chromium.base.annotations.CalledByNative;
public class JavaHandlerThread {
    static final /* synthetic */ boolean $assertionsDisabled = (!JavaHandlerThread.class.desiredAssertionStatus());
    private final HandlerThread mThread;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeInitializeThread(long j, long j2);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeStopThread(long j, long j2);

    public JavaHandlerThread(String str) {
        this.mThread = new HandlerThread(str);
    }

    @CalledByNative
    private static JavaHandlerThread create(String str) {
        return new JavaHandlerThread(str);
    }

    public void maybeStart() {
        if (!hasStarted()) {
            this.mThread.start();
        }
    }

    @CalledByNative
    private void startAndInitialize(final long j, final long j2) {
        maybeStart();
        new Handler(this.mThread.getLooper()).post(new Runnable() { // from class: org.chromium.base.JavaHandlerThread.1
            @Override // java.lang.Runnable
            public void run() {
                JavaHandlerThread.this.nativeInitializeThread(j, j2);
            }
        });
    }

    @TargetApi(18)
    @CalledByNative
    private void stop(final long j, final long j2) {
        if ($assertionsDisabled || hasStarted()) {
            final boolean z = Build.VERSION.SDK_INT >= 18;
            new Handler(this.mThread.getLooper()).post(new Runnable() { // from class: org.chromium.base.JavaHandlerThread.2
                @Override // java.lang.Runnable
                public void run() {
                    JavaHandlerThread.this.nativeStopThread(j, j2);
                    if (!z) {
                        JavaHandlerThread.this.mThread.quit();
                    }
                }
            });
            if (z) {
                this.mThread.quitSafely();
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    private boolean hasStarted() {
        return this.mThread.getState() != Thread.State.NEW;
    }
}
