package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
final class zzav extends zzbm {
    private /* synthetic */ ConnectionResult zzflz;
    private /* synthetic */ zzau zzfma;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzav(zzau zzau, zzbk zzbk, ConnectionResult connectionResult) {
        super(zzbk);
        this.zzfma = zzau;
        this.zzflz = connectionResult;
    }

    @Override // com.google.android.gms.common.api.internal.zzbm
    public final void zzagz() {
        this.zzfma.zzflw.zze(this.zzflz);
    }
}
