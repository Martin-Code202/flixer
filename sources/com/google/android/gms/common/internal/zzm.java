package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
public final class zzm implements zzj {
    private /* synthetic */ zzd zzftk;

    public zzm(zzd zzd) {
        this.zzftk = zzd;
    }

    @Override // com.google.android.gms.common.internal.zzj
    public final void zzf(ConnectionResult connectionResult) {
        if (connectionResult.isSuccess()) {
            this.zzftk.zza((zzam) null, this.zzftk.zzajm());
        } else if (this.zzftk.zzftc != null) {
            this.zzftk.zzftc.onConnectionFailed(connectionResult);
        }
    }
}
