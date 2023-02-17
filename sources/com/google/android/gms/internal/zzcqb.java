package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzam;
public final class zzcqb extends zzeb implements zzcqa {
    zzcqb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.internal.zzcqa
    public final void zza(zzam zzam, int i, boolean z) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzam);
        zzax.writeInt(i);
        zzed.zza(zzax, z);
        zzb(9, zzax);
    }

    @Override // com.google.android.gms.internal.zzcqa
    public final void zza(zzcqd zzcqd, zzcpy zzcpy) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzcqd);
        zzed.zza(zzax, zzcpy);
        zzb(12, zzax);
    }

    @Override // com.google.android.gms.internal.zzcqa
    public final void zzec(int i) {
        Parcel zzax = zzax();
        zzax.writeInt(i);
        zzb(7, zzax);
    }
}
