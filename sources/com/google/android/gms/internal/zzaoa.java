package com.google.android.gms.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.PersistableBundle;
import com.google.android.gms.common.internal.zzbp;
public final class zzaoa extends zzams {
    private boolean zzdqu;
    private boolean zzdqv;
    private final AlarmManager zzdqw = ((AlarmManager) getContext().getSystemService("alarm"));
    private Integer zzdqx;

    protected zzaoa(zzamu zzamu) {
        super(zzamu);
    }

    private final int getJobId() {
        if (this.zzdqx == null) {
            String valueOf = String.valueOf(getContext().getPackageName());
            this.zzdqx = Integer.valueOf((valueOf.length() != 0 ? "analytics".concat(valueOf) : new String("analytics")).hashCode());
        }
        return this.zzdqx.intValue();
    }

    private final PendingIntent zzyk() {
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(getContext(), "com.google.android.gms.analytics.AnalyticsReceiver"));
        return PendingIntent.getBroadcast(getContext(), 0, intent, 0);
    }

    public final void cancel() {
        this.zzdqv = false;
        this.zzdqw.cancel(zzyk());
        if (Build.VERSION.SDK_INT >= 24) {
            zza("Cancelling job. JobID", Integer.valueOf(getJobId()));
            ((JobScheduler) getContext().getSystemService("jobscheduler")).cancel(getJobId());
        }
    }

    public final void schedule() {
        zzwk();
        zzbp.zza(this.zzdqu, "Receiver not registered");
        long zzxy = zzanv.zzxy();
        if (zzxy > 0) {
            cancel();
            long elapsedRealtime = zzvx().elapsedRealtime() + zzxy;
            this.zzdqv = true;
            if (Build.VERSION.SDK_INT >= 24) {
                zzdm("Scheduling upload with JobScheduler");
                ComponentName componentName = new ComponentName(getContext(), "com.google.android.gms.analytics.AnalyticsJobService");
                JobScheduler jobScheduler = (JobScheduler) getContext().getSystemService("jobscheduler");
                JobInfo.Builder builder = new JobInfo.Builder(getJobId(), componentName);
                builder.setMinimumLatency(zzxy);
                builder.setOverrideDeadline(zzxy << 1);
                PersistableBundle persistableBundle = new PersistableBundle();
                persistableBundle.putString("action", "com.google.android.gms.analytics.ANALYTICS_DISPATCH");
                builder.setExtras(persistableBundle);
                JobInfo build = builder.build();
                zza("Scheduling job. JobID", Integer.valueOf(getJobId()));
                jobScheduler.schedule(build);
                return;
            }
            zzdm("Scheduling upload with AlarmManager");
            this.zzdqw.setInexactRepeating(2, elapsedRealtime, zzxy, zzyk());
        }
    }

    public final boolean zzdp() {
        return this.zzdqv;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzams
    public final void zzuk() {
        ActivityInfo receiverInfo;
        try {
            cancel();
            if (zzanv.zzxy() > 0 && (receiverInfo = getContext().getPackageManager().getReceiverInfo(new ComponentName(getContext(), "com.google.android.gms.analytics.AnalyticsReceiver"), 2)) != null && receiverInfo.enabled) {
                zzdm("Receiver registered for local dispatch.");
                this.zzdqu = true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public final boolean zzyj() {
        return this.zzdqu;
    }
}
