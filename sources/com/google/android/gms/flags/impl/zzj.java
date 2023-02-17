package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzbvp;
public final class zzj {
    private static SharedPreferences zzhbh = null;

    public static SharedPreferences zzcy(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (zzhbh == null) {
                zzhbh = (SharedPreferences) zzbvp.zza(new zzk(context));
            }
            sharedPreferences = zzhbh;
        }
        return sharedPreferences;
    }
}
