package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.concurrent.atomic.AtomicReference;
final class zzbf implements GoogleApiClient.ConnectionCallbacks {
    private /* synthetic */ zzbd zzfmu;
    private /* synthetic */ AtomicReference zzfmv;
    private /* synthetic */ zzda zzfmw;

    zzbf(zzbd zzbd, AtomicReference atomicReference, zzda zzda) {
        this.zzfmu = zzbd;
        this.zzfmv = atomicReference;
        this.zzfmw = zzda;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.zzfmu.zza((GoogleApiClient) this.zzfmv.get(), this.zzfmw, true);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
