package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.internal.zzj;
import java.lang.ref.WeakReference;
final class zzat implements zzj {
    private final Api<?> zzfdf;
    private final boolean zzfjr;
    private final WeakReference<zzar> zzflx;

    public zzat(zzar zzar, Api<?> api, boolean z) {
        this.zzflx = new WeakReference<>(zzar);
        this.zzfdf = api;
        this.zzfjr = z;
    }

    @Override // com.google.android.gms.common.internal.zzj
    public final void zzf(ConnectionResult connectionResult) {
        zzar zzar = this.zzflx.get();
        if (zzar != null) {
            zzbp.zza(Looper.myLooper() == zzar.zzd(zzar).zzfjt.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            zzar.zzc(zzar).lock();
            try {
                if (zzar.zza(zzar, 0)) {
                    if (!connectionResult.isSuccess()) {
                        zzar.zza(zzar, connectionResult, this.zzfdf, this.zzfjr);
                    }
                    if (zzar.zzk(zzar)) {
                        zzar.zzj(zzar);
                    }
                    zzar.zzc(zzar).unlock();
                }
            } finally {
                zzar.zzc(zzar).unlock();
            }
        }
    }
}
