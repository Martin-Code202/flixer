package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.zzbed;
public final class zzc {
    public static boolean zzab(Context context, String str) {
        "com.google.android.gms".equals(str);
        try {
            return (zzbed.zzcr(context).getApplicationInfo(str, 0).flags & 2097152) != 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
