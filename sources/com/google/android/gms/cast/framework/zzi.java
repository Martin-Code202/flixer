package com.google.android.gms.cast.framework;

import android.os.Parcel;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzed;
public abstract class zzi extends zzec implements zzh {
    public zzi() {
        attachInterface(this, "com.google.android.gms.cast.framework.ICastConnectionController");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzr(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 2:
                zza(parcel.readString(), (LaunchOptions) zzed.zza(parcel, LaunchOptions.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
                zzez(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                zzbd(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 5:
                parcel2.writeNoException();
                parcel2.writeInt(11400208);
                return true;
            default:
                return false;
        }
    }
}
