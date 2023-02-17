package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zzp implements Parcelable.Creator<LocationAvailability> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationAvailability createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 1000;
        int i2 = 1;
        int i3 = 1;
        long j = 0;
        zzy[] zzyArr = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    i2 = zzbcl.zzg(parcel, readInt);
                    break;
                case 2:
                    i3 = zzbcl.zzg(parcel, readInt);
                    break;
                case 3:
                    j = zzbcl.zzi(parcel, readInt);
                    break;
                case 4:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 5:
                    zzyArr = (zzy[]) zzbcl.zzb(parcel, readInt, zzy.CREATOR);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new LocationAvailability(i, i2, i3, j, zzyArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationAvailability[] newArray(int i) {
        return new LocationAvailability[i];
    }
}
