package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzed;
public final class zzo extends zzeb implements zzm {
    zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationListener");
    }

    @Override // com.google.android.gms.location.zzm
    public final void onLocationChanged(Location location) {
        Parcel zzax = zzax();
        zzed.zza(zzax, location);
        zzc(1, zzax);
    }
}
