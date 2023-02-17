package o;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Arrays;
/* renamed from: o.г  reason: contains not printable characters */
public class C0490 extends FilterInputStream {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final short f13584 = ((short) ((int) ((Math.sqrt(5.0d) - 1.0d) * Math.pow(2.0d, 15.0d))));

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f13585;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f13586;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f13587;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int[] f13588 = new int[8];

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private int f13589;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int[] f13590 = new int[8];

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f13591 = 8;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int[] f13592 = new int[8];

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private int f13593;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f13594;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f13595;

    public C0490(InputStream inputStream, int[] iArr, int i, byte[] bArr, int i2, int i3) {
        super(inputStream);
        this.f13585 = Math.min(Math.max(i2, 5), 16);
        this.f13595 = i3;
        if (i3 == 3) {
            this.f13590 = m14454(bArr);
        }
        m14457(((((long) iArr[0]) & 4294967295L) << 32) | (((long) iArr[1]) & 4294967295L), i);
        this.f13594 = this.in.read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        m14458();
        int[] iArr = this.f13588;
        int i = this.f13591;
        this.f13591 = i + 1;
        return iArr[i];
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int read = read();
        if (read == -1) {
            return -1;
        }
        bArr[i] = (byte) read;
        int i3 = 1;
        while (i3 < i2) {
            int read2 = read();
            if (read2 == -1) {
                return i3;
            }
            bArr[i + i3] = (byte) read2;
            i3++;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return 8 - this.f13591;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m14457(long j, int i) {
        if (i == 0) {
            m14455(j);
            return;
        }
        this.f13586 = (int) j;
        this.f13587 = ((int) j) * i;
        this.f13593 = ((int) j) ^ i;
        this.f13589 = (int) (j >> 32);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m14455(long j) {
        this.f13586 = (int) j;
        this.f13587 = (int) (((j >> 3) * ((long) f13584)) >> 32);
        this.f13593 = (int) (j >> 32);
        this.f13589 = (int) ((j >> 3) + ((long) f13584));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m14459() {
        if (this.f13595 == 3) {
            System.arraycopy(this.f13588, 0, this.f13592, 0, this.f13588.length);
        }
        int i = ((this.f13588[0] << 24) & -16777216) + ((this.f13588[1] << 16) & 16711680) + ((this.f13588[2] << 8) & 65280) + (this.f13588[3] & 255);
        int i2 = ((this.f13588[4] << 24) & -16777216) + ((this.f13588[5] << 16) & 16711680) + ((this.f13588[6] << 8) & 65280) + (this.f13588[7] & 255);
        for (int i3 = 0; i3 < this.f13585; i3++) {
            i2 -= (((f13584 * (this.f13585 - i3)) + i) ^ ((i << 4) + this.f13593)) ^ ((i >>> 5) + this.f13589);
            i -= (((f13584 * (this.f13585 - i3)) + i2) ^ ((i2 << 4) + this.f13586)) ^ ((i2 >>> 5) + this.f13587);
        }
        this.f13588[0] = i >>> 24;
        this.f13588[1] = (i >> 16) & 255;
        this.f13588[2] = (i >> 8) & 255;
        this.f13588[3] = i & 255;
        this.f13588[4] = i2 >>> 24;
        this.f13588[5] = (i2 >> 16) & 255;
        this.f13588[6] = (i2 >> 8) & 255;
        this.f13588[7] = i2 & 255;
        if (this.f13595 == 3) {
            m14456();
            System.arraycopy(this.f13592, 0, this.f13590, 0, this.f13592.length);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m14456() {
        for (int i = 0; i < 8; i++) {
            int[] iArr = this.f13588;
            iArr[i] = (iArr[i] ^ this.f13590[i]) & 255;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private int[] m14454(byte[] bArr) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = bArr[i] & 255;
        }
        return iArr;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m14458() {
        if (this.f13591 != 8) {
            return;
        }
        if (this.f13594 == -1) {
            Arrays.fill(this.f13588, -1);
            this.f13591 = 0;
            return;
        }
        this.f13588[0] = this.f13594;
        for (int i = 1; i < 8; i++) {
            this.f13588[i] = this.in.read();
        }
        m14459();
        this.f13594 = this.in.read();
        if (this.f13594 == -1) {
            Arrays.fill(this.f13588, 8 - this.f13588[7], 8, -1);
        }
        this.f13591 = 0;
    }
}
