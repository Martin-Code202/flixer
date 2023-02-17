package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzc;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzarj;
import com.google.android.gms.internal.zzark;
import com.google.android.gms.internal.zzarl;
import com.google.android.gms.internal.zzash;
import com.google.android.gms.internal.zzasp;
import com.google.android.gms.internal.zzato;
public final class Auth {
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API = new Api<>("Auth.CREDENTIALS_API", zzdye, zzdyb);
    public static final CredentialsApi CredentialsApi = new zzash();
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API = new Api<>("Auth.GOOGLE_SIGN_IN_API", zzdyg, zzdyd);
    public static final GoogleSignInApi GoogleSignInApi = new zzc();
    public static final Api<zzf> PROXY_API = zzd.API;
    public static final ProxyApi ProxyApi = new zzato();
    public static final Api.zzf<zzasp> zzdyb = new Api.zzf<>();
    private static Api.zzf<zzarl> zzdyc = new Api.zzf<>();
    public static final Api.zzf<zzd> zzdyd = new Api.zzf<>();
    private static final Api.zza<zzasp, AuthCredentialsOptions> zzdye = new zza();
    private static final Api.zza<zzarl, Object> zzdyf = new zzb();
    private static final Api.zza<zzd, GoogleSignInOptions> zzdyg = new zzc();
    private static Api<Object> zzdyh = new Api<>("Auth.ACCOUNT_STATUS_API", zzdyf, zzdyc);
    private static zzarj zzdyi = new zzark();

    public static final class AuthCredentialsOptions implements Api.ApiOptions.Optional {
        private static AuthCredentialsOptions zzdyj = new AuthCredentialsOptions(new Builder());
        private final String zzdyk = null;
        private final PasswordSpecification zzdyl;

        public static class Builder {
            private PasswordSpecification zzdyl = PasswordSpecification.zzeaw;
        }

        private AuthCredentialsOptions(Builder builder) {
            this.zzdyl = builder.zzdyl;
        }

        public final Bundle zzzu() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", null);
            bundle.putParcelable("password_specification", this.zzdyl);
            return bundle;
        }
    }
}
