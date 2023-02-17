package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.zzbp;
public final class zzamj extends zzams {
    private final zzang zzdnu;

    public zzamj(zzamu zzamu, zzamw zzamw) {
        super(zzamu);
        zzbp.zzu(zzamw);
        this.zzdnu = new zzang(zzamu, zzamw);
    }

    /* access modifiers changed from: package-private */
    public final void onServiceConnected() {
        zzj.zzuj();
        this.zzdnu.onServiceConnected();
    }

    public final void start() {
        this.zzdnu.start();
    }

    public final long zza(zzamx zzamx) {
        zzwk();
        zzbp.zzu(zzamx);
        zzj.zzuj();
        long zza = this.zzdnu.zza(zzamx, true);
        if (zza == 0) {
            this.zzdnu.zzb(zzamx);
        }
        return zza;
    }

    public final void zza(zzaob zzaob) {
        zzwk();
        zzwa().zzc(new zzamp(this, zzaob));
    }

    public final void zza(zzaoi zzaoi) {
        zzbp.zzu(zzaoi);
        zzwk();
        zzb("Hit delivery requested", zzaoi);
        zzwa().zzc(new zzamn(this, zzaoi));
    }

    public final void zza(String str, Runnable runnable) {
        zzbp.zzh(str, "campaign param can't be empty");
        zzwa().zzc(new zzamm(this, str, runnable));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzams
    public final void zzuk() {
        this.zzdnu.initialize();
    }

    public final void zzvs() {
        zzwk();
        Context context = getContext();
        if (!zzaou.zzbe(context) || !zzaov.zzbi(context)) {
            zza((zzaob) null);
            return;
        }
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
        context.startService(intent);
    }

    public final void zzvu() {
        zzwk();
        zzj.zzuj();
        zzang zzang = this.zzdnu;
        zzj.zzuj();
        zzang.zzwk();
        zzang.zzdm("Service disconnected");
    }

    /* access modifiers changed from: package-private */
    public final void zzvv() {
        zzj.zzuj();
        this.zzdnu.zzvv();
    }
}
