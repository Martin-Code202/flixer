package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;
public abstract class zzast extends zzec implements zzass {
    public zzast() {
        attachInterface(this, "com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zza((Status) zzed.zza(parcel, Status.CREATOR), (Credential) zzed.zza(parcel, Credential.CREATOR));
                break;
            case 2:
                zze((Status) zzed.zza(parcel, Status.CREATOR));
                break;
            case 3:
                zza((Status) zzed.zza(parcel, Status.CREATOR), parcel.readString());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
