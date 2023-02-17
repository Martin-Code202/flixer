package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zzcqf;
final class zzcx implements Runnable {
    private /* synthetic */ zzcqf zzfme;
    private /* synthetic */ zzcw zzfpe;

    zzcx(zzcw zzcw, zzcqf zzcqf) {
        this.zzfpe = zzcw;
        this.zzfme = zzcqf;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzfpe.zzc(this.zzfme);
    }
}
