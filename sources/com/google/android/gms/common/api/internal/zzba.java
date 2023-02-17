package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
final class zzba implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private /* synthetic */ zzar zzflw;

    private zzba(zzar zzar) {
        this.zzflw = zzar;
    }

    /* synthetic */ zzba(zzar zzar, zzas zzas) {
        this(zzar);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.zzflw.zzflo.zza(new zzay(this.zzflw));
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzflw.zzfkd.lock();
        try {
            if (this.zzflw.zzd(connectionResult)) {
                this.zzflw.zzahd();
                this.zzflw.zzahb();
            } else {
                this.zzflw.zze(connectionResult);
            }
        } finally {
            this.zzflw.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
