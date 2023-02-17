package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
public final class zzv extends zzq {
    private final Context mContext;

    public zzv(Context context) {
        this.mContext = context;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzp
    public final void zzaap() {
        if (!GooglePlayServicesUtil.zzf(this.mContext, Binder.getCallingUid())) {
            throw new SecurityException(new StringBuilder(52).append("Calling UID ").append(Binder.getCallingUid()).append(" is not Google Play services.").toString());
        }
        zzy zzbl = zzy.zzbl(this.mContext);
        GoogleSignInAccount zzaas = zzbl.zzaas();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.DEFAULT_SIGN_IN;
        if (zzaas != null) {
            googleSignInOptions = zzbl.zzaat();
        }
        GoogleApiClient build = new GoogleApiClient.Builder(this.mContext).addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions).build();
        try {
            if (build.blockingConnect().isSuccess()) {
                if (zzaas != null) {
                    Auth.GoogleSignInApi.revokeAccess(build);
                } else {
                    build.clearDefaultAccountAndReconnect();
                }
            }
        } finally {
            build.disconnect();
        }
    }
}
