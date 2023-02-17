package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zzd implements Parcelable.Creator<zzc> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 2:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzc(str, i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc[] newArray(int i) {
        return new zzc[i];
    }
}
