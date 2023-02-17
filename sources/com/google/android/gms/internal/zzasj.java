package com.google.android.gms.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;
final class zzasj extends zzasf {
    private /* synthetic */ zzasi zzebh;

    zzasj(zzasi zzasi) {
        this.zzebh = zzasi;
    }

    @Override // com.google.android.gms.internal.zzasf, com.google.android.gms.internal.zzass
    public final void zza(Status status, Credential credential) {
        this.zzebh.setResult((zzasi) new zzasg(status, credential));
    }

    @Override // com.google.android.gms.internal.zzasf, com.google.android.gms.internal.zzass
    public final void zze(Status status) {
        this.zzebh.setResult((zzasi) zzasg.zzf(status));
    }
}
