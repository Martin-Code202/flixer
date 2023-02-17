package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbcl;
import java.util.ArrayList;
public final class zzd implements Parcelable.Creator<GoogleSignInOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 0;
        ArrayList arrayList = null;
        Account account = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str = null;
        String str2 = null;
        ArrayList arrayList2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 2:
                    arrayList = zzbcl.zzc(parcel, readInt, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) zzbcl.zza(parcel, readInt, Account.CREATOR);
                    break;
                case 4:
                    z = zzbcl.zzc(parcel, readInt);
                    break;
                case 5:
                    z2 = zzbcl.zzc(parcel, readInt);
                    break;
                case 6:
                    z3 = zzbcl.zzc(parcel, readInt);
                    break;
                case 7:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 8:
                    str2 = zzbcl.zzq(parcel, readInt);
                    break;
                case 9:
                    arrayList2 = zzbcl.zzc(parcel, readInt, zzn.CREATOR);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new GoogleSignInOptions(i, arrayList, account, z, z2, z3, str, str2, arrayList2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
