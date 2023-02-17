package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbcl;
import java.util.ArrayList;
public final class zzb implements Parcelable.Creator<GoogleSignInAccount> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        long j = 0;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
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
                    str3 = zzbcl.zzq(parcel, readInt);
                    break;
                case 5:
                    str4 = zzbcl.zzq(parcel, readInt);
                    break;
                case 6:
                    uri = (Uri) zzbcl.zza(parcel, readInt, Uri.CREATOR);
                    break;
                case 7:
                    str5 = zzbcl.zzq(parcel, readInt);
                    break;
                case 8:
                    j = zzbcl.zzi(parcel, readInt);
                    break;
                case 9:
                    str6 = zzbcl.zzq(parcel, readInt);
                    break;
                case 10:
                    arrayList = zzbcl.zzc(parcel, readInt, Scope.CREATOR);
                    break;
                case 11:
                    str7 = zzbcl.zzq(parcel, readInt);
                    break;
                case 12:
                    str8 = zzbcl.zzq(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, arrayList, str7, str8);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
