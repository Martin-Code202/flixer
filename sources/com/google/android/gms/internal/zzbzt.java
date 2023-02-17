package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.common.api.internal.zzcm;
import com.google.android.gms.location.LocationListener;
final class zzbzt implements zzcm<LocationListener> {
    private /* synthetic */ Location zzhzq;

    zzbzt(zzbzs zzbzs, Location location) {
        this.zzhzq = location;
    }

    @Override // com.google.android.gms.common.api.internal.zzcm
    public final void zzagx() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.common.api.internal.zzcm
    public final /* synthetic */ void zzq(LocationListener locationListener) {
        locationListener.onLocationChanged(this.zzhzq);
    }
}
