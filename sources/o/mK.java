package o;

import java.io.DataInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.UUID;
public final class mK {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static short m8839(byte b) {
        return (short) (b & 255);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static long m8840(byte[] bArr) {
        if (bArr != null && bArr.length >= 4) {
            return m8837(bArr, 0);
        }
        throw new IllegalArgumentException("Byte array is bad!");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static long m8837(byte[] bArr, int i) {
        return 0 | ((long) ((bArr[i + 0] << 24) & -16777216)) | ((long) ((bArr[i + 1] << 16) & 16711680)) | ((long) ((bArr[i + 2] << 8) & 65280)) | ((long) (bArr[i + 3] & 255));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static long m8841(byte[] bArr) {
        return m8842(bArr, 0);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static long m8842(byte[] bArr, int i) {
        long j = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            j |= ((long) (bArr[i2 + i] & 255)) << (56 - (i2 * 8));
        }
        return j;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static byte[] m8845(DataInputStream dataInputStream, int i) {
        byte[] bArr = new byte[i];
        dataInputStream.read(bArr);
        return bArr;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static UUID m8838(DataInputStream dataInputStream) {
        byte[] bArr = new byte[16];
        dataInputStream.read(bArr);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        UUID uuid = new UUID(wrap.getLong(), wrap.getLong());
        C1283.m16854("nf_subtitles_imv2", "readUUID: " + uuid);
        return uuid;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final String m8843(byte[] bArr) {
        return m8844(bArr, "UTF-8");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final String m8844(byte[] bArr, String str) {
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
