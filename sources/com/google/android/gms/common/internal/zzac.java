package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
/* access modifiers changed from: package-private */
public final class zzac implements zzg {
    private /* synthetic */ GoogleApiClient.OnConnectionFailedListener zzfuk;

    zzac(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzfuk = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.internal.zzg
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzfuk.onConnectionFailed(connectionResult);
    }
}
