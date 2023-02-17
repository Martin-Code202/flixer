package com.google.android.gms.cast.framework.media;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzed;
public final class zze extends zzeb implements zzd {
    zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.media.IMediaNotificationService");
    }

    @Override // com.google.android.gms.cast.framework.media.zzd
    public final IBinder onBind(Intent intent) {
        Parcel zzax = zzax();
        zzed.zza(zzax, intent);
        Parcel zza = zza(3, zzax);
        IBinder readStrongBinder = zza.readStrongBinder();
        zza.recycle();
        return readStrongBinder;
    }

    @Override // com.google.android.gms.cast.framework.media.zzd
    public final void onCreate() {
        zzb(1, zzax());
    }

    @Override // com.google.android.gms.cast.framework.media.zzd
    public final void onDestroy() {
        zzb(4, zzax());
    }

    @Override // com.google.android.gms.cast.framework.media.zzd
    public final int onStartCommand(Intent intent, int i, int i2) {
        Parcel zzax = zzax();
        zzed.zza(zzax, intent);
        zzax.writeInt(i);
        zzax.writeInt(i2);
        Parcel zza = zza(2, zzax);
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}
