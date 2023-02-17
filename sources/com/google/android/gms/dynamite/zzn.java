package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzed;
public final class zzn extends zzeb implements zzm {
    zzn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // com.google.android.gms.dynamite.zzm
    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) {
        Parcel zzax = zzax();
        zzed.zza(zzax, iObjectWrapper);
        zzax.writeString(str);
        zzax.writeInt(i);
        zzed.zza(zzax, iObjectWrapper2);
        Parcel zza = zza(2, zzax);
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }
}
