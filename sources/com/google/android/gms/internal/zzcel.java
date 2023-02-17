package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
/* access modifiers changed from: package-private */
public final class zzcel implements Runnable {
    private /* synthetic */ boolean zzivr;
    private /* synthetic */ AppMeasurement.zzb zzivs;
    private /* synthetic */ zzcen zzivt;
    private /* synthetic */ zzcek zzivu;

    zzcel(zzcek zzcek, boolean z, AppMeasurement.zzb zzb, zzcen zzcen) {
        this.zzivu = zzcek;
        this.zzivr = z;
        this.zzivs = zzb;
        this.zzivt = zzcen;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzivr && this.zzivu.zzivi != null) {
            this.zzivu.zza(this.zzivu.zzivi);
        }
        if (this.zzivs == null || this.zzivs.zziko != this.zzivt.zziko || !zzcfw.zzas(this.zzivs.zzikn, this.zzivt.zzikn) || !zzcfw.zzas(this.zzivs.zzikm, this.zzivt.zzikm)) {
            Bundle bundle = new Bundle();
            zzcek.zza(this.zzivt, bundle);
            if (this.zzivs != null) {
                if (this.zzivs.zzikm != null) {
                    bundle.putString("_pn", this.zzivs.zzikm);
                }
                bundle.putString("_pc", this.zzivs.zzikn);
                bundle.putLong("_pi", this.zzivs.zziko);
            }
            this.zzivu.zzaua().zzc("auto", "_vs", bundle);
        }
        this.zzivu.zzivi = this.zzivt;
        this.zzivu.zzaud().zza(this.zzivt);
    }
}
