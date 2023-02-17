package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zzc implements Parcelable.Creator<AdBreakStatus> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdBreakStatus createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        long j3 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    j = zzbcl.zzi(parcel, readInt);
                    break;
                case 3:
                    j2 = zzbcl.zzi(parcel, readInt);
                    break;
                case 4:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 5:
                    str2 = zzbcl.zzq(parcel, readInt);
                    break;
                case 6:
                    j3 = zzbcl.zzi(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new AdBreakStatus(j, j2, str, str2, j3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdBreakStatus[] newArray(int i) {
        return new AdBreakStatus[i];
    }
}
