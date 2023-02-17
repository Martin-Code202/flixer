package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
public final class zzbdd extends zzeb implements zzbdc {
    zzbdd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    @Override // com.google.android.gms.internal.zzbdc
    public final void zza(zzbda zzbda) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzbda);
        zzc(1, zzax);
    }
}
