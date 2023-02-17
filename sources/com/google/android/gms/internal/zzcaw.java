package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
public final class zzcaw implements Parcelable.Creator<zzcav> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcav createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        zzcft zzcft = null;
        long j = 0;
        boolean z = false;
        String str3 = null;
        zzcbk zzcbk = null;
        long j2 = 0;
        zzcbk zzcbk2 = null;
        long j3 = 0;
        zzcbk zzcbk3 = null;
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
                    str2 = zzbcl.zzq(parcel, readInt);
                    break;
                case 4:
                    zzcft = (zzcft) zzbcl.zza(parcel, readInt, zzcft.CREATOR);
                    break;
                case 5:
                    j = zzbcl.zzi(parcel, readInt);
                    break;
                case 6:
                    z = zzbcl.zzc(parcel, readInt);
                    break;
                case 7:
                    str3 = zzbcl.zzq(parcel, readInt);
                    break;
                case 8:
                    zzcbk = (zzcbk) zzbcl.zza(parcel, readInt, zzcbk.CREATOR);
                    break;
                case 9:
                    j2 = zzbcl.zzi(parcel, readInt);
                    break;
                case 10:
                    zzcbk2 = (zzcbk) zzbcl.zza(parcel, readInt, zzcbk.CREATOR);
                    break;
                case 11:
                    j3 = zzbcl.zzi(parcel, readInt);
                    break;
                case 12:
                    zzcbk3 = (zzcbk) zzbcl.zza(parcel, readInt, zzcbk.CREATOR);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzcav(i, str, str2, zzcft, j, z, str3, zzcbk, j2, zzcbk2, j3, zzcbk3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcav[] newArray(int i) {
        return new zzcav[i];
    }
}
