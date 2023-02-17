package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzbp;
public final class zzw implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final Api<?> zzfdf;
    private final boolean zzfjr;
    private zzx zzfjs;

    public zzw(Api<?> api, boolean z) {
        this.zzfdf = api;
        this.zzfjr = z;
    }

    private final void zzagh() {
        zzbp.zzb(this.zzfjs, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzagh();
        this.zzfjs.onConnected(bundle);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzagh();
        this.zzfjs.zza(connectionResult, this.zzfdf, this.zzfjr);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        zzagh();
        this.zzfjs.onConnectionSuspended(i);
    }

    public final void zza(zzx zzx) {
        this.zzfjs = zzx;
    }
}
