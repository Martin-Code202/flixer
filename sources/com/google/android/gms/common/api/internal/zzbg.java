package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
final class zzbg implements GoogleApiClient.OnConnectionFailedListener {
    private /* synthetic */ zzda zzfmw;

    zzbg(zzbd zzbd, zzda zzda) {
        this.zzfmw = zzda;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzfmw.setResult(new Status(8));
    }
}
