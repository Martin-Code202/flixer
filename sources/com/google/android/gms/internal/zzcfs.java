package com.google.android.gms.internal;
/* access modifiers changed from: package-private */
public final class zzcfs extends zzcbc {
    private /* synthetic */ zzcfr zziwx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcfs(zzcfr zzcfr, zzccw zzccw) {
        super(zzccw);
        this.zziwx = zzcfr;
    }

    @Override // com.google.android.gms.internal.zzcbc
    public final void run() {
        this.zziwx.zzaum().zzayk().log("Sending upload intent from DelayedRunnable");
        this.zziwx.zzazx();
    }
}
