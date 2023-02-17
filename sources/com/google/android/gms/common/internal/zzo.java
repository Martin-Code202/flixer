package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
public final class zzo extends zze {
    private /* synthetic */ zzd zzftk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzo(zzd zzd, int i, Bundle bundle) {
        super(zzd, i, null);
        this.zzftk = zzd;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zze
    public final boolean zzajo() {
        this.zzftk.zzfsw.zzf(ConnectionResult.zzffe);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zze
    public final void zzj(ConnectionResult connectionResult) {
        this.zzftk.zzfsw.zzf(connectionResult);
        this.zzftk.onConnectionFailed(connectionResult);
    }
}
