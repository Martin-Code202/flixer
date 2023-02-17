package com.google.android.gms.internal;

import android.app.job.JobParameters;
/* access modifiers changed from: package-private */
public final class zzaow implements zzaob {
    final /* synthetic */ Integer zzdty;
    private /* synthetic */ zzamu zzdtz;
    final /* synthetic */ zzaon zzdua;
    final /* synthetic */ JobParameters zzdub;
    final /* synthetic */ zzaov zzduc;

    zzaow(zzaov zzaov, Integer num, zzamu zzamu, zzaon zzaon, JobParameters jobParameters) {
        this.zzduc = zzaov;
        this.zzdty = num;
        this.zzdtz = zzamu;
        this.zzdua = zzaon;
        this.zzdub = jobParameters;
    }

    @Override // com.google.android.gms.internal.zzaob
    public final void zzb(Throwable th) {
        this.zzduc.mHandler.post(new zzaox(this));
    }
}
