package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.internal.zzasz;
final class zze extends Api.zza<zzasz, zzf> {
    zze() {
    }

    /* Return type fixed from 'com.google.android.gms.common.api.Api$zze' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, android.os.Looper, com.google.android.gms.common.internal.zzq, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener] */
    @Override // com.google.android.gms.common.api.Api.zza
    public final /* synthetic */ zzasz zza(Context context, Looper looper, zzq zzq, zzf zzf, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzasz(context, looper, zzq, zzf, connectionCallbacks, onConnectionFailedListener);
    }
}
