package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
/* access modifiers changed from: package-private */
public final class zzab implements zzf {
    private /* synthetic */ GoogleApiClient.ConnectionCallbacks zzfuj;

    zzab(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zzfuj = connectionCallbacks;
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnected(Bundle bundle) {
        this.zzfuj.onConnected(bundle);
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnectionSuspended(int i) {
        this.zzfuj.onConnectionSuspended(i);
    }
}
