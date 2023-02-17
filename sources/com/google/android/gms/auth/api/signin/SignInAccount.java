package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
public class SignInAccount extends zzbck implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new zze();
    @Deprecated
    private String zzdmx;
    @Deprecated
    private String zzebv;
    private GoogleSignInAccount zzeco;

    SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.zzeco = googleSignInAccount;
        this.zzebv = zzbp.zzh(str, "8.3 and 8.4 SDKs require non-null email");
        this.zzdmx = zzbp.zzh(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    public final GoogleSignInAccount getGoogleSignInAccount() {
        return this.zzeco;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 4, this.zzebv, false);
        zzbcn.zza(parcel, 7, (Parcelable) this.zzeco, i, false);
        zzbcn.zza(parcel, 8, this.zzdmx, false);
        zzbcn.zzai(parcel, zze);
    }
}
