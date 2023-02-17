package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.common.api.internal.zzcj;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.zzn;
/* access modifiers changed from: package-private */
public final class zzbzs extends zzn {
    private final zzcj<LocationListener> zzfpb;

    @Override // com.google.android.gms.location.zzm
    public final synchronized void onLocationChanged(Location location) {
        this.zzfpb.zza(new zzbzt(this, location));
    }
}
