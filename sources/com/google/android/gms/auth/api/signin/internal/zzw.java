package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.zzbcl;
public final class zzw implements Parcelable.Creator<SignInConfiguration> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInConfiguration createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        String str = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 5:
                    googleSignInOptions = (GoogleSignInOptions) zzbcl.zza(parcel, readInt, GoogleSignInOptions.CREATOR);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new SignInConfiguration(str, googleSignInOptions);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInConfiguration[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
