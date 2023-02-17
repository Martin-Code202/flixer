package com.google.android.gms.internal;

import java.lang.Thread;
/* access modifiers changed from: package-private */
public final class zzamv implements Thread.UncaughtExceptionHandler {
    private /* synthetic */ zzamu zzdot;

    zzamv(zzamu zzamu) {
        this.zzdot = zzamu;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        zzaon zzwm = this.zzdot.zzwm();
        if (zzwm != null) {
            zzwm.zze("Job execution failed", th);
        }
    }
}
