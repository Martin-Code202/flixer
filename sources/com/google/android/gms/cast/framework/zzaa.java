package com.google.android.gms.cast.framework;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzed;
public abstract class zzaa extends zzec implements zzz {
    public zzaa() {
        attachInterface(this, "com.google.android.gms.cast.framework.ISessionProvider");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                IObjectWrapper zzfa = zzfa(parcel.readString());
                parcel2.writeNoException();
                zzed.zza(parcel2, zzfa);
                return true;
            case 2:
                boolean isSessionRecoverable = isSessionRecoverable();
                parcel2.writeNoException();
                zzed.zza(parcel2, isSessionRecoverable);
                return true;
            case 3:
                String category = getCategory();
                parcel2.writeNoException();
                parcel2.writeString(category);
                return true;
            case 4:
                parcel2.writeNoException();
                parcel2.writeInt(11400208);
                return true;
            default:
                return false;
        }
    }
}
