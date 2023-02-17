package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
/* access modifiers changed from: package-private */
public final class zze<TResult> implements zzk<TResult> {
    private final Object mLock = new Object();
    private final Executor zzjqr;
    private OnCompleteListener<TResult> zzkfz;

    public zze(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.zzjqr = executor;
        this.zzkfz = onCompleteListener;
    }

    @Override // com.google.android.gms.tasks.zzk
    public final void onComplete(Task<TResult> task) {
        synchronized (this.mLock) {
            if (this.zzkfz != null) {
                this.zzjqr.execute(new zzf(this, task));
            }
        }
    }
}
