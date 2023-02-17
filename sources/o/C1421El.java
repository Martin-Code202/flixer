package o;

import java.nio.charset.StandardCharsets;
import o.C1418Ei;
/* renamed from: o.El  reason: case insensitive filesystem */
public class C1421El implements C1418Ei.AbstractC0086 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final char[] f5540 = m4902();

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final byte[] f5541 = m4903();

    /* renamed from: ˏ  reason: contains not printable characters */
    private static char[] m4902() {
        char[] cArr = new char[64];
        for (int i = 0; i < 26; i++) {
            cArr[i] = (char) (i + 65);
        }
        for (int i2 = 26; i2 < 52; i2++) {
            cArr[i2] = (char) ((i2 - 26) + 97);
        }
        for (int i3 = 52; i3 < 62; i3++) {
            cArr[i3] = (char) ((i3 - 52) + 48);
        }
        cArr[62] = '+';
        cArr[63] = '/';
        return cArr;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static byte[] m4903() {
        byte[] bArr = new byte[128];
        for (int i = 0; i < 128; i++) {
            bArr[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            bArr[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            bArr[i3] = (byte) ((i3 - 97) + 26);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            bArr[i4] = (byte) ((i4 - 48) + 52);
        }
        bArr[43] = 62;
        bArr[47] = 63;
        bArr[61] = Byte.MAX_VALUE;
        return bArr;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static char m4901(int i) {
        return f5540[i & 63];
    }

    @Override // o.C1418Ei.AbstractC0086
    /* renamed from: ˏ */
    public String mo4896(byte[] bArr) {
        char[] cArr = new char[(((bArr.length + 2) / 3) * 4)];
        int i = 0;
        int length = bArr.length;
        int i2 = 0;
        while (length >= 3) {
            int i3 = i + 1;
            cArr[i] = m4901(bArr[i2] >> 2);
            int i4 = i3 + 1;
            cArr[i3] = m4901(((bArr[i2] & 3) << 4) | ((bArr[i2 + 1] >> 4) & 15));
            int i5 = i4 + 1;
            cArr[i4] = m4901(((bArr[i2 + 1] & 15) << 2) | ((bArr[i2 + 2] >> 6) & 3));
            i = i5 + 1;
            cArr[i5] = m4901(bArr[i2 + 2] & 63);
            length -= 3;
            i2 += 3;
        }
        if (length == 1) {
            int i6 = i + 1;
            cArr[i] = m4901(bArr[i2] >> 2);
            int i7 = i6 + 1;
            cArr[i6] = m4901((bArr[i2] & 3) << 4);
            int i8 = i7 + 1;
            cArr[i7] = '=';
            int i9 = i8 + 1;
            cArr[i8] = '=';
        } else if (length == 2) {
            int i10 = i + 1;
            cArr[i] = m4901(bArr[i2] >> 2);
            int i11 = i10 + 1;
            cArr[i10] = m4901(((bArr[i2] & 3) << 4) | ((bArr[i2 + 1] >> 4) & 15));
            int i12 = i11 + 1;
            cArr[i11] = m4901((bArr[i2 + 1] & 15) << 2);
            int i13 = i12 + 1;
            cArr[i12] = '=';
        }
        return new String(cArr);
    }

    @Override // o.C1418Ei.AbstractC0086
    /* renamed from: ˋ */
    public byte[] mo4895(String str) {
        boolean z = false;
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        int length = bytes.length;
        byte[] bArr = new byte[((length * 3) / 4)];
        int i = 0;
        byte[] bArr2 = new byte[4];
        int i2 = 0;
        boolean z2 = false;
        for (byte b : bytes) {
            if (b < 0) {
                z = true;
            } else {
                byte b2 = f5541[b];
                if (b2 != -1) {
                    if (z2) {
                        z = true;
                    }
                    i2++;
                    bArr2[i2] = b2;
                    if (i2 == 4) {
                        if (bArr2[0] == Byte.MAX_VALUE || bArr2[1] == Byte.MAX_VALUE) {
                            z = true;
                        }
                        if (bArr2[2] == Byte.MAX_VALUE || bArr2[3] == Byte.MAX_VALUE) {
                            z2 = true;
                        }
                        i++;
                        bArr[i] = (byte) ((bArr2[0] << 2) | (bArr2[1] >> 4));
                        if (bArr2[2] != Byte.MAX_VALUE) {
                            i++;
                            bArr[i] = (byte) ((bArr2[1] << 4) | (bArr2[2] >> 2));
                        }
                        if (bArr2[3] != Byte.MAX_VALUE) {
                            i++;
                            bArr[i] = (byte) ((bArr2[2] << 6) | bArr2[3]);
                        }
                        i2 = 0;
                    }
                } else if (!(b == 32 || b == 9 || b == 10 || b == 13)) {
                    z = true;
                }
            }
        }
        if (i2 != 0) {
            z = true;
        }
        if (z) {
            throw new IllegalArgumentException("Invalid Base64 encoded string: " + str);
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr, 0, bArr3, 0, i);
        return bArr3;
    }
}
