package com.ibm.icu.impl;
public final class UCharacterUtility {
    public static boolean isNonCharacter(int i) {
        if ((65534 & i) == 65534) {
            return true;
        }
        return i >= 64976 && i <= 65007;
    }

    static int toInt(char c, char c2) {
        return (c << 16) | c2;
    }

    static int compareNullTermByteSubString(String str, byte[] bArr, int i, int i2) {
        byte b = 1;
        int length = str.length();
        while (b != 0) {
            b = bArr[i2];
            i2++;
            if (b == 0) {
                break;
            } else if (i == length || str.charAt(i) != ((char) (b & 255))) {
                return -1;
            } else {
                i++;
            }
        }
        return i;
    }

    static int skipNullTermByteSubString(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            byte b = 1;
            while (b != 0) {
                b = bArr[i];
                i++;
            }
        }
        return i;
    }

    static int skipByteSubString(byte[] bArr, int i, int i2, byte b) {
        int i3 = 0;
        while (i3 < i2) {
            if (bArr[i + i3] == b) {
                return i3 + 1;
            }
            i3++;
        }
        return i3;
    }
}
