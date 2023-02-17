package com.google.android.gms.internal;
final class zzawk extends zzawo {
    private /* synthetic */ zzawg zzeve;

    private zzawk(zzawg zzawg) {
        this.zzeve = zzawg;
    }

    @Override // com.google.android.gms.internal.zzawn
    public final void zzb(long j, long j2) {
        this.zzeve.publishProgress(Long.valueOf(j), Long.valueOf(j2));
    }
}
