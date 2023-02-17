package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
public abstract class zzcpz extends zzec implements zzcpy {
    public zzcpz() {
        attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 3:
                zzed.zza(parcel, ConnectionResult.CREATOR);
                zzed.zza(parcel, zzcpv.CREATOR);
                break;
            case 4:
                zzed.zza(parcel, Status.CREATOR);
                break;
            case 5:
            default:
                return false;
            case 6:
                zzed.zza(parcel, Status.CREATOR);
                break;
            case 7:
                zzed.zza(parcel, Status.CREATOR);
                zzed.zza(parcel, GoogleSignInAccount.CREATOR);
                break;
            case 8:
                zzb((zzcqf) zzed.zza(parcel, zzcqf.CREATOR));
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
