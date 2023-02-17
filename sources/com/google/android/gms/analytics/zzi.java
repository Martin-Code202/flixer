package com.google.android.gms.analytics;

import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class zzi<T extends zzi> {
    private final zzj zzdkt;
    protected final zzg zzdku;
    private final List<Object> zzdkv = new ArrayList();

    protected zzi(zzj zzj, zzd zzd) {
        zzbp.zzu(zzj);
        this.zzdkt = zzj;
        zzg zzg = new zzg(this, zzd);
        zzg.zzuf();
        this.zzdku = zzg;
    }

    /* access modifiers changed from: protected */
    public void zza(zzg zzg) {
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzg zzg) {
        Iterator<Object> it = this.zzdkv.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public zzg zzts() {
        zzg zztx = this.zzdku.zztx();
        zzd(zztx);
        return zztx;
    }

    /* access modifiers changed from: protected */
    public final zzj zzug() {
        return this.zzdkt;
    }
}
