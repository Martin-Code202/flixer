package com.google.android.gms.internal;
final class zzcdd implements Runnable {
    private /* synthetic */ zzcas zziui;
    private /* synthetic */ zzcdb zziuj;
    private /* synthetic */ zzcav zziuk;

    zzcdd(zzcdb zzcdb, zzcav zzcav, zzcas zzcas) {
        this.zziuj = zzcdb;
        this.zziuk = zzcav;
        this.zziui = zzcas;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcdb.zza(this.zziuj).zzazl();
        zzcdb.zza(this.zziuj).zzc(this.zziuk, this.zziui);
    }
}
