package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeb;
public final class zzau extends zzeb implements zzas {
    zzau(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.zzas
    public final IObjectWrapper zzaez() {
        Parcel zza = zza(1, zzax());
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }

    @Override // com.google.android.gms.common.internal.zzas
    public final int zzafa() {
        Parcel zza = zza(2, zzax());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}
