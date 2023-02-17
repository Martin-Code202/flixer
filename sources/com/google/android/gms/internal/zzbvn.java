package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
public final class zzbvn extends zzeb implements zzbvl {
    zzbvn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.flags.IFlagProvider");
    }

    @Override // com.google.android.gms.internal.zzbvl
    public final boolean getBooleanFlagValue(String str, boolean z, int i) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzed.zza(zzax, z);
        zzax.writeInt(i);
        Parcel zza = zza(2, zzax);
        boolean zza2 = zzed.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzbvl
    public final int getIntFlagValue(String str, int i, int i2) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzax.writeInt(i);
        zzax.writeInt(i2);
        Parcel zza = zza(3, zzax);
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.zzbvl
    public final long getLongFlagValue(String str, long j, int i) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzax.writeLong(j);
        zzax.writeInt(i);
        Parcel zza = zza(4, zzax);
        long readLong = zza.readLong();
        zza.recycle();
        return readLong;
    }

    @Override // com.google.android.gms.internal.zzbvl
    public final String getStringFlagValue(String str, String str2, int i) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzax.writeString(str2);
        zzax.writeInt(i);
        Parcel zza = zza(5, zzax);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzbvl
    public final void init(IObjectWrapper iObjectWrapper) {
        Parcel zzax = zzax();
        zzed.zza(zzax, iObjectWrapper);
        zzb(1, zzax);
    }
}
