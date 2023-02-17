package com.google.android.gms.internal;
public final class zzcgd extends zzeha<zzcgd> {
    private static volatile zzcgd[] zziyi;
    public String name = null;
    public Boolean zziyj = null;
    public Boolean zziyk = null;

    public zzcgd() {
        this.zzngg = null;
        this.zzngp = -1;
    }

    public static zzcgd[] zzbae() {
        if (zziyi == null) {
            synchronized (zzehe.zzngo) {
                if (zziyi == null) {
                    zziyi = new zzcgd[0];
                }
            }
        }
        return zziyi;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcgd)) {
            return false;
        }
        zzcgd zzcgd = (zzcgd) obj;
        if (this.name == null) {
            if (zzcgd.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzcgd.name)) {
            return false;
        }
        if (this.zziyj == null) {
            if (zzcgd.zziyj != null) {
                return false;
            }
        } else if (!this.zziyj.equals(zzcgd.zziyj)) {
            return false;
        }
        if (this.zziyk == null) {
            if (zzcgd.zziyk != null) {
                return false;
            }
        } else if (!this.zziyk.equals(zzcgd.zziyk)) {
            return false;
        }
        return (this.zzngg == null || this.zzngg.isEmpty()) ? zzcgd.zzngg == null || zzcgd.zzngg.isEmpty() : this.zzngg.equals(zzcgd.zzngg);
    }

    public final int hashCode() {
        return ((((((((getClass().getName().hashCode() + 527) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.zziyj == null ? 0 : this.zziyj.hashCode())) * 31) + (this.zziyk == null ? 0 : this.zziyk.hashCode())) * 31) + ((this.zzngg == null || this.zzngg.isEmpty()) ? 0 : this.zzngg.hashCode());
    }

    @Override // com.google.android.gms.internal.zzehg
    public final /* synthetic */ zzehg zza(zzegx zzegx) {
        while (true) {
            int zzcby = zzegx.zzcby();
            switch (zzcby) {
                case 0:
                    return this;
                case 10:
                    this.name = zzegx.readString();
                    break;
                case 16:
                    this.zziyj = Boolean.valueOf(zzegx.zzcea());
                    break;
                case 24:
                    this.zziyk = Boolean.valueOf(zzegx.zzcea());
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
        if (this.name != null) {
            zzegy.zzl(1, this.name);
        }
        if (this.zziyj != null) {
            zzegy.zzl(2, this.zziyj.booleanValue());
        }
        if (this.zziyk != null) {
            zzegy.zzl(3, this.zziyk.booleanValue());
        }
        super.zza(zzegy);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzeha, com.google.android.gms.internal.zzehg
    public final int zzn() {
        int zzn = super.zzn();
        if (this.name != null) {
            zzn += zzegy.zzm(1, this.name);
        }
        if (this.zziyj != null) {
            this.zziyj.booleanValue();
            zzn += zzegy.zzgs(2) + 1;
        }
        if (this.zziyk == null) {
            return zzn;
        }
        this.zziyk.booleanValue();
        return zzn + zzegy.zzgs(3) + 1;
    }
}
