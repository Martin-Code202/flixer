package com.google.android.gms.analytics;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.zzaov;
import com.google.android.gms.internal.zzaoy;
public final class AnalyticsService extends Service implements zzaoy {
    private zzaov<AnalyticsService> zzdjk;

    private final zzaov<AnalyticsService> zztt() {
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
    public final IBinder onBind(Intent intent) {
        zztt();
        return null;
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

    @Override // com.google.android.gms.internal.zzaoy
    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }
}
