package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;
final class zzbw implements Runnable {
    private /* synthetic */ ConnectionResult zzfod;
    private /* synthetic */ zzbv zzfof;

    zzbw(zzbv zzbv, ConnectionResult connectionResult) {
        this.zzfof = zzbv;
        this.zzfod = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzfod.isSuccess()) {
            this.zzfof.zzfoe = true;
            if (this.zzfof.zzfkg.zzaac()) {
                this.zzfof.zzaid();
            } else {
                this.zzfof.zzfkg.zza(null, Collections.emptySet());
            }
        } else {
            ((zzbr) this.zzfof.zzfnt.zzfkj.get(this.zzfof.zzfgr)).onConnectionFailed(this.zzfod);
        }
    }
}
