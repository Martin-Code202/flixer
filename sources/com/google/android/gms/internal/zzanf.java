package com.google.android.gms.internal;
public final class zzanf extends zzams {
    private final zzalv zzdla = new zzalv();

    zzanf(zzamu zzamu) {
        super(zzamu);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzams
    public final void zzuk() {
        zzwa().zzuh().zzb(this.zzdla);
        zzape zzwe = zzwe();
        String zzun = zzwe.zzun();
        if (zzun != null) {
            this.zzdla.setAppName(zzun);
        }
        String zzuo = zzwe.zzuo();
        if (zzuo != null) {
            this.zzdla.setAppVersion(zzuo);
        }
    }

    public final zzalv zzxd() {
        zzwk();
        return this.zzdla;
    }
}
