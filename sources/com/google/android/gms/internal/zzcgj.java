package com.google.android.gms.internal;
public final class zzcgj extends zzeha<zzcgj> {
    public zzcgk[] zzizb = zzcgk.zzbaj();

    public zzcgj() {
        this.zzngg = null;
        this.zzngp = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcgj)) {
            return false;
        }
        zzcgj zzcgj = (zzcgj) obj;
        if (!zzehe.equals(this.zzizb, zzcgj.zzizb)) {
            return false;
        }
        return (this.zzngg == null || this.zzngg.isEmpty()) ? zzcgj.zzngg == null || zzcgj.zzngg.isEmpty() : this.zzngg.equals(zzcgj.zzngg);
    }

    public final int hashCode() {
        return ((((getClass().getName().hashCode() + 527) * 31) + zzehe.hashCode(this.zzizb)) * 31) + ((this.zzngg == null || this.zzngg.isEmpty()) ? 0 : this.zzngg.hashCode());
    }

    @Override // com.google.android.gms.internal.zzehg
    public final /* synthetic */ zzehg zza(zzegx zzegx) {
        while (true) {
            int zzcby = zzegx.zzcby();
            switch (zzcby) {
                case 0:
                    return this;
                case 10:
                    int zzb = zzehj.zzb(zzegx, 10);
                    int length = this.zzizb == null ? 0 : this.zzizb.length;
                    int i = length;
                    zzcgk[] zzcgkArr = new zzcgk[(length + zzb)];
                    if (i != 0) {
                        System.arraycopy(this.zzizb, 0, zzcgkArr, 0, i);
                    }
                    while (i < zzcgkArr.length - 1) {
                        zzcgkArr[i] = new zzcgk();
                        zzegx.zza(zzcgkArr[i]);
                        zzegx.zzcby();
                        i++;
                    }
                    zzcgkArr[i] = new zzcgk();
                    zzegx.zza(zzcgkArr[i]);
                    this.zzizb = zzcgkArr;
                    break;
                default:
                    if (super.zza(zzegx, zzcby)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzeha, com.google.android.gms.internal.zzehg
    public final void zza(zzegy zzegy) {
        if (this.zzizb != null && this.zzizb.length > 0) {
            for (int i = 0; i < this.zzizb.length; i++) {
                zzcgk zzcgk = this.zzizb[i];
                if (zzcgk != null) {
                    zzegy.zza(1, zzcgk);
                }
            }
        }
        super.zza(zzegy);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzeha, com.google.android.gms.internal.zzehg
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zzizb != null && this.zzizb.length > 0) {
            for (int i = 0; i < this.zzizb.length; i++) {
                zzcgk zzcgk = this.zzizb[i];
                if (zzcgk != null) {
                    zzn += zzegy.zzb(1, zzcgk);
                }
            }
        }
        return zzn;
    }
}
