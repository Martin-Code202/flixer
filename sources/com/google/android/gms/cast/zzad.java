package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zzad implements Parcelable.Creator<LaunchOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LaunchOptions createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        boolean z = false;
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    z = zzbcl.zzc(parcel, readInt);
                    break;
                case 3:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new LaunchOptions(z, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LaunchOptions[] newArray(int i) {
        return new LaunchOptions[i];
    }
}
