package com.google.android.gms.internal;
public final class zzcgi extends zzeha<zzcgi> {
    private static volatile zzcgi[] zziyz;
    public String name = null;
    public String zzfwn = null;
    private Float zzixa = null;
    public Double zzixb = null;
    public Long zziza = null;

    public zzcgi() {
        this.zzngg = null;
        this.zzngp = -1;
    }

    public static zzcgi[] zzbai() {
        if (zziyz == null) {
            synchronized (zzehe.zzngo) {
                if (zziyz == null) {
                    zziyz = new zzcgi[0];
                }
            }
        }
        return zziyz;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcgi)) {
            return false;
        }
        zzcgi zzcgi = (zzcgi) obj;
        if (this.name == null) {
            if (zzcgi.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzcgi.name)) {
            return false;
        }
        if (this.zzfwn == null) {
            if (zzcgi.zzfwn != null) {
                return false;
            }
        } else if (!this.zzfwn.equals(zzcgi.zzfwn)) {
            return false;
        }
        if (this.zziza == null) {
            if (zzcgi.zziza != null) {
                return false;
            }
        } else if (!this.zziza.equals(zzcgi.zziza)) {
            return false;
        }
        if (this.zzixa == null) {
            if (zzcgi.zzixa != null) {
                return false;
            }
        } else if (!this.zzixa.equals(zzcgi.zzixa)) {
            return false;
        }
        if (this.zzixb == null) {
            if (zzcgi.zzixb != null) {
                return false;
            }
        } else if (!this.zzixb.equals(zzcgi.zzixb)) {
            return false;
        }
        return (this.zzngg == null || this.zzngg.isEmpty()) ? zzcgi.zzngg == null || zzcgi.zzngg.isEmpty() : this.zzngg.equals(zzcgi.zzngg);
    }

    public final int hashCode() {
        return ((((((((((((getClass().getName().hashCode() + 527) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.zzfwn == null ? 0 : this.zzfwn.hashCode())) * 31) + (this.zziza == null ? 0 : this.zziza.hashCode())) * 31) + (this.zzixa == null ? 0 : this.zzixa.hashCode())) * 31) + (this.zzixb == null ? 0 : this.zzixb.hashCode())) * 31) + ((this.zzngg == null || this.zzngg.isEmpty()) ? 0 : this.zzngg.hashCode());
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
                case 18:
                    this.zzfwn = zzegx.readString();
                    break;
                case 24:
                    this.zziza = Long.valueOf(zzegx.zzcec());
                    break;
                case 37:
                    this.zzixa = Float.valueOf(Float.intBitsToFloat(zzegx.zzced()));
                    break;
                case 41:
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
        if (this.name != null) {
            zzegy.zzl(1, this.name);
        }
        if (this.zzfwn != null) {
            zzegy.zzl(2, this.zzfwn);
        }
        if (this.zziza != null) {
            zzegy.zze(3, this.zziza.longValue());
        }
        if (this.zzixa != null) {
            zzegy.zzc(4, this.zzixa.floatValue());
        }
        if (this.zzixb != null) {
            zzegy.zza(5, this.zzixb.doubleValue());
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
        if (this.zzfwn != null) {
            zzn += zzegy.zzm(2, this.zzfwn);
        }
        if (this.zziza != null) {
            zzn += zzegy.zzg(3, this.zziza.longValue());
        }
        if (this.zzixa != null) {
            this.zzixa.floatValue();
            zzn += zzegy.zzgs(4) + 4;
        }
        if (this.zzixb == null) {
            return zzn;
        }
        this.zzixb.doubleValue();
        return zzn + zzegy.zzgs(5) + 8;
    }
}
