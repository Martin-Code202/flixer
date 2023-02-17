package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
public final class SignInConfiguration extends zzbck implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzw();
    private final String zzedb;
    private GoogleSignInOptions zzedc;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this.zzedb = zzbp.zzgg(str);
        this.zzedc = googleSignInOptions;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
            if (this.zzedb.equals(signInConfiguration.zzedb)) {
                return this.zzedc == null ? signInConfiguration.zzedc == null : this.zzedc.equals(signInConfiguration.zzedc);
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return new zzo().zzo(this.zzedb).zzo(this.zzedc).zzaao();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, this.zzedb, false);
        zzbcn.zza(parcel, 5, (Parcelable) this.zzedc, i, false);
        zzbcn.zzai(parcel, zze);
    }

    public final GoogleSignInOptions zzaaq() {
        return this.zzedc;
    }
}
