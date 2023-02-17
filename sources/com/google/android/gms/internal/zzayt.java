package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
public final class zzayt implements Parcelable.Creator<zzays> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzays createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzays(str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzays[] newArray(int i) {
        return new zzays[i];
    }
}
