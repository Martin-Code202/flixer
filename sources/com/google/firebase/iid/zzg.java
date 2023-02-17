package com.google.firebase.iid;

import android.util.Log;
/* access modifiers changed from: package-private */
public final class zzg implements Runnable {
    private /* synthetic */ zzd zzmlb;
    private /* synthetic */ zzf zzmlc;

    zzg(zzf zzf, zzd zzd) {
        this.zzmlc = zzf;
        this.zzmlb = zzd;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        this.zzmlc.zzmla.handleIntent(this.zzmlb.intent);
        this.zzmlb.finish();
    }
}
