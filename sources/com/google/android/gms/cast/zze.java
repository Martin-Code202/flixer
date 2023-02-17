package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.internal.zzaze;
final class zze extends Api.zza<zzaze, Cast.CastOptions> {
    zze() {
    }

    /* Return type fixed from 'com.google.android.gms.common.api.Api$zze' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, android.os.Looper, com.google.android.gms.common.internal.zzq, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener] */
    @Override // com.google.android.gms.common.api.Api.zza
    public final /* synthetic */ zzaze zza(Context context, Looper looper, zzq zzq, Cast.CastOptions castOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Cast.CastOptions castOptions2 = castOptions;
        zzbp.zzb(castOptions2, "Setting the API options is required.");
        return new zzaze(context, looper, zzq, castOptions2.zzeif, (long) Cast.CastOptions.zza(castOptions2), castOptions2.zzeig, castOptions2.extras, connectionCallbacks, onConnectionFailedListener);
    }
}
