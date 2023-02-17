package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzm;
/* access modifiers changed from: package-private */
public abstract class zzaso<R extends Result> extends zzm<R, zzasp> {
    zzaso(GoogleApiClient googleApiClient) {
        super(Auth.CREDENTIALS_API, googleApiClient);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.zzaso<R extends com.google.android.gms.common.api.Result> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.zzm, com.google.android.gms.common.api.internal.zzn
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((zzaso<R>) ((Result) obj));
    }

    /* access modifiers changed from: protected */
    public abstract void zza(Context context, zzasu zzasu);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$zzb] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzm
    public final /* synthetic */ void zza(zzasp zzasp) {
        zzasp zzasp2 = zzasp;
        zza(zzasp2.getContext(), (zzasu) zzasp2.zzajk());
    }
}
