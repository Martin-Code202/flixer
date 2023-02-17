package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import com.google.android.gms.internal.zzec;
public abstract class zzq extends zzec implements zzp {
    public zzq() {
        attachInterface(this, "com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        zzaap();
        return true;
    }
}
