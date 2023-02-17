package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzm;
public final class zzc<A extends zzm<? extends Result, Api.zzb>> extends zza {
    private A zzfib;

    public zzc(int i, A a) {
        super(i);
        this.zzfib = a;
    }

    @Override // com.google.android.gms.common.api.internal.zza
    public final void zza(zzah zzah, boolean z) {
        zzah.zza(this.zzfib, z);
    }

    @Override // com.google.android.gms.common.api.internal.zza
    public final void zza(zzbr<?> zzbr) {
        this.zzfib.zzb(zzbr.zzagn());
    }

    @Override // com.google.android.gms.common.api.internal.zza
    public final void zzr(Status status) {
        this.zzfib.zzt(status);
    }
}
