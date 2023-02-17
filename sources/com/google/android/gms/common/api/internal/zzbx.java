package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
public final class zzbx<O extends Api.ApiOptions> extends zzan {
    private final GoogleApi<O> zzfog;

    public zzbx(GoogleApi<O> googleApi) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.zzfog = googleApi;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Context getContext() {
        return this.zzfog.getApplicationContext();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper getLooper() {
        return this.zzfog.getLooper();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zza(zzdg zzdg) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zzb(zzdg zzdg) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T zzd(T t) {
        return (T) this.zzfog.zza(t);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T zze(T t) {
        return (T) this.zzfog.zzb(t);
    }
}
