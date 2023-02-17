package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzed;
public final class zzbb extends zzeb implements zzaz {
    zzbb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzaz
    public final boolean zza(zzm zzm, IObjectWrapper iObjectWrapper) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzm);
        zzed.zza(zzax, iObjectWrapper);
        Parcel zza = zza(5, zzax);
        boolean zza2 = zzed.zza(zza);
        zza.recycle();
        return zza2;
    }
}
