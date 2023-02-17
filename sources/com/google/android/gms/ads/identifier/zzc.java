package com.google.android.gms.ads.identifier;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.HashMap;
/* access modifiers changed from: package-private */
public final /* synthetic */ class zzc implements Runnable {
    private final AdvertisingIdClient.Info zzaly;
    private final boolean zzalz;
    private final long zzama;

    zzc(AdvertisingIdClient.Info info, boolean z, long j) {
        this.zzaly = info;
        this.zzalz = z;
        this.zzama = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AdvertisingIdClient.Info info = this.zzaly;
        boolean z = this.zzalz;
        long j = this.zzama;
        HashMap hashMap = new HashMap();
        hashMap.put("ad_id_size", Integer.toString(info == null ? -1 : info.getId().length()));
        hashMap.put("has_gmscore", z ? "1" : "0");
        hashMap.put("tag", "AdvertisingIdLightClient");
        hashMap.put("time_spent", Long.toString(j));
        new zze().zzb(hashMap);
    }
}
