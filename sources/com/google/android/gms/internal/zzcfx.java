package com.google.android.gms.internal;
public final class zzcfx extends zzeha<zzcfx> {
    private static volatile zzcfx[] zzixh;
    public Integer zzixi = null;
    public zzcgb[] zzixj = zzcgb.zzbad();
    public zzcfy[] zzixk = zzcfy.zzbab();

    public zzcfx() {
        this.zzngg = null;
        this.zzngp = -1;
    }

    public static zzcfx[] zzbaa() {
        if (zzixh == null) {
            synchronized (zzehe.zzngo) {
                if (zzixh == null) {
                    zzixh = new zzcfx[0];
                }
            }
        }
        return zzixh;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcfx)) {
            return false;
        }
        zzcfx zzcfx = (zzcfx) obj;
        if (this.zzixi == null) {
            if (zzcfx.zzixi != null) {
                return false;
            }
        } else if (!this.zzixi.equals(zzcfx.zzixi)) {
            return false;
        }
        if (zzehe.equals(this.zzixj, zzcfx.zzixj) && zzehe.equals(this.zzixk, zzcfx.zzixk)) {
            return (this.zzngg == null || this.zzngg.isEmpty()) ? zzcfx.zzngg == null || zzcfx.zzngg.isEmpty() : this.zzngg.equals(zzcfx.zzngg);
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzixi == null ? 0 : this.zzixi.hashCode())) * 31) + zzehe.hashCode(this.zzixj)) * 31) + zzehe.hashCode(this.zzixk)) * 31) + ((this.zzngg == null || this.zzngg.isEmpty()) ? 0 : this.zzngg.hashCode());
    }

    @Override // com.google.android.gms.internal.zzehg
    public final /* synthetic */ zzehg zza(zzegx zzegx) {
        while (true) {
            int zzcby = zzegx.zzcby();
            switch (zzcby) {
                case 0:
                    return this;
                case 8:
                    this.zzixi = Integer.valueOf(zzegx.zzccj());
                    break;
                case 18:
                    int zzb = zzehj.zzb(zzegx, 18);
                    int length = this.zzixj == null ? 0 : this.zzixj.length;
                    int i = length;
                    zzcgb[] zzcgbArr = new zzcgb[(length + zzb)];
                    if (i != 0) {
                        System.arraycopy(this.zzixj, 0, zzcgbArr, 0, i);
                    }
                    while (i < zzcgbArr.length - 1) {
                        zzcgbArr[i] = new zzcgb();
                        zzegx.zza(zzcgbArr[i]);
                        zzegx.zzcby();
                        i++;
                    }
                    zzcgbArr[i] = new zzcgb();
                    zzegx.zza(zzcgbArr[i]);
                    this.zzixj = zzcgbArr;
                    break;
                case 26:
                    int zzb2 = zzehj.zzb(zzegx, 26);
                    int length2 = this.zzixk == null ? 0 : this.zzixk.length;
                    int i2 = length2;
                    zzcfy[] zzcfyArr = new zzcfy[(length2 + zzb2)];
                    if (i2 != 0) {
                        System.arraycopy(this.zzixk, 0, zzcfyArr, 0, i2);
                    }
                    while (i2 < zzcfyArr.length - 1) {
                        zzcfyArr[i2] = new zzcfy();
                        zzegx.zza(zzcfyArr[i2]);
                        zzegx.zzcby();
                        i2++;
                    }
                    zzcfyArr[i2] = new zzcfy();
                    zzegx.zza(zzcfyArr[i2]);
                    this.zzixk = zzcfyArr;
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
        if (this.zzixi != null) {
            zzegy.zzv(1, this.zzixi.intValue());
        }
        if (this.zzixj != null && this.zzixj.length > 0) {
            for (int i = 0; i < this.zzixj.length; i++) {
                zzcgb zzcgb = this.zzixj[i];
                if (zzcgb != null) {
                    zzegy.zza(2, zzcgb);
                }
            }
        }
        if (this.zzixk != null && this.zzixk.length > 0) {
            for (int i2 = 0; i2 < this.zzixk.length; i2++) {
                zzcfy zzcfy = this.zzixk[i2];
                if (zzcfy != null) {
                    zzegy.zza(3, zzcfy);
                }
            }
        }
        super.zza(zzegy);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzeha, com.google.android.gms.internal.zzehg
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zzixi != null) {
            zzn += zzegy.zzaf(1, this.zzixi.intValue());
        }
        if (this.zzixj != null && this.zzixj.length > 0) {
            for (int i = 0; i < this.zzixj.length; i++) {
                zzcgb zzcgb = this.zzixj[i];
                if (zzcgb != null) {
                    zzn += zzegy.zzb(2, zzcgb);
                }
            }
        }
        if (this.zzixk != null && this.zzixk.length > 0) {
            for (int i2 = 0; i2 < this.zzixk.length; i2++) {
                zzcfy zzcfy = this.zzixk[i2];
                if (zzcfy != null) {
                    zzn += zzegy.zzb(3, zzcfy);
                }
            }
        }
        return zzn;
    }
}
