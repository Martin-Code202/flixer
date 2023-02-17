package com.google.android.gms.internal;

import com.google.android.gms.common.api.internal.zzcj;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzk;
/* access modifiers changed from: package-private */
public final class zzbzp extends zzk {
    private final zzcj<LocationCallback> zzfpb;

    @Override // com.google.android.gms.location.zzj
    public final void onLocationAvailability(LocationAvailability locationAvailability) {
        this.zzfpb.zza(new zzbzr(this, locationAvailability));
    }

    @Override // com.google.android.gms.location.zzj
    public final void onLocationResult(LocationResult locationResult) {
        this.zzfpb.zza(new zzbzq(this, locationResult));
    }
}
