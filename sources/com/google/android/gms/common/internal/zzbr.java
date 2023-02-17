package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.internal.zzbcl;
public final class zzbr implements Parcelable.Creator<zzbq> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbq createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 0;
        Account account = null;
        int i2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 2:
                    account = (Account) zzbcl.zza(parcel, readInt, Account.CREATOR);
                    break;
                case 3:
                    i2 = zzbcl.zzg(parcel, readInt);
                    break;
                case 4:
                    googleSignInAccount = (GoogleSignInAccount) zzbcl.zza(parcel, readInt, GoogleSignInAccount.CREATOR);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzbq(i, account, i2, googleSignInAccount);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbq[] newArray(int i) {
        return new zzbq[i];
    }
}
