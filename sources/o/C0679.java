package o;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Arrays;
/* renamed from: o.ง  reason: contains not printable characters */
public class C0679 extends FilterInputStream {

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f14124 = this.f14125;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f14125;

    /* renamed from: ˋ  reason: contains not printable characters */
    private short f14126;

    /* renamed from: ˎ  reason: contains not printable characters */
    private long[] f14127 = new long[4];

    /* renamed from: ˏ  reason: contains not printable characters */
    private long[] f14128 = new long[4];

    /* renamed from: ॱ  reason: contains not printable characters */
    private int[] f14129 = new int[this.f14125];

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f14130;

    public C0679(InputStream inputStream, int i, int i2, short s, int i3, int i4) {
        super(inputStream);
        this.f14125 = Math.min(Math.max((int) s, 4), 8);
        this.f14127 = C0580.m14701(i ^ i4, this.f14125 ^ i4);
        this.f14128 = C0580.m14701(i2 ^ i4, i3 ^ i4);
        this.f14130 = this.in.read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        m14918();
        int[] iArr = this.f14129;
        int i = this.f14124;
        this.f14124 = i + 1;
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
        return this.f14125 - this.f14124;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m14917() {
        C0580.m14700(this.f14127, this.f14128, this.f14126);
        for (int i = 0; i < this.f14125; i++) {
            int[] iArr = this.f14129;
            iArr[i] = (int) (((long) iArr[i]) ^ ((this.f14127[this.f14126] >> (i << 3)) & 255));
        }
        this.f14126 = (short) ((this.f14126 + 1) % 4);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m14918() {
        if (this.f14124 != this.f14125) {
            return;
        }
        if (this.f14130 == -1) {
            Arrays.fill(this.f14129, -1);
            this.f14124 = 0;
            return;
        }
        this.f14129[0] = this.f14130;
        for (int i = 1; i < this.f14125; i++) {
            this.f14129[i] = this.in.read();
        }
        m14917();
        this.f14130 = this.in.read();
        if (this.f14130 == -1) {
            Arrays.fill(this.f14129, this.f14125 - this.f14129[this.f14125 - 1], this.f14125, -1);
        }
        this.f14124 = 0;
    }
}
