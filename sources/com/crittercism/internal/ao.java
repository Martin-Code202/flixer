package com.crittercism.internal;

import android.content.Context;
import com.crittercism.app.CrittercismConfig;
public final class ao {
    public boolean a;
    public boolean b;
    private boolean c;

    public ao(Context context, CrittercismConfig crittercismConfig) {
        this.a = crittercismConfig.isLogcatReportingEnabled();
        this.b = a("android.permission.ACCESS_NETWORK_STATE", context);
        this.c = a("android.permission.GET_TASKS", context);
    }

    private static boolean a(String str, Context context) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) != -1;
    }
}
