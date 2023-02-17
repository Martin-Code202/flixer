package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
public final class zzcpw implements Parcelable.Creator<zzcpv> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcpv createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 0;
        int i2 = 0;
        Intent intent = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 2:
                    i2 = zzbcl.zzg(parcel, readInt);
                    break;
                case 3:
                    intent = (Intent) zzbcl.zza(parcel, readInt, Intent.CREATOR);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzcpv(i, i2, intent);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcpv[] newArray(int i) {
        return new zzcpv[i];
    }
}
