package com.google.android.gms.internal;
public final class zzehc implements Cloneable {
    private static final zzehd zzngi = new zzehd();
    private int mSize;
    private boolean zzngj;
    private int[] zzngk;
    private zzehd[] zzngl;

    zzehc() {
        this(10);
    }

    private zzehc(int i) {
        this.zzngj = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzngk = new int[idealIntArraySize];
        this.zzngl = new zzehd[idealIntArraySize];
        this.mSize = 0;
    }

    private static int idealIntArraySize(int i) {
        int i2;
        int i3 = i << 2;
        int i4 = 4;
        while (true) {
            if (i4 >= 32) {
                i2 = i3;
                break;
            } else if (i3 <= (1 << i4) - 12) {
                i2 = (1 << i4) - 12;
                break;
            } else {
                i4++;
            }
        }
        return i2 / 4;
    }

    private final int zzhk(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzngk[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    @Override // java.lang.Object
    public final /* synthetic */ Object clone() {
        int i = this.mSize;
        zzehc zzehc = new zzehc(i);
        System.arraycopy(this.zzngk, 0, zzehc.zzngk, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzngl[i2] != null) {
                zzehc.zzngl[i2] = (zzehd) this.zzngl[i2].clone();
            }
        }
        zzehc.mSize = i;
        return zzehc;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzehc)) {
            return false;
        }
        zzehc zzehc = (zzehc) obj;
        if (this.mSize != zzehc.mSize) {
            return false;
        }
        int[] iArr = this.zzngk;
        int[] iArr2 = zzehc.zzngk;
        int i = this.mSize;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            } else if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            return false;
        }
        zzehd[] zzehdArr = this.zzngl;
        zzehd[] zzehdArr2 = zzehc.zzngl;
        int i3 = this.mSize;
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                z2 = true;
                break;
            } else if (!zzehdArr[i4].equals(zzehdArr2[i4])) {
                z2 = false;
                break;
            } else {
                i4++;
            }
        }
        return z2;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzngk[i2]) * 31) + this.zzngl[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    /* access modifiers changed from: package-private */
    public final int size() {
        return this.mSize;
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, zzehd zzehd) {
        int zzhk = zzhk(i);
        if (zzhk >= 0) {
            this.zzngl[zzhk] = zzehd;
            return;
        }
        int i2 = zzhk ^ -1;
        if (i2 >= this.mSize || this.zzngl[i2] != zzngi) {
            if (this.mSize >= this.zzngk.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                zzehd[] zzehdArr = new zzehd[idealIntArraySize];
                System.arraycopy(this.zzngk, 0, iArr, 0, this.zzngk.length);
                System.arraycopy(this.zzngl, 0, zzehdArr, 0, this.zzngl.length);
                this.zzngk = iArr;
                this.zzngl = zzehdArr;
            }
            if (this.mSize - i2 != 0) {
                System.arraycopy(this.zzngk, i2, this.zzngk, i2 + 1, this.mSize - i2);
                System.arraycopy(this.zzngl, i2, this.zzngl, i2 + 1, this.mSize - i2);
            }
            this.zzngk[i2] = i;
            this.zzngl[i2] = zzehd;
            this.mSize++;
            return;
        }
        this.zzngk[i2] = i;
        this.zzngl[i2] = zzehd;
    }

    /* access modifiers changed from: package-private */
    public final zzehd zzhi(int i) {
        int zzhk = zzhk(i);
        if (zzhk < 0 || this.zzngl[zzhk] == zzngi) {
            return null;
        }
        return this.zzngl[zzhk];
    }

    /* access modifiers changed from: package-private */
    public final zzehd zzhj(int i) {
        return this.zzngl[i];
    }
}
