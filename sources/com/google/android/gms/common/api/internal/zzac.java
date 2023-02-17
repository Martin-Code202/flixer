package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.internal.zzcps;
import com.google.android.gms.internal.zzcpt;
public final class zzac<O extends Api.ApiOptions> extends GoogleApi<O> {
    private final Api.zza<? extends zzcps, zzcpt> zzfhl;
    private final Api.zze zzfkg;
    private final zzw zzfkh;
    private final zzq zzfki;

    public zzac(Context context, Api<O> api, Looper looper, Api.zze zze, zzw zzw, zzq zzq, Api.zza<? extends zzcps, zzcpt> zza) {
        super(context, api, looper);
        this.zzfkg = zze;
        this.zzfkh = zzw;
        this.zzfki = zzq;
        this.zzfhl = zza;
        this.zzfgu.zza(this);
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    public final Api.zze zza(Looper looper, zzbr<O> zzbr) {
        this.zzfkh.zza(zzbr);
        return this.zzfkg;
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    public final zzcw zza(Context context, Handler handler) {
        return new zzcw(context, handler, this.zzfki, this.zzfhl);
    }

    public final Api.zze zzagn() {
        return this.zzfkg;
    }
}
