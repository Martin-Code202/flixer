package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzat;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
public final class zzm extends zzbck {
    public static final Parcelable.Creator<zzm> CREATOR = new zzn();
    private final String zzffs;
    private final zzg zzfft;
    private final boolean zzffu;

    zzm(String str, IBinder iBinder, boolean z) {
        this.zzffs = str;
        this.zzfft = zzai(iBinder);
        this.zzffu = z;
    }

    zzm(String str, zzg zzg, boolean z) {
        this.zzffs = str;
        this.zzfft = zzg;
        this.zzffu = z;
    }

    private static zzg zzai(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper zzaez = zzat.zzak(iBinder).zzaez();
            byte[] bArr = zzaez == null ? null : (byte[]) zzn.zzx(zzaez);
            if (bArr != null) {
                return new zzh(bArr);
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        } catch (RemoteException e) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 1, this.zzffs, false);
        if (this.zzfft == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            iBinder = null;
        } else {
            iBinder = this.zzfft.asBinder();
        }
        zzbcn.zza(parcel, 2, iBinder, false);
        zzbcn.zza(parcel, 3, this.zzffu);
        zzbcn.zzai(parcel, zze);
    }
}
