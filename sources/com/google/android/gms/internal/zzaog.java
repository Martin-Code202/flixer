package com.google.android.gms.internal;
final class zzaog implements zzanu<zzaoh> {
    private final zzamu zzdoc;
    private final zzaoh zzdsr = new zzaoh();

    public zzaog(zzamu zzamu) {
        this.zzdoc = zzamu;
    }

    @Override // com.google.android.gms.internal.zzanu
    public final void zzc(String str, boolean z) {
        if ("ga_dryRun".equals(str)) {
            this.zzdsr.zzdsu = z ? 1 : 0;
            return;
        }
        this.zzdoc.zzvy().zzd("Bool xml configuration name not recognized", str);
    }

    @Override // com.google.android.gms.internal.zzanu
    public final void zzd(String str, int i) {
        if ("ga_dispatchPeriod".equals(str)) {
            this.zzdsr.zzdst = i;
        } else {
            this.zzdoc.zzvy().zzd("Int xml configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.zzanu
    public final void zzj(String str, String str2) {
    }

    @Override // com.google.android.gms.internal.zzanu
    public final void zzk(String str, String str2) {
        if ("ga_appName".equals(str)) {
            this.zzdsr.zzdma = str2;
        } else if ("ga_appVersion".equals(str)) {
            this.zzdsr.zzdmb = str2;
        } else if ("ga_logLevel".equals(str)) {
            this.zzdsr.zzdss = str2;
        } else {
            this.zzdoc.zzvy().zzd("String xml configuration name not recognized", str);
        }
    }

    /* Return type fixed from 'com.google.android.gms.internal.zzans' to match base method */
    @Override // com.google.android.gms.internal.zzanu
    public final /* synthetic */ zzaoh zzxt() {
        return this.zzdsr;
    }
}
