package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
/* access modifiers changed from: package-private */
public final class zzj extends zzl<Status> {
    zzj(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$zzb] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzm
    public final /* synthetic */ void zza(zzd zzd) {
        zzd zzd2 = zzd;
        ((zzt) zzd2.zzajk()).zzc(new zzk(this), zzd2.zzaan());
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzs
    public final /* synthetic */ Result zzb(Status status) {
        return status;
    }
}
