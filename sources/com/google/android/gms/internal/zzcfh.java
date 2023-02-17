package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzcfk;
public final class zzcfh<T extends Context & zzcfk> {
    private final T zzdtw;

    public zzcfh(T t) {
        zzbp.zzu(t);
        this.zzdtw = t;
    }

    private final void zza(Integer num, JobParameters jobParameters) {
        zzccw zzdn = zzccw.zzdn(this.zzdtw);
        zzdn.zzaul().zzg(new zzcfi(this, zzdn, num, zzdn.zzaum(), jobParameters));
    }

    private final zzcbw zzaum() {
        return zzccw.zzdn(this.zzdtw).zzaum();
    }

    public static boolean zzk(Context context, boolean z) {
        zzbp.zzu(context);
        return Build.VERSION.SDK_INT >= 24 ? zzcfw.zzv(context, "com.google.android.gms.measurement.AppMeasurementJobService") : zzcfw.zzv(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public final IBinder onBind(Intent intent) {
        if (intent == null) {
            zzaum().zzaye().log("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzcdb(zzccw.zzdn(this.zzdtw));
        }
        zzaum().zzayg().zzj("onBind received unknown action", action);
        return null;
    }

    public final void onCreate() {
        zzcbw zzaum = zzccw.zzdn(this.zzdtw).zzaum();
        zzcax.zzawl();
        zzaum.zzayk().log("Local AppMeasurementService is starting up");
    }

    public final void onDestroy() {
        zzcbw zzaum = zzccw.zzdn(this.zzdtw).zzaum();
        zzcax.zzawl();
        zzaum.zzayk().log("Local AppMeasurementService is shutting down");
    }

    public final void onRebind(Intent intent) {
        if (intent == null) {
            zzaum().zzaye().log("onRebind called with null intent");
            return;
        }
        zzaum().zzayk().zzj("onRebind called. action", intent.getAction());
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        zzcbw zzaum = zzccw.zzdn(this.zzdtw).zzaum();
        if (intent == null) {
            zzaum.zzayg().log("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzcax.zzawl();
        zzaum.zzayk().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            return 2;
        }
        zza(Integer.valueOf(i2), null);
        return 2;
    }

    @TargetApi(24)
    public final boolean onStartJob(JobParameters jobParameters) {
        zzcbw zzaum = zzccw.zzdn(this.zzdtw).zzaum();
        String string = jobParameters.getExtras().getString("action");
        zzcax.zzawl();
        zzaum.zzayk().zzj("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zza(null, jobParameters);
        return true;
    }

    public final boolean onUnbind(Intent intent) {
        if (intent == null) {
            zzaum().zzaye().log("onUnbind called with null intent");
            return true;
        }
        zzaum().zzayk().zzj("onUnbind called for intent. action", intent.getAction());
        return true;
    }
}
