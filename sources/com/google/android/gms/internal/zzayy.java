package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
public final class zzayy extends GoogleApi<Object> {
    private static final Api<Object> API = new Api<>("CastApi.API", zzdwp, zzdwo);
    private static final Api.zzf<zzazc> zzdwo = new Api.zzf<>();
    private static final Api.zza<zzazc, Object> zzdwp = new zzayz();

    public zzayy(Context context) {
        super(context, API, null, GoogleApi.zza.zzfgv);
    }
}
