package com.google.android.gms.cast.framework;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.zzec;
public interface zzr extends IInterface {

    public static abstract class zza extends zzec implements zzr {
        public static zzr zzae(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.IReconnectionService");
            return queryLocalInterface instanceof zzr ? (zzr) queryLocalInterface : new zzs(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            throw new NoSuchMethodError();
        }
    }

    IBinder onBind(Intent intent);

    void onCreate();

    void onDestroy();

    int onStartCommand(Intent intent, int i, int i2);
}
