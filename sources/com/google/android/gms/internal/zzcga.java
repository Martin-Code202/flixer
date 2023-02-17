package com.google.android.gms.internal;
public final class zzcga extends zzeha<zzcga> {
    public Integer zzixw = null;
    public Boolean zzixx = null;
    public String zzixy = null;
    public String zzixz = null;
    public String zziya = null;

    public zzcga() {
        this.zzngg = null;
        this.zzngp = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcga)) {
            return false;
        }
        zzcga zzcga = (zzcga) obj;
        if (this.zzixw == null) {
            if (zzcga.zzixw != null) {
                return false;
            }
        } else if (!this.zzixw.equals(zzcga.zzixw)) {
            return false;
        }
        if (this.zzixx == null) {
            if (zzcga.zzixx != null) {
                return false;
            }
        } else if (!this.zzixx.equals(zzcga.zzixx)) {
            return false;
        }
        if (this.zzixy == null) {
            if (zzcga.zzixy != null) {
                return false;
            }
        } else if (!this.zzixy.equals(zzcga.zzixy)) {
            return false;
        }
        if (this.zzixz == null) {
            if (zzcga.zzixz != null) {
                return false;
            }
        } else if (!this.zzixz.equals(zzcga.zzixz)) {
            return false;
        }
        if (this.zziya == null) {
            if (zzcga.zziya != null) {
                return false;
            }
        } else if (!this.zziya.equals(zzcga.zziya)) {
            return false;
        }
        return (this.zzngg == null || this.zzngg.isEmpty()) ? zzcga.zzngg == null || zzcga.zzngg.isEmpty() : this.zzngg.equals(zzcga.zzngg);
    }

    public final int hashCode() {
        return ((((((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzixw == null ? 0 : this.zzixw.intValue())) * 31) + (this.zzixx == null ? 0 : this.zzixx.hashCode())) * 31) + (this.zzixy == null ? 0 : this.zzixy.hashCode())) * 31) + (this.zzixz == null ? 0 : this.zzixz.hashCode())) * 31) + (this.zziya == null ? 0 : this.zziya.hashCode())) * 31) + ((this.zzngg == null || this.zzngg.isEmpty()) ? 0 : this.zzngg.hashCode());
    }

    @Override // com.google.android.gms.internal.zzehg
    public final /* synthetic */ zzehg zza(zzegx zzegx) {
        while (true) {
            int zzcby = zzegx.zzcby();
            switch (zzcby) {
                case 0:
                    return this;
                case 8:
                    int position = zzegx.getPosition();
                    int zzccj = zzegx.zzccj();
                    switch (zzccj) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            this.zzixw = Integer.valueOf(zzccj);
                            continue;
                        default:
                            zzegx.zzhb(position);
                            zza(zzegx, zzcby);
                            continue;
                    }
                case 16:
                    this.zzixx = Boolean.valueOf(zzegx.zzcea());
                    break;
                case 26:
                    this.zzixy = zzegx.readString();
                    break;
                case 34:
                    this.zzixz = zzegx.readString();
                    break;
                case 42:
                    this.zziya = zzegx.readString();
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
        if (this.zzixw != null) {
            zzegy.zzv(1, this.zzixw.intValue());
        }
        if (this.zzixx != null) {
            zzegy.zzl(2, this.zzixx.booleanValue());
        }
        if (this.zzixy != null) {
            zzegy.zzl(3, this.zzixy);
        }
        if (this.zzixz != null) {
            zzegy.zzl(4, this.zzixz);
        }
        if (this.zziya != null) {
            zzegy.zzl(5, this.zziya);
        }
        super.zza(zzegy);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzeha, com.google.android.gms.internal.zzehg
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zzixw != null) {
            zzn += zzegy.zzaf(1, this.zzixw.intValue());
        }
        if (this.zzixx != null) {
            this.zzixx.booleanValue();
            zzn += zzegy.zzgs(2) + 1;
        }
        if (this.zzixy != null) {
            zzn += zzegy.zzm(3, this.zzixy);
        }
        if (this.zzixz != null) {
            zzn += zzegy.zzm(4, this.zzixz);
        }
        return this.zziya != null ? zzn + zzegy.zzm(5, this.zziya) : zzn;
    }
}
