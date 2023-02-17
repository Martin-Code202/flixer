package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zze implements Parcelable.Creator<SignInAccount> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInAccount createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        String str = "";
        GoogleSignInAccount googleSignInAccount = null;
        String str2 = "";
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 4:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 5:
                case 6:
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
                case 7:
                    googleSignInAccount = (GoogleSignInAccount) zzbcl.zza(parcel, readInt, GoogleSignInAccount.CREATOR);
                    break;
                case 8:
                    str2 = zzbcl.zzq(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new SignInAccount(str, googleSignInAccount, str2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInAccount[] newArray(int i) {
        return new SignInAccount[i];
    }
}
