package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.Status;
final class zzm implements Cast.ApplicationConnectionResult {
    private /* synthetic */ Status zzeil;

    zzm(Cast.zza zza, Status status) {
        this.zzeil = status;
    }

    @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
    public final ApplicationMetadata getApplicationMetadata() {
        return null;
    }

    @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
    public final String getApplicationStatus() {
        return null;
    }

    @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
    public final String getSessionId() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzeil;
    }

    @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
    public final boolean getWasLaunched() {
        return false;
    }
}
