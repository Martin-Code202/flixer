package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
public abstract class zzew extends zzec implements zzev {
    public static zzev zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return queryLocalInterface instanceof zzev ? (zzev) queryLocalInterface : new zzex(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        throw new NoSuchMethodError();
    }
}
