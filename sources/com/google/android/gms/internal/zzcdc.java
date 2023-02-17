package com.google.android.gms.internal;
final class zzcdc implements Runnable {
    private /* synthetic */ zzcas zziui;
    private /* synthetic */ zzcdb zziuj;

    zzcdc(zzcdb zzcdb, zzcas zzcas) {
        this.zziuj = zzcdb;
        this.zziui = zzcas;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcdb.zza(this.zziuj).zzazl();
        zzcdb.zza(this.zziuj).zzd(this.zziui);
    }
}
