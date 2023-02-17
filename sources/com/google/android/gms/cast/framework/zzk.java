package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzed;
public final class zzk extends zzeb implements zzj {
    zzk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ICastContext");
    }

    @Override // com.google.android.gms.cast.framework.zzj
    public final Bundle zzabx() {
        Parcel zza = zza(1, zzax());
        Bundle bundle = (Bundle) zzed.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.cast.framework.zzj
    public final zzv zzaby() {
        zzv zzv;
        Parcel zza = zza(5, zzax());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzv = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.ISessionManager");
            zzv = queryLocalInterface instanceof zzv ? (zzv) queryLocalInterface : new zzw(readStrongBinder);
        }
        zza.recycle();
        return zzv;
    }

    @Override // com.google.android.gms.cast.framework.zzj
    public final zzp zzabz() {
        zzp zzp;
        Parcel zza = zza(6, zzax());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzp = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.IDiscoveryManager");
            zzp = queryLocalInterface instanceof zzp ? (zzp) queryLocalInterface : new zzq(readStrongBinder);
        }
        zza.recycle();
        return zzp;
    }

    @Override // com.google.android.gms.cast.framework.zzj
    public final IObjectWrapper zzaca() {
        Parcel zza = zza(10, zzax());
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }
}
