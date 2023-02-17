package com.google.android.gms.internal;
public final class zzcgh extends zzeha<zzcgh> {
    private static volatile zzcgh[] zziyv;
    public Integer count = null;
    public String name = null;
    public zzcgi[] zziyw = zzcgi.zzbai();
    public Long zziyx = null;
    public Long zziyy = null;

    public zzcgh() {
        this.zzngg = null;
        this.zzngp = -1;
    }

    public static zzcgh[] zzbah() {
        if (zziyv == null) {
            synchronized (zzehe.zzngo) {
                if (zziyv == null) {
                    zziyv = new zzcgh[0];
                }
            }
        }
        return zziyv;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcgh)) {
            return false;
        }
        zzcgh zzcgh = (zzcgh) obj;
        if (!zzehe.equals(this.zziyw, zzcgh.zziyw)) {
            return false;
        }
        if (this.name == null) {
            if (zzcgh.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzcgh.name)) {
            return false;
        }
        if (this.zziyx == null) {
            if (zzcgh.zziyx != null) {
                return false;
            }
        } else if (!this.zziyx.equals(zzcgh.zziyx)) {
            return false;
        }
        if (this.zziyy == null) {
            if (zzcgh.zziyy != null) {
                return false;
            }
        } else if (!this.zziyy.equals(zzcgh.zziyy)) {
            return false;
        }
        if (this.count == null) {
            if (zzcgh.count != null) {
                return false;
            }
        } else if (!this.count.equals(zzcgh.count)) {
            return false;
        }
        return (this.zzngg == null || this.zzngg.isEmpty()) ? zzcgh.zzngg == null || zzcgh.zzngg.isEmpty() : this.zzngg.equals(zzcgh.zzngg);
    }

    public final int hashCode() {
        return ((((((((((((getClass().getName().hashCode() + 527) * 31) + zzehe.hashCode(this.zziyw)) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.zziyx == null ? 0 : this.zziyx.hashCode())) * 31) + (this.zziyy == null ? 0 : this.zziyy.hashCode())) * 31) + (this.count == null ? 0 : this.count.hashCode())) * 31) + ((this.zzngg == null || this.zzngg.isEmpty()) ? 0 : this.zzngg.hashCode());
    }

    @Override // com.google.android.gms.internal.zzehg
    public final /* synthetic */ zzehg zza(zzegx zzegx) {
        while (true) {
            int zzcby = zzegx.zzcby();
            switch (zzcby) {
                case 0:
                    return this;
                case 10:
                    int zzb = zzehj.zzb(zzegx, 10);
                    int length = this.zziyw == null ? 0 : this.zziyw.length;
                    int i = length;
                    zzcgi[] zzcgiArr = new zzcgi[(length + zzb)];
                    if (i != 0) {
                        System.arraycopy(this.zziyw, 0, zzcgiArr, 0, i);
                    }
                    while (i < zzcgiArr.length - 1) {
                        zzcgiArr[i] = new zzcgi();
                        zzegx.zza(zzcgiArr[i]);
                        zzegx.zzcby();
                        i++;
                    }
                    zzcgiArr[i] = new zzcgi();
                    zzegx.zza(zzcgiArr[i]);
                    this.zziyw = zzcgiArr;
                    break;
                case 18:
                    this.name = zzegx.readString();
                    break;
                case 24:
                    this.zziyx = Long.valueOf(zzegx.zzcec());
                    break;
                case 32:
                    this.zziyy = Long.valueOf(zzegx.zzcec());
                    break;
                case 40:
                    this.count = Integer.valueOf(zzegx.zzccj());
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
        if (this.zziyw != null && this.zziyw.length > 0) {
            for (int i = 0; i < this.zziyw.length; i++) {
                zzcgi zzcgi = this.zziyw[i];
                if (zzcgi != null) {
                    zzegy.zza(1, zzcgi);
                }
            }
        }
        if (this.name != null) {
            zzegy.zzl(2, this.name);
        }
        if (this.zziyx != null) {
            zzegy.zze(3, this.zziyx.longValue());
        }
        if (this.zziyy != null) {
            zzegy.zze(4, this.zziyy.longValue());
        }
        if (this.count != null) {
            zzegy.zzv(5, this.count.intValue());
        }
        super.zza(zzegy);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzeha, com.google.android.gms.internal.zzehg
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zziyw != null && this.zziyw.length > 0) {
            for (int i = 0; i < this.zziyw.length; i++) {
                zzcgi zzcgi = this.zziyw[i];
                if (zzcgi != null) {
                    zzn += zzegy.zzb(1, zzcgi);
                }
            }
        }
        if (this.name != null) {
            zzn += zzegy.zzm(2, this.name);
        }
        if (this.zziyx != null) {
            zzn += zzegy.zzg(3, this.zziyx.longValue());
        }
        if (this.zziyy != null) {
            zzn += zzegy.zzg(4, this.zziyy.longValue());
        }
        return this.count != null ? zzn + zzegy.zzaf(5, this.count.intValue()) : zzn;
    }
}
