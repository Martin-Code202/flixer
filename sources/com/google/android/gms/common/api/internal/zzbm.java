package com.google.android.gms.common.api.internal;
/* access modifiers changed from: package-private */
public abstract class zzbm {
    private final zzbk zzfng;

    protected zzbm(zzbk zzbk) {
        this.zzfng = zzbk;
    }

    /* access modifiers changed from: protected */
    public abstract void zzagz();

    public final void zzc(zzbl zzbl) {
        zzbl.zzfkd.lock();
        try {
            if (zzbl.zzfnc == this.zzfng) {
                zzagz();
                zzbl.zzfkd.unlock();
            }
        } finally {
            zzbl.zzfkd.unlock();
        }
    }
}
