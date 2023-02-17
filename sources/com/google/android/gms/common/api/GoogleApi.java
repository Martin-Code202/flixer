package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.zzbp;
import com.google.android.gms.common.api.internal.zzbr;
import com.google.android.gms.common.api.internal.zzbx;
import com.google.android.gms.common.api.internal.zzcw;
import com.google.android.gms.common.api.internal.zzcz;
import com.google.android.gms.common.api.internal.zzg;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.common.internal.zzr;
import java.util.Collections;
public class GoogleApi<O extends Api.ApiOptions> {
    private final Context mContext;
    private final int mId;
    private final Looper zzakf;
    private final Api<O> zzfdf;
    private final O zzfgq;
    private final zzh<O> zzfgr;
    private final GoogleApiClient zzfgs;
    private final zzcz zzfgt;
    protected final zzbp zzfgu;

    public static class zza {
        public static final zza zzfgv = new zzd().zzafn();
        public final zzcz zzfgw;
        public final Looper zzfgx;

        private zza(zzcz zzcz, Account account, Looper looper) {
            this.zzfgw = zzcz;
            this.zzfgx = looper;
        }
    }

    protected GoogleApi(Context context, Api<O> api, Looper looper) {
        com.google.android.gms.common.internal.zzbp.zzb(context, "Null context is not permitted.");
        com.google.android.gms.common.internal.zzbp.zzb(api, "Api must not be null.");
        com.google.android.gms.common.internal.zzbp.zzb(looper, "Looper must not be null.");
        this.mContext = context.getApplicationContext();
        this.zzfdf = api;
        this.zzfgq = null;
        this.zzakf = looper;
        this.zzfgr = zzh.zzb(api);
        this.zzfgs = new zzbx(this);
        this.zzfgu = zzbp.zzca(this.mContext);
        this.mId = this.zzfgu.zzahq();
        this.zzfgt = new zzg();
    }

    public GoogleApi(Context context, Api<O> api, O o2, zza zza2) {
        com.google.android.gms.common.internal.zzbp.zzb(context, "Null context is not permitted.");
        com.google.android.gms.common.internal.zzbp.zzb(api, "Api must not be null.");
        com.google.android.gms.common.internal.zzbp.zzb(zza2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = context.getApplicationContext();
        this.zzfdf = api;
        this.zzfgq = o2;
        this.zzakf = zza2.zzfgx;
        this.zzfgr = zzh.zza(this.zzfdf, this.zzfgq);
        this.zzfgs = new zzbx(this);
        this.zzfgu = zzbp.zzca(this.mContext);
        this.mId = this.zzfgu.zzahq();
        this.zzfgt = zza2.zzfgw;
        this.zzfgu.zza((GoogleApi<?>) this);
    }

    private final <A extends Api.zzb, T extends zzm<? extends Result, A>> T zza(int i, T t) {
        t.zzagg();
        this.zzfgu.zza(this, i, t);
        return t;
    }

    private final zzr zzafm() {
        GoogleSignInAccount googleSignInAccount;
        return new zzr().zze(this.zzfgq instanceof Api.ApiOptions.HasGoogleSignInAccountOptions ? ((Api.ApiOptions.HasGoogleSignInAccountOptions) this.zzfgq).getGoogleSignInAccount().getAccount() : this.zzfgq instanceof Api.ApiOptions.HasAccountOptions ? ((Api.ApiOptions.HasAccountOptions) this.zzfgq).getAccount() : null).zze((!(this.zzfgq instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount = ((Api.ApiOptions.HasGoogleSignInAccountOptions) this.zzfgq).getGoogleSignInAccount()) == null) ? Collections.emptySet() : googleSignInAccount.getGrantedScopes());
    }

    public final Context getApplicationContext() {
        return this.mContext;
    }

    public final int getInstanceId() {
        return this.mId;
    }

    public final Looper getLooper() {
        return this.zzakf;
    }

    public Api.zze zza(Looper looper, zzbr<O> zzbr) {
        return this.zzfdf.zzafd().zza(this.mContext, looper, zzafm().zzfz(this.mContext.getPackageName()).zzga(this.mContext.getClass().getName()).zzaka(), this.zzfgq, zzbr, zzbr);
    }

    public zzcw zza(Context context, Handler handler) {
        return new zzcw(context, handler, zzafm().zzaka());
    }

    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T zza(T t) {
        return (T) zza(0, (int) t);
    }

    public final Api<O> zzafj() {
        return this.zzfdf;
    }

    public final zzh<O> zzafk() {
        return this.zzfgr;
    }

    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T zzb(T t) {
        return (T) zza(1, (int) t);
    }
}
