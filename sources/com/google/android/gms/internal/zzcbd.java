package com.google.android.gms.internal;

import android.os.Looper;
final class zzcbd implements Runnable {
    private /* synthetic */ zzcbc zzine;

    zzcbd(zzcbc zzcbc) {
        this.zzine = zzcbc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzcbc.zza(this.zzine).zzaul().zzg(this);
            return;
        }
        boolean zzdp = this.zzine.zzdp();
        zzcbc.zza(this.zzine, 0);
        if (zzdp && zzcbc.zzb(this.zzine)) {
            this.zzine.run();
        }
    }
}
