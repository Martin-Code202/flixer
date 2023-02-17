package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzec;
public interface zzt extends IInterface {

    public static abstract class zza extends zzec implements zzt {
        public static zzt zzaf(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.ISession");
            return queryLocalInterface instanceof zzt ? (zzt) queryLocalInterface : new zzu(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            throw new NoSuchMethodError();
        }
    }

    boolean isConnected();

    boolean isResuming();

    void notifyFailedToResumeSession(int i);

    void notifyFailedToStartSession(int i);

    void notifySessionEnded(int i);

    IObjectWrapper zzacb();
}
