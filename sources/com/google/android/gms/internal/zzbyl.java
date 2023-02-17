package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
public final class zzbyl implements Parcelable.Creator<zzbyk> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbyk createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 2:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzbyk(i, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbyk[] newArray(int i) {
        return new zzbyk[i];
    }
}
