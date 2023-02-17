package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
public final class zzasx implements Parcelable.Creator<zzasw> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzasw createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        Credential credential = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    credential = (Credential) zzbcl.zza(parcel, readInt, Credential.CREATOR);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzasw(credential);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzasw[] newArray(int i) {
        return new zzasw[i];
    }
}
