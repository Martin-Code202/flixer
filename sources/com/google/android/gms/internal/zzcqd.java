package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbq;
public final class zzcqd extends zzbck {
    public static final Parcelable.Creator<zzcqd> CREATOR = new zzcqe();
    private int zzdxr;
    private zzbq zzjnx;

    zzcqd(int i, zzbq zzbq) {
        this.zzdxr = i;
        this.zzjnx = zzbq;
    }

    public zzcqd(zzbq zzbq) {
        this(1, zzbq);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.zzdxr);
        zzbcn.zza(parcel, 2, (Parcelable) this.zzjnx, i, false);
        zzbcn.zzai(parcel, zze);
    }
}
