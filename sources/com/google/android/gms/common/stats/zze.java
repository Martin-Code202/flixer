package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.zzj;
import java.util.List;
public final class zze {
    private static boolean zzfxj = false;
    private static zze zzfyj = new zze();
    private static Boolean zzfyk;

    public static void zza(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        zza(context, str, 8, str2, str3, str4, i2, list, 0);
    }

    public static void zza(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        if (zzfyk == null) {
            zzfyk = false;
        }
        if (zzfyk.booleanValue()) {
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                Log.e("WakeLockTracker", valueOf.length() != 0 ? "missing wakeLock key. ".concat(valueOf) : new String("missing wakeLock key. "));
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (7 == i || 8 == i || 10 == i || 11 == i) {
                List<String> list2 = list;
                if (list != null && list.size() == 1) {
                    list2 = "com.google.android.gms".equals(list.get(0)) ? null : list;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int zzcm = zzj.zzcm(context);
                String packageName = context.getPackageName();
                try {
                    context.startService(new Intent().setComponent(zzb.zzfxo).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(currentTimeMillis, i, str2, i2, list2, str, elapsedRealtime, zzcm, str3, "com.google.android.gms".equals(packageName) ? null : packageName, zzj.zzcn(context), j, str4)));
                } catch (Exception e) {
                    Log.wtf("WakeLockTracker", e);
                }
            }
        }
    }

    public static zze zzalc() {
        return zzfyj;
    }
}
