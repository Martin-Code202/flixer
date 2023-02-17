package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzm;
/* access modifiers changed from: package-private */
public abstract class zzl<R extends Result> extends zzm<R, zzd> {
    public zzl(GoogleApiClient googleApiClient) {
        super(Auth.GOOGLE_SIGN_IN_API, googleApiClient);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.auth.api.signin.internal.zzl<R extends com.google.android.gms.common.api.Result> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.zzm, com.google.android.gms.common.api.internal.zzn
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((zzl<R>) ((Result) obj));
    }
}
