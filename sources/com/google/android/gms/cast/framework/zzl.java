package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzec;
public interface zzl extends IInterface {

    public static abstract class zza extends zzec implements zzl {
        public static zzl zzad(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.ICastSession");
            return queryLocalInterface instanceof zzl ? (zzl) queryLocalInterface : new zzm(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            throw new NoSuchMethodError();
        }
    }

    void onConnected(Bundle bundle);

    void onConnectionFailed(ConnectionResult connectionResult);

    void onConnectionSuspended(int i);

    void zza(ApplicationMetadata applicationMetadata, String str, String str2, boolean z);

    void zzb(boolean z, int i);

    void zzbe(int i);
}
