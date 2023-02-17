package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zze implements Parcelable.Creator<CredentialRequest> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialRequest createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 0;
        boolean z = false;
        String[] strArr = null;
        CredentialPickerConfig credentialPickerConfig = null;
        CredentialPickerConfig credentialPickerConfig2 = null;
        boolean z2 = false;
        String str = null;
        String str2 = null;
        boolean z3 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    z = zzbcl.zzc(parcel, readInt);
                    break;
                case 2:
                    strArr = zzbcl.zzaa(parcel, readInt);
                    break;
                case 3:
                    credentialPickerConfig = (CredentialPickerConfig) zzbcl.zza(parcel, readInt, CredentialPickerConfig.CREATOR);
                    break;
                case 4:
                    credentialPickerConfig2 = (CredentialPickerConfig) zzbcl.zza(parcel, readInt, CredentialPickerConfig.CREATOR);
                    break;
                case 5:
                    z2 = zzbcl.zzc(parcel, readInt);
                    break;
                case 6:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 7:
                    str2 = zzbcl.zzq(parcel, readInt);
                    break;
                case 8:
                    z3 = zzbcl.zzc(parcel, readInt);
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
        return new CredentialRequest(i, z, strArr, credentialPickerConfig, credentialPickerConfig2, z2, str, str2, z3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialRequest[] newArray(int i) {
        return new CredentialRequest[i];
    }
}
