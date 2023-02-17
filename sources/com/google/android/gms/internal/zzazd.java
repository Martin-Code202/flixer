package com.google.android.gms.internal;

import android.text.TextUtils;
public class zzazd {
    private final String zzefz;
    protected final zzazx zzejc;
    private zzbab zzfas;

    protected zzazd(String str, String str2, String str3) {
        zzazl.zzfg(str);
        this.zzefz = str;
        this.zzejc = new zzazx(str2);
        setSessionLabel(str3);
    }

    public final String getNamespace() {
        return this.zzefz;
    }

    public final void setSessionLabel(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.zzejc.zzfl(str);
        }
    }

    public final void zza(zzbab zzbab) {
        this.zzfas = zzbab;
        if (this.zzfas == null) {
            zzaee();
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(String str, long j, String str2) {
        Object[] objArr = {str, null};
        this.zzfas.zza(this.zzefz, str, j, null);
    }

    public void zzaee() {
    }

    /* access modifiers changed from: protected */
    public final long zzaef() {
        return this.zzfas.zzabr();
    }

    public void zzc(long j, int i) {
    }

    public void zzff(String str) {
    }
}
