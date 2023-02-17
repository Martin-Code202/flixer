package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zzbl implements Parcelable.Creator<VideoInfo> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ VideoInfo createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 3:
                    i2 = zzbcl.zzg(parcel, readInt);
                    break;
                case 4:
                    i3 = zzbcl.zzg(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new VideoInfo(i, i2, i3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ VideoInfo[] newArray(int i) {
        return new VideoInfo[i];
    }
}
