package com.google.android.gms.common.api.internal;
/* access modifiers changed from: package-private */
public final class zzz implements Runnable {
    private /* synthetic */ zzy zzfkf;

    zzz(zzy zzy) {
        this.zzfkf = zzy;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzfkf.zzfkd.lock();
        try {
            this.zzfkf.zzagj();
        } finally {
            this.zzfkf.zzfkd.unlock();
        }
    }
}
