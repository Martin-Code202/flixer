package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
public final class zzazn implements Parcelable.Creator<zzazm> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzazm createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        double d = 0.0d;
        boolean z = false;
        int i = 0;
        ApplicationMetadata applicationMetadata = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    d = zzbcl.zzn(parcel, readInt);
                    break;
                case 3:
                    z = zzbcl.zzc(parcel, readInt);
                    break;
                case 4:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 5:
                    applicationMetadata = (ApplicationMetadata) zzbcl.zza(parcel, readInt, ApplicationMetadata.CREATOR);
                    break;
                case 6:
                    i2 = zzbcl.zzg(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzazm(d, z, i, applicationMetadata, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzazm[] newArray(int i) {
        return new zzazm[i];
    }
}
