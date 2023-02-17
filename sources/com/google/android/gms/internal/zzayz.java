package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzq;
final class zzayz extends Api.zza<zzazc, Object> {
    zzayz() {
    }

    /* Return type fixed from 'com.google.android.gms.common.api.Api$zze' to match base method */
    @Override // com.google.android.gms.common.api.Api.zza
    public final /* synthetic */ zzazc zza(Context context, Looper looper, zzq zzq, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzazc(context, looper, zzq, connectionCallbacks, onConnectionFailedListener);
    }
}
