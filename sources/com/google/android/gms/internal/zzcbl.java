package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
public final class zzcbl implements Parcelable.Creator<zzcbk> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcbk createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        String str = null;
        zzcbh zzcbh = null;
        String str2 = null;
        long j = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 3:
                    zzcbh = (zzcbh) zzbcl.zza(parcel, readInt, zzcbh.CREATOR);
                    break;
                case 4:
                    str2 = zzbcl.zzq(parcel, readInt);
                    break;
                case 5:
                    j = zzbcl.zzi(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzcbk(str, zzcbh, str2, j);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcbk[] newArray(int i) {
        return new zzcbk[i];
    }
}
