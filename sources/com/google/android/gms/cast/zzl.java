package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaze;
import com.google.android.gms.internal.zzazp;
final class zzl extends zzazp {
    private /* synthetic */ String val$sessionId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzl(Cast.CastApi.zza zza, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.val$sessionId = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$zzb] */
    @Override // com.google.android.gms.internal.zzazp, com.google.android.gms.common.api.internal.zzm
    public final /* bridge */ /* synthetic */ void zza(zzaze zzaze) {
        zza(zzaze);
    }

    @Override // com.google.android.gms.internal.zzazp
    public final void zza(zzaze zzaze) {
        if (TextUtils.isEmpty(this.val$sessionId)) {
            setResult((zzl) zzb(new Status(2001, "IllegalArgument: sessionId cannot be null or empty", null)));
            return;
        }
        try {
            zzaze.zza(this.val$sessionId, this);
        } catch (IllegalStateException unused) {
            zzbi(2001);
        }
    }
}
