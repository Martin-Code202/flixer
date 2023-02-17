package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
/* access modifiers changed from: package-private */
public final class zzcew implements Runnable {
    private /* synthetic */ zzcas zziui;
    private /* synthetic */ zzceo zziwe;
    private /* synthetic */ boolean zziwh = true;
    private /* synthetic */ boolean zziwi;
    private /* synthetic */ zzcav zziwj;
    private /* synthetic */ zzcav zziwk;

    zzcew(zzceo zzceo, boolean z, boolean z2, zzcav zzcav, zzcas zzcas, zzcav zzcav2) {
        this.zziwe = zzceo;
        this.zziwi = z2;
        this.zziwj = zzcav;
        this.zziui = zzcas;
        this.zziwk = zzcav2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbo zzcbo = this.zziwe.zzivy;
        if (zzcbo == null) {
            this.zziwe.zzaum().zzaye().log("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zziwh) {
            this.zziwe.zza(zzcbo, this.zziwi ? null : this.zziwj, this.zziui);
        } else {
            try {
                if (TextUtils.isEmpty(this.zziwk.packageName)) {
                    zzcbo.zza(this.zziwj, this.zziui);
                } else {
                    zzcbo.zzb(this.zziwj);
                }
            } catch (RemoteException e) {
                this.zziwe.zzaum().zzaye().zzj("Failed to send conditional user property to the service", e);
            }
        }
        this.zziwe.zzww();
    }
}
