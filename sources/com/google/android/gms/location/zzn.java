package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzed;
public abstract class zzn extends zzec implements zzm {
    public zzn() {
        attachInterface(this, "com.google.android.gms.location.ILocationListener");
    }

    public static zzm zzbb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return queryLocalInterface instanceof zzm ? (zzm) queryLocalInterface : new zzo(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        onLocationChanged((Location) zzed.zza(parcel, Location.CREATOR));
        return true;
    }
}
