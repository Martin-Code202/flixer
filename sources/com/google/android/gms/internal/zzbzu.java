package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.internal.zzq;
public final class zzbzu extends zzbyi {
    private final zzbzo zzhzr;

    public zzbzu(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, zzq.zzcc(context));
    }

    public zzbzu(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, zzq zzq) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, zzq);
        this.zzhzr = new zzbzo(context, this.zzhza);
    }

    @Override // com.google.android.gms.common.internal.zzd, com.google.android.gms.common.api.Api.zze
    public final void disconnect() {
        synchronized (this.zzhzr) {
            if (isConnected()) {
                try {
                    this.zzhzr.removeAllListeners();
                    this.zzhzr.zzasy();
                } catch (Exception e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.disconnect();
        }
    }

    public final void zza(long j, PendingIntent pendingIntent) {
        zzajj();
        zzbp.zzu(pendingIntent);
        zzbp.zzb(j >= 0, "detectionIntervalMillis must be >= 0");
        ((zzbzk) zzajk()).zza(j, true, pendingIntent);
    }

    public final void zzc(PendingIntent pendingIntent) {
        zzajj();
        zzbp.zzu(pendingIntent);
        ((zzbzk) zzajk()).zzc(pendingIntent);
    }
}
