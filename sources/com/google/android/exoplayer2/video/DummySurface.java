package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
@TargetApi(17)
public final class DummySurface extends Surface {
    private static boolean secureSupported;
    private static boolean secureSupportedInitialized;
    public final boolean secure;
    private final DummySurfaceThread thread;
    private boolean threadReleased;

    public static synchronized boolean isSecureSupported(Context context) {
        boolean z;
        synchronized (DummySurface.class) {
            if (!secureSupportedInitialized) {
                secureSupported = Util.SDK_INT >= 24 && enableSecureDummySurfaceV24(context);
                secureSupportedInitialized = true;
            }
            z = secureSupported;
        }
        return z;
    }

    public static DummySurface newInstanceV17(Context context, boolean z) {
        assertApiLevel17OrHigher();
        Assertions.checkState(!z || isSecureSupported(context));
        return new DummySurfaceThread().init(z);
    }

    private DummySurface(DummySurfaceThread dummySurfaceThread, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.thread = dummySurfaceThread;
        this.secure = z;
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.thread) {
            if (!this.threadReleased) {
                this.thread.release();
                this.threadReleased = true;
            }
        }
    }

    private static void assertApiLevel17OrHigher() {
        if (Util.SDK_INT < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    @TargetApi(24)
    private static boolean enableSecureDummySurfaceV24(Context context) {
        String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
        if (eglQueryString == null || !eglQueryString.contains("EGL_EXT_protected_content")) {
            return false;
        }
        if (Util.SDK_INT == 24 && "samsung".equals(Util.MANUFACTURER)) {
            return false;
        }
        if (Util.SDK_INT >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public static class DummySurfaceThread extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {
        private EGLContext context;
        private EGLDisplay display;
        private Handler handler;
        private Error initError;
        private RuntimeException initException;
        private EGLSurface pbuffer;
        private DummySurface surface;
        private SurfaceTexture surfaceTexture;
        private final int[] textureIdHolder = new int[1];

        public DummySurfaceThread() {
            super("dummySurface");
        }

        public DummySurface init(boolean z) {
            start();
            this.handler = new Handler(getLooper(), this);
            boolean z2 = false;
            synchronized (this) {
                this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
                while (this.surface == null && this.initException == null && this.initError == null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
            if (this.initException != null) {
                throw this.initException;
            } else if (this.initError == null) {
                return this.surface;
            } else {
                throw this.initError;
            }
        }

        public void release() {
            this.handler.sendEmptyMessage(3);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture2) {
            this.handler.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    try {
                        initInternal(message.arg1 != 0);
                        synchronized (this) {
                            notify();
                        }
                        return true;
                    } catch (RuntimeException e) {
                        Log.e("DummySurface", "Failed to initialize dummy surface", e);
                        this.initException = e;
                        synchronized (this) {
                            notify();
                            return true;
                        }
                    } catch (Error e2) {
                        Log.e("DummySurface", "Failed to initialize dummy surface", e2);
                        this.initError = e2;
                        synchronized (this) {
                            notify();
                            return true;
                        }
                    } catch (Throwable th) {
                        synchronized (this) {
                            notify();
                            throw th;
                        }
                    }
                case 2:
                    this.surfaceTexture.updateTexImage();
                    return true;
                case 3:
                    try {
                        releaseInternal();
                        return true;
                    } catch (Throwable th2) {
                        Log.e("DummySurface", "Failed to release dummy surface", th2);
                        return true;
                    } finally {
                        quit();
                    }
                default:
                    return true;
            }
        }

        private void initInternal(boolean z) {
            int[] iArr;
            int[] iArr2;
            this.display = EGL14.eglGetDisplay(0);
            Assertions.checkState(this.display != null, "eglGetDisplay failed");
            int[] iArr3 = new int[2];
            Assertions.checkState(EGL14.eglInitialize(this.display, iArr3, 0, iArr3, 1), "eglInitialize failed");
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr4 = new int[1];
            Assertions.checkState(EGL14.eglChooseConfig(this.display, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr4, 0) && iArr4[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
            EGLConfig eGLConfig = eGLConfigArr[0];
            if (z) {
                iArr = new int[]{12440, 2, 12992, 1, 12344};
            } else {
                iArr = new int[]{12440, 2, 12344};
            }
            this.context = EGL14.eglCreateContext(this.display, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
            Assertions.checkState(this.context != null, "eglCreateContext failed");
            if (z) {
                iArr2 = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
            } else {
                iArr2 = new int[]{12375, 1, 12374, 1, 12344};
            }
            this.pbuffer = EGL14.eglCreatePbufferSurface(this.display, eGLConfig, iArr2, 0);
            Assertions.checkState(this.pbuffer != null, "eglCreatePbufferSurface failed");
            Assertions.checkState(EGL14.eglMakeCurrent(this.display, this.pbuffer, this.pbuffer, this.context), "eglMakeCurrent failed");
            GLES20.glGenTextures(1, this.textureIdHolder, 0);
            this.surfaceTexture = new SurfaceTexture(this.textureIdHolder[0]);
            this.surfaceTexture.setOnFrameAvailableListener(this);
            this.surface = new DummySurface(this, this.surfaceTexture, z);
        }

        private void releaseInternal() {
            try {
                if (this.surfaceTexture != null) {
                    this.surfaceTexture.release();
                    GLES20.glDeleteTextures(1, this.textureIdHolder, 0);
                }
            } finally {
                if (this.pbuffer != null) {
                    EGL14.eglDestroySurface(this.display, this.pbuffer);
                }
                if (this.context != null) {
                    EGL14.eglDestroyContext(this.display, this.context);
                }
                this.pbuffer = null;
                this.context = null;
                this.display = null;
                this.surface = null;
                this.surfaceTexture = null;
            }
        }
    }
}
