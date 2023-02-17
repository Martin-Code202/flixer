package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbs;
public final class zzcqf extends zzbck {
    public static final Parcelable.Creator<zzcqf> CREATOR = new zzcqg();
    private int zzdxr;
    private final ConnectionResult zzfiy;
    private final zzbs zzjny;

    public zzcqf(int i) {
        this(new ConnectionResult(8, null), null);
    }

    zzcqf(int i, ConnectionResult connectionResult, zzbs zzbs) {
        this.zzdxr = i;
        this.zzfiy = connectionResult;
        this.zzjny = zzbs;
    }

    private zzcqf(ConnectionResult connectionResult, zzbs zzbs) {
        this(1, connectionResult, null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.zzdxr);
        zzbcn.zza(parcel, 2, (Parcelable) this.zzfiy, i, false);
        zzbcn.zza(parcel, 3, (Parcelable) this.zzjny, i, false);
        zzbcn.zzai(parcel, zze);
    }

    public final ConnectionResult zzagd() {
        return this.zzfiy;
    }

    public final zzbs zzbcd() {
        return this.zzjny;
    }
}
