package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzq;
final class zzcpq extends Api.zza<zzcqc, zzcpt> {
    zzcpq() {
    }

    /* Return type fixed from 'com.google.android.gms.common.api.Api$zze' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, android.os.Looper, com.google.android.gms.common.internal.zzq, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener] */
    @Override // com.google.android.gms.common.api.Api.zza
    public final /* synthetic */ zzcqc zza(Context context, Looper looper, zzq zzq, zzcpt zzcpt, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzcpt zzcpt2 = zzcpt;
        if (zzcpt2 == null) {
            zzcpt2 = zzcpt.zzjno;
        }
        return new zzcqc(context, looper, true, zzq, zzcpt2, connectionCallbacks, onConnectionFailedListener);
    }
}
