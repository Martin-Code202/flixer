package com.google.android.gms.common.api.internal;
final class zzbq implements zzl {
    private /* synthetic */ zzbp zzfnt;

    zzbq(zzbp zzbp) {
        this.zzfnt = zzbp;
    }

    @Override // com.google.android.gms.common.api.internal.zzl
    public final void zzbe(boolean z) {
        this.zzfnt.mHandler.sendMessage(this.zzfnt.mHandler.obtainMessage(1, Boolean.valueOf(z)));
    }
}
