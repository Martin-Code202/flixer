package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zzq implements Parcelable.Creator<LocationRequest> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationRequest createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 102;
        long j = 3600000;
        long j2 = 600000;
        boolean z = false;
        long j3 = Long.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        float f = 0.0f;
        long j4 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 2:
                    j = zzbcl.zzi(parcel, readInt);
                    break;
                case 3:
                    j2 = zzbcl.zzi(parcel, readInt);
                    break;
                case 4:
                    z = zzbcl.zzc(parcel, readInt);
                    break;
                case 5:
                    j3 = zzbcl.zzi(parcel, readInt);
                    break;
                case 6:
                    i2 = zzbcl.zzg(parcel, readInt);
                    break;
                case 7:
                    f = zzbcl.zzl(parcel, readInt);
                    break;
                case 8:
                    j4 = zzbcl.zzi(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new LocationRequest(i, j, j2, z, j3, i2, f, j4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationRequest[] newArray(int i) {
        return new LocationRequest[i];
    }
}
