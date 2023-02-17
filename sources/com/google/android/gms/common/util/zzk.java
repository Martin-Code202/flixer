package com.google.android.gms.common.util;
public final class zzk {
    public static String zza(byte[] bArr, int i, int i2, boolean z) {
        if (bArr == null || bArr.length == 0 || i2 <= 0 || i2 > bArr.length) {
            return null;
        }
        StringBuilder sb = new StringBuilder((((i2 + 16) - 1) / 16) * 57);
        int i3 = 0;
        int i4 = i2;
        int i5 = 0;
        while (i4 > 0) {
            if (i3 == 0) {
                if (i2 < 65536) {
                    sb.append(String.format("%04X:", Integer.valueOf(i5)));
                } else {
                    sb.append(String.format("%08X:", Integer.valueOf(i5)));
                }
            } else if (i3 == 8) {
                sb.append(" -");
            }
            sb.append(String.format(" %02X", Integer.valueOf(bArr[i5] & 255)));
            i4--;
            i3++;
            if (i3 == 16 || i4 == 0) {
                sb.append('\n');
                i3 = 0;
            }
            i5++;
        }
        return sb.toString();
    }
}
