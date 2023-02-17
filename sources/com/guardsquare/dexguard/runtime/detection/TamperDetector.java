package com.guardsquare.dexguard.runtime.detection;

import android.content.Context;
public class TamperDetector {
    private static int c = 0;
    private static int d = 1;
    private static final byte[] e = {124, -12, -113, -110, 4, -26, 16, 46, -64, -11, 60, -41, -20, -18, 5, -16, -3, 39, -39, -5, -7, -19, -5, 40, -40, -8, 2, 8, -1, -8, 25, -52, 4, -5, -18, 8, -1, -8, 22, -42, -11, -18, 5, -19, -2, 1, 0, 49, -58, -17, -4, -11, 10, -14, -11, 65, -26, -49, -4, -11, 10, -24, -1, -3, -20, 31, -22, -7, -13, 5, -11, -3, 29, -49, 6, -6, 16, -22, -24, 7, 9, -5, -11, 2, -14, 2, -18, 7, 3, -3, -12, 41, -60, 0, 10, -19, 8, -1, -8, 12, -26, -12, -8, -7};

    private static String a(int i, int i2, short s) {
        int i3;
        int i4;
        int i5;
        byte[] bArr;
        int i6;
        byte[] bArr2;
        int i7 = c + 65;
        d = i7 % 128;
        switch (i7 % 2 != 0) {
            case false:
                int i8 = i | 2;
                i3 = s + 127;
                bArr = e;
                i6 = 1;
                i4 = i2 + 74;
                bArr2 = new byte[i8];
                i5 = i8 + 4;
                break;
            case true:
            default:
                int i9 = 24 - i;
                i3 = s + 97;
                bArr = e;
                i6 = 0;
                i4 = i2 + 4;
                bArr2 = new byte[i9];
                i5 = i9 - 1;
                break;
        }
        while (true) {
            bArr2[i6] = (byte) i3;
            if (i6 != i5) {
                i6++;
                byte b = bArr[i4];
                int i10 = d + 47;
                c = i10 % 128;
                switch (i10 % 2 == 0) {
                    case false:
                        i4 += 77;
                        i3 = (i3 << b) ^ 81;
                        break;
                    case true:
                    default:
                        i4++;
                        i3 = (i3 - b) - 5;
                        break;
                }
            } else {
                return new String(bArr2, 0).intern();
            }
        }
    }

    public static int checkApk(Context context) {
        int i = (c + 94) - 1;
        d = i % 128;
        if (i % 2 == 0) {
        }
        int checkApk = checkApk(context, 0);
        int i2 = (c + 56) - 1;
        d = i2 % 128;
        switch (i2 % 2 == 0) {
            case false:
                return checkApk;
            case true:
            default:
                Object[] objArr = null;
                int length = objArr.length;
                return checkApk;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:218:0x067a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x02ea A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int checkApk(android.content.Context r14, int r15) {
        /*
        // Method dump skipped, instructions count: 1962
        */
        throw new UnsupportedOperationException("Method not decompiled: com.guardsquare.dexguard.runtime.detection.TamperDetector.checkApk(android.content.Context, int):int");
    }
}
