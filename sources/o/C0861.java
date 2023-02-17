package o;
/* renamed from: o.ᔆ  reason: contains not printable characters */
public class C0861 {

    /* renamed from: ʼ  reason: contains not printable characters */
    static final int[] f14706 = new int[10];

    /* renamed from: ˊ  reason: contains not printable characters */
    static final byte[] f14707 = new byte[256];

    /* renamed from: ˋ  reason: contains not printable characters */
    static final int[] f14708 = new int[256];

    /* renamed from: ˎ  reason: contains not printable characters */
    static final byte[] f14709 = new byte[256];

    /* renamed from: ˏ  reason: contains not printable characters */
    static final int[] f14710 = new int[256];

    /* renamed from: ॱ  reason: contains not printable characters */
    static final int[] f14711 = new int[256];

    /* renamed from: ᐝ  reason: contains not printable characters */
    static final int[] f14712 = new int[256];

    static {
        m15548();
        for (int i = 0; i < 256; i++) {
            int i2 = f14709[i] & 255;
            f14707[i2] = (byte) i;
            int i3 = i << 1;
            int i4 = i3;
            if (i3 >= 256) {
                i4 ^= 283;
            }
            int i5 = i4 << 1;
            int i6 = i5;
            if (i5 >= 256) {
                i6 ^= 283;
            }
            int i7 = i6 << 1;
            int i8 = i7;
            if (i7 >= 256) {
                i8 ^= 283;
            }
            int i9 = i8 ^ i;
            int i10 = (((i8 ^ i6) ^ i4) << 24) | (i9 << 16) | ((i9 ^ i6) << 8) | (i9 ^ i4);
            f14708[i2] = i10;
            f14711[i2] = (i10 >>> 8) | (i10 << 24);
            f14710[i2] = (i10 >>> 16) | (i10 << 16);
            f14712[i2] = (i10 >>> 24) | (i10 << 8);
        }
        m15546(283);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    static int[] m15547(byte[] bArr, int i) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException();
        }
        int i2 = (i + 1) * 4;
        int[] iArr = new int[i2];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            i4 = i8 + 1;
            iArr[i5] = (bArr[i4] << 24) | ((bArr[i6] & 255) << 16) | ((bArr[i7] & 255) << 8) | (bArr[i8] & 255);
        }
        int i9 = 4;
        int i10 = 0;
        while (i9 < i2) {
            int i11 = iArr[i9 - 1];
            if (i10 == 0) {
                i10 = 4;
                i3++;
                i11 = ((((f14709[(i11 >>> 16) & 255] << 24) | ((f14709[(i11 >>> 8) & 255] & 255) << 16)) | ((f14709[i11 & 255] & 255) << 8)) | (f14709[i11 >>> 24] & 255)) ^ f14706[i3];
            }
            iArr[i9] = iArr[i9 - 4] ^ i11;
            i9++;
            i10--;
        }
        return iArr;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static int[] m15551(byte[] bArr, int i) {
        return m15552(bArr, m15547(bArr, i), i);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int[] m15552(byte[] bArr, int[] iArr, int i) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException();
        }
        int[] iArr2 = new int[((i + 1) * 4)];
        int i2 = i * 4;
        int i3 = i2 + 1;
        iArr2[0] = iArr[i2];
        int i4 = i3 + 1;
        iArr2[1] = iArr[i3];
        int i5 = i4 + 1;
        iArr2[2] = iArr[i4];
        int i6 = 0 + 1 + 1 + 1 + 1;
        iArr2[3] = iArr[i5];
        int i7 = i5 - 7;
        for (int i8 = 1; i8 < i; i8++) {
            int i9 = i7 + 1;
            int i10 = iArr[i7];
            int i11 = i6 + 1;
            iArr2[i6] = ((f14708[f14709[i10 >>> 24] & 255] ^ f14711[f14709[(i10 >>> 16) & 255] & 255]) ^ f14710[f14709[(i10 >>> 8) & 255] & 255]) ^ f14712[f14709[i10 & 255] & 255];
            int i12 = i9 + 1;
            int i13 = iArr[i9];
            int i14 = i11 + 1;
            iArr2[i11] = ((f14708[f14709[i13 >>> 24] & 255] ^ f14711[f14709[(i13 >>> 16) & 255] & 255]) ^ f14710[f14709[(i13 >>> 8) & 255] & 255]) ^ f14712[f14709[i13 & 255] & 255];
            int i15 = i12 + 1;
            int i16 = iArr[i12];
            int i17 = i14 + 1;
            iArr2[i14] = ((f14708[f14709[i16 >>> 24] & 255] ^ f14711[f14709[(i16 >>> 16) & 255] & 255]) ^ f14710[f14709[(i16 >>> 8) & 255] & 255]) ^ f14712[f14709[i16 & 255] & 255];
            int i18 = iArr[i15];
            i6 = i17 + 1;
            iArr2[i17] = ((f14708[f14709[i18 >>> 24] & 255] ^ f14711[f14709[(i18 >>> 16) & 255] & 255]) ^ f14710[f14709[(i18 >>> 8) & 255] & 255]) ^ f14712[f14709[i18 & 255] & 255];
            i7 = i15 - 7;
        }
        int i19 = i6 + 1;
        int i20 = i7 + 1;
        iArr2[i6] = iArr[i7];
        int i21 = i19 + 1;
        int i22 = i20 + 1;
        iArr2[i19] = iArr[i20];
        iArr2[i21] = iArr[i22];
        iArr2[i21 + 1] = iArr[i22 + 1];
        return iArr2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static byte[][] m15549(int i) {
        byte[][] bArr = new byte[4][];
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i >>> (i2 << 3);
            bArr[i2] = new byte[]{(byte) (i3 & 3), (byte) ((i3 >> 2) & 3), (byte) ((i3 >> 4) & 3), (byte) ((i3 >> 6) & 3)};
        }
        return bArr;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m15548() {
        byte b = 1;
        byte b2 = 1;
        do {
            b = (byte) (((b << 1) ^ b) ^ ((b & 128) != 0 ? 27 : 0));
            byte b3 = (byte) ((b2 << 1) ^ b2);
            byte b4 = (byte) (b3 ^ (b3 << 2));
            byte b5 = (byte) (b4 ^ (b4 << 4));
            b2 = (byte) (b5 ^ ((b5 & 128) != 0 ? (byte) 9 : 0));
            f14709[b & 255] = (byte) (((((b2 ^ 99) ^ m15550(b2, 1)) ^ m15550(b2, 2)) ^ m15550(b2, 3)) ^ m15550(b2, 4));
        } while ((b & 255) != 1);
        f14709[0] = 99;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m15546(int i) {
        int i2 = 1;
        f14706[0] = 16777216;
        for (int i3 = 1; i3 < 10; i3++) {
            int i4 = i2 << 1;
            i2 = i4;
            if (i4 >= 256) {
                i2 ^= i;
            }
            f14706[i3] = i2 << 24;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int m15550(byte b, int i) {
        int i2 = b & 255;
        return (i2 << i) | (i2 >> (8 - i));
    }
}
