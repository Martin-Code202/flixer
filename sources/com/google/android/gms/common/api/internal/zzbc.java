package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import java.util.Collections;
public final class zzbc implements zzbk {
    private final zzbl zzflg;

    public zzbc(zzbl zzbl) {
        this.zzflg = zzbl;
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final void begin() {
        for (Api.zze zze : this.zzflg.zzfmm.values()) {
            zze.disconnect();
        }
        this.zzflg.zzfjt.zzfmn = Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final void connect() {
        this.zzflg.zzahl();
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final boolean disconnect() {
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T zzd(T t) {
        this.zzflg.zzfjt.zzfkr.add(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T zze(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
