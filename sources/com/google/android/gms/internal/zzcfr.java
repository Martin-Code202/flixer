package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import com.google.android.gms.common.util.zzd;
public final class zzcfr extends zzcdu {
    private final AlarmManager zzdqw = ((AlarmManager) getContext().getSystemService("alarm"));
    private Integer zzdqx;
    private final zzcbc zziww;

    protected zzcfr(zzccw zzccw) {
        super(zzccw);
        this.zziww = new zzcfs(this, zzccw);
    }

    private final int getJobId() {
        if (this.zzdqx == null) {
            String valueOf = String.valueOf(getContext().getPackageName());
            this.zzdqx = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.zzdqx.intValue();
    }

    @TargetApi(24)
    private final void zzazw() {
        JobScheduler jobScheduler = (JobScheduler) getContext().getSystemService("jobscheduler");
        zzaum().zzayk().zzj("Cancelling job. JobID", Integer.valueOf(getJobId()));
        jobScheduler.cancel(getJobId());
    }

    /* access modifiers changed from: private */
    public final void zzazx() {
        Intent intent = new Intent();
        Context context = getContext();
        zzcax.zzawl();
        Intent className = intent.setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        getContext().sendBroadcast(className);
    }

    private final PendingIntent zzyk() {
        Intent intent = new Intent();
        Context context = getContext();
        zzcax.zzawl();
        Intent className = intent.setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(getContext(), 0, className, 0);
    }

    public final void cancel() {
        zzwk();
        this.zzdqw.cancel(zzyk());
        this.zziww.cancel();
        if (Build.VERSION.SDK_INT >= 24) {
            zzazw();
        }
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzatv() {
        super.zzatv();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzatw() {
        super.zzatw();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzatx() {
        super.zzatx();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcan zzaty() {
        return super.zzaty();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcau zzatz() {
        return super.zzatz();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcdw zzaua() {
        return super.zzaua();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbr zzaub() {
        return super.zzaub();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbe zzauc() {
        return super.zzauc();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzceo zzaud() {
        return super.zzaud();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcek zzaue() {
        return super.zzaue();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbs zzauf() {
        return super.zzauf();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcay zzaug() {
        return super.zzaug();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbu zzauh() {
        return super.zzauh();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcfw zzaui() {
        return super.zzaui();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzccq zzauj() {
        return super.zzauj();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcfl zzauk() {
        return super.zzauk();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzccr zzaul() {
        return super.zzaul();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbw zzaum() {
        return super.zzaum();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcch zzaun() {
        return super.zzaun();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcax zzauo() {
        return super.zzauo();
    }

    public final void zzs(long j) {
        zzwk();
        zzcax.zzawl();
        if (!zzccn.zzj(getContext(), false)) {
            zzaum().zzayj().log("Receiver not registered/enabled");
        }
        zzcax.zzawl();
        if (!zzcfh.zzk(getContext(), false)) {
            zzaum().zzayj().log("Service not registered/enabled");
        }
        cancel();
        long elapsedRealtime = zzvx().elapsedRealtime() + j;
        if (j < zzcax.zzaxc() && !this.zziww.zzdp()) {
            zzaum().zzayk().log("Scheduling upload with DelayedRunnable");
            this.zziww.zzs(j);
        }
        zzcax.zzawl();
        if (Build.VERSION.SDK_INT >= 24) {
            zzaum().zzayk().log("Scheduling upload with JobScheduler");
            ComponentName componentName = new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementJobService");
            JobScheduler jobScheduler = (JobScheduler) getContext().getSystemService("jobscheduler");
            JobInfo.Builder builder = new JobInfo.Builder(getJobId(), componentName);
            builder.setMinimumLatency(j);
            builder.setOverrideDeadline(j << 1);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            builder.setExtras(persistableBundle);
            JobInfo build = builder.build();
            zzaum().zzayk().zzj("Scheduling job. JobID", Integer.valueOf(getJobId()));
            jobScheduler.schedule(build);
            return;
        }
        zzaum().zzayk().log("Scheduling upload with AlarmManager");
        this.zzdqw.setInexactRepeating(2, elapsedRealtime, Math.max(zzcax.zzaxd(), j), zzyk());
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzuj() {
        super.zzuj();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzcdu
    public final void zzuk() {
        this.zzdqw.cancel(zzyk());
        if (Build.VERSION.SDK_INT >= 24) {
            zzazw();
        }
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzd zzvx() {
        return super.zzvx();
    }
}
