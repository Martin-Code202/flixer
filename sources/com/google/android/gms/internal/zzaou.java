package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzbp;
public final class zzaou {
    static Object zzaqc = new Object();
    private static Boolean zzdjp;
    static zzcqh zzdtv;

    public static void onReceive(Context context, Intent intent) {
        zzaon zzvy = zzamu.zzbg(context).zzvy();
        if (intent == null) {
            zzvy.zzdp("AnalyticsReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzvy.zza("Local AnalyticsReceiver got", action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean zzbi = zzaov.zzbi(context);
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (zzaqc) {
                context.startService(intent2);
                if (zzbi) {
                    try {
                        if (zzdtv == null) {
                            zzcqh zzcqh = new zzcqh(context, 1, "Analytics WakeLock");
                            zzdtv = zzcqh;
                            zzcqh.setReferenceCounted(false);
                        }
                        zzdtv.acquire(1000);
                    } catch (SecurityException unused) {
                        zzvy.zzdp("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                }
            }
        }
    }

    public static boolean zzbe(Context context) {
        zzbp.zzu(context);
        if (zzdjp != null) {
            return zzdjp.booleanValue();
        }
        boolean zza = zzapd.zza(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        zzdjp = Boolean.valueOf(zza);
        return zza;
    }
}
