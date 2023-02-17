package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzed;
public final class zzw extends zzeb implements zzv {
    zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ISessionManager");
    }

    @Override // com.google.android.gms.cast.framework.zzv
    public final void zza(zzn zzn) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzn);
        zzb(4, zzax);
    }

    @Override // com.google.android.gms.cast.framework.zzv
    public final void zza(zzx zzx) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzx);
        zzb(2, zzax);
    }

    @Override // com.google.android.gms.cast.framework.zzv
    public final IObjectWrapper zzaca() {
        Parcel zza = zza(7, zzax());
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }

    @Override // com.google.android.gms.cast.framework.zzv
    public final IObjectWrapper zzacc() {
        Parcel zza = zza(1, zzax());
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }

    @Override // com.google.android.gms.cast.framework.zzv
    public final void zzb(boolean z, boolean z2) {
        Parcel zzax = zzax();
        zzed.zza(zzax, true);
        zzed.zza(zzax, z2);
        zzb(6, zzax);
    }
}
