package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zzc implements Parcelable.Creator<CredentialPickerConfig> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialPickerConfig createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    z = zzbcl.zzc(parcel, readInt);
                    break;
                case 2:
                    z2 = zzbcl.zzc(parcel, readInt);
                    break;
                case 3:
                    z3 = zzbcl.zzc(parcel, readInt);
                    break;
                case 4:
                    i2 = zzbcl.zzg(parcel, readInt);
                    break;
                case 1000:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new CredentialPickerConfig(i, z, z2, z3, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialPickerConfig[] newArray(int i) {
        return new CredentialPickerConfig[i];
    }
}
