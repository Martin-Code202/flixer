package com.google.android.gms.internal;
public final class zzcgf extends zzeha<zzcgf> {
    private static volatile zzcgf[] zziyq;
    public String key = null;
    public String value = null;

    public zzcgf() {
        this.zzngg = null;
        this.zzngp = -1;
    }

    public static zzcgf[] zzbaf() {
        if (zziyq == null) {
            synchronized (zzehe.zzngo) {
                if (zziyq == null) {
                    zziyq = new zzcgf[0];
                }
            }
        }
        return zziyq;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcgf)) {
            return false;
        }
        zzcgf zzcgf = (zzcgf) obj;
        if (this.key == null) {
            if (zzcgf.key != null) {
                return false;
            }
        } else if (!this.key.equals(zzcgf.key)) {
            return false;
        }
        if (this.value == null) {
            if (zzcgf.value != null) {
                return false;
            }
        } else if (!this.value.equals(zzcgf.value)) {
            return false;
        }
        return (this.zzngg == null || this.zzngg.isEmpty()) ? zzcgf.zzngg == null || zzcgf.zzngg.isEmpty() : this.zzngg.equals(zzcgf.zzngg);
    }

    public final int hashCode() {
        return ((((((getClass().getName().hashCode() + 527) * 31) + (this.key == null ? 0 : this.key.hashCode())) * 31) + (this.value == null ? 0 : this.value.hashCode())) * 31) + ((this.zzngg == null || this.zzngg.isEmpty()) ? 0 : this.zzngg.hashCode());
    }

    @Override // com.google.android.gms.internal.zzehg
    public final /* synthetic */ zzehg zza(zzegx zzegx) {
        while (true) {
            int zzcby = zzegx.zzcby();
            switch (zzcby) {
                case 0:
                    return this;
                case 10:
                    this.key = zzegx.readString();
                    break;
                case 18:
                    this.value = zzegx.readString();
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
        if (this.key != null) {
            zzegy.zzl(1, this.key);
        }
        if (this.value != null) {
            zzegy.zzl(2, this.value);
        }
        super.zza(zzegy);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzeha, com.google.android.gms.internal.zzehg
    public final int zzn() {
        int zzn = super.zzn();
        if (this.key != null) {
            zzn += zzegy.zzm(1, this.key);
        }
        return this.value != null ? zzn + zzegy.zzm(2, this.value) : zzn;
    }
}
