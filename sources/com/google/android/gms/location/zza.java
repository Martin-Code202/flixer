package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.internal.zzbzu;
final class zza extends Api.zza<zzbzu, Object> {
    zza() {
    }

    /* Return type fixed from 'com.google.android.gms.common.api.Api$zze' to match base method */
    @Override // com.google.android.gms.common.api.Api.zza
    public final /* synthetic */ zzbzu zza(Context context, Looper looper, zzq zzq, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzbzu(context, looper, connectionCallbacks, onConnectionFailedListener, "activity_recognition");
    }
}
