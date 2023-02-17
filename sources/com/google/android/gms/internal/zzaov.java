package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzaoy;
public final class zzaov<T extends Context & zzaoy> {
    private static Boolean zzdtx;
    private final Handler mHandler = new Handler();
    private final T zzdtw;

    public zzaov(T t) {
        zzbp.zzu(t);
        this.zzdtw = t;
    }

    private final void zza(Integer num, JobParameters jobParameters) {
        zzamu zzbg = zzamu.zzbg(this.zzdtw);
        zzbg.zzwc().zza(new zzaow(this, num, zzbg, zzbg.zzvy(), jobParameters));
    }

    public static boolean zzbi(Context context) {
        zzbp.zzu(context);
        if (zzdtx != null) {
            return zzdtx.booleanValue();
        }
        boolean zzv = zzapd.zzv(context, "com.google.android.gms.analytics.AnalyticsService");
        zzdtx = Boolean.valueOf(zzv);
        return zzv;
    }

    public final void onCreate() {
        zzamu.zzbg(this.zzdtw).zzvy().zzdm("Local AnalyticsService is starting up");
    }

    public final void onDestroy() {
        zzamu.zzbg(this.zzdtw).zzvy().zzdm("Local AnalyticsService is shutting down");
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        try {
            synchronized (zzaou.zzaqc) {
                zzcqh zzcqh = zzaou.zzdtv;
                if (zzcqh != null && zzcqh.isHeld()) {
                    zzcqh.release();
                }
            }
        } catch (SecurityException unused) {
        }
        zzaon zzvy = zzamu.zzbg(this.zzdtw).zzvy();
        if (intent == null) {
            zzvy.zzdp("AnalyticsService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzvy.zza("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            return 2;
        }
        zza(Integer.valueOf(i2), null);
        return 2;
    }

    @TargetApi(24)
    public final boolean onStartJob(JobParameters jobParameters) {
        zzaon zzvy = zzamu.zzbg(this.zzdtw).zzvy();
        String string = jobParameters.getExtras().getString("action");
        zzvy.zza("Local AnalyticsJobService called. action", string);
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(string)) {
            return true;
        }
        zza(null, jobParameters);
        return true;
    }
}
