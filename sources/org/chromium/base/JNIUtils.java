package org.chromium.base;

import org.chromium.base.annotations.CalledByNative;
public class JNIUtils {
    static final /* synthetic */ boolean $assertionsDisabled = (!JNIUtils.class.desiredAssertionStatus());
    private static Boolean sSelectiveJniRegistrationEnabled;

    @CalledByNative
    public static Object getClassLoader() {
        return JNIUtils.class.getClassLoader();
    }

    @CalledByNative
    public static boolean isSelectiveJniRegistrationEnabled() {
        if (sSelectiveJniRegistrationEnabled == null) {
            sSelectiveJniRegistrationEnabled = false;
        }
        return sSelectiveJniRegistrationEnabled.booleanValue();
    }
}
