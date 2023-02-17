package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbp;
public final class zzcft extends zzbck {
    public static final Parcelable.Creator<zzcft> CREATOR = new zzcfu();
    public final String name;
    private int versionCode;
    private String zzfwn;
    public final String zzimf;
    public final long zziwy;
    private Long zziwz;
    private Float zzixa;
    private Double zzixb;

    zzcft(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        this.versionCode = i;
        this.name = str;
        this.zziwy = j;
        this.zziwz = l;
        this.zzixa = null;
        if (i == 1) {
            this.zzixb = f != null ? Double.valueOf(f.doubleValue()) : null;
        } else {
            this.zzixb = d;
        }
        this.zzfwn = str2;
        this.zzimf = str3;
    }

    zzcft(zzcfv zzcfv) {
        this(zzcfv.mName, zzcfv.zzixc, zzcfv.mValue, zzcfv.mOrigin);
    }

    zzcft(String str, long j, Object obj, String str2) {
        zzbp.zzgg(str);
        this.versionCode = 2;
        this.name = str;
        this.zziwy = j;
        this.zzimf = str2;
        if (obj == null) {
            this.zziwz = null;
            this.zzixa = null;
            this.zzixb = null;
            this.zzfwn = null;
        } else if (obj instanceof Long) {
            this.zziwz = (Long) obj;
            this.zzixa = null;
            this.zzixb = null;
            this.zzfwn = null;
        } else if (obj instanceof String) {
            this.zziwz = null;
            this.zzixa = null;
            this.zzixb = null;
            this.zzfwn = (String) obj;
        } else if (obj instanceof Double) {
            this.zziwz = null;
            this.zzixa = null;
            this.zzixb = (Double) obj;
            this.zzfwn = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public final Object getValue() {
        if (this.zziwz != null) {
            return this.zziwz;
        }
        if (this.zzixb != null) {
            return this.zzixb;
        }
        if (this.zzfwn != null) {
            return this.zzfwn;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.versionCode);
        zzbcn.zza(parcel, 2, this.name, false);
        zzbcn.zza(parcel, 3, this.zziwy);
        zzbcn.zza(parcel, 4, this.zziwz, false);
        zzbcn.zza(parcel, 5, (Float) null, false);
        zzbcn.zza(parcel, 6, this.zzfwn, false);
        zzbcn.zza(parcel, 7, this.zzimf, false);
        zzbcn.zza(parcel, 8, this.zzixb, false);
        zzbcn.zzai(parcel, zze);
    }
}
