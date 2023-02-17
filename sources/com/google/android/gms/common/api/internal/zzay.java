package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zzcpx;
import com.google.android.gms.internal.zzcqf;
import java.lang.ref.WeakReference;
final class zzay extends zzcpx {
    private final WeakReference<zzar> zzflx;

    zzay(zzar zzar) {
        this.zzflx = new WeakReference<>(zzar);
    }

    @Override // com.google.android.gms.internal.zzcpx, com.google.android.gms.internal.zzcpy
    public final void zzb(zzcqf zzcqf) {
        zzar zzar = this.zzflx.get();
        if (zzar != null) {
            zzar.zzflg.zza(new zzaz(this, zzar, zzar, zzcqf));
        }
    }
}
