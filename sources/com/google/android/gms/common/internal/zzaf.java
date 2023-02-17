package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
public abstract class zzaf {
    private static final Object zzfus = new Object();
    private static zzaf zzfut;

    public static zzaf zzce(Context context) {
        synchronized (zzfus) {
            if (zzfut == null) {
                zzfut = new zzah(context.getApplicationContext());
            }
        }
        return zzfut;
    }

    public final void zza(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        zzb(new zzag(str, str2, i), serviceConnection, str3);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(zzag zzag, ServiceConnection serviceConnection, String str);

    /* access modifiers changed from: protected */
    public abstract void zzb(zzag zzag, ServiceConnection serviceConnection, String str);
}
