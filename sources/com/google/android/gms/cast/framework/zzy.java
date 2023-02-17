package com.google.android.gms.cast.framework;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzed;
public abstract class zzy extends zzec implements zzx {
    public zzy() {
        attachInterface(this, "com.google.android.gms.cast.framework.ISessionManagerListener");
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
                zzt(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                zzc(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                zze(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 5:
                zzu(IObjectWrapper.zza.zzao(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                zzf(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 7:
                zzd(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 8:
                zza(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), zzed.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 9:
                zzg(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 10:
                zzh(IObjectWrapper.zza.zzao(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 11:
                parcel2.writeNoException();
                parcel2.writeInt(11400208);
                return true;
            default:
                return false;
        }
    }
}
