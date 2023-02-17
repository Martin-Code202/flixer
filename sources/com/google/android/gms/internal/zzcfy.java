package com.google.android.gms.internal;
public final class zzcfy extends zzeha<zzcfy> {
    private static volatile zzcfy[] zzixl;
    public Integer zzixm = null;
    public String zzixn = null;
    public zzcfz[] zzixo = zzcfz.zzbac();
    private Boolean zzixp = null;
    public zzcga zzixq = null;

    public zzcfy() {
        this.zzngg = null;
        this.zzngp = -1;
    }

    public static zzcfy[] zzbab() {
        if (zzixl == null) {
            synchronized (zzehe.zzngo) {
                if (zzixl == null) {
                    zzixl = new zzcfy[0];
                }
            }
        }
        return zzixl;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcfy)) {
            return false;
        }
        zzcfy zzcfy = (zzcfy) obj;
        if (this.zzixm == null) {
            if (zzcfy.zzixm != null) {
                return false;
            }
        } else if (!this.zzixm.equals(zzcfy.zzixm)) {
            return false;
        }
        if (this.zzixn == null) {
            if (zzcfy.zzixn != null) {
                return false;
            }
        } else if (!this.zzixn.equals(zzcfy.zzixn)) {
            return false;
        }
        if (!zzehe.equals(this.zzixo, zzcfy.zzixo)) {
            return false;
        }
        if (this.zzixp == null) {
            if (zzcfy.zzixp != null) {
                return false;
            }
        } else if (!this.zzixp.equals(zzcfy.zzixp)) {
            return false;
        }
        if (this.zzixq == null) {
            if (zzcfy.zzixq != null) {
                return false;
            }
        } else if (!this.zzixq.equals(zzcfy.zzixq)) {
            return false;
        }
        return (this.zzngg == null || this.zzngg.isEmpty()) ? zzcfy.zzngg == null || zzcfy.zzngg.isEmpty() : this.zzngg.equals(zzcfy.zzngg);
    }

    public final int hashCode() {
        int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + (this.zzixm == null ? 0 : this.zzixm.hashCode())) * 31) + (this.zzixn == null ? 0 : this.zzixn.hashCode())) * 31) + zzehe.hashCode(this.zzixo)) * 31;
        int hashCode2 = this.zzixp == null ? 0 : this.zzixp.hashCode();
        zzcga zzcga = this.zzixq;
        return ((((hashCode + hashCode2) * 31) + (zzcga == null ? 0 : zzcga.hashCode())) * 31) + ((this.zzngg == null || this.zzngg.isEmpty()) ? 0 : this.zzngg.hashCode());
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
                    this.zzixn = zzegx.readString();
                    break;
                case 26:
                    int zzb = zzehj.zzb(zzegx, 26);
                    int length = this.zzixo == null ? 0 : this.zzixo.length;
                    int i = length;
                    zzcfz[] zzcfzArr = new zzcfz[(length + zzb)];
                    if (i != 0) {
                        System.arraycopy(this.zzixo, 0, zzcfzArr, 0, i);
                    }
                    while (i < zzcfzArr.length - 1) {
                        zzcfzArr[i] = new zzcfz();
                        zzegx.zza(zzcfzArr[i]);
                        zzegx.zzcby();
                        i++;
                    }
                    zzcfzArr[i] = new zzcfz();
                    zzegx.zza(zzcfzArr[i]);
                    this.zzixo = zzcfzArr;
                    break;
                case 32:
                    this.zzixp = Boolean.valueOf(zzegx.zzcea());
                    break;
                case 42:
                    if (this.zzixq == null) {
                        this.zzixq = new zzcga();
                    }
                    zzegx.zza(this.zzixq);
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
        if (this.zzixn != null) {
            zzegy.zzl(2, this.zzixn);
        }
        if (this.zzixo != null && this.zzixo.length > 0) {
            for (int i = 0; i < this.zzixo.length; i++) {
                zzcfz zzcfz = this.zzixo[i];
                if (zzcfz != null) {
                    zzegy.zza(3, zzcfz);
                }
            }
        }
        if (this.zzixp != null) {
            zzegy.zzl(4, this.zzixp.booleanValue());
        }
        if (this.zzixq != null) {
            zzegy.zza(5, this.zzixq);
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
        if (this.zzixn != null) {
            zzn += zzegy.zzm(2, this.zzixn);
        }
        if (this.zzixo != null && this.zzixo.length > 0) {
            for (int i = 0; i < this.zzixo.length; i++) {
                zzcfz zzcfz = this.zzixo[i];
                if (zzcfz != null) {
                    zzn += zzegy.zzb(3, zzcfz);
                }
            }
        }
        if (this.zzixp != null) {
            this.zzixp.booleanValue();
            zzn += zzegy.zzgs(4) + 1;
        }
        return this.zzixq != null ? zzn + zzegy.zzb(5, this.zzixq) : zzn;
    }
}
