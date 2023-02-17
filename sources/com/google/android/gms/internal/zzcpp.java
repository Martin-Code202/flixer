package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
public final class zzcpp {
    public static final Api<zzcpt> API = new Api<>("SignIn.API", zzdwp, zzdwo);
    private static Api.zzf<zzcqc> zzdwo = new Api.zzf<>();
    public static final Api.zza<zzcqc, zzcpt> zzdwp = new zzcpq();
    private static Scope zzecc = new Scope("profile");
    private static Scope zzecd = new Scope(SignupConstants.Field.EMAIL);
    private static Api<Object> zzgdm = new Api<>("SignIn.INTERNAL_API", zzjnn, zzjnm);
    private static Api.zzf<zzcqc> zzjnm = new Api.zzf<>();
    private static Api.zza<zzcqc, Object> zzjnn = new zzcpr();
}
