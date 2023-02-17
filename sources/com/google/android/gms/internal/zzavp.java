package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.zzd;
import com.google.android.gms.cast.framework.zzab;
import com.google.android.gms.cast.framework.zzh;
import com.google.android.gms.cast.framework.zzj;
import com.google.android.gms.cast.framework.zzl;
import com.google.android.gms.cast.framework.zzr;
import com.google.android.gms.cast.framework.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzawl;
import java.util.Map;
public final class zzavp extends zzeb implements zzavo {
    zzavp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
    }

    @Override // com.google.android.gms.internal.zzavo
    public final zzd zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, CastMediaOptions castMediaOptions) {
        Parcel zzax = zzax();
        zzed.zza(zzax, iObjectWrapper);
        zzed.zza(zzax, iObjectWrapper2);
        zzed.zza(zzax, iObjectWrapper3);
        zzed.zza(zzax, castMediaOptions);
        Parcel zza = zza(4, zzax);
        zzd zzag = zzd.zza.zzag(zza.readStrongBinder());
        zza.recycle();
        return zzag;
    }

    @Override // com.google.android.gms.internal.zzavo
    public final zzj zza(IObjectWrapper iObjectWrapper, CastOptions castOptions, zzavq zzavq, Map map) {
        Parcel zzax = zzax();
        zzed.zza(zzax, iObjectWrapper);
        zzed.zza(zzax, castOptions);
        zzed.zza(zzax, zzavq);
        zzax.writeMap(map);
        Parcel zza = zza(1, zzax);
        zzj zzac = zzj.zza.zzac(zza.readStrongBinder());
        zza.recycle();
        return zzac;
    }

    @Override // com.google.android.gms.internal.zzavo
    public final zzl zza(CastOptions castOptions, IObjectWrapper iObjectWrapper, zzh zzh) {
        Parcel zzax = zzax();
        zzed.zza(zzax, castOptions);
        zzed.zza(zzax, iObjectWrapper);
        zzed.zza(zzax, zzh);
        Parcel zza = zza(3, zzax);
        zzl zzad = zzl.zza.zzad(zza.readStrongBinder());
        zza.recycle();
        return zzad;
    }

    @Override // com.google.android.gms.internal.zzavo
    public final zzr zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel zzax = zzax();
        zzed.zza(zzax, iObjectWrapper);
        zzed.zza(zzax, iObjectWrapper2);
        zzed.zza(zzax, iObjectWrapper3);
        Parcel zza = zza(5, zzax);
        zzr zzae = zzr.zza.zzae(zza.readStrongBinder());
        zza.recycle();
        return zzae;
    }

    @Override // com.google.android.gms.internal.zzavo
    public final zzt zza(String str, String str2, zzab zzab) {
        Parcel zzax = zzax();
        zzax.writeString(str);
        zzax.writeString(str2);
        zzed.zza(zzax, zzab);
        Parcel zza = zza(2, zzax);
        zzt zzaf = zzt.zza.zzaf(zza.readStrongBinder());
        zza.recycle();
        return zzaf;
    }

    @Override // com.google.android.gms.internal.zzavo
    public final zzawl zza(IObjectWrapper iObjectWrapper, zzawn zzawn, int i, int i2, boolean z, long j, int i3, int i4, int i5) {
        Parcel zzax = zzax();
        zzed.zza(zzax, iObjectWrapper);
        zzed.zza(zzax, zzawn);
        zzax.writeInt(i);
        zzax.writeInt(i2);
        zzed.zza(zzax, z);
        zzax.writeLong(j);
        zzax.writeInt(i3);
        zzax.writeInt(i4);
        zzax.writeInt(i5);
        Parcel zza = zza(6, zzax);
        zzawl zzah = zzawl.zza.zzah(zza.readStrongBinder());
        zza.recycle();
        return zzah;
    }
}
