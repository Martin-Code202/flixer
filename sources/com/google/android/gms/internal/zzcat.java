package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
public final class zzcat implements Parcelable.Creator<zzcas> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcas createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        String str5 = null;
        boolean z = true;
        boolean z2 = false;
        long j3 = -2147483648L;
        String str6 = null;
        long j4 = 0;
        long j5 = 0;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 3:
                    str2 = zzbcl.zzq(parcel, readInt);
                    break;
                case 4:
                    str3 = zzbcl.zzq(parcel, readInt);
                    break;
                case 5:
                    str4 = zzbcl.zzq(parcel, readInt);
                    break;
                case 6:
                    j = zzbcl.zzi(parcel, readInt);
                    break;
                case 7:
                    j2 = zzbcl.zzi(parcel, readInt);
                    break;
                case 8:
                    str5 = zzbcl.zzq(parcel, readInt);
                    break;
                case 9:
                    z = zzbcl.zzc(parcel, readInt);
                    break;
                case 10:
                    z2 = zzbcl.zzc(parcel, readInt);
                    break;
                case 11:
                    j3 = zzbcl.zzi(parcel, readInt);
                    break;
                case 12:
                    str6 = zzbcl.zzq(parcel, readInt);
                    break;
                case 13:
                    j4 = zzbcl.zzi(parcel, readInt);
                    break;
                case 14:
                    j5 = zzbcl.zzi(parcel, readInt);
                    break;
                case 15:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzcas(str, str2, str3, str4, j, j2, str5, z, z2, j3, str6, j4, j5, i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcas[] newArray(int i) {
        return new zzcas[i];
    }
}
