package org.bouncycastle.util;
public final class Arrays {
    public static void fill(byte[] bArr, byte b) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = b;
        }
    }
}
