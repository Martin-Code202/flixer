package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
final class zzay implements zzax {
    private final IBinder zzajw;

    zzay(IBinder iBinder) {
        this.zzajw = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zzajw;
    }

    @Override // com.google.android.gms.common.internal.zzax
    public final void zza(zzav zzav, zzy zzy) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(zzav.asBinder());
            obtain.writeInt(1);
            zzy.writeToParcel(obtain, 0);
            this.zzajw.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
