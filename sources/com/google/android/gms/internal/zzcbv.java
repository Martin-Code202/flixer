package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;
public final class zzcbv extends zzd<zzcbo> {
    public zzcbv(Context context, Looper looper, zzf zzf, zzg zzg) {
        super(context, looper, 93, zzf, zzg, null);
    }

    /* Return type fixed from 'android.os.IInterface' to match base method */
    @Override // com.google.android.gms.common.internal.zzd
    public final /* synthetic */ zzcbo zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return queryLocalInterface instanceof zzcbo ? (zzcbo) queryLocalInterface : new zzcbq(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhc() {
        return "com.google.android.gms.measurement.START";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhd() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}
