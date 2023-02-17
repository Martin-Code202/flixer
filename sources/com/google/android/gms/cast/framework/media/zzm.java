package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
import java.util.ArrayList;
public final class zzm implements Parcelable.Creator<NotificationOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ NotificationOptions createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        ArrayList<String> arrayList = null;
        int[] iArr = null;
        long j = 0;
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    arrayList = zzbcl.zzac(parcel, readInt);
                    break;
                case 3:
                    iArr = zzbcl.zzw(parcel, readInt);
                    break;
                case 4:
                    j = zzbcl.zzi(parcel, readInt);
                    break;
                case 5:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 6:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 7:
                    i2 = zzbcl.zzg(parcel, readInt);
                    break;
                case 8:
                    i3 = zzbcl.zzg(parcel, readInt);
                    break;
                case 9:
                    i4 = zzbcl.zzg(parcel, readInt);
                    break;
                case 10:
                    i5 = zzbcl.zzg(parcel, readInt);
                    break;
                case 11:
                    i6 = zzbcl.zzg(parcel, readInt);
                    break;
                case 12:
                    i7 = zzbcl.zzg(parcel, readInt);
                    break;
                case 13:
                    i8 = zzbcl.zzg(parcel, readInt);
                    break;
                case 14:
                    i9 = zzbcl.zzg(parcel, readInt);
                    break;
                case 15:
                    i10 = zzbcl.zzg(parcel, readInt);
                    break;
                case 16:
                    i11 = zzbcl.zzg(parcel, readInt);
                    break;
                case 17:
                    i12 = zzbcl.zzg(parcel, readInt);
                    break;
                case 18:
                    i13 = zzbcl.zzg(parcel, readInt);
                    break;
                case 19:
                    i14 = zzbcl.zzg(parcel, readInt);
                    break;
                case 20:
                    i15 = zzbcl.zzg(parcel, readInt);
                    break;
                case 21:
                    i16 = zzbcl.zzg(parcel, readInt);
                    break;
                case 22:
                    i17 = zzbcl.zzg(parcel, readInt);
                    break;
                case 23:
                    i18 = zzbcl.zzg(parcel, readInt);
                    break;
                case 24:
                    i19 = zzbcl.zzg(parcel, readInt);
                    break;
                case 25:
                    i20 = zzbcl.zzg(parcel, readInt);
                    break;
                case 26:
                    i21 = zzbcl.zzg(parcel, readInt);
                    break;
                case 27:
                    i22 = zzbcl.zzg(parcel, readInt);
                    break;
                case 28:
                    i23 = zzbcl.zzg(parcel, readInt);
                    break;
                case 29:
                    i24 = zzbcl.zzg(parcel, readInt);
                    break;
                case 30:
                    i25 = zzbcl.zzg(parcel, readInt);
                    break;
                case 31:
                    i26 = zzbcl.zzg(parcel, readInt);
                    break;
                case 32:
                    i27 = zzbcl.zzg(parcel, readInt);
                    break;
                case 33:
                    iBinder = zzbcl.zzr(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new NotificationOptions(arrayList, iArr, j, str, i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, iBinder);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ NotificationOptions[] newArray(int i) {
        return new NotificationOptions[i];
    }
}
