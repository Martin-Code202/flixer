package com.google.android.gms.internal;
public final class zzcgg extends zzeha<zzcgg> {
    private static volatile zzcgg[] zziyr;
    public Integer zzixi = null;
    public zzcgl zziys = null;
    public zzcgl zziyt = null;
    public Boolean zziyu = null;

    public zzcgg() {
        this.zzngg = null;
        this.zzngp = -1;
    }

    public static zzcgg[] zzbag() {
        if (zziyr == null) {
            synchronized (zzehe.zzngo) {
                if (zziyr == null) {
                    zziyr = new zzcgg[0];
                }
            }
        }
        return zziyr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcgg)) {
            return false;
        }
        zzcgg zzcgg = (zzcgg) obj;
        if (this.zzixi == null) {
            if (zzcgg.zzixi != null) {
                return false;
            }
        } else if (!this.zzixi.equals(zzcgg.zzixi)) {
            return false;
        }
        if (this.zziys == null) {
            if (zzcgg.zziys != null) {
                return false;
            }
        } else if (!this.zziys.equals(zzcgg.zziys)) {
            return false;
        }
        if (this.zziyt == null) {
            if (zzcgg.zziyt != null) {
                return false;
            }
        } else if (!this.zziyt.equals(zzcgg.zziyt)) {
            return false;
        }
        if (this.zziyu == null) {
            if (zzcgg.zziyu != null) {
                return false;
            }
        } else if (!this.zziyu.equals(zzcgg.zziyu)) {
            return false;
        }
        return (this.zzngg == null || this.zzngg.isEmpty()) ? zzcgg.zzngg == null || zzcgg.zzngg.isEmpty() : this.zzngg.equals(zzcgg.zzngg);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        int hashCode2 = this.zzixi == null ? 0 : this.zzixi.hashCode();
        zzcgl zzcgl = this.zziys;
        int i = (hashCode + hashCode2) * 31;
        int hashCode3 = zzcgl == null ? 0 : zzcgl.hashCode();
        zzcgl zzcgl2 = this.zziyt;
        return ((((((i + hashCode3) * 31) + (zzcgl2 == null ? 0 : zzcgl2.hashCode())) * 31) + (this.zziyu == null ? 0 : this.zziyu.hashCode())) * 31) + ((this.zzngg == null || this.zzngg.isEmpty()) ? 0 : this.zzngg.hashCode());
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
                    if (this.zziys == null) {
                        this.zziys = new zzcgl();
                    }
                    zzegx.zza(this.zziys);
                    break;
                case 26:
                    if (this.zziyt == null) {
                        this.zziyt = new zzcgl();
                    }
                    zzegx.zza(this.zziyt);
                    break;
                case 32:
                    this.zziyu = Boolean.valueOf(zzegx.zzcea());
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
        if (this.zziys != null) {
            zzegy.zza(2, this.zziys);
        }
        if (this.zziyt != null) {
            zzegy.zza(3, this.zziyt);
        }
        if (this.zziyu != null) {
            zzegy.zzl(4, this.zziyu.booleanValue());
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
        if (this.zziys != null) {
            zzn += zzegy.zzb(2, this.zziys);
        }
        if (this.zziyt != null) {
            zzn += zzegy.zzb(3, this.zziyt);
        }
        if (this.zziyu == null) {
            return zzn;
        }
        this.zziyu.booleanValue();
        return zzn + zzegy.zzgs(4) + 1;
    }
}
