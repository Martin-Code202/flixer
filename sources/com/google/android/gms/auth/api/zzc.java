package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzq;
import java.util.Collections;
import java.util.List;
final class zzc extends Api.zza<zzd, GoogleSignInOptions> {
    zzc() {
    }

    /* Return type fixed from 'com.google.android.gms.common.api.Api$zze' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, android.os.Looper, com.google.android.gms.common.internal.zzq, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener] */
    @Override // com.google.android.gms.common.api.Api.zza
    public final /* synthetic */ zzd zza(Context context, Looper looper, zzq zzq, GoogleSignInOptions googleSignInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzd(context, looper, zzq, googleSignInOptions, connectionCallbacks, onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.Api.zzd
    public final /* synthetic */ List zzn(Object obj) {
        GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
        return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.zzaag();
    }
}
