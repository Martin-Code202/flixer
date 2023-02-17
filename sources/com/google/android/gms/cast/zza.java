package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zza implements Parcelable.Creator<AdBreakClipInfo> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdBreakClipInfo createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        String str = null;
        String str2 = null;
        long j = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 3:
                    str2 = zzbcl.zzq(parcel, readInt);
                    break;
                case 4:
                    j = zzbcl.zzi(parcel, readInt);
                    break;
                case 5:
                    str3 = zzbcl.zzq(parcel, readInt);
                    break;
                case 6:
                    str4 = zzbcl.zzq(parcel, readInt);
                    break;
                case 7:
                    str5 = zzbcl.zzq(parcel, readInt);
                    break;
                case 8:
                    str6 = zzbcl.zzq(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new AdBreakClipInfo(str, str2, j, str3, str4, str5, str6);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdBreakClipInfo[] newArray(int i) {
        return new AdBreakClipInfo[i];
    }
}
