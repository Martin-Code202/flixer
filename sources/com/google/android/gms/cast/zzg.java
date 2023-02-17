package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzaze;
final class zzg extends Cast.zza {
    private /* synthetic */ String zzeic;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzg(Cast.CastApi.zza zza, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zzeic = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$zzb] */
    @Override // com.google.android.gms.cast.Cast.zza, com.google.android.gms.common.api.internal.zzm
    public final /* bridge */ /* synthetic */ void zza(zzaze zzaze) {
        zza(zzaze);
    }

    @Override // com.google.android.gms.cast.Cast.zza
    public final void zza(zzaze zzaze) {
        try {
            String str = this.zzeic;
            LaunchOptions launchOptions = new LaunchOptions();
            launchOptions.setRelaunchIfRunning(false);
            zzaze.zza(str, launchOptions, this);
        } catch (IllegalStateException unused) {
            zzbi(2001);
        }
    }
}
