package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
public final class zzasw extends zzbck {
    public static final Parcelable.Creator<zzasw> CREATOR = new zzasx();
    private final Credential zzebf;

    public zzasw(Credential credential) {
        this.zzebf = credential;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 1, (Parcelable) this.zzebf, i, false);
        zzbcn.zzai(parcel, zze);
    }
}
