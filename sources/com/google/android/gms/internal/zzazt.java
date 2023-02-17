package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.cast.ApplicationMetadata;
public abstract class zzazt extends zzec implements zzazs {
    public zzazt() {
        attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzbj(parcel.readInt());
                return true;
            case 2:
                zza((ApplicationMetadata) zzed.zza(parcel, ApplicationMetadata.CREATOR), parcel.readString(), parcel.readString(), zzed.zza(parcel));
                return true;
            case 3:
                zzbe(parcel.readInt());
                return true;
            case 4:
                zza(parcel.readString(), parcel.readDouble(), zzed.zza(parcel));
                return true;
            case 5:
                zzs(parcel.readString(), parcel.readString());
                return true;
            case 6:
                zza(parcel.readString(), parcel.createByteArray());
                return true;
            case 7:
                zzbl(parcel.readInt());
                return true;
            case 8:
                zzbk(parcel.readInt());
                return true;
            case 9:
                onApplicationDisconnected(parcel.readInt());
                return true;
            case 10:
                zza(parcel.readString(), parcel.readLong(), parcel.readInt());
                return true;
            case 11:
                zzb(parcel.readString(), parcel.readLong());
                return true;
            case 12:
                zzb((zzays) zzed.zza(parcel, zzays.CREATOR));
                return true;
            case 13:
                zzb((zzazm) zzed.zza(parcel, zzazm.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
