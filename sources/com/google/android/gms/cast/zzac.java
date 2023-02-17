package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zzac implements Parcelable.Creator<zzab> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzab createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzab(i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzab[] newArray(int i) {
        return new zzab[i];
    }
}
