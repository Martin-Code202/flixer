package org.linphone.mediastream.video.display;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import org.linphone.mediastream.Log;
public class GL2JNIView extends GLSurfaceView {
    private static final boolean DEBUG = false;

    public GL2JNIView(Context context) {
        super(context);
        init(false, 0, 0);
    }

    public GL2JNIView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(false, 0, 0);
    }

    public GL2JNIView(Context context, boolean z, int i, int i2) {
        super(context);
        init(z, i, i2);
    }

    private void init(boolean z, int i, int i2) {
        if (z) {
            getHolder().setFormat(-3);
        }
        setEGLContextFactory(new ContextFactory());
        setEGLConfigChooser(z ? new ConfigChooser(8, 8, 8, 8, i, i2) : new ConfigChooser(5, 6, 5, 0, i, i2));
    }

    /* access modifiers changed from: package-private */
    public static class ContextFactory implements GLSurfaceView.EGLContextFactory {
        private static int EGL_CONTEXT_CLIENT_VERSION = 12440;

        private ContextFactory() {
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            Log.w("creating OpenGL ES 2.0 context");
            GL2JNIView.checkEglError("Before eglCreateContext", egl10);
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
            GL2JNIView.checkEglError("After eglCreateContext", egl10);
            return eglCreateContext;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    /* access modifiers changed from: private */
    public static void checkEglError(String str, EGL10 egl10) {
        while (true) {
            int eglGetError = egl10.eglGetError();
            if (eglGetError != 12288) {
                Log.e(String.format("%s: EGL error: 0x%x", str, Integer.valueOf(eglGetError)));
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class ConfigChooser implements GLSurfaceView.EGLConfigChooser {
        private static int EGL_OPENGL_ES2_BIT = 4;
        private static int[] s_configAttribs2 = {12324, 4, 12323, 4, 12322, 4, 12352, EGL_OPENGL_ES2_BIT, 12344};
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public ConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, s_configAttribs2, null, 0, iArr);
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            egl10.eglChooseConfig(eGLDisplay, s_configAttribs2, eGLConfigArr, i, iArr);
            return chooseConfig(egl10, eGLDisplay, eGLConfigArr);
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue)) {
                return this.mValue[0];
            }
            return i2;
        }

        private void printConfigs(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            int length = eGLConfigArr.length;
            Log.w(String.format("%d configurations", Integer.valueOf(length)));
            for (int i = 0; i < length; i++) {
                Log.w(String.format("Configuration %d:\n", Integer.valueOf(i)));
                printConfig(egl10, eGLDisplay, eGLConfigArr[i]);
            }
        }

        private void printConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354};
            String[] strArr = {"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
            int[] iArr2 = new int[1];
            int i = 0;
            while (true) {
                int length = iArr.length;
                if (i < 33) {
                    int i2 = iArr[i];
                    String str = strArr[i];
                    if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, iArr2)) {
                        Log.w(String.format("  %s: %d\n", str, Integer.valueOf(iArr2[0])));
                    } else {
                        do {
                        } while (egl10.eglGetError() != 12288);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
