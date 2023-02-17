package com.google.android.gms.internal;

import android.os.RemoteException;
/* access modifiers changed from: package-private */
public final class zzceu implements Runnable {
    private /* synthetic */ zzcas zziui;
    private /* synthetic */ zzceo zziwe;

    zzceu(zzceo zzceo, zzcas zzcas) {
        this.zziwe = zzceo;
        this.zziui = zzcas;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbo zzcbo = this.zziwe.zzivy;
        if (zzcbo == null) {
            this.zziwe.zzaum().zzaye().log("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzcbo.zzb(this.zziui);
            this.zziwe.zzww();
        } catch (RemoteException e) {
            this.zziwe.zzaum().zzaye().zzj("Failed to send measurementEnabled to the service", e);
        }
    }
}
