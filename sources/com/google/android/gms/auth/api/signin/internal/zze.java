package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzbp;
import com.google.android.gms.internal.zzbde;
public final class zze {
    private static zzbde zzecs = new zzbde("GoogleSignInCommon", new String[0]);

    public static Intent zza(Context context, GoogleSignInOptions googleSignInOptions) {
        zzecs.zzb("GoogleSignInCommon", "getSignInIntent()");
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setClass(context, SignInHubActivity.class);
        intent.putExtra("config", signInConfiguration);
        return intent;
    }

    public static PendingResult<Status> zzb(GoogleApiClient googleApiClient, Context context) {
        zzecs.zzb("GoogleSignInCommon", "Revoking access");
        zzbk(context);
        return googleApiClient.zze(new zzj(googleApiClient));
    }

    private static void zzbk(Context context) {
        zzy.zzbl(context).zzaau();
        for (GoogleApiClient googleApiClient : GoogleApiClient.zzafo()) {
            googleApiClient.zzafp();
        }
        zzbp.zzahp();
    }
}
