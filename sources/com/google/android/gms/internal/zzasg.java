package com.google.android.gms.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;
public final class zzasg implements CredentialRequestResult {
    private final Status mStatus;
    private final Credential zzebf;

    public zzasg(Status status, Credential credential) {
        this.mStatus = status;
        this.zzebf = credential;
    }

    public static zzasg zzf(Status status) {
        return new zzasg(status, null);
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialRequestResult
    public final Credential getCredential() {
        return this.zzebf;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.mStatus;
    }
}
