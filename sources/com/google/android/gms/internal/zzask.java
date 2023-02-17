package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
final class zzask extends zzaso<Status> {
    private /* synthetic */ Credential zzebi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzask(zzash zzash, GoogleApiClient googleApiClient, Credential credential) {
        super(googleApiClient);
        this.zzebi = credential;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzaso
    public final void zza(Context context, zzasu zzasu) {
        zzasu.zza(new zzasn(this), new zzasw(this.zzebi));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzs
    public final /* synthetic */ Result zzb(Status status) {
        return status;
    }
}
