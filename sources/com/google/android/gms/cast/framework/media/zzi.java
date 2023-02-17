package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zzi implements Parcelable.Creator<ImageHints> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ImageHints createFromParcel(Parcel parcel) {
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
        return new ImageHints(i, i2, i3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ImageHints[] newArray(int i) {
        return new ImageHints[i];
    }
}
