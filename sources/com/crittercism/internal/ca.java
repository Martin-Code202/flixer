package com.crittercism.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.crittercism.app.CrashData;
public final class ca {
    public static CrashData a;

    public static void a(Context context, CrashData crashData) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.crittercism.usersettings", 0).edit();
        boolean z = crashData != null;
        edit.putBoolean("crashedOnLastLoad", z);
        if (z) {
            edit.putString("crashName", crashData.getName());
            edit.putString("crashReason", crashData.getReason());
            edit.putLong("crashDate", crashData.getTimeOccurred().getTime());
        }
        edit.commit();
    }
}
