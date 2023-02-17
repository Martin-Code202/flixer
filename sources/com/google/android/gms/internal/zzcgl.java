package com.google.android.gms.internal;
public final class zzcgl extends zzeha<zzcgl> {
    public long[] zzjaf = zzehj.zzngv;
    public long[] zzjag = zzehj.zzngv;

    public zzcgl() {
        this.zzngg = null;
        this.zzngp = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcgl)) {
            return false;
        }
        zzcgl zzcgl = (zzcgl) obj;
        if (zzehe.equals(this.zzjaf, zzcgl.zzjaf) && zzehe.equals(this.zzjag, zzcgl.zzjag)) {
            return (this.zzngg == null || this.zzngg.isEmpty()) ? zzcgl.zzngg == null || zzcgl.zzngg.isEmpty() : this.zzngg.equals(zzcgl.zzngg);
        }
        return false;
    }

    public final int hashCode() {
        return ((((((getClass().getName().hashCode() + 527) * 31) + zzehe.hashCode(this.zzjaf)) * 31) + zzehe.hashCode(this.zzjag)) * 31) + ((this.zzngg == null || this.zzngg.isEmpty()) ? 0 : this.zzngg.hashCode());
    }

    @Override // com.google.android.gms.internal.zzehg
    public final /* synthetic */ zzehg zza(zzegx zzegx) {
        while (true) {
            int zzcby = zzegx.zzcby();
            switch (zzcby) {
                case 0:
                    return this;
                case 8:
                    int zzb = zzehj.zzb(zzegx, 8);
                    int length = this.zzjaf == null ? 0 : this.zzjaf.length;
                    int i = length;
                    long[] jArr = new long[(length + zzb)];
                    if (i != 0) {
                        System.arraycopy(this.zzjaf, 0, jArr, 0, i);
                    }
                    while (i < jArr.length - 1) {
                        jArr[i] = zzegx.zzcec();
                        zzegx.zzcby();
                        i++;
                    }
                    jArr[i] = zzegx.zzcec();
                    this.zzjaf = jArr;
                    break;
                case 10:
                    int zzgn = zzegx.zzgn(zzegx.zzccj());
                    int i2 = 0;
                    int position = zzegx.getPosition();
                    while (zzegx.zzcef() > 0) {
                        zzegx.zzcec();
                        i2++;
                    }
                    zzegx.zzhb(position);
                    int length2 = this.zzjaf == null ? 0 : this.zzjaf.length;
                    int i3 = length2;
                    long[] jArr2 = new long[(length2 + i2)];
                    if (i3 != 0) {
                        System.arraycopy(this.zzjaf, 0, jArr2, 0, i3);
                    }
                    while (i3 < jArr2.length) {
                        jArr2[i3] = zzegx.zzcec();
                        i3++;
                    }
                    this.zzjaf = jArr2;
                    zzegx.zzgo(zzgn);
                    break;
                case 16:
                    int zzb2 = zzehj.zzb(zzegx, 16);
                    int length3 = this.zzjag == null ? 0 : this.zzjag.length;
                    int i4 = length3;
                    long[] jArr3 = new long[(length3 + zzb2)];
                    if (i4 != 0) {
                        System.arraycopy(this.zzjag, 0, jArr3, 0, i4);
                    }
                    while (i4 < jArr3.length - 1) {
                        jArr3[i4] = zzegx.zzcec();
                        zzegx.zzcby();
                        i4++;
                    }
                    jArr3[i4] = zzegx.zzcec();
                    this.zzjag = jArr3;
                    break;
                case 18:
                    int zzgn2 = zzegx.zzgn(zzegx.zzccj());
                    int i5 = 0;
                    int position2 = zzegx.getPosition();
                    while (zzegx.zzcef() > 0) {
                        zzegx.zzcec();
                        i5++;
                    }
                    zzegx.zzhb(position2);
                    int length4 = this.zzjag == null ? 0 : this.zzjag.length;
                    int i6 = length4;
                    long[] jArr4 = new long[(length4 + i5)];
                    if (i6 != 0) {
                        System.arraycopy(this.zzjag, 0, jArr4, 0, i6);
                    }
                    while (i6 < jArr4.length) {
                        jArr4[i6] = zzegx.zzcec();
                        i6++;
                    }
                    this.zzjag = jArr4;
                    zzegx.zzgo(zzgn2);
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
        if (this.zzjaf != null && this.zzjaf.length > 0) {
            for (int i = 0; i < this.zzjaf.length; i++) {
                zzegy.zza(1, this.zzjaf[i]);
            }
        }
        if (this.zzjag != null && this.zzjag.length > 0) {
            for (int i2 = 0; i2 < this.zzjag.length; i2++) {
                zzegy.zza(2, this.zzjag[i2]);
            }
        }
        super.zza(zzegy);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzeha, com.google.android.gms.internal.zzehg
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zzjaf != null && this.zzjaf.length > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.zzjaf.length; i2++) {
                i += zzegy.zzcq(this.zzjaf[i2]);
            }
            zzn = zzn + i + (this.zzjaf.length * 1);
        }
        if (this.zzjag == null || this.zzjag.length <= 0) {
            return zzn;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzjag.length; i4++) {
            i3 += zzegy.zzcq(this.zzjag[i4]);
        }
        return zzn + i3 + (this.zzjag.length * 1);
    }
}
