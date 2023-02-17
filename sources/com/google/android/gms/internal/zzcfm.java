package com.google.android.gms.internal;

import android.os.Bundle;
/* access modifiers changed from: package-private */
public final class zzcfm extends zzcbc {
    private /* synthetic */ zzcfl zziwv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcfm(zzcfl zzcfl, zzccw zzccw) {
        super(zzccw);
        this.zziwv = zzcfl;
    }

    @Override // com.google.android.gms.internal.zzcbc
    public final void run() {
        zzcfl zzcfl = this.zziwv;
        zzcfl.zzuj();
        zzcfl.zzaum().zzayk().zzj("Session started, time", Long.valueOf(zzcfl.zzvx().elapsedRealtime()));
        zzcfl.zzaun().zzird.set(false);
        zzcfl.zzaua().zzc("auto", "_s", new Bundle());
        zzcfl.zzaun().zzire.set(zzcfl.zzvx().currentTimeMillis());
    }
}
