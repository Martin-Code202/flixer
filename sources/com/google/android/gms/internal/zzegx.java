package com.google.android.gms.internal;
public final class zzegx {
    private final byte[] buffer;
    private int zznbj;
    private int zznbk = 64;
    private int zznbl = 67108864;
    private int zznbp;
    private int zznbr;
    private int zznbs = Integer.MAX_VALUE;
    private int zzngc;
    private int zzngd;
    private int zznge;

    private zzegx(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzngc = i;
        this.zzngd = i + i2;
        this.zznge = i;
    }

    private final void zzcck() {
        this.zzngd += this.zznbp;
        int i = this.zzngd;
        if (i > this.zznbs) {
            this.zznbp = i - this.zznbs;
            this.zzngd -= this.zznbp;
            return;
        }
        this.zznbp = 0;
    }

    private final byte zzceg() {
        if (this.zznge == this.zzngd) {
            throw zzehf.zzcek();
        }
        byte[] bArr = this.buffer;
        int i = this.zznge;
        this.zznge = i + 1;
        return bArr[i];
    }

    public static zzegx zzh(byte[] bArr, int i, int i2) {
        return new zzegx(bArr, 0, i2);
    }

    private final void zzhc(int i) {
        if (i < 0) {
            throw zzehf.zzcel();
        } else if (this.zznge + i > this.zznbs) {
            zzhc(this.zznbs - this.zznge);
            throw zzehf.zzcek();
        } else if (i <= this.zzngd - this.zznge) {
            this.zznge += i;
        } else {
            throw zzehf.zzcek();
        }
    }

    public final int getPosition() {
        return this.zznge - this.zzngc;
    }

    public final String readString() {
        int zzccj = zzccj();
        if (zzccj < 0) {
            throw zzehf.zzcel();
        } else if (zzccj > this.zzngd - this.zznge) {
            throw zzehf.zzcek();
        } else {
            String str = new String(this.buffer, this.zznge, zzccj, zzehe.UTF_8);
            this.zznge += zzccj;
            return str;
        }
    }

    public final void zza(zzehg zzehg) {
        int zzccj = zzccj();
        if (this.zznbj >= this.zznbk) {
            throw zzehf.zzcen();
        }
        int zzgn = zzgn(zzccj);
        this.zznbj++;
        zzehg.zza(this);
        zzgm(0);
        this.zznbj--;
        zzgo(zzgn);
    }

    public final byte[] zzad(int i, int i2) {
        if (i2 == 0) {
            return zzehj.zznha;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzngc + i, bArr, 0, i2);
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public final void zzae(int i, int i2) {
        if (i > this.zznge - this.zzngc) {
            throw new IllegalArgumentException(new StringBuilder(50).append("Position ").append(i).append(" is beyond current ").append(this.zznge - this.zzngc).toString());
        } else if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(24).append("Bad position ").append(i).toString());
        } else {
            this.zznge = this.zzngc + i;
            this.zznbr = i2;
        }
    }

    public final int zzcby() {
        if (this.zznge == this.zzngd) {
            this.zznbr = 0;
            return 0;
        }
        this.zznbr = zzccj();
        if (this.zznbr != 0) {
            return this.zznbr;
        }
        throw new zzehf("Protocol message contained an invalid tag (zero).");
    }

    public final long zzcbz() {
        return zzcec();
    }

    public final int zzccj() {
        byte zzceg = zzceg();
        if (zzceg >= 0) {
            return zzceg;
        }
        int i = zzceg & Byte.MAX_VALUE;
        byte zzceg2 = zzceg();
        if (zzceg2 >= 0) {
            return i | (zzceg2 << 7);
        }
        int i2 = i | ((zzceg2 & Byte.MAX_VALUE) << 7);
        byte zzceg3 = zzceg();
        if (zzceg3 >= 0) {
            return i2 | (zzceg3 << 14);
        }
        int i3 = i2 | ((zzceg3 & Byte.MAX_VALUE) << 14);
        byte zzceg4 = zzceg();
        if (zzceg4 >= 0) {
            return i3 | (zzceg4 << 21);
        }
        byte zzceg5 = zzceg();
        int i4 = ((zzceg4 & Byte.MAX_VALUE) << 21) | i3 | (zzceg5 << 28);
        if (zzceg5 >= 0) {
            return i4;
        }
        for (int i5 = 0; i5 < 5; i5++) {
            if (zzceg() >= 0) {
                return i4;
            }
        }
        throw zzehf.zzcem();
    }

    public final int zzcdz() {
        return zzccj();
    }

    public final boolean zzcea() {
        return zzccj() != 0;
    }

    public final long zzcec() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzceg = zzceg();
            j |= ((long) (zzceg & Byte.MAX_VALUE)) << i;
            if ((zzceg & 128) == 0) {
                return j;
            }
        }
        throw zzehf.zzcem();
    }

    public final int zzced() {
        return (zzceg() & 255) | ((zzceg() & 255) << 8) | ((zzceg() & 255) << 16) | ((zzceg() & 255) << 24);
    }

    public final long zzcee() {
        return (((long) zzceg()) & 255) | ((((long) zzceg()) & 255) << 8) | ((((long) zzceg()) & 255) << 16) | ((((long) zzceg()) & 255) << 24) | ((((long) zzceg()) & 255) << 32) | ((((long) zzceg()) & 255) << 40) | ((((long) zzceg()) & 255) << 48) | ((((long) zzceg()) & 255) << 56);
    }

    public final int zzcef() {
        if (this.zznbs == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zznbs - this.zznge;
    }

    public final void zzgm(int i) {
        if (this.zznbr != i) {
            throw new zzehf("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final int zzgn(int i) {
        if (i < 0) {
            throw zzehf.zzcel();
        }
        int i2 = i + this.zznge;
        int i3 = this.zznbs;
        if (i2 > i3) {
            throw zzehf.zzcek();
        }
        this.zznbs = i2;
        zzcck();
        return i3;
    }

    public final void zzgo(int i) {
        this.zznbs = i;
        zzcck();
    }

    public final boolean zzha(int i) {
        int zzcby;
        switch (i & 7) {
            case 0:
                zzccj();
                return true;
            case 1:
                zzcee();
                return true;
            case 2:
                zzhc(zzccj());
                return true;
            case 3:
                do {
                    zzcby = zzcby();
                    if (zzcby != 0) {
                    }
                    zzgm(((i >>> 3) << 3) | 4);
                    return true;
                } while (zzha(zzcby));
                zzgm(((i >>> 3) << 3) | 4);
                return true;
            case 4:
                return false;
            case 5:
                zzced();
                return true;
            default:
                throw new zzehf("Protocol message tag had invalid wire type.");
        }
    }

    public final void zzhb(int i) {
        zzae(i, this.zznbr);
    }
}
