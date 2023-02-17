package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbp;
public final class zzcas extends zzbck {
    public static final Parcelable.Creator<zzcas> CREATOR = new zzcat();
    public final String packageName;
    public final String zzhts;
    public final String zzilt;
    public final String zzilu;
    public final long zzilv;
    public final long zzilw;
    public final String zzilx;
    public final boolean zzily;
    public final boolean zzilz;
    public final long zzima;
    public final String zzimb;
    public final long zzimc;
    public final long zzimd;
    public final int zzime;

    zzcas(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i) {
        zzbp.zzgg(str);
        this.packageName = str;
        this.zzilt = TextUtils.isEmpty(str2) ? null : str2;
        this.zzhts = str3;
        this.zzima = j;
        this.zzilu = str4;
        this.zzilv = j2;
        this.zzilw = j3;
        this.zzilx = str5;
        this.zzily = z;
        this.zzilz = z2;
        this.zzimb = str6;
        this.zzimc = j4;
        this.zzimd = j5;
        this.zzime = i;
    }

    zzcas(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, long j5, int i) {
        this.packageName = str;
        this.zzilt = str2;
        this.zzhts = str3;
        this.zzima = j3;
        this.zzilu = str4;
        this.zzilv = j;
        this.zzilw = j2;
        this.zzilx = str5;
        this.zzily = z;
        this.zzilz = z2;
        this.zzimb = str6;
        this.zzimc = j4;
        this.zzimd = j5;
        this.zzime = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, this.packageName, false);
        zzbcn.zza(parcel, 3, this.zzilt, false);
        zzbcn.zza(parcel, 4, this.zzhts, false);
        zzbcn.zza(parcel, 5, this.zzilu, false);
        zzbcn.zza(parcel, 6, this.zzilv);
        zzbcn.zza(parcel, 7, this.zzilw);
        zzbcn.zza(parcel, 8, this.zzilx, false);
        zzbcn.zza(parcel, 9, this.zzily);
        zzbcn.zza(parcel, 10, this.zzilz);
        zzbcn.zza(parcel, 11, this.zzima);
        zzbcn.zza(parcel, 12, this.zzimb, false);
        zzbcn.zza(parcel, 13, this.zzimc);
        zzbcn.zza(parcel, 14, this.zzimd);
        zzbcn.zzc(parcel, 15, this.zzime);
        zzbcn.zzai(parcel, zze);
    }
}
