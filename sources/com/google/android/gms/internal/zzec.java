package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
public class zzec extends Binder implements IInterface {
    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i > 16777215) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel.enforceInterface(getInterfaceDescriptor());
        return false;
    }
}
