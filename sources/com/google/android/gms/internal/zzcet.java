package com.google.android.gms.internal;
/* access modifiers changed from: package-private */
public final class zzcet extends zzcbc {
    private /* synthetic */ zzceo zziwe;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcet(zzceo zzceo, zzccw zzccw) {
        super(zzccw);
        this.zziwe = zzceo;
    }

    @Override // com.google.android.gms.internal.zzcbc
    public final void run() {
        this.zziwe.zzaum().zzayg().log("Tasks have been queued for a long time");
    }
}
