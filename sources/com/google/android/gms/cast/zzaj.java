package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zzaj implements Parcelable.Creator<MediaTrack> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MediaTrack createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        long j = 0;
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        String str5 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    j = zzbcl.zzi(parcel, readInt);
                    break;
                case 3:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 4:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 5:
                    str2 = zzbcl.zzq(parcel, readInt);
                    break;
                case 6:
                    str3 = zzbcl.zzq(parcel, readInt);
                    break;
                case 7:
                    str4 = zzbcl.zzq(parcel, readInt);
                    break;
                case 8:
                    i2 = zzbcl.zzg(parcel, readInt);
                    break;
                case 9:
                    str5 = zzbcl.zzq(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new MediaTrack(j, i, str, str2, str3, str4, i2, str5);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MediaTrack[] newArray(int i) {
        return new MediaTrack[i];
    }
}
