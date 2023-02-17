package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;
final class zzcds implements Runnable {
    private /* synthetic */ String zziag;
    private /* synthetic */ zzcdb zziuj;
    private /* synthetic */ String zziup;
    private /* synthetic */ String zziuq;
    private /* synthetic */ long zziur;

    zzcds(zzcdb zzcdb, String str, String str2, String str3, long j) {
        this.zziuj = zzcdb;
        this.zziup = str;
        this.zziag = str2;
        this.zziuq = str3;
        this.zziur = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zziup == null) {
            zzcdb.zza(this.zziuj).zzaue().zza(this.zziag, (AppMeasurement.zzb) null);
            return;
        }
        AppMeasurement.zzb zzb = new AppMeasurement.zzb();
        zzb.zzikm = this.zziuq;
        zzb.zzikn = this.zziup;
        zzb.zziko = this.zziur;
        zzcdb.zza(this.zziuj).zzaue().zza(this.zziag, zzb);
    }
}
