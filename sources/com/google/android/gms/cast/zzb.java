package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zzb implements Parcelable.Creator<AdBreakInfo> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdBreakInfo createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        long j = 0;
        String str = null;
        long j2 = 0;
        boolean z = false;
        String[] strArr = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    j = zzbcl.zzi(parcel, readInt);
                    break;
                case 3:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 4:
                    j2 = zzbcl.zzi(parcel, readInt);
                    break;
                case 5:
                    z = zzbcl.zzc(parcel, readInt);
                    break;
                case 6:
                    strArr = zzbcl.zzaa(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new AdBreakInfo(j, str, j2, z, strArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdBreakInfo[] newArray(int i) {
        return new AdBreakInfo[i];
    }
}
