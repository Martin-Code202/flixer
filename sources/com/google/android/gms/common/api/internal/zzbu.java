package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
final class zzbu implements Runnable {
    private /* synthetic */ zzbr zzfoc;
    private /* synthetic */ ConnectionResult zzfod;

    zzbu(zzbr zzbr, ConnectionResult connectionResult) {
        this.zzfoc = zzbr;
        this.zzfod = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzfoc.onConnectionFailed(this.zzfod);
    }
}
