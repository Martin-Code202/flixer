package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;
@Deprecated
public final class zzaom {
    private static volatile Logger zzdtg = new zzanw();

    private static boolean zzad(int i) {
        return zzdtg != null && zzdtg.getLogLevel() <= i;
    }

    public static void zzf(String str, Object obj) {
        String str2;
        zzaon zzyt = zzaon.zzyt();
        if (zzyt != null) {
            zzyt.zze(str, obj);
        } else if (zzad(3)) {
            if (obj != null) {
                String valueOf = String.valueOf(obj);
                str2 = new StringBuilder(String.valueOf(valueOf).length() + String.valueOf(str).length() + 1).append(str).append(":").append(valueOf).toString();
            } else {
                str2 = str;
            }
            Log.e(zzaod.zzdra.get(), str2);
        }
        Logger logger = zzdtg;
        if (logger != null) {
            logger.error(str);
        }
    }
}
