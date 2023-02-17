package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;
/* access modifiers changed from: package-private */
public final class zzcem implements Runnable {
    private /* synthetic */ zzcek zzivu;
    private /* synthetic */ zzcen zzivv;

    zzcem(zzcek zzcek, zzcen zzcen) {
        this.zzivu = zzcek;
        this.zzivv = zzcen;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzivu.zza(this.zzivv);
        this.zzivu.zzivi = null;
        this.zzivu.zzaud().zza((AppMeasurement.zzb) null);
    }
}
