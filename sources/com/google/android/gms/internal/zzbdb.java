package com.google.android.gms.internal;

import android.os.Parcel;
public abstract class zzbdb extends zzec implements zzbda {
    public zzbdb() {
        attachInterface(this, "com.google.android.gms.common.internal.service.ICommonCallbacks");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        zzcg(parcel.readInt());
        parcel2.writeNoException();
        return true;
    }
}
