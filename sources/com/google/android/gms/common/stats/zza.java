package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.zzc;
import java.util.Collections;
import java.util.List;
public final class zza {
    private static final Object zzfus = new Object();
    private static volatile zza zzfxi;
    private static boolean zzfxj = false;
    private final List<String> zzfxk = Collections.EMPTY_LIST;
    private final List<String> zzfxl = Collections.EMPTY_LIST;
    private final List<String> zzfxm = Collections.EMPTY_LIST;
    private final List<String> zzfxn = Collections.EMPTY_LIST;

    private zza() {
    }

    public static zza zzakz() {
        if (zzfxi == null) {
            synchronized (zzfus) {
                if (zzfxi == null) {
                    zzfxi = new zza();
                }
            }
        }
        return zzfxi;
    }

    public final boolean zza(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    public final boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        if (!(component == null ? false : zzc.zzab(context, component.getPackageName()))) {
            return context.bindService(intent, serviceConnection, i);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }
}
