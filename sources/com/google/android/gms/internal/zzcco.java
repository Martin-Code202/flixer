package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
final class zzcco implements Runnable {
    private /* synthetic */ Context zzanz;
    private /* synthetic */ zzccw zzirq;
    private /* synthetic */ long zzirr;
    private /* synthetic */ Bundle zzirs;
    private /* synthetic */ zzcbw zzirt;

    zzcco(zzccn zzccn, zzccw zzccw, long j, Bundle bundle, Context context, zzcbw zzcbw) {
        this.zzirq = zzccw;
        this.zzirr = j;
        this.zzirs = bundle;
        this.zzanz = context;
        this.zzirt = zzcbw;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j = 0;
        zzcfv zzah = this.zzirq.zzaug().zzah(this.zzirq.zzaub().getAppId(), "_fot");
        if (zzah != null && (zzah.mValue instanceof Long)) {
            j = ((Long) zzah.mValue).longValue();
        }
        long j2 = this.zzirr;
        if (j > 0 && (j2 >= j || j2 <= 0)) {
            j2 = j - 1;
        }
        if (j2 > 0) {
            this.zzirs.putLong("click_timestamp", j2);
        }
        AppMeasurement.getInstance(this.zzanz).logEventInternal("auto", "_cmp", this.zzirs);
        this.zzirt.zzayk().log("Install campaign recorded");
    }
}
