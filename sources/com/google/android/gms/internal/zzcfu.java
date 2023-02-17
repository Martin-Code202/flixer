package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
public final class zzcfu implements Parcelable.Creator<zzcft> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcft createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 0;
        String str = null;
        long j = 0;
        Long l = null;
        Float f = null;
        String str2 = null;
        String str3 = null;
        Double d = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 2:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 3:
                    j = zzbcl.zzi(parcel, readInt);
                    break;
                case 4:
                    l = zzbcl.zzj(parcel, readInt);
                    break;
                case 5:
                    f = zzbcl.zzm(parcel, readInt);
                    break;
                case 6:
                    str2 = zzbcl.zzq(parcel, readInt);
                    break;
                case 7:
                    str3 = zzbcl.zzq(parcel, readInt);
                    break;
                case 8:
                    d = zzbcl.zzo(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzcft(i, str, j, l, f, str2, str3, d);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcft[] newArray(int i) {
        return new zzcft[i];
    }
}
