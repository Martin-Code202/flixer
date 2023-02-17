package com.google.android.gms.location;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzed;
public final class zzl extends zzeb implements zzj {
    zzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationCallback");
    }

    @Override // com.google.android.gms.location.zzj
    public final void onLocationAvailability(LocationAvailability locationAvailability) {
        Parcel zzax = zzax();
        zzed.zza(zzax, locationAvailability);
        zzc(2, zzax);
    }

    @Override // com.google.android.gms.location.zzj
    public final void onLocationResult(LocationResult locationResult) {
        Parcel zzax = zzax();
        zzed.zza(zzax, locationResult);
        zzc(1, zzax);
    }
}
