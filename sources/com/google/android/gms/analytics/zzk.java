package com.google.android.gms.analytics;

import java.util.Iterator;
/* access modifiers changed from: package-private */
public final class zzk implements Runnable {
    private /* synthetic */ zzg zzdlc;
    private /* synthetic */ zzj zzdld;

    zzk(zzj zzj, zzg zzg) {
        this.zzdld = zzj;
        this.zzdlc = zzg;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdlc.zzud().zza(this.zzdlc);
        Iterator it = this.zzdld.zzdkx.iterator();
        while (it.hasNext()) {
            it.next();
        }
        zzj zzj = this.zzdld;
        zzj.zzb(this.zzdlc);
    }
}
