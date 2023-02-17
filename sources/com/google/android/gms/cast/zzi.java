package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzaze;
final class zzi extends Cast.zza {
    private /* synthetic */ String val$sessionId;
    private /* synthetic */ String zzeic;
    private /* synthetic */ zzab zzeie = null;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzi(Cast.CastApi.zza zza, GoogleApiClient googleApiClient, String str, String str2, zzab zzab) {
        super(googleApiClient);
        this.zzeic = str;
        this.val$sessionId = str2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$zzb] */
    @Override // com.google.android.gms.cast.Cast.zza, com.google.android.gms.common.api.internal.zzm
    public final /* bridge */ /* synthetic */ void zza(zzaze zzaze) {
        zza(zzaze);
    }

    @Override // com.google.android.gms.cast.Cast.zza
    public final void zza(zzaze zzaze) {
        try {
            zzaze.zza(this.zzeic, this.val$sessionId, this.zzeie, this);
        } catch (IllegalStateException unused) {
            zzbi(2001);
        }
    }
}
