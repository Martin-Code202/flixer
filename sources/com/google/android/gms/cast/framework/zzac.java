package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzed;
public abstract class zzac extends zzec implements zzab {
    public zzac() {
        attachInterface(this, "com.google.android.gms.cast.framework.ISessionProxy");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                IObjectWrapper zzacd = zzacd();
                parcel2.writeNoException();
                zzed.zza(parcel2, zzacd);
                return true;
            case 2:
                start((Bundle) zzed.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
                resume((Bundle) zzed.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 4:
                end(zzed.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 5:
                long sessionRemainingTimeMs = getSessionRemainingTimeMs();
                parcel2.writeNoException();
                parcel2.writeLong(sessionRemainingTimeMs);
                return true;
            case 6:
                parcel2.writeNoException();
                parcel2.writeInt(11400208);
                return true;
            default:
                return false;
        }
    }
}
