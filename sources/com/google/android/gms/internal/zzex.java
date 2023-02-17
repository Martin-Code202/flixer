package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
public final class zzex extends zzeb implements zzev {
    zzex(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // com.google.android.gms.internal.zzev
    public final String getId() {
        Parcel zza = zza(1, zzax());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzev
    public final boolean zzb(boolean z) {
        Parcel zzax = zzax();
        zzed.zza(zzax, true);
        Parcel zza = zza(2, zzax);
        boolean zza2 = zzed.zza(zza);
        zza.recycle();
        return zza2;
    }
}
