package com.google.android.gms.internal;

import android.os.Process;
final class zzbea implements Runnable {
    private final int mPriority;
    private final Runnable zzv;

    public zzbea(Runnable runnable, int i) {
        this.zzv = runnable;
        this.mPriority = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.mPriority);
        this.zzv.run();
    }
}
