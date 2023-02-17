package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;
/* access modifiers changed from: package-private */
public final class zzbj extends zzbz {
    private WeakReference<zzbd> zzfmy;

    zzbj(zzbd zzbd) {
        this.zzfmy = new WeakReference<>(zzbd);
    }

    @Override // com.google.android.gms.common.api.internal.zzbz
    public final void zzage() {
        zzbd zzbd = this.zzfmy.get();
        if (zzbd != null) {
            zzbd.resume();
        }
    }
}
