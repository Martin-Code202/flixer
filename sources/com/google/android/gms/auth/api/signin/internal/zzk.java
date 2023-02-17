package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Status;
final class zzk extends zza {
    private /* synthetic */ zzj zzecx;

    zzk(zzj zzj) {
        this.zzecx = zzj;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zza, com.google.android.gms.auth.api.signin.internal.zzr
    public final void zzj(Status status) {
        this.zzecx.setResult((zzj) status);
    }
}
