package com.google.android.gms.internal;
public final class zzcgm extends zzeha<zzcgm> {
    private static volatile zzcgm[] zzjah;
    public String name = null;
    public String zzfwn = null;
    private Float zzixa = null;
    public Double zzixb = null;
    public Long zziza = null;
    public Long zzjai = null;

    public zzcgm() {
        this.zzngg = null;
        this.zzngp = -1;
    }

    public static zzcgm[] zzbak() {
        if (zzjah == null) {
            synchronized (zzehe.zzngo) {
                if (zzjah == null) {
                    zzjah = new zzcgm[0];
                }
            }
        }
        return zzjah;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcgm)) {
            return false;
        }
        zzcgm zzcgm = (zzcgm) obj;
        if (this.zzjai == null) {
            if (zzcgm.zzjai != null) {
                return false;
            }
        } else if (!this.zzjai.equals(zzcgm.zzjai)) {
            return false;
        }
        if (this.name == null) {
            if (zzcgm.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzcgm.name)) {
            return false;
        }
        if (this.zzfwn == null) {
            if (zzcgm.zzfwn != null) {
                return false;
            }
        } else if (!this.zzfwn.equals(zzcgm.zzfwn)) {
            return false;
        }
        if (this.zziza == null) {
            if (zzcgm.zziza != null) {
                return false;
            }
        } else if (!this.zziza.equals(zzcgm.zziza)) {
            return false;
        }
        if (this.zzixa == null) {
            if (zzcgm.zzixa != null) {
                return false;
            }
        } else if (!this.zzixa.equals(zzcgm.zzixa)) {
            return false;
        }
        if (this.zzixb == null) {
            if (zzcgm.zzixb != null) {
                return false;
            }
        } else if (!this.zzixb.equals(zzcgm.zzixb)) {
            return false;
        }
        return (this.zzngg == null || this.zzngg.isEmpty()) ? zzcgm.zzngg == null || zzcgm.zzngg.isEmpty() : this.zzngg.equals(zzcgm.zzngg);
    }

    public final int hashCode() {
        return ((((((((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzjai == null ? 0 : this.zzjai.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.zzfwn == null ? 0 : this.zzfwn.hashCode())) * 31) + (this.zziza == null ? 0 : this.zziza.hashCode())) * 31) + (this.zzixa == null ? 0 : this.zzixa.hashCode())) * 31) + (this.zzixb == null ? 0 : this.zzixb.hashCode())) * 31) + ((this.zzngg == null || this.zzngg.isEmpty()) ? 0 : this.zzngg.hashCode());
    }

    @Override // com.google.android.gms.internal.zzehg
    public final /* synthetic */ zzehg zza(zzegx zzegx) {
        while (true) {
            int zzcby = zzegx.zzcby();
            switch (zzcby) {
                case 0:
                    return this;
                case 8:
                    this.zzjai = Long.valueOf(zzegx.zzcec());
                    break;
                case 18:
                    this.name = zzegx.readString();
                    break;
                case 26:
                    this.zzfwn = zzegx.readString();
                    break;
                case 32:
                    this.zziza = Long.valueOf(zzegx.zzcec());
                    break;
                case 45:
                    this.zzixa = Float.valueOf(Float.intBitsToFloat(zzegx.zzced()));
                    break;
                case 49:
                    this.zzixb = Double.valueOf(Double.longBitsToDouble(zzegx.zzcee()));
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
        if (this.zzjai != null) {
            zzegy.zze(1, this.zzjai.longValue());
        }
        if (this.name != null) {
            zzegy.zzl(2, this.name);
        }
        if (this.zzfwn != null) {
            zzegy.zzl(3, this.zzfwn);
        }
        if (this.zziza != null) {
            zzegy.zze(4, this.zziza.longValue());
        }
        if (this.zzixa != null) {
            zzegy.zzc(5, this.zzixa.floatValue());
        }
        if (this.zzixb != null) {
            zzegy.zza(6, this.zzixb.doubleValue());
        }
        super.zza(zzegy);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzeha, com.google.android.gms.internal.zzehg
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zzjai != null) {
            zzn += zzegy.zzg(1, this.zzjai.longValue());
        }
        if (this.name != null) {
            zzn += zzegy.zzm(2, this.name);
        }
        if (this.zzfwn != null) {
            zzn += zzegy.zzm(3, this.zzfwn);
        }
        if (this.zziza != null) {
            zzn += zzegy.zzg(4, this.zziza.longValue());
        }
        if (this.zzixa != null) {
            this.zzixa.floatValue();
            zzn += zzegy.zzgs(5) + 4;
        }
        if (this.zzixb == null) {
            return zzn;
        }
        this.zzixb.doubleValue();
        return zzn + zzegy.zzgs(6) + 8;
    }
}
