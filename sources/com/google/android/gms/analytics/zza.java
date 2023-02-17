package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzame;
import com.google.android.gms.internal.zzami;
import com.google.android.gms.internal.zzamu;
import java.util.ListIterator;
public class zza extends zzi<zza> {
    private final zzamu zzdji;
    private boolean zzdjj;

    public zza(zzamu zzamu) {
        super(zzamu.zzwa(), zzamu.zzvx());
        this.zzdji = zzamu;
    }

    public final void enableAdvertisingIdCollection(boolean z) {
        this.zzdjj = z;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.analytics.zzi
    public final void zza(zzg zzg) {
        zzame zzame = (zzame) zzg.zzb(zzame.class);
        if (TextUtils.isEmpty(zzame.zzve())) {
            zzame.setClientId(this.zzdji.zzwq().zzxp());
        }
        if (this.zzdjj && TextUtils.isEmpty(zzame.zzvf())) {
            zzami zzwp = this.zzdji.zzwp();
            zzame.zzdi(zzwp.zzvn());
            zzame.zzah(zzwp.zzvg());
        }
    }

    public final void zzcw(String str) {
        zzbp.zzgg(str);
        Uri zzcx = zzb.zzcx(str);
        ListIterator<zzm> listIterator = this.zzdku.getTransports().listIterator();
        while (listIterator.hasNext()) {
            if (zzcx.equals(listIterator.next().zztu())) {
                listIterator.remove();
            }
        }
        this.zzdku.getTransports().add(new zzb(this.zzdji, str));
    }

    /* access modifiers changed from: package-private */
    public final zzamu zztr() {
        return this.zzdji;
    }

    @Override // com.google.android.gms.analytics.zzi
    public final zzg zzts() {
        zzg zztx = this.zzdku.zztx();
        zztx.zza(this.zzdji.zzwi().zzxd());
        zztx.zza(this.zzdji.zzwj().zzyh());
        zzd(zztx);
        return zztx;
    }
}
