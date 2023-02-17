package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.zzy;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzam;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzq;
public final class zzcqc extends zzaa<zzcqa> implements zzcps {
    private final zzq zzfki;
    private Integer zzftt;
    private final boolean zzjnv;
    private final Bundle zzjnw;

    private zzcqc(Context context, Looper looper, boolean z, zzq zzq, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, zzq, connectionCallbacks, onConnectionFailedListener);
        this.zzjnv = true;
        this.zzfki = zzq;
        this.zzjnw = bundle;
        this.zzftt = zzq.zzajz();
    }

    public zzcqc(Context context, Looper looper, boolean z, zzq zzq, zzcpt zzcpt, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, true, zzq, zza(zzq), connectionCallbacks, onConnectionFailedListener);
    }

    public static Bundle zza(zzq zzq) {
        zzcpt zzajy = zzq.zzajy();
        Integer zzajz = zzq.zzajz();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", zzq.getAccount());
        if (zzajz != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", zzajz.intValue());
        }
        if (zzajy != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzajy.zzbbx());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzajy.isIdTokenRequested());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", zzajy.getServerClientId());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", zzajy.zzbby());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", zzajy.zzbbz());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", zzajy.zzbca());
            if (zzajy.zzbcb() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", zzajy.zzbcb().longValue());
            }
            if (zzajy.zzbcc() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", zzajy.zzbcc().longValue());
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.zzcps
    public final void connect() {
        zza(new zzm(this));
    }

    @Override // com.google.android.gms.internal.zzcps
    public final void zza(zzam zzam, boolean z) {
        try {
            ((zzcqa) zzajk()).zza(zzam, this.zzftt.intValue(), z);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // com.google.android.gms.internal.zzcps
    public final void zza(zzcpy zzcpy) {
        zzbp.zzb(zzcpy, "Expecting a valid ISignInCallbacks");
        try {
            Account zzajq = this.zzfki.zzajq();
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(zzajq.name)) {
                googleSignInAccount = zzy.zzbl(getContext()).zzaas();
            }
            ((zzcqa) zzajk()).zza(new zzcqd(new zzbq(zzajq, this.zzftt.intValue(), googleSignInAccount)), zzcpy);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zzcpy.zzb(new zzcqf(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.zzd, com.google.android.gms.common.api.Api.zze
    public final boolean zzaac() {
        return this.zzjnv;
    }

    @Override // com.google.android.gms.internal.zzcps
    public final void zzbbw() {
        try {
            ((zzcqa) zzajk()).zzec(this.zzftt.intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof zzcqa ? (zzcqa) queryLocalInterface : new zzcqb(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhc() {
        return "com.google.android.gms.signin.service.START";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhd() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final Bundle zzzu() {
        if (!getContext().getPackageName().equals(this.zzfki.zzajv())) {
            this.zzjnw.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzfki.zzajv());
        }
        return this.zzjnw;
    }
}
