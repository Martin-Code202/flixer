package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
import java.util.ArrayList;
public final class zzi implements Parcelable.Creator<PasswordSpecification> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PasswordSpecification createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        String str = null;
        ArrayList<String> arrayList = null;
        ArrayList<Integer> arrayList2 = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 2:
                    arrayList = zzbcl.zzac(parcel, readInt);
                    break;
                case 3:
                    arrayList2 = zzbcl.zzab(parcel, readInt);
                    break;
                case 4:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 5:
                    i2 = zzbcl.zzg(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new PasswordSpecification(str, arrayList, arrayList2, i, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PasswordSpecification[] newArray(int i) {
        return new PasswordSpecification[i];
    }
}
