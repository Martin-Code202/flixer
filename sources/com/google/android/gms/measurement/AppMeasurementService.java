package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.zzcfh;
import com.google.android.gms.internal.zzcfk;
public final class AppMeasurementService extends Service implements zzcfk {
    private zzcfh zziks;

    private final zzcfh zzatu() {
        if (this.zziks == null) {
            this.zziks = new zzcfh(this);
        }
        return this.zziks;
    }

    @Override // com.google.android.gms.internal.zzcfk
    public final boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return zzatu().onBind(intent);
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

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        zzatu().onStartCommand(intent, i, i2);
        AppMeasurementReceiver.completeWakefulIntent(intent);
        return 2;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return zzatu().onUnbind(intent);
    }

    @Override // com.google.android.gms.internal.zzcfk
    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }
}
