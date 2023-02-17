package com.google.android.gms.common.api.internal;
/* access modifiers changed from: package-private */
public abstract class zzbb implements Runnable {
    private /* synthetic */ zzar zzflw;

    private zzbb(zzar zzar) {
        this.zzflw = zzar;
    }

    /* synthetic */ zzbb(zzar zzar, zzas zzas) {
        this(zzar);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.zzflw.zzfkd.lock();
        try {
            if (!Thread.interrupted()) {
                zzagz();
                this.zzflw.zzfkd.unlock();
            }
        } catch (RuntimeException e) {
            this.zzflw.zzflg.zza(e);
        } finally {
            this.zzflw.zzfkd.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzagz();
}
