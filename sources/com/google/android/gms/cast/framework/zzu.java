package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzed;
public final class zzu extends zzeb implements zzt {
    zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ISession");
    }

    @Override // com.google.android.gms.cast.framework.zzt
    public final boolean isConnected() {
        Parcel zza = zza(5, zzax());
        boolean zza2 = zzed.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.cast.framework.zzt
    public final boolean isResuming() {
        Parcel zza = zza(9, zzax());
        boolean zza2 = zzed.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.cast.framework.zzt
    public final void notifyFailedToResumeSession(int i) {
        Parcel zzax = zzax();
        zzax.writeInt(i);
        zzb(15, zzax);
    }

    @Override // com.google.android.gms.cast.framework.zzt
    public final void notifyFailedToStartSession(int i) {
        Parcel zzax = zzax();
        zzax.writeInt(i);
        zzb(12, zzax);
    }

    @Override // com.google.android.gms.cast.framework.zzt
    public final void notifySessionEnded(int i) {
        Parcel zzax = zzax();
        zzax.writeInt(i);
        zzb(13, zzax);
    }

    @Override // com.google.android.gms.cast.framework.zzt
    public final IObjectWrapper zzacb() {
        Parcel zza = zza(1, zzax());
        IObjectWrapper zzao = IObjectWrapper.zza.zzao(zza.readStrongBinder());
        zza.recycle();
        return zzao;
    }
}
