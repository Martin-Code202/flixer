package o;
/* renamed from: o.ᒄ  reason: contains not printable characters */
public class C0769 {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m15220(int i, int i2, boolean z, int i3, int[] iArr, int[][] iArr2, int[] iArr3) {
        if (!z) {
            m15222(iArr);
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4] ^ i;
            i = i2 ^ m15221(i5, iArr2);
            i2 = i5;
        }
        int i6 = i ^ iArr[iArr.length - 2];
        int i7 = i2 ^ iArr[iArr.length - 1];
        if (!z) {
            m15222(iArr);
        }
        iArr3[0] = i7;
        iArr3[1] = i6;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m15222(int[] iArr) {
        for (int i = 0; i < iArr.length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(iArr.length - i) - 1];
            iArr[(iArr.length - i) - 1] = i2;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int m15221(int i, int[][] iArr) {
        return ((iArr[0][i >>> 24] + iArr[1][(i >>> 16) & 255]) ^ iArr[2][(i >>> 8) & 255]) + iArr[3][i & 255];
    }
}
