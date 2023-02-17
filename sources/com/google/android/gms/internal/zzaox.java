package com.google.android.gms.internal;

import android.os.Build;
final class zzaox implements Runnable {
    private /* synthetic */ zzaow zzdud;

    zzaox(zzaow zzaow) {
        this.zzdud = zzaow;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzdud.zzdty != null) {
            if (((zzaoy) this.zzdud.zzduc.zzdtw).callServiceStopSelfResult(this.zzdud.zzdty.intValue())) {
                this.zzdud.zzdua.zzdm("Local AnalyticsService processed last dispatch request");
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            this.zzdud.zzdua.zzdm("AnalyticsJobService processed last dispatch request");
            ((zzaoy) this.zzdud.zzduc.zzdtw).zza(this.zzdud.zzdub, false);
        }
    }
}
