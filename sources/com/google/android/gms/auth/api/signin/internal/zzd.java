package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzq;
public final class zzd extends zzaa<zzt> {
    private final GoogleSignInOptions zzecr;

    public zzd(Context context, Looper looper, zzq zzq, GoogleSignInOptions googleSignInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 91, zzq, connectionCallbacks, onConnectionFailedListener);
        GoogleSignInOptions build = googleSignInOptions != null ? googleSignInOptions : new GoogleSignInOptions.Builder().build();
        if (!zzq.zzajt().isEmpty()) {
            GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder(build);
            for (Scope scope : zzq.zzajt()) {
                builder.requestScopes(scope, new Scope[0]);
            }
            build = builder.build();
        }
        this.zzecr = build;
    }

    @Override // com.google.android.gms.common.internal.zzd, com.google.android.gms.common.api.Api.zze
    public final boolean zzaal() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.zzd, com.google.android.gms.common.api.Api.zze
    public final Intent zzaam() {
        return zze.zza(getContext(), this.zzecr);
    }

    public final GoogleSignInOptions zzaan() {
        return this.zzecr;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return queryLocalInterface instanceof zzt ? (zzt) queryLocalInterface : new zzu(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhc() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhd() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }
}
