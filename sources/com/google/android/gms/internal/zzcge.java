package com.google.android.gms.internal;
public final class zzcge extends zzeha<zzcge> {
    public String zzilt = null;
    public Long zziyl = null;
    private Integer zziym = null;
    public zzcgf[] zziyn = zzcgf.zzbaf();
    public zzcgd[] zziyo = zzcgd.zzbae();
    public zzcfx[] zziyp = zzcfx.zzbaa();

    public zzcge() {
        this.zzngg = null;
        this.zzngp = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcge)) {
            return false;
        }
        zzcge zzcge = (zzcge) obj;
        if (this.zziyl == null) {
            if (zzcge.zziyl != null) {
                return false;
            }
        } else if (!this.zziyl.equals(zzcge.zziyl)) {
            return false;
        }
        if (this.zzilt == null) {
            if (zzcge.zzilt != null) {
                return false;
            }
        } else if (!this.zzilt.equals(zzcge.zzilt)) {
            return false;
        }
        if (this.zziym == null) {
            if (zzcge.zziym != null) {
                return false;
            }
        } else if (!this.zziym.equals(zzcge.zziym)) {
            return false;
        }
        if (zzehe.equals(this.zziyn, zzcge.zziyn) && zzehe.equals(this.zziyo, zzcge.zziyo) && zzehe.equals(this.zziyp, zzcge.zziyp)) {
            return (this.zzngg == null || this.zzngg.isEmpty()) ? zzcge.zzngg == null || zzcge.zzngg.isEmpty() : this.zzngg.equals(zzcge.zzngg);
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((getClass().getName().hashCode() + 527) * 31) + (this.zziyl == null ? 0 : this.zziyl.hashCode())) * 31) + (this.zzilt == null ? 0 : this.zzilt.hashCode())) * 31) + (this.zziym == null ? 0 : this.zziym.hashCode())) * 31) + zzehe.hashCode(this.zziyn)) * 31) + zzehe.hashCode(this.zziyo)) * 31) + zzehe.hashCode(this.zziyp)) * 31) + ((this.zzngg == null || this.zzngg.isEmpty()) ? 0 : this.zzngg.hashCode());
    }

    @Override // com.google.android.gms.internal.zzehg
    public final /* synthetic */ zzehg zza(zzegx zzegx) {
        while (true) {
            int zzcby = zzegx.zzcby();
            switch (zzcby) {
                case 0:
                    return this;
                case 8:
                    this.zziyl = Long.valueOf(zzegx.zzcec());
                    break;
                case 18:
                    this.zzilt = zzegx.readString();
                    break;
                case 24:
                    this.zziym = Integer.valueOf(zzegx.zzccj());
                    break;
                case 34:
                    int zzb = zzehj.zzb(zzegx, 34);
                    int length = this.zziyn == null ? 0 : this.zziyn.length;
                    int i = length;
                    zzcgf[] zzcgfArr = new zzcgf[(length + zzb)];
                    if (i != 0) {
                        System.arraycopy(this.zziyn, 0, zzcgfArr, 0, i);
                    }
                    while (i < zzcgfArr.length - 1) {
                        zzcgfArr[i] = new zzcgf();
                        zzegx.zza(zzcgfArr[i]);
                        zzegx.zzcby();
                        i++;
                    }
                    zzcgfArr[i] = new zzcgf();
                    zzegx.zza(zzcgfArr[i]);
                    this.zziyn = zzcgfArr;
                    break;
                case 42:
                    int zzb2 = zzehj.zzb(zzegx, 42);
                    int length2 = this.zziyo == null ? 0 : this.zziyo.length;
                    int i2 = length2;
                    zzcgd[] zzcgdArr = new zzcgd[(length2 + zzb2)];
                    if (i2 != 0) {
                        System.arraycopy(this.zziyo, 0, zzcgdArr, 0, i2);
                    }
                    while (i2 < zzcgdArr.length - 1) {
                        zzcgdArr[i2] = new zzcgd();
                        zzegx.zza(zzcgdArr[i2]);
                        zzegx.zzcby();
                        i2++;
                    }
                    zzcgdArr[i2] = new zzcgd();
                    zzegx.zza(zzcgdArr[i2]);
                    this.zziyo = zzcgdArr;
                    break;
                case 50:
                    int zzb3 = zzehj.zzb(zzegx, 50);
                    int length3 = this.zziyp == null ? 0 : this.zziyp.length;
                    int i3 = length3;
                    zzcfx[] zzcfxArr = new zzcfx[(length3 + zzb3)];
                    if (i3 != 0) {
                        System.arraycopy(this.zziyp, 0, zzcfxArr, 0, i3);
                    }
                    while (i3 < zzcfxArr.length - 1) {
                        zzcfxArr[i3] = new zzcfx();
                        zzegx.zza(zzcfxArr[i3]);
                        zzegx.zzcby();
                        i3++;
                    }
                    zzcfxArr[i3] = new zzcfx();
                    zzegx.zza(zzcfxArr[i3]);
                    this.zziyp = zzcfxArr;
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
        if (this.zziyl != null) {
            zzegy.zze(1, this.zziyl.longValue());
        }
        if (this.zzilt != null) {
            zzegy.zzl(2, this.zzilt);
        }
        if (this.zziym != null) {
            zzegy.zzv(3, this.zziym.intValue());
        }
        if (this.zziyn != null && this.zziyn.length > 0) {
            for (int i = 0; i < this.zziyn.length; i++) {
                zzcgf zzcgf = this.zziyn[i];
                if (zzcgf != null) {
                    zzegy.zza(4, zzcgf);
                }
            }
        }
        if (this.zziyo != null && this.zziyo.length > 0) {
            for (int i2 = 0; i2 < this.zziyo.length; i2++) {
                zzcgd zzcgd = this.zziyo[i2];
                if (zzcgd != null) {
                    zzegy.zza(5, zzcgd);
                }
            }
        }
        if (this.zziyp != null && this.zziyp.length > 0) {
            for (int i3 = 0; i3 < this.zziyp.length; i3++) {
                zzcfx zzcfx = this.zziyp[i3];
                if (zzcfx != null) {
                    zzegy.zza(6, zzcfx);
                }
            }
        }
        super.zza(zzegy);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzeha, com.google.android.gms.internal.zzehg
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zziyl != null) {
            zzn += zzegy.zzg(1, this.zziyl.longValue());
        }
        if (this.zzilt != null) {
            zzn += zzegy.zzm(2, this.zzilt);
        }
        if (this.zziym != null) {
            zzn += zzegy.zzaf(3, this.zziym.intValue());
        }
        if (this.zziyn != null && this.zziyn.length > 0) {
            for (int i = 0; i < this.zziyn.length; i++) {
                zzcgf zzcgf = this.zziyn[i];
                if (zzcgf != null) {
                    zzn += zzegy.zzb(4, zzcgf);
                }
            }
        }
        if (this.zziyo != null && this.zziyo.length > 0) {
            for (int i2 = 0; i2 < this.zziyo.length; i2++) {
                zzcgd zzcgd = this.zziyo[i2];
                if (zzcgd != null) {
                    zzn += zzegy.zzb(5, zzcgd);
                }
            }
        }
        if (this.zziyp != null && this.zziyp.length > 0) {
            for (int i3 = 0; i3 < this.zziyp.length; i3++) {
                zzcfx zzcfx = this.zziyp[i3];
                if (zzcfx != null) {
                    zzn += zzegy.zzb(6, zzcfx);
                }
            }
        }
        return zzn;
    }
}
