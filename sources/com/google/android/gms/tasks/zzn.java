package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzbp;
import java.util.concurrent.Executor;
/* access modifiers changed from: package-private */
public final class zzn<TResult> extends Task<TResult> {
    private final Object mLock = new Object();
    private final zzl<TResult> zzkgj = new zzl<>();
    private boolean zzkgk;
    private TResult zzkgl;
    private Exception zzkgm;

    zzn() {
    }

    private final void zzbig() {
        zzbp.zza(!this.zzkgk, "Task is already complete");
    }

    private final void zzbih() {
        synchronized (this.mLock) {
            if (this.zzkgk) {
                this.zzkgj.zzb(this);
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.zzkgj.zza(new zze(executor, onCompleteListener));
        zzbih();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Exception getException() {
        Exception exc;
        synchronized (this.mLock) {
            exc = this.zzkgm;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzkgk && this.zzkgm == null;
        }
        return z;
    }

    public final void setException(Exception exc) {
        zzbp.zzb(exc, "Exception must not be null");
        synchronized (this.mLock) {
            zzbig();
            this.zzkgk = true;
            this.zzkgm = exc;
        }
        this.zzkgj.zzb(this);
    }

    public final void setResult(TResult tresult) {
        synchronized (this.mLock) {
            zzbig();
            this.zzkgk = true;
            this.zzkgl = tresult;
        }
        this.zzkgj.zzb(this);
    }

    public final boolean trySetException(Exception exc) {
        zzbp.zzb(exc, "Exception must not be null");
        synchronized (this.mLock) {
            if (this.zzkgk) {
                return false;
            }
            this.zzkgk = true;
            this.zzkgm = exc;
            this.zzkgj.zzb(this);
            return true;
        }
    }

    public final boolean trySetResult(TResult tresult) {
        synchronized (this.mLock) {
            if (this.zzkgk) {
                return false;
            }
            this.zzkgk = true;
            this.zzkgl = tresult;
            this.zzkgj.zzb(this);
            return true;
        }
    }
}
