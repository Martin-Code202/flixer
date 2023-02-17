package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.util.zzp;
public final class zzbeb {
    private static Context zzfzp;
    private static Boolean zzfzq;

    public static synchronized boolean zzcp(Context context) {
        synchronized (zzbeb.class) {
            Context applicationContext = context.getApplicationContext();
            if (zzfzp == null || zzfzq == null || zzfzp != applicationContext) {
                zzfzq = null;
                if (zzp.isAtLeastO()) {
                    zzfzq = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        zzfzq = true;
                    } catch (ClassNotFoundException unused) {
                        zzfzq = false;
                    }
                }
                zzfzp = applicationContext;
                return zzfzq.booleanValue();
            }
            return zzfzq.booleanValue();
        }
    }
}
