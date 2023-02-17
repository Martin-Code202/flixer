package com.google.android.gms.internal;
public final class zzcgb extends zzeha<zzcgb> {
    private static volatile zzcgb[] zziyb;
    public Integer zzixm = null;
    public String zziyc = null;
    public zzcfz zziyd = null;

    public zzcgb() {
        this.zzngg = null;
        this.zzngp = -1;
    }

    public static zzcgb[] zzbad() {
        if (zziyb == null) {
            synchronized (zzehe.zzngo) {
                if (zziyb == null) {
                    zziyb = new zzcgb[0];
                }
            }
        }
        return zziyb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcgb)) {
            return false;
        }
        zzcgb zzcgb = (zzcgb) obj;
        if (this.zzixm == null) {
            if (zzcgb.zzixm != null) {
                return false;
            }
        } else if (!this.zzixm.equals(zzcgb.zzixm)) {
            return false;
        }
        if (this.zziyc == null) {
            if (zzcgb.zziyc != null) {
                return false;
            }
        } else if (!this.zziyc.equals(zzcgb.zziyc)) {
            return false;
        }
        if (this.zziyd == null) {
            if (zzcgb.zziyd != null) {
                return false;
            }
        } else if (!this.zziyd.equals(zzcgb.zziyd)) {
            return false;
        }
        return (this.zzngg == null || this.zzngg.isEmpty()) ? zzcgb.zzngg == null || zzcgb.zzngg.isEmpty() : this.zzngg.equals(zzcgb.zzngg);
    }

    public final int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + (this.zzixm == null ? 0 : this.zzixm.hashCode())) * 31;
        int hashCode2 = this.zziyc == null ? 0 : this.zziyc.hashCode();
        zzcfz zzcfz = this.zziyd;
        return ((((hashCode + hashCode2) * 31) + (zzcfz == null ? 0 : zzcfz.hashCode())) * 31) + ((this.zzngg == null || this.zzngg.isEmpty()) ? 0 : this.zzngg.hashCode());
    }

    @Override // com.google.android.gms.internal.zzehg
    public final /* synthetic */ zzehg zza(zzegx zzegx) {
        while (true) {
            int zzcby = zzegx.zzcby();
            switch (zzcby) {
                case 0:
                    return this;
                case 8:
                    this.zzixm = Integer.valueOf(zzegx.zzccj());
                    break;
                case 18:
                    this.zziyc = zzegx.readString();
                    break;
                case 26:
                    if (this.zziyd == null) {
                        this.zziyd = new zzcfz();
                    }
                    zzegx.zza(this.zziyd);
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
        if (this.zzixm != null) {
            zzegy.zzv(1, this.zzixm.intValue());
        }
        if (this.zziyc != null) {
            zzegy.zzl(2, this.zziyc);
        }
        if (this.zziyd != null) {
            zzegy.zza(3, this.zziyd);
        }
        super.zza(zzegy);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzeha, com.google.android.gms.internal.zzehg
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zzixm != null) {
            zzn += zzegy.zzaf(1, this.zzixm.intValue());
        }
        if (this.zziyc != null) {
            zzn += zzegy.zzm(2, this.zziyc);
        }
        return this.zziyd != null ? zzn + zzegy.zzb(3, this.zziyd) : zzn;
    }
}
