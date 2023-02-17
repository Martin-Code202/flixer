package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;
import java.util.Map;
public final class zzaok extends zzeb implements zzaoj {
    zzaok(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.analytics.internal.IAnalyticsService");
    }

    @Override // com.google.android.gms.internal.zzaoj
    public final void zza(Map map, long j, String str, List<zzanp> list) {
        Parcel zzax = zzax();
        zzax.writeMap(map);
        zzax.writeLong(j);
        zzax.writeString(str);
        zzax.writeTypedList(list);
        zzb(1, zzax);
    }
}
