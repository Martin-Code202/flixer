package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.zzo;
public class zzb {
    private static zzb zzalx;
    private final Context zzahy;

    private zzb(Context context) {
        this.zzahy = context;
    }

    private final void zza(AdvertisingIdClient.Info info, boolean z, long j) {
        if (Math.random() <= ((double) new zzd(this.zzahy).getFloat("gads:ad_id_use_shared_preference:ping_ratio", 0.0f))) {
            new Thread(new zzc(info, z, j)).start();
        }
    }

    public static zzb zzd(Context context) {
        zzb zzb;
        synchronized (zzb.class) {
            if (zzalx == null) {
                zzalx = new zzb(context);
            }
            zzb = zzalx;
        }
        return zzb;
    }

    public final AdvertisingIdClient.Info getInfo() {
        Context remoteContext = zzo.getRemoteContext(this.zzahy);
        if (remoteContext == null) {
            zza(null, false, -1);
            return null;
        }
        SharedPreferences sharedPreferences = remoteContext.getSharedPreferences("adid_settings", 0);
        if (sharedPreferences == null) {
            zza(null, false, -1);
            return null;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AdvertisingIdClient.Info info = (!sharedPreferences.contains("adid_key") || !sharedPreferences.contains("enable_limit_ad_tracking")) ? null : new AdvertisingIdClient.Info(sharedPreferences.getString("adid_key", ""), sharedPreferences.getBoolean("enable_limit_ad_tracking", false));
        zza(info, true, SystemClock.elapsedRealtime() - elapsedRealtime);
        return info;
    }
}
