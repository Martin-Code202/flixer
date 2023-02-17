package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.zzbcl;
import java.util.ArrayList;
public final class zzn implements Parcelable.Creator<CastDevice> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CastDevice createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        ArrayList arrayList = null;
        int i2 = 0;
        int i3 = -1;
        String str6 = null;
        String str7 = null;
        int i4 = 0;
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
                    str5 = zzbcl.zzq(parcel, readInt);
                    break;
                case 7:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 8:
                    arrayList = zzbcl.zzc(parcel, readInt, WebImage.CREATOR);
                    break;
                case 9:
                    i2 = zzbcl.zzg(parcel, readInt);
                    break;
                case 10:
                    i3 = zzbcl.zzg(parcel, readInt);
                    break;
                case 11:
                    str6 = zzbcl.zzq(parcel, readInt);
                    break;
                case 12:
                    str7 = zzbcl.zzq(parcel, readInt);
                    break;
                case 13:
                    i4 = zzbcl.zzg(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new CastDevice(str, str2, str3, str4, str5, i, arrayList, i2, i3, str6, str7, i4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CastDevice[] newArray(int i) {
        return new CastDevice[i];
    }
}
