package com.google.android.gms.internal;
final class zzcdp implements Runnable {
    private /* synthetic */ zzcas zziui;
    private /* synthetic */ zzcdb zziuj;
    private /* synthetic */ zzcft zziuo;

    zzcdp(zzcdb zzcdb, zzcft zzcft, zzcas zzcas) {
        this.zziuj = zzcdb;
        this.zziuo = zzcft;
        this.zziui = zzcas;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcdb.zza(this.zziuj).zzazl();
        zzcdb.zza(this.zziuj).zzb(this.zziuo, this.zziui);
    }
}
