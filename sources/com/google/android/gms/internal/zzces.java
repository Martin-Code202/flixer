package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.measurement.AppMeasurement;
/* access modifiers changed from: package-private */
public final class zzces implements Runnable {
    private /* synthetic */ zzceo zziwe;
    private /* synthetic */ AppMeasurement.zzb zziwg;

    zzces(zzceo zzceo, AppMeasurement.zzb zzb) {
        this.zziwe = zzceo;
        this.zziwg = zzb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbo zzcbo = this.zziwe.zzivy;
        if (zzcbo == null) {
            this.zziwe.zzaum().zzaye().log("Failed to send current screen to service");
            return;
        }
        try {
            if (this.zziwg == null) {
                zzcbo.zza(0, (String) null, (String) null, this.zziwe.getContext().getPackageName());
            } else {
                zzcbo.zza(this.zziwg.zziko, this.zziwg.zzikm, this.zziwg.zzikn, this.zziwe.getContext().getPackageName());
            }
            this.zziwe.zzww();
        } catch (RemoteException e) {
            this.zziwe.zzaum().zzaye().zzj("Failed to send current screen to the service", e);
        }
    }
}
