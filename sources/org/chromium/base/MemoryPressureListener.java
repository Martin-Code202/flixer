package org.chromium.base;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import org.chromium.base.annotations.CalledByNative;
public class MemoryPressureListener {
    /* access modifiers changed from: private */
    public static native void nativeOnMemoryPressure(int i);

    @CalledByNative
    private static void registerSystemCallback() {
        ContextUtils.getApplicationContext().registerComponentCallbacks(new ComponentCallbacks2() { // from class: org.chromium.base.MemoryPressureListener.1
            @Override // android.content.ComponentCallbacks2
            public void onTrimMemory(int i) {
                MemoryPressureListener.maybeNotifyMemoryPresure(i);
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
                MemoryPressureListener.nativeOnMemoryPressure(2);
            }

            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
            }
        });
    }

    public static void maybeNotifyMemoryPresure(int i) {
        if (i >= 80) {
            nativeOnMemoryPressure(2);
        } else if (i >= 40 || i == 15) {
            nativeOnMemoryPressure(1);
        }
    }
}
