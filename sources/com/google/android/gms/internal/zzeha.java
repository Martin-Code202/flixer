package com.google.android.gms.internal;

import com.google.android.gms.internal.zzeha;
public abstract class zzeha<M extends zzeha<M>> extends zzehg {
    protected zzehc zzngg;

    @Override // com.google.android.gms.internal.zzehg
    public void zza(zzegy zzegy) {
        if (this.zzngg != null) {
            for (int i = 0; i < this.zzngg.size(); i++) {
                this.zzngg.zzhj(i).zza(zzegy);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzegx zzegx, int i) {
        int position = zzegx.getPosition();
        if (!zzegx.zzha(i)) {
            return false;
        }
        int i2 = i >>> 3;
        zzehi zzehi = new zzehi(i, zzegx.zzad(position, zzegx.getPosition() - position));
        zzehd zzehd = null;
        if (this.zzngg == null) {
            this.zzngg = new zzehc();
        } else {
            zzehd = this.zzngg.zzhi(i2);
        }
        if (zzehd == null) {
            zzehd = new zzehd();
            this.zzngg.zza(i2, zzehd);
        }
        zzehd.zza(zzehi);
        return true;
    }

    /* renamed from: zzceh */
    public M clone() {
        M m = (M) ((zzeha) super.clone());
        zzehe.zza(this, m);
        return m;
    }

    @Override // com.google.android.gms.internal.zzehg
    public /* synthetic */ zzehg zzcei() {
        return (zzeha) clone();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzehg
    public int zzn() {
        int i = 0;
        if (this.zzngg != null) {
            for (int i2 = 0; i2 < this.zzngg.size(); i2++) {
                i += this.zzngg.zzhj(i2).zzn();
            }
        }
        return i;
    }
}
