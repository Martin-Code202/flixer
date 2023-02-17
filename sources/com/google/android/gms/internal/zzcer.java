package com.google.android.gms.internal;

import android.os.RemoteException;
/* access modifiers changed from: package-private */
public final class zzcer implements Runnable {
    private /* synthetic */ zzcas zziui;
    private /* synthetic */ zzceo zziwe;

    zzcer(zzceo zzceo, zzcas zzcas) {
        this.zziwe = zzceo;
        this.zziui = zzcas;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbo zzcbo = this.zziwe.zzivy;
        if (zzcbo == null) {
            this.zziwe.zzaum().zzaye().log("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzcbo.zza(this.zziui);
            this.zziwe.zza(zzcbo, null, this.zziui);
            this.zziwe.zzww();
        } catch (RemoteException e) {
            this.zziwe.zzaum().zzaye().zzj("Failed to send app launch to the service", e);
        }
    }
}
