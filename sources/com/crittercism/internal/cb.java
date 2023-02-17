package com.crittercism.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
public final class cb {
    public static boolean a = true;
    public SharedPreferences b;

    public cb(Context context) {
        if (a) {
            a = false;
            if (Looper.getMainLooper() == Looper.myLooper()) {
                cf.b(ce.StrictModeSessionId.a());
            }
        }
        this.b = context.getSharedPreferences("com.crittercism.usersettings", 0);
        if (!this.b.contains("sessionIDSetting")) {
            this.b.edit().putInt("sessionIDSetting", 0).commit();
        }
    }
}
