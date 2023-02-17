package org.chromium.base;

import android.content.Context;
public class ContextUtils {
    private static Context sApplicationContext;

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    public static void initApplicationContext(Context context) {
        if (sApplicationContext == null || sApplicationContext == context) {
            initJavaSideApplicationContext(context);
            return;
        }
        throw new RuntimeException("Attempting to set multiple global application contexts.");
    }

    private static void initJavaSideApplicationContext(Context context) {
        if (context == null) {
            throw new RuntimeException("Global application context cannot be set to null.");
        }
        sApplicationContext = context;
    }
}
