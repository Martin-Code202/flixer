package o;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Arrays;
/* renamed from: o.ܙ  reason: contains not printable characters */
public class C0637 extends FilterInputStream {

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f13947;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int[] f13948 = new int[2];

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f13949;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int[] f13950 = new int[8];

    /* renamed from: ˎ  reason: contains not printable characters */
    private int[] f13951 = new int[8];

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0694 f13952;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int[] f13953 = new int[8];

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f13954 = 8;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f13955;

    public C0637(InputStream inputStream, int[] iArr, byte[] bArr, int i, boolean z, int i2) {
        super(inputStream);
        this.f13949 = Math.min(Math.max(i, 3), 16);
        this.f13947 = i2;
        if (i2 == 2) {
            System.arraycopy(m14773(bArr), 0, this.f13953, 0, 8);
        }
        this.f13952 = new C0694(iArr, this.f13949, true, z);
        this.f13955 = this.in.read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        m14775();
        int[] iArr = this.f13950;
        int i = this.f13954;
        this.f13954 = i + 1;
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
        return 8 - this.f13954;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m14774() {
        if (this.f13947 == 2) {
            System.arraycopy(this.f13950, 0, this.f13951, 0, this.f13950.length);
        }
        C0769.m15220(((this.f13950[0] << 24) & -16777216) + ((this.f13950[1] << 16) & 16711680) + ((this.f13950[2] << 8) & 65280) + (this.f13950[3] & 255), ((this.f13950[4] << 24) & -16777216) + ((this.f13950[5] << 16) & 16711680) + ((this.f13950[6] << 8) & 65280) + (this.f13950[7] & 255), false, this.f13949, this.f13952.f14197, this.f13952.f14199, this.f13948);
        int i = this.f13948[0];
        int i2 = this.f13948[1];
        this.f13950[0] = i >>> 24;
        this.f13950[1] = (i >> 16) & 255;
        this.f13950[2] = (i >> 8) & 255;
        this.f13950[3] = i & 255;
        this.f13950[4] = i2 >>> 24;
        this.f13950[5] = (i2 >> 16) & 255;
        this.f13950[6] = (i2 >> 8) & 255;
        this.f13950[7] = i2 & 255;
        if (this.f13947 == 2) {
            m14772();
            System.arraycopy(this.f13951, 0, this.f13953, 0, this.f13951.length);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m14772() {
        for (int i = 0; i < 8; i++) {
            int[] iArr = this.f13950;
            iArr[i] = (iArr[i] ^ this.f13953[i]) & 255;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private int[] m14773(byte[] bArr) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = bArr[i] & 255;
        }
        return iArr;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m14775() {
        if (this.f13954 != 8) {
            return;
        }
        if (this.f13955 == -1) {
            Arrays.fill(this.f13950, -1);
            this.f13954 = 0;
            return;
        }
        this.f13950[0] = this.f13955;
        for (int i = 1; i < 8; i++) {
            this.f13950[i] = this.in.read();
        }
        m14774();
        this.f13955 = this.in.read();
        if (this.f13955 == -1) {
            Arrays.fill(this.f13950, 8 - this.f13950[7], 8, -1);
        }
        this.f13954 = 0;
    }
}
