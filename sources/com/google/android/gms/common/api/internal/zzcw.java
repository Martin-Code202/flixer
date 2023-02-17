package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.internal.zzbs;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.internal.zzcpp;
import com.google.android.gms.internal.zzcps;
import com.google.android.gms.internal.zzcpt;
import com.google.android.gms.internal.zzcpx;
import com.google.android.gms.internal.zzcqf;
import java.util.Set;
public final class zzcw extends zzcpx implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static Api.zza<? extends zzcps, zzcpt> zzfpc = zzcpp.zzdwp;
    private final Context mContext;
    private final Handler mHandler;
    private Set<Scope> zzecl;
    private final Api.zza<? extends zzcps, zzcpt> zzfge;
    private zzq zzfki;
    private zzcps zzflo;
    private zzcy zzfpd;

    public zzcw(Context context, Handler handler, zzq zzq) {
        this(context, handler, zzq, zzfpc);
    }

    public zzcw(Context context, Handler handler, zzq zzq, Api.zza<? extends zzcps, zzcpt> zza) {
        this.mContext = context;
        this.mHandler = handler;
        this.zzfki = (zzq) zzbp.zzb(zzq, "ClientSettings must not be null");
        this.zzecl = zzq.zzajs();
        this.zzfge = zza;
    }

    /* access modifiers changed from: private */
    public final void zzc(zzcqf zzcqf) {
        ConnectionResult zzagd = zzcqf.zzagd();
        if (zzagd.isSuccess()) {
            zzbs zzbcd = zzcqf.zzbcd();
            ConnectionResult zzagd2 = zzbcd.zzagd();
            if (!zzagd2.isSuccess()) {
                String valueOf = String.valueOf(zzagd2);
                Log.wtf("SignInCoordinator", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                this.zzfpd.zzh(zzagd2);
                this.zzflo.disconnect();
                return;
            }
            this.zzfpd.zzb(zzbcd.zzakm(), this.zzecl);
        } else {
            this.zzfpd.zzh(zzagd);
        }
        this.zzflo.disconnect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.zzflo.zza(this);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzfpd.zzh(connectionResult);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.zzflo.disconnect();
    }

    public final void zza(zzcy zzcy) {
        if (this.zzflo != null) {
            this.zzflo.disconnect();
        }
        this.zzfki.zzc(Integer.valueOf(System.identityHashCode(this)));
        this.zzflo = (zzcps) this.zzfge.zza(this.mContext, this.mHandler.getLooper(), this.zzfki, this.zzfki.zzajy(), this, this);
        this.zzfpd = zzcy;
        this.zzflo.connect();
    }

    public final zzcps zzaic() {
        return this.zzflo;
    }

    public final void zzain() {
        if (this.zzflo != null) {
            this.zzflo.disconnect();
        }
    }

    @Override // com.google.android.gms.internal.zzcpx, com.google.android.gms.internal.zzcpy
    public final void zzb(zzcqf zzcqf) {
        this.mHandler.post(new zzcx(this, zzcqf));
    }
}
