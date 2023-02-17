package com.google.android.gms.cast.framework.media;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.zzec;
public interface zzd extends IInterface {

    public static abstract class zza extends zzec implements zzd {
        public static zzd zzag(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.IMediaNotificationService");
            return queryLocalInterface instanceof zzd ? (zzd) queryLocalInterface : new zze(iBinder);
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
