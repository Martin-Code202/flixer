package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzed;
public abstract class zzk extends zzec implements zzj {
    public zzk() {
        attachInterface(this, "com.google.android.gms.location.ILocationCallback");
    }

    public static zzj zzba(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof zzj ? (zzj) queryLocalInterface : new zzl(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                onLocationResult((LocationResult) zzed.zza(parcel, LocationResult.CREATOR));
                return true;
            case 2:
                onLocationAvailability((LocationAvailability) zzed.zza(parcel, LocationAvailability.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
