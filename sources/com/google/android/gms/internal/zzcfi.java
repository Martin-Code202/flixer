package com.google.android.gms.internal;

import android.app.job.JobParameters;
/* access modifiers changed from: package-private */
public final class zzcfi implements Runnable {
    final /* synthetic */ Integer zzdty;
    final /* synthetic */ JobParameters zzdub;
    private /* synthetic */ zzccw zzirq;
    final /* synthetic */ zzcbw zzirt;
    final /* synthetic */ zzcfh zziwq;

    zzcfi(zzcfh zzcfh, zzccw zzccw, Integer num, zzcbw zzcbw, JobParameters jobParameters) {
        this.zziwq = zzcfh;
        this.zzirq = zzccw;
        this.zzdty = num;
        this.zzirt = zzcbw;
        this.zzdub = jobParameters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzirq.zzazl();
        this.zzirq.zzi(new zzcfj(this));
        this.zzirq.zzazh();
    }
}
