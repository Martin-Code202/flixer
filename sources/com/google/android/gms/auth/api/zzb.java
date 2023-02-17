package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.internal.zzarl;
final class zzb extends Api.zza<zzarl, Object> {
    zzb() {
    }

    /* Return type fixed from 'com.google.android.gms.common.api.Api$zze' to match base method */
    @Override // com.google.android.gms.common.api.Api.zza
    public final /* synthetic */ zzarl zza(Context context, Looper looper, zzq zzq, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzarl(context, looper, zzq, connectionCallbacks, onConnectionFailedListener);
    }
}
