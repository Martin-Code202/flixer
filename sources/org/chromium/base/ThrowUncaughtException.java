package org.chromium.base;

import org.chromium.base.annotations.CalledByNative;
abstract class ThrowUncaughtException {
    ThrowUncaughtException() {
    }

    @CalledByNative
    private static void post() {
        ThreadUtils.postOnUiThread(new Runnable() { // from class: org.chromium.base.ThrowUncaughtException.1
            @Override // java.lang.Runnable
            public void run() {
                throw new RuntimeException("Intentional exception not caught by JNI");
            }
        });
    }
}
