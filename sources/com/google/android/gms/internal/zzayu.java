package com.google.android.gms.internal;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzm;
public abstract class zzayu<R extends Result> extends zzm<R, zzaze> {
    public zzayu(GoogleApiClient googleApiClient) {
        super(Cast.API, googleApiClient);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.zzayu<R extends com.google.android.gms.common.api.Result> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.zzm, com.google.android.gms.common.api.internal.zzn
    public /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((zzayu<R>) ((Result) obj));
    }

    public final void zzbi(int i) {
        setResult((zzayu<R>) zzb(new Status(2001)));
    }
}
