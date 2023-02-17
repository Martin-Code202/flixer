package com.google.android.gms.internal;
final class zzcdr implements Runnable {
    private /* synthetic */ zzcas zziui;
    private /* synthetic */ zzcdb zziuj;

    zzcdr(zzcdb zzcdb, zzcas zzcas) {
        this.zziuj = zzcdb;
        this.zziui = zzcas;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcdb.zza(this.zziuj).zzazl();
        zzcdb.zza(this.zziuj).zze(this.zziui);
    }
}
