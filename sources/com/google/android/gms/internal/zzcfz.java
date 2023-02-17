package com.google.android.gms.internal;
public final class zzcfz extends zzeha<zzcfz> {
    private static volatile zzcfz[] zzixr;
    public zzcgc zzixs = null;
    public zzcga zzixt = null;
    public Boolean zzixu = null;
    public String zzixv = null;

    public zzcfz() {
        this.zzngg = null;
        this.zzngp = -1;
    }

    public static zzcfz[] zzbac() {
        if (zzixr == null) {
            synchronized (zzehe.zzngo) {
                if (zzixr == null) {
                    zzixr = new zzcfz[0];
                }
            }
        }
        return zzixr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcfz)) {
            return false;
        }
        zzcfz zzcfz = (zzcfz) obj;
        if (this.zzixs == null) {
            if (zzcfz.zzixs != null) {
                return false;
            }
        } else if (!this.zzixs.equals(zzcfz.zzixs)) {
            return false;
        }
        if (this.zzixt == null) {
            if (zzcfz.zzixt != null) {
                return false;
            }
        } else if (!this.zzixt.equals(zzcfz.zzixt)) {
            return false;
        }
        if (this.zzixu == null) {
            if (zzcfz.zzixu != null) {
                return false;
            }
        } else if (!this.zzixu.equals(zzcfz.zzixu)) {
            return false;
        }
        if (this.zzixv == null) {
            if (zzcfz.zzixv != null) {
                return false;
            }
        } else if (!this.zzixv.equals(zzcfz.zzixv)) {
            return false;
        }
        return (this.zzngg == null || this.zzngg.isEmpty()) ? zzcfz.zzngg == null || zzcfz.zzngg.isEmpty() : this.zzngg.equals(zzcfz.zzngg);
    }

    public final int hashCode() {
        zzcgc zzcgc = this.zzixs;
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        int hashCode2 = zzcgc == null ? 0 : zzcgc.hashCode();
        zzcga zzcga = this.zzixt;
        return ((((((((hashCode + hashCode2) * 31) + (zzcga == null ? 0 : zzcga.hashCode())) * 31) + (this.zzixu == null ? 0 : this.zzixu.hashCode())) * 31) + (this.zzixv == null ? 0 : this.zzixv.hashCode())) * 31) + ((this.zzngg == null || this.zzngg.isEmpty()) ? 0 : this.zzngg.hashCode());
    }

    @Override // com.google.android.gms.internal.zzehg
    public final /* synthetic */ zzehg zza(zzegx zzegx) {
        while (true) {
            int zzcby = zzegx.zzcby();
            switch (zzcby) {
                case 0:
                    return this;
                case 10:
                    if (this.zzixs == null) {
                        this.zzixs = new zzcgc();
                    }
                    zzegx.zza(this.zzixs);
                    break;
                case 18:
                    if (this.zzixt == null) {
                        this.zzixt = new zzcga();
                    }
                    zzegx.zza(this.zzixt);
                    break;
                case 24:
                    this.zzixu = Boolean.valueOf(zzegx.zzcea());
                    break;
                case 34:
                    this.zzixv = zzegx.readString();
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
        if (this.zzixs != null) {
            zzegy.zza(1, this.zzixs);
        }
        if (this.zzixt != null) {
            zzegy.zza(2, this.zzixt);
        }
        if (this.zzixu != null) {
            zzegy.zzl(3, this.zzixu.booleanValue());
        }
        if (this.zzixv != null) {
            zzegy.zzl(4, this.zzixv);
        }
        super.zza(zzegy);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzeha, com.google.android.gms.internal.zzehg
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zzixs != null) {
            zzn += zzegy.zzb(1, this.zzixs);
        }
        if (this.zzixt != null) {
            zzn += zzegy.zzb(2, this.zzixt);
        }
        if (this.zzixu != null) {
            this.zzixu.booleanValue();
            zzn += zzegy.zzgs(3) + 1;
        }
        return this.zzixv != null ? zzn + zzegy.zzm(4, this.zzixv) : zzn;
    }
}
