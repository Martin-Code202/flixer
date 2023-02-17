package com.google.android.gms.internal;
final class zzcdm implements Runnable {
    private /* synthetic */ String zziag;
    private /* synthetic */ zzcdb zziuj;
    private /* synthetic */ zzcbk zziun;

    zzcdm(zzcdb zzcdb, zzcbk zzcbk, String str) {
        this.zziuj = zzcdb;
        this.zziun = zzcbk;
        this.zziag = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcdb.zza(this.zziuj).zzazl();
        zzcdb.zza(this.zziuj).zzb(this.zziun, this.zziag);
    }
}
