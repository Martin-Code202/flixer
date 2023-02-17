package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzaze;
import com.google.android.gms.internal.zzazp;
final class zzf extends zzazp {
    private /* synthetic */ String val$message;
    private /* synthetic */ String zzeib;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzf(Cast.CastApi.zza zza, GoogleApiClient googleApiClient, String str, String str2) {
        super(googleApiClient);
        this.zzeib = str;
        this.val$message = str2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$zzb] */
    @Override // com.google.android.gms.internal.zzazp, com.google.android.gms.common.api.internal.zzm
    public final /* bridge */ /* synthetic */ void zza(zzaze zzaze) {
        zza(zzaze);
    }

    @Override // com.google.android.gms.internal.zzazp
    public final void zza(zzaze zzaze) {
        try {
            zzaze.zza(this.zzeib, this.val$message, this);
        } catch (IllegalArgumentException | IllegalStateException unused) {
            zzbi(2001);
        }
    }
}
