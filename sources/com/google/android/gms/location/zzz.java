package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zzz implements Parcelable.Creator<zzy> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzy createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 1;
        int i2 = 1;
        long j = -1;
        long j2 = -1;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 2:
                    i2 = zzbcl.zzg(parcel, readInt);
                    break;
                case 3:
                    j = zzbcl.zzi(parcel, readInt);
                    break;
                case 4:
                    j2 = zzbcl.zzi(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzy(i, i2, j, j2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzy[] newArray(int i) {
        return new zzy[i];
    }
}
