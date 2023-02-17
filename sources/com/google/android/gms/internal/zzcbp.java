package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.List;
public abstract class zzcbp extends zzec implements zzcbo {
    public zzcbp() {
        attachInterface(this, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zza((zzcbk) zzed.zza(parcel, zzcbk.CREATOR), (zzcas) zzed.zza(parcel, zzcas.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                zza((zzcft) zzed.zza(parcel, zzcft.CREATOR), (zzcas) zzed.zza(parcel, zzcas.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                zza((zzcas) zzed.zza(parcel, zzcas.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                zza((zzcbk) zzed.zza(parcel, zzcbk.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zzb((zzcas) zzed.zza(parcel, zzcas.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                List<zzcft> zza = zza((zzcas) zzed.zza(parcel, zzcas.CREATOR), zzed.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                return true;
            case 9:
                byte[] zza2 = zza((zzcbk) zzed.zza(parcel, zzcbk.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(zza2);
                return true;
            case 10:
                zza(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String zzc = zzc((zzcas) zzed.zza(parcel, zzcas.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzc);
                return true;
            case 12:
                zza((zzcav) zzed.zza(parcel, zzcav.CREATOR), (zzcas) zzed.zza(parcel, zzcas.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                zzb((zzcav) zzed.zza(parcel, zzcav.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                List<zzcft> zza3 = zza(parcel.readString(), parcel.readString(), zzed.zza(parcel), (zzcas) zzed.zza(parcel, zzcas.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza3);
                return true;
            case 15:
                List<zzcft> zza4 = zza(parcel.readString(), parcel.readString(), parcel.readString(), zzed.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza4);
                return true;
            case 16:
                List<zzcav> zza5 = zza(parcel.readString(), parcel.readString(), (zzcas) zzed.zza(parcel, zzcas.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza5);
                return true;
            case 17:
                List<zzcav> zzj = zzj(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(zzj);
                return true;
        }
    }
}
