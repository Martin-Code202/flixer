package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.zzbp;
public final class zzcj<L> {
    private volatile L mListener;
    private final zzck zzfot;

    public final void clear() {
        this.mListener = null;
    }

    public final void zza(zzcm<? super L> zzcm) {
        zzbp.zzb(zzcm, "Notifier must not be null");
        this.zzfot.sendMessage(this.zzfot.obtainMessage(1, zzcm));
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzcm<? super L> zzcm) {
        L l = this.mListener;
        if (l == null) {
            zzcm.zzagx();
            return;
        }
        try {
            zzcm.zzq(l);
        } catch (RuntimeException e) {
            zzcm.zzagx();
            throw e;
        }
    }
}
