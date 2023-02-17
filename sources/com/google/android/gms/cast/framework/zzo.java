package com.google.android.gms.cast.framework;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzed;
public abstract class zzo extends zzec implements zzn {
    public zzo() {
        attachInterface(this, "com.google.android.gms.cast.framework.ICastStateListener");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                IObjectWrapper zzabs = zzabs();
                parcel2.writeNoException();
                zzed.zza(parcel2, zzabs);
                return true;
            case 2:
                onCastStateChanged(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 3:
                parcel2.writeNoException();
                parcel2.writeInt(11400208);
                return true;
            default:
                return false;
        }
    }
}
