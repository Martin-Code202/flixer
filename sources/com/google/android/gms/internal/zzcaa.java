package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.zzj;
import com.google.android.gms.location.zzk;
import com.google.android.gms.location.zzm;
import com.google.android.gms.location.zzn;
public final class zzcaa extends zzbck {
    public static final Parcelable.Creator<zzcaa> CREATOR = new zzcab();
    private PendingIntent mPendingIntent;
    private int zzhzz;
    private zzbzy zziaa;
    private zzm zziab;
    private zzj zziac;
    private zzbzf zziad;

    zzcaa(int i, zzbzy zzbzy, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        zzbzf zzbzf;
        this.zzhzz = i;
        this.zziaa = zzbzy;
        this.zziab = iBinder == null ? null : zzn.zzbb(iBinder);
        this.mPendingIntent = pendingIntent;
        this.zziac = iBinder2 == null ? null : zzk.zzba(iBinder2);
        if (iBinder3 == null) {
            zzbzf = null;
        } else if (iBinder3 == null) {
            zzbzf = null;
        } else {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzbzf = queryLocalInterface instanceof zzbzf ? (zzbzf) queryLocalInterface : new zzbzh(iBinder3);
        }
        this.zziad = zzbzf;
    }

    public static zzcaa zza(zzj zzj, zzbzf zzbzf) {
        return new zzcaa(2, null, null, null, zzj.asBinder(), zzbzf != null ? zzbzf.asBinder() : null);
    }

    public static zzcaa zza(zzm zzm, zzbzf zzbzf) {
        return new zzcaa(2, null, zzm.asBinder(), null, null, zzbzf != null ? zzbzf.asBinder() : null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.zzhzz);
        zzbcn.zza(parcel, 2, (Parcelable) this.zziaa, i, false);
        zzbcn.zza(parcel, 3, this.zziab == null ? null : this.zziab.asBinder(), false);
        zzbcn.zza(parcel, 4, (Parcelable) this.mPendingIntent, i, false);
        zzbcn.zza(parcel, 5, this.zziac == null ? null : this.zziac.asBinder(), false);
        zzbcn.zza(parcel, 6, this.zziad == null ? null : this.zziad.asBinder(), false);
        zzbcn.zzai(parcel, zze);
    }
}
