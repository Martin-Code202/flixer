package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.zzbp;
/* access modifiers changed from: package-private */
public abstract class zzanx {
    private static volatile Handler zzdqr;
    private final zzamu zzdoc;
    private volatile long zzdqs;
    private final Runnable zzv = new zzany(this);

    zzanx(zzamu zzamu) {
        zzbp.zzu(zzamu);
        this.zzdoc = zzamu;
    }

    private final Handler getHandler() {
        Handler handler;
        if (zzdqr != null) {
            return zzdqr;
        }
        synchronized (zzanx.class) {
            if (zzdqr == null) {
                zzdqr = new Handler(this.zzdoc.getContext().getMainLooper());
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
            this.zzdqs = this.zzdoc.zzvx().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzv, j)) {
                this.zzdoc.zzvy().zze("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final void zzt(long j) {
        if (zzdp()) {
            if (j < 0) {
                cancel();
                return;
            }
            long abs = j - Math.abs(this.zzdoc.zzvx().currentTimeMillis() - this.zzdqs);
            long j2 = abs;
            if (abs < 0) {
                j2 = 0;
            }
            getHandler().removeCallbacks(this.zzv);
            if (!getHandler().postDelayed(this.zzv, j2)) {
                this.zzdoc.zzvy().zze("Failed to adjust delayed post. time", Long.valueOf(j2));
            }
        }
    }

    public final long zzyg() {
        if (this.zzdqs == 0) {
            return 0;
        }
        return Math.abs(this.zzdoc.zzvx().currentTimeMillis() - this.zzdqs);
    }
}
