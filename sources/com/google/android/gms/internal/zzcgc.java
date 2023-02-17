package com.google.android.gms.internal;
public final class zzcgc extends zzeha<zzcgc> {
    public Integer zziye = null;
    public String zziyf = null;
    public Boolean zziyg = null;
    public String[] zziyh = zzehj.EMPTY_STRING_ARRAY;

    public zzcgc() {
        this.zzngg = null;
        this.zzngp = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcgc)) {
            return false;
        }
        zzcgc zzcgc = (zzcgc) obj;
        if (this.zziye == null) {
            if (zzcgc.zziye != null) {
                return false;
            }
        } else if (!this.zziye.equals(zzcgc.zziye)) {
            return false;
        }
        if (this.zziyf == null) {
            if (zzcgc.zziyf != null) {
                return false;
            }
        } else if (!this.zziyf.equals(zzcgc.zziyf)) {
            return false;
        }
        if (this.zziyg == null) {
            if (zzcgc.zziyg != null) {
                return false;
            }
        } else if (!this.zziyg.equals(zzcgc.zziyg)) {
            return false;
        }
        if (!zzehe.equals(this.zziyh, zzcgc.zziyh)) {
            return false;
        }
        return (this.zzngg == null || this.zzngg.isEmpty()) ? zzcgc.zzngg == null || zzcgc.zzngg.isEmpty() : this.zzngg.equals(zzcgc.zzngg);
    }

    public final int hashCode() {
        return ((((((((((getClass().getName().hashCode() + 527) * 31) + (this.zziye == null ? 0 : this.zziye.intValue())) * 31) + (this.zziyf == null ? 0 : this.zziyf.hashCode())) * 31) + (this.zziyg == null ? 0 : this.zziyg.hashCode())) * 31) + zzehe.hashCode(this.zziyh)) * 31) + ((this.zzngg == null || this.zzngg.isEmpty()) ? 0 : this.zzngg.hashCode());
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
                        case 5:
                        case 6:
                            this.zziye = Integer.valueOf(zzccj);
                            continue;
                        default:
                            zzegx.zzhb(position);
                            zza(zzegx, zzcby);
                            continue;
                    }
                case 18:
                    this.zziyf = zzegx.readString();
                    break;
                case 24:
                    this.zziyg = Boolean.valueOf(zzegx.zzcea());
                    break;
                case 34:
                    int zzb = zzehj.zzb(zzegx, 34);
                    int length = this.zziyh == null ? 0 : this.zziyh.length;
                    int i = length;
                    String[] strArr = new String[(length + zzb)];
                    if (i != 0) {
                        System.arraycopy(this.zziyh, 0, strArr, 0, i);
                    }
                    while (i < strArr.length - 1) {
                        strArr[i] = zzegx.readString();
                        zzegx.zzcby();
                        i++;
                    }
                    strArr[i] = zzegx.readString();
                    this.zziyh = strArr;
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
        if (this.zziye != null) {
            zzegy.zzv(1, this.zziye.intValue());
        }
        if (this.zziyf != null) {
            zzegy.zzl(2, this.zziyf);
        }
        if (this.zziyg != null) {
            zzegy.zzl(3, this.zziyg.booleanValue());
        }
        if (this.zziyh != null && this.zziyh.length > 0) {
            for (int i = 0; i < this.zziyh.length; i++) {
                String str = this.zziyh[i];
                if (str != null) {
                    zzegy.zzl(4, str);
                }
            }
        }
        super.zza(zzegy);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzeha, com.google.android.gms.internal.zzehg
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zziye != null) {
            zzn += zzegy.zzaf(1, this.zziye.intValue());
        }
        if (this.zziyf != null) {
            zzn += zzegy.zzm(2, this.zziyf);
        }
        if (this.zziyg != null) {
            this.zziyg.booleanValue();
            zzn += zzegy.zzgs(3) + 1;
        }
        if (this.zziyh == null || this.zziyh.length <= 0) {
            return zzn;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.zziyh.length; i3++) {
            String str = this.zziyh[i3];
            if (str != null) {
                i++;
                i2 += zzegy.zzrk(str);
            }
        }
        return zzn + i2 + (i * 1);
    }
}
