package o;
/* renamed from: o.＿  reason: contains not printable characters */
public final class C1225 {

    /* renamed from: ˏ  reason: contains not printable characters */
    static final int[] f15746 = {2, 1, 4};

    /* renamed from: ˏ  reason: contains not printable characters */
    static int m16564(int[] iArr) {
        int i = 0;
        if (iArr == null) {
            return 0;
        }
        for (int i2 : iArr) {
            i |= i2;
        }
        return i;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static int[] m16565(int i) {
        int i2 = 0;
        int[] iArr = f15746;
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            i2 += (i & i4) == i4 ? 1 : 0;
        }
        int[] iArr2 = new int[i2];
        int i5 = 0;
        int[] iArr3 = f15746;
        for (int i6 : iArr3) {
            if ((i & i6) == i6) {
                i5++;
                iArr2[i5] = i6;
            }
        }
        return iArr2;
    }
}
