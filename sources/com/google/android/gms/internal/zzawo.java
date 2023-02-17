package com.google.android.gms.internal;

import android.os.Parcel;
public abstract class zzawo extends zzec implements zzawn {
    public zzawo() {
        attachInterface(this, "com.google.android.gms.cast.framework.media.internal.IFetchBitmapTaskProgressPublisher");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzb(parcel.readLong(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel2.writeNoException();
                parcel2.writeInt(11400208);
                return true;
            default:
                return false;
        }
    }
}
