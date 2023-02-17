package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
public final class zzawm extends zzeb implements zzawl {
    zzawm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.media.internal.IFetchBitmapTask");
    }

    @Override // com.google.android.gms.internal.zzawl
    public final Bitmap zzm(Uri uri) {
        Parcel zzax = zzax();
        zzed.zza(zzax, uri);
        Parcel zza = zza(1, zzax);
        Bitmap bitmap = (Bitmap) zzed.zza(zza, Bitmap.CREATOR);
        zza.recycle();
        return bitmap;
    }
}
