package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbp;
public final class zzcbk extends zzbck {
    public static final Parcelable.Creator<zzcbk> CREATOR = new zzcbl();
    public final String name;
    public final String zzimf;
    public final zzcbh zzinq;
    public final long zzinr;

    zzcbk(zzcbk zzcbk, long j) {
        zzbp.zzu(zzcbk);
        this.name = zzcbk.name;
        this.zzinq = zzcbk.zzinq;
        this.zzimf = zzcbk.zzimf;
        this.zzinr = j;
    }

    public zzcbk(String str, zzcbh zzcbh, String str2, long j) {
        this.name = str;
        this.zzinq = zzcbh;
        this.zzimf = str2;
        this.zzinr = j;
    }

    @Override // java.lang.Object
    public final String toString() {
        String str = this.zzimf;
        String str2 = this.name;
        String valueOf = String.valueOf(this.zzinq);
        return new StringBuilder(String.valueOf(valueOf).length() + String.valueOf(str).length() + 21 + String.valueOf(str2).length()).append("origin=").append(str).append(",name=").append(str2).append(",params=").append(valueOf).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, this.name, false);
        zzbcn.zza(parcel, 3, (Parcelable) this.zzinq, i, false);
        zzbcn.zza(parcel, 4, this.zzimf, false);
        zzbcn.zza(parcel, 5, this.zzinr);
        zzbcn.zzai(parcel, zze);
    }
}
