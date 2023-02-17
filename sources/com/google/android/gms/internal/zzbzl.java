package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
public final class zzbzl extends zzeb implements zzbzk {
    zzbzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // com.google.android.gms.internal.zzbzk
    public final void zza(long j, boolean z, PendingIntent pendingIntent) {
        Parcel zzax = zzax();
        zzax.writeLong(j);
        zzed.zza(zzax, true);
        zzed.zza(zzax, pendingIntent);
        zzb(5, zzax);
    }

    @Override // com.google.android.gms.internal.zzbzk
    public final void zza(zzcaa zzcaa) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzcaa);
        zzb(59, zzax);
    }

    @Override // com.google.android.gms.internal.zzbzk
    public final void zzbk(boolean z) {
        Parcel zzax = zzax();
        zzed.zza(zzax, z);
        zzb(12, zzax);
    }

    @Override // com.google.android.gms.internal.zzbzk
    public final void zzc(PendingIntent pendingIntent) {
        Parcel zzax = zzax();
        zzed.zza(zzax, pendingIntent);
        zzb(6, zzax);
    }
}
