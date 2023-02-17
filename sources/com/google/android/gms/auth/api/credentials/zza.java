package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
import java.util.ArrayList;
public final class zza implements Parcelable.Creator<Credential> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Credential createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        String str = null;
        String str2 = null;
        Uri uri = null;
        ArrayList arrayList = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 2:
                    str2 = zzbcl.zzq(parcel, readInt);
                    break;
                case 3:
                    uri = (Uri) zzbcl.zza(parcel, readInt, Uri.CREATOR);
                    break;
                case 4:
                    arrayList = zzbcl.zzc(parcel, readInt, IdToken.CREATOR);
                    break;
                case 5:
                    str3 = zzbcl.zzq(parcel, readInt);
                    break;
                case 6:
                    str4 = zzbcl.zzq(parcel, readInt);
                    break;
                case 7:
                    str5 = zzbcl.zzq(parcel, readInt);
                    break;
                case 8:
                    str6 = zzbcl.zzq(parcel, readInt);
                    break;
                case 9:
                    str7 = zzbcl.zzq(parcel, readInt);
                    break;
                case 10:
                    str8 = zzbcl.zzq(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new Credential(str, str2, uri, arrayList, str3, str4, str5, str6, str7, str8);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Credential[] newArray(int i) {
        return new Credential[i];
    }
}
