package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;
final class zzasn extends zzasf {
    private zzn<Status> zzebj;

    zzasn(zzn<Status> zzn) {
        this.zzebj = zzn;
    }

    @Override // com.google.android.gms.internal.zzasf, com.google.android.gms.internal.zzass
    public final void zze(Status status) {
        this.zzebj.setResult(status);
    }
}
