package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
final class zzbyf extends zzbyh {
    private /* synthetic */ long zzhyx;
    private /* synthetic */ PendingIntent zzhyy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbyf(zzbye zzbye, GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.zzhyx = j;
        this.zzhyy = pendingIntent;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$zzb] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzm
    public final /* synthetic */ void zza(zzbzu zzbzu) {
        zzbzu.zza(this.zzhyx, this.zzhyy);
        setResult((zzbyf) Status.zzfhu);
    }
}
