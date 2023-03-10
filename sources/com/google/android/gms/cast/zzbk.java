package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zzbk implements Parcelable.Creator<TextTrackStyle> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TextTrackStyle createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        String str = null;
        int i8 = 0;
        int i9 = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    f = zzbcl.zzl(parcel, readInt);
                    break;
                case 3:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 4:
                    i2 = zzbcl.zzg(parcel, readInt);
                    break;
                case 5:
                    i3 = zzbcl.zzg(parcel, readInt);
                    break;
                case 6:
                    i4 = zzbcl.zzg(parcel, readInt);
                    break;
                case 7:
                    i5 = zzbcl.zzg(parcel, readInt);
                    break;
                case 8:
                    i6 = zzbcl.zzg(parcel, readInt);
                    break;
                case 9:
                    i7 = zzbcl.zzg(parcel, readInt);
                    break;
                case 10:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 11:
                    i8 = zzbcl.zzg(parcel, readInt);
                    break;
                case 12:
                    i9 = zzbcl.zzg(parcel, readInt);
                    break;
                case 13:
                    str2 = zzbcl.zzq(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new TextTrackStyle(f, i, i2, i3, i4, i5, i6, i7, str, i8, i9, str2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TextTrackStyle[] newArray(int i) {
        return new TextTrackStyle[i];
    }
}
