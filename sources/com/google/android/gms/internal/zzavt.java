package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
public final class zzavt extends zzeb implements zzavs {
    zzavt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.internal.IMediaRouterCallback");
    }

    @Override // com.google.android.gms.internal.zzavs
    public final void zza(String str, Bundle bundle, int i) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzed.zza(zzax, bundle);
        zzax.writeInt(i);
        zzb(6, zzax);
    }

    @Override // com.google.android.gms.internal.zzavs
    public final void zzc(String str, Bundle bundle) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzed.zza(zzax, bundle);
        zzb(1, zzax);
    }

    @Override // com.google.android.gms.internal.zzavs
    public final void zzd(String str, Bundle bundle) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzed.zza(zzax, bundle);
        zzb(2, zzax);
    }

    @Override // com.google.android.gms.internal.zzavs
    public final void zze(String str, Bundle bundle) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzed.zza(zzax, bundle);
        zzb(3, zzax);
    }

    @Override // com.google.android.gms.internal.zzavs
    public final void zzf(String str, Bundle bundle) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzed.zza(zzax, bundle);
        zzb(4, zzax);
    }
}
