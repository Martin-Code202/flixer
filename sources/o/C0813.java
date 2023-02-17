package o;

import java.io.FilterInputStream;
import java.io.InputStream;
/* renamed from: o.ᒼ  reason: contains not printable characters */
public class C0813 extends FilterInputStream {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final int[] f14556 = C0861.f14712;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final int[] f14557 = C0861.f14708;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final int[] f14558 = C0861.f14710;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final byte[] f14559 = C0861.f14707;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final int[] f14560 = C0861.f14711;

    /* renamed from: ʻ  reason: contains not printable characters */
    private final byte[] f14561 = new byte[16];

    /* renamed from: ʼ  reason: contains not printable characters */
    private final int[] f14562 = new int[4];

    /* renamed from: ʽ  reason: contains not printable characters */
    private final byte[][] f14563;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private int f14564 = 16;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private int f14565 = Integer.MAX_VALUE;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f14566 = 16;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final byte[] f14567 = new byte[16];

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final int f14568;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final int[] f14569;

    public C0813(InputStream inputStream, int i, byte[] bArr, byte[][] bArr2) {
        super(inputStream);
        this.f14568 = i;
        this.f14569 = C0861.m15551(bArr, i);
        this.f14563 = m15381(bArr2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        m15379();
        if (this.f14564 >= this.f14566) {
            return -1;
        }
        byte[] bArr = this.f14567;
        int i = this.f14564;
        this.f14564 = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3 = i;
        int i4 = i + i2;
        while (i3 < i4) {
            m15379();
            if (this.f14564 < this.f14566) {
                i3++;
                byte[] bArr2 = this.f14567;
                int i5 = this.f14564;
                this.f14564 = i5 + 1;
                bArr[i3] = bArr2[i5];
            } else if (i3 == i) {
                return -1;
            } else {
                return i2 - (i4 - i3);
            }
        }
        return i2;
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
        return this.f14566 - this.f14564;
    }

    @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() {
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private byte[][] m15381(byte[][] bArr) {
        byte[][] bArr2 = new byte[bArr.length][];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = new byte[bArr[i].length];
            for (int i2 = 0; i2 < bArr[i].length; i2++) {
                bArr2[i][bArr[i][i2]] = (byte) i2;
            }
        }
        return bArr2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private int m15379() {
        int read;
        if (this.f14565 == Integer.MAX_VALUE) {
            this.f14565 = this.in.read();
        }
        if (this.f14564 == 16) {
            this.f14561[0] = (byte) this.f14565;
            int i = 1;
            do {
                read = this.in.read(this.f14561, i, 16 - i) + i;
                i = read;
            } while (read < 16);
            m15380(this.f14561, 0, this.f14567, 0);
            this.f14565 = this.in.read();
            this.f14564 = 0;
            this.f14566 = this.f14565 < 0 ? 16 - (this.f14567[15] & 255) : 16;
        }
        return this.f14566;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m15380(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        this.f14562[0] = ((((bArr[i] << 24) | ((bArr[i3] & 255) << 16)) | ((bArr[i4] & 255) << 8)) | (bArr[i5] & 255)) ^ this.f14569[0];
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = i8 + 1;
        int i10 = i9 + 1;
        this.f14562[1] = ((((bArr[i6] << 24) | ((bArr[i7] & 255) << 16)) | ((bArr[i8] & 255) << 8)) | (bArr[i9] & 255)) ^ this.f14569[1];
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        int i14 = i13 + 1;
        this.f14562[2] = ((((bArr[i10] << 24) | ((bArr[i11] & 255) << 16)) | ((bArr[i12] & 255) << 8)) | (bArr[i13] & 255)) ^ this.f14569[2];
        int i15 = i14 + 1;
        int i16 = i15 + 1;
        this.f14562[3] = ((((bArr[i14] << 24) | ((bArr[i15] & 255) << 16)) | ((bArr[i16] & 255) << 8)) | (bArr[i16 + 1] & 255)) ^ this.f14569[3];
        int i17 = 4;
        int i18 = 1;
        while (i18 < this.f14568) {
            int i19 = (((f14557[this.f14562[this.f14563[0][0]] >>> 24] ^ f14560[(this.f14562[this.f14563[1][0]] >>> 16) & 255]) ^ f14558[(this.f14562[this.f14563[2][0]] >>> 8) & 255]) ^ f14556[this.f14562[this.f14563[3][0]] & 255]) ^ this.f14569[i17];
            int i20 = (((f14557[this.f14562[this.f14563[0][1]] >>> 24] ^ f14560[(this.f14562[this.f14563[1][1]] >>> 16) & 255]) ^ f14558[(this.f14562[this.f14563[2][1]] >>> 8) & 255]) ^ f14556[this.f14562[this.f14563[3][1]] & 255]) ^ this.f14569[i17 + 1];
            int i21 = (((f14557[this.f14562[this.f14563[0][2]] >>> 24] ^ f14560[(this.f14562[this.f14563[1][2]] >>> 16) & 255]) ^ f14558[(this.f14562[this.f14563[2][2]] >>> 8) & 255]) ^ f14556[this.f14562[this.f14563[3][2]] & 255]) ^ this.f14569[i17 + 2];
            int i22 = (((f14557[this.f14562[this.f14563[0][3]] >>> 24] ^ f14560[(this.f14562[this.f14563[1][3]] >>> 16) & 255]) ^ f14558[(this.f14562[this.f14563[2][3]] >>> 8) & 255]) ^ f14556[this.f14562[this.f14563[3][3]] & 255]) ^ this.f14569[i17 + 3];
            this.f14562[0] = i19;
            this.f14562[1] = i20;
            this.f14562[2] = i21;
            this.f14562[3] = i22;
            i18++;
            i17 += 4;
        }
        int i23 = this.f14569[i17];
        int i24 = i2 + 1;
        bArr2[i2] = (byte) (f14559[this.f14562[this.f14563[0][0]] >>> 24] ^ (i23 >>> 24));
        int i25 = i24 + 1;
        bArr2[i24] = (byte) (f14559[(this.f14562[this.f14563[1][0]] >>> 16) & 255] ^ (i23 >>> 16));
        int i26 = i25 + 1;
        bArr2[i25] = (byte) (f14559[(this.f14562[this.f14563[2][0]] >>> 8) & 255] ^ (i23 >>> 8));
        int i27 = i26 + 1;
        bArr2[i26] = (byte) (f14559[this.f14562[this.f14563[3][0]] & 255] ^ i23);
        int i28 = this.f14569[i17 + 1];
        int i29 = i27 + 1;
        bArr2[i27] = (byte) (f14559[this.f14562[this.f14563[0][1]] >>> 24] ^ (i28 >>> 24));
        int i30 = i29 + 1;
        bArr2[i29] = (byte) (f14559[(this.f14562[this.f14563[1][1]] >>> 16) & 255] ^ (i28 >>> 16));
        int i31 = i30 + 1;
        bArr2[i30] = (byte) (f14559[(this.f14562[this.f14563[2][1]] >>> 8) & 255] ^ (i28 >>> 8));
        int i32 = i31 + 1;
        bArr2[i31] = (byte) (f14559[this.f14562[this.f14563[3][1]] & 255] ^ i28);
        int i33 = this.f14569[i17 + 2];
        int i34 = i32 + 1;
        bArr2[i32] = (byte) (f14559[this.f14562[this.f14563[0][2]] >>> 24] ^ (i33 >>> 24));
        int i35 = i34 + 1;
        bArr2[i34] = (byte) (f14559[(this.f14562[this.f14563[1][2]] >>> 16) & 255] ^ (i33 >>> 16));
        int i36 = i35 + 1;
        bArr2[i35] = (byte) (f14559[(this.f14562[this.f14563[2][2]] >>> 8) & 255] ^ (i33 >>> 8));
        int i37 = i36 + 1;
        bArr2[i36] = (byte) (f14559[this.f14562[this.f14563[3][2]] & 255] ^ i33);
        int i38 = this.f14569[i17 + 3];
        int i39 = i37 + 1;
        bArr2[i37] = (byte) (f14559[this.f14562[this.f14563[0][3]] >>> 24] ^ (i38 >>> 24));
        int i40 = i39 + 1;
        bArr2[i39] = (byte) (f14559[(this.f14562[this.f14563[1][3]] >>> 16) & 255] ^ (i38 >>> 16));
        bArr2[i40] = (byte) (f14559[(this.f14562[this.f14563[2][3]] >>> 8) & 255] ^ (i38 >>> 8));
        bArr2[i40 + 1] = (byte) (f14559[this.f14562[this.f14563[3][3]] & 255] ^ i38);
    }
}
