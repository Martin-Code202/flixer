package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.internal.zzcfh;
import com.google.android.gms.internal.zzcfk;
@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements zzcfk {
    private zzcfh zziks;

    private final zzcfh zzatu() {
        if (this.zziks == null) {
            this.zziks = new zzcfh(this);
        }
        return this.zziks;
    }

    @Override // com.google.android.gms.internal.zzcfk
    public final boolean callServiceStopSelfResult(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        zzatu().onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        zzatu().onDestroy();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        zzatu().onRebind(intent);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return zzatu().onStartJob(jobParameters);
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return zzatu().onUnbind(intent);
    }

    @Override // com.google.android.gms.internal.zzcfk
    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }
}
