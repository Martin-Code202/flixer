package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
public interface zzawl extends IInterface {

    public static abstract class zza extends zzec implements zzawl {
        public static zzawl zzah(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.internal.IFetchBitmapTask");
            return queryLocalInterface instanceof zzawl ? (zzawl) queryLocalInterface : new zzawm(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            throw new NoSuchMethodError();
        }
    }

    Bitmap zzm(Uri uri);
}
