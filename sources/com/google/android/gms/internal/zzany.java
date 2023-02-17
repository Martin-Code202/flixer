package com.google.android.gms.internal;

import android.os.Looper;
/* access modifiers changed from: package-private */
public final class zzany implements Runnable {
    private /* synthetic */ zzanx zzdqt;

    zzany(zzanx zzanx) {
        this.zzdqt = zzanx;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.zzdqt.zzdoc.zzwa().zzc(this);
            return;
        }
        boolean zzdp = this.zzdqt.zzdp();
        this.zzdqt.zzdqs = 0;
        if (zzdp) {
            this.zzdqt.run();
        }
    }
}
