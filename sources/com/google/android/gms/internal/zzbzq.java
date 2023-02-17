package com.google.android.gms.internal;

import com.google.android.gms.common.api.internal.zzcm;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
final class zzbzq implements zzcm<LocationCallback> {
    private /* synthetic */ LocationResult zzhzo;

    zzbzq(zzbzp zzbzp, LocationResult locationResult) {
        this.zzhzo = locationResult;
    }

    @Override // com.google.android.gms.common.api.internal.zzcm
    public final void zzagx() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.common.api.internal.zzcm
    public final /* synthetic */ void zzq(LocationCallback locationCallback) {
        locationCallback.onLocationResult(this.zzhzo);
    }
}
