package com.google.android.gms.common.api.internal;
final class zzap extends zzbm {
    private /* synthetic */ zzao zzfli;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzap(zzao zzao, zzbk zzbk) {
        super(zzbk);
        this.zzfli = zzao;
    }

    @Override // com.google.android.gms.common.api.internal.zzbm
    public final void zzagz() {
        this.zzfli.onConnectionSuspended(1);
    }
}
