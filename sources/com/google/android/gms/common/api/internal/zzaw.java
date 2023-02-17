package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzj;
final class zzaw extends zzbm {
    private /* synthetic */ zzj zzfmb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaw(zzau zzau, zzbk zzbk, zzj zzj) {
        super(zzbk);
        this.zzfmb = zzj;
    }

    @Override // com.google.android.gms.common.api.internal.zzbm
    public final void zzagz() {
        this.zzfmb.zzf(new ConnectionResult(16, null));
    }
}
