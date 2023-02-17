package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzed;
public final class zzl extends zzeb implements zzk {
    zzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final int zza(IObjectWrapper iObjectWrapper, String str, boolean z) {
        Parcel zzax = zzax();
        zzed.zza(zzax, iObjectWrapper);
        zzax.writeString(str);
        zzed.zza(zzax, z);
        Parcel zza = zza(3, zzax);
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i) {
        Parcel zzax = zzax();
        zzed.zza(zzax, iObjectWrapper);
        zzax.writeString(str);
        zzax.writeInt(i);
        Parcel zza = zza(2, zzax);
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }
}
