package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.zzbp;
/* access modifiers changed from: package-private */
public abstract class zzcbc {
    private static volatile Handler zzdqr;
    private volatile long zzdqs;
    private final zzccw zzikh;
    private boolean zzind = true;
    private final Runnable zzv = new zzcbd(this);

    zzcbc(zzccw zzccw) {
        zzbp.zzu(zzccw);
        this.zzikh = zzccw;
    }

    private final Handler getHandler() {
        Handler handler;
        if (zzdqr != null) {
            return zzdqr;
        }
        synchronized (zzcbc.class) {
            if (zzdqr == null) {
                zzdqr = new Handler(this.zzikh.getContext().getMainLooper());
            }
            handler = zzdqr;
        }
        return handler;
    }

    public final void cancel() {
        this.zzdqs = 0;
        getHandler().removeCallbacks(this.zzv);
    }

    public abstract void run();

    public final boolean zzdp() {
        return this.zzdqs != 0;
    }

    public final void zzs(long j) {
        cancel();
        if (j >= 0) {
            this.zzdqs = this.zzikh.zzvx().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzv, j)) {
                this.zzikh.zzaum().zzaye().zzj("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }
}
