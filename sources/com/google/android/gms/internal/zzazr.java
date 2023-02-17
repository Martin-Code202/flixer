package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzab;
public final class zzazr extends zzeb implements zzazq {
    zzazr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.internal.ICastDeviceController");
    }

    @Override // com.google.android.gms.internal.zzazq
    public final void disconnect() {
        zzc(1, zzax());
    }

    @Override // com.google.android.gms.internal.zzazq
    public final void zza(String str, String str2, zzab zzab) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzax.writeString(str2);
        zzed.zza(zzax, zzab);
        zzc(14, zzax);
    }

    @Override // com.google.android.gms.internal.zzazq
    public final void zzb(String str, LaunchOptions launchOptions) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzed.zza(zzax, launchOptions);
        zzc(13, zzax);
    }

    @Override // com.google.android.gms.internal.zzazq
    public final void zzb(String str, String str2, long j) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzax.writeString(str2);
        zzax.writeLong(j);
        zzc(9, zzax);
    }

    @Override // com.google.android.gms.internal.zzazq
    public final void zzez(String str) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzc(5, zzax);
    }

    @Override // com.google.android.gms.internal.zzazq
    public final void zzfj(String str) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzc(11, zzax);
    }

    @Override // com.google.android.gms.internal.zzazq
    public final void zzfk(String str) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzc(12, zzax);
    }
}
