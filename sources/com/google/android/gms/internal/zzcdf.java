package com.google.android.gms.internal;
final class zzcdf implements Runnable {
    private /* synthetic */ zzcdb zziuj;
    private /* synthetic */ zzcav zziuk;

    zzcdf(zzcdb zzcdb, zzcav zzcav) {
        this.zziuj = zzcdb;
        this.zziuk = zzcav;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcdb.zza(this.zziuj).zzazl();
        zzcdb.zza(this.zziuj).zze(this.zziuk);
    }
}
