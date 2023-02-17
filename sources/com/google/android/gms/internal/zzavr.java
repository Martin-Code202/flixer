package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
public abstract class zzavr extends zzec implements zzavq {
    public zzavr() {
        attachInterface(this, "com.google.android.gms.cast.framework.internal.IMediaRouter");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzavs zzavs;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                Bundle bundle = (Bundle) zzed.zza(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzavs = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.internal.IMediaRouterCallback");
                    zzavs = queryLocalInterface instanceof zzavs ? (zzavs) queryLocalInterface : new zzavt(readStrongBinder);
                }
                zza(bundle, zzavs);
                parcel2.writeNoException();
                return true;
            case 2:
                zza((Bundle) zzed.zza(parcel, Bundle.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 3:
                zzh((Bundle) zzed.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 4:
                boolean zzb = zzb((Bundle) zzed.zza(parcel, Bundle.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                zzed.zza(parcel2, zzb);
                return true;
            case 5:
                zzfb(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zzacm();
                parcel2.writeNoException();
                return true;
            case 7:
                boolean zzacn = zzacn();
                parcel2.writeNoException();
                zzed.zza(parcel2, zzacn);
                return true;
            case 8:
                Bundle zzfc = zzfc(parcel.readString());
                parcel2.writeNoException();
                zzed.zzb(parcel2, zzfc);
                return true;
            case 9:
                String zzaco = zzaco();
                parcel2.writeNoException();
                parcel2.writeString(zzaco);
                return true;
            case 10:
                parcel2.writeNoException();
                parcel2.writeInt(11400208);
                return true;
            default:
                return false;
        }
    }
}
