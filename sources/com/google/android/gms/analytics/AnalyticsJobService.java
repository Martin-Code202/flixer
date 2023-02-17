package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.internal.zzaov;
import com.google.android.gms.internal.zzaoy;
@TargetApi(24)
public final class AnalyticsJobService extends JobService implements zzaoy {
    private zzaov<AnalyticsJobService> zzdjk;

    private final zzaov<AnalyticsJobService> zztt() {
        if (this.zzdjk == null) {
            this.zzdjk = new zzaov<>(this);
        }
        return this.zzdjk;
    }

    @Override // com.google.android.gms.internal.zzaoy
    public final boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        zztt().onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        zztt().onDestroy();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        return zztt().onStartCommand(intent, i, i2);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return zztt().onStartJob(jobParameters);
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // com.google.android.gms.internal.zzaoy
    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }
}
