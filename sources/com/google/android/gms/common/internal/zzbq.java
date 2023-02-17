package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
public final class zzbq extends zzbck {
    public static final Parcelable.Creator<zzbq> CREATOR = new zzbr();
    private final Account zzduy;
    private int zzdxr;
    private final int zzfvw;
    private final GoogleSignInAccount zzfvx;

    zzbq(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.zzdxr = i;
        this.zzduy = account;
        this.zzfvw = i2;
        this.zzfvx = googleSignInAccount;
    }

    public zzbq(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.zzdxr);
        zzbcn.zza(parcel, 2, (Parcelable) this.zzduy, i, false);
        zzbcn.zzc(parcel, 3, this.zzfvw);
        zzbcn.zza(parcel, 4, (Parcelable) this.zzfvx, i, false);
        zzbcn.zzai(parcel, zze);
    }
}
