package com.google.android.gms.internal;

import com.google.android.gms.common.api.internal.zzcm;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
final class zzbzr implements zzcm<LocationCallback> {
    private /* synthetic */ LocationAvailability zzhzp;

    zzbzr(zzbzp zzbzp, LocationAvailability locationAvailability) {
        this.zzhzp = locationAvailability;
    }

    @Override // com.google.android.gms.common.api.internal.zzcm
    public final void zzagx() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.common.api.internal.zzcm
    public final /* synthetic */ void zzq(LocationCallback locationCallback) {
        locationCallback.onLocationAvailability(this.zzhzp);
    }
}
