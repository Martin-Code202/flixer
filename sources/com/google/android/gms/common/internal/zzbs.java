package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
public final class zzbs extends zzbck {
    public static final Parcelable.Creator<zzbs> CREATOR = new zzbt();
    private int zzdxr;
    private ConnectionResult zzfiy;
    private boolean zzflt;
    private IBinder zzfvy;
    private boolean zzfvz;

    zzbs(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.zzdxr = i;
        this.zzfvy = iBinder;
        this.zzfiy = connectionResult;
        this.zzflt = z;
        this.zzfvz = z2;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbs)) {
            return false;
        }
        zzbs zzbs = (zzbs) obj;
        return this.zzfiy.equals(zzbs.zzfiy) && zzakm().equals(zzbs.zzakm());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.zzdxr);
        zzbcn.zza(parcel, 2, this.zzfvy, false);
        zzbcn.zza(parcel, 3, (Parcelable) this.zzfiy, i, false);
        zzbcn.zza(parcel, 4, this.zzflt);
        zzbcn.zza(parcel, 5, this.zzfvz);
        zzbcn.zzai(parcel, zze);
    }

    public final ConnectionResult zzagd() {
        return this.zzfiy;
    }

    public final zzam zzakm() {
        IBinder iBinder = this.zzfvy;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
        return queryLocalInterface instanceof zzam ? (zzam) queryLocalInterface : new zzao(iBinder);
    }

    public final boolean zzakn() {
        return this.zzflt;
    }

    public final boolean zzako() {
        return this.zzfvz;
    }
}
