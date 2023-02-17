package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
final class zzdh implements Runnable {
    private /* synthetic */ Result zzfpn;
    private /* synthetic */ zzdg zzfpo;

    zzdh(zzdg zzdg, Result result) {
        this.zzfpo = zzdg;
        this.zzfpn = result;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzs.zzfjd.set(true);
            this.zzfpo.zzfpl.sendMessage(this.zzfpo.zzfpl.obtainMessage(0, this.zzfpo.zzfpg.onSuccess(this.zzfpn)));
            zzs.zzfjd.set(false);
            zzdg zzdg = this.zzfpo;
            zzdg.zzd(this.zzfpn);
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zzfpo.zzfjg.get();
            if (googleApiClient != null) {
                googleApiClient.zzb(this.zzfpo);
            }
        } catch (RuntimeException e) {
            this.zzfpo.zzfpl.sendMessage(this.zzfpo.zzfpl.obtainMessage(1, e));
            zzs.zzfjd.set(false);
            zzdg zzdg2 = this.zzfpo;
            zzdg.zzd(this.zzfpn);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.zzfpo.zzfjg.get();
            if (googleApiClient2 != null) {
                googleApiClient2.zzb(this.zzfpo);
            }
        } catch (Throwable th) {
            zzs.zzfjd.set(false);
            zzdg zzdg3 = this.zzfpo;
            zzdg.zzd(this.zzfpn);
            GoogleApiClient googleApiClient3 = (GoogleApiClient) this.zzfpo.zzfjg.get();
            if (googleApiClient3 != null) {
                googleApiClient3.zzb(this.zzfpo);
            }
            throw th;
        }
    }
}
