package com.google.android.gms.internal;
final class zzcdl implements Runnable {
    private /* synthetic */ zzcas zziui;
    private /* synthetic */ zzcdb zziuj;
    private /* synthetic */ zzcbk zziun;

    zzcdl(zzcdb zzcdb, zzcbk zzcbk, zzcas zzcas) {
        this.zziuj = zzcdb;
        this.zziun = zzcbk;
        this.zziui = zzcas;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcdb.zza(this.zziuj).zzazl();
        zzcdb.zza(this.zziuj).zzb(this.zziun, this.zziui);
    }
}
