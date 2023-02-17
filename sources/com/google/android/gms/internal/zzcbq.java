package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;
public final class zzcbq extends zzeb implements zzcbo {
    zzcbq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final List<zzcft> zza(zzcas zzcas, boolean z) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzcas);
        zzed.zza(zzax, z);
        Parcel zza = zza(7, zzax);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzcft.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final List<zzcav> zza(String str, String str2, zzcas zzcas) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzax.writeString(str2);
        zzed.zza(zzax, zzcas);
        Parcel zza = zza(16, zzax);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzcav.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final List<zzcft> zza(String str, String str2, String str3, boolean z) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzax.writeString(str2);
        zzax.writeString(str3);
        zzed.zza(zzax, z);
        Parcel zza = zza(15, zzax);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzcft.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final List<zzcft> zza(String str, String str2, boolean z, zzcas zzcas) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzax.writeString(str2);
        zzed.zza(zzax, z);
        zzed.zza(zzax, zzcas);
        Parcel zza = zza(14, zzax);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzcft.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final void zza(long j, String str, String str2, String str3) {
        Parcel zzax = zzax();
        zzax.writeLong(j);
        zzax.writeString(str);
        zzax.writeString(str2);
        zzax.writeString(str3);
        zzb(10, zzax);
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final void zza(zzcas zzcas) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzcas);
        zzb(4, zzax);
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final void zza(zzcav zzcav, zzcas zzcas) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzcav);
        zzed.zza(zzax, zzcas);
        zzb(12, zzax);
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final void zza(zzcbk zzcbk, zzcas zzcas) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzcbk);
        zzed.zza(zzax, zzcas);
        zzb(1, zzax);
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final void zza(zzcbk zzcbk, String str, String str2) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzcbk);
        zzax.writeString(str);
        zzax.writeString(str2);
        zzb(5, zzax);
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final void zza(zzcft zzcft, zzcas zzcas) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzcft);
        zzed.zza(zzax, zzcas);
        zzb(2, zzax);
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final byte[] zza(zzcbk zzcbk, String str) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzcbk);
        zzax.writeString(str);
        Parcel zza = zza(9, zzax);
        byte[] createByteArray = zza.createByteArray();
        zza.recycle();
        return createByteArray;
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final void zzb(zzcas zzcas) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzcas);
        zzb(6, zzax);
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final void zzb(zzcav zzcav) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzcav);
        zzb(13, zzax);
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final String zzc(zzcas zzcas) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzcas);
        Parcel zza = zza(11, zzax);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final List<zzcav> zzj(String str, String str2, String str3) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzax.writeString(str2);
        zzax.writeString(str3);
        Parcel zza = zza(17, zzax);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzcav.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }
}
