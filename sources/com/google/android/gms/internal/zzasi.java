package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
final class zzasi extends zzaso<CredentialRequestResult> {
    private /* synthetic */ CredentialRequest zzebg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzasi(zzash zzash, GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        super(googleApiClient);
        this.zzebg = credentialRequest;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzaso
    public final void zza(Context context, zzasu zzasu) {
        zzasu.zza(new zzasj(this), this.zzebg);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzs
    public final /* synthetic */ Result zzb(Status status) {
        return zzasg.zzf(status);
    }
}
