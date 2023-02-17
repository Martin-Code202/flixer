package o;

import android.util.Base64;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* renamed from: o.Ax  reason: case insensitive filesystem */
public final class C1324Ax {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final int[] f4562 = {1, 10, 100, 1000, SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS, 100000, 1000000, 10000000, 100000000};

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final int[] f4563 = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m3812(String str) {
        return m3822(str.getBytes());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m3821(String str) {
        return new String(m3819(str));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static byte[] m3819(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = Integer.valueOf(str.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return bArr;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m3822(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            m3817(sb, b);
        }
        return sb.toString();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m3817(StringBuilder sb, byte b) {
        sb.append("0123456789ABCDEF".charAt((b >> 4) & 15)).append("0123456789ABCDEF".charAt(b & 15));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m3813(byte[] bArr, String str) {
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(new SecretKeySpec(str.getBytes("UTF-8"), "HmacSHA256"));
        return m3822(instance.doFinal(bArr));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m3815(String str, String str2) {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.update(m3820(str, str2));
        return m3822(instance.digest());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static byte[] m3820(String str, String str2) {
        byte[] bArr;
        byte[] bArr2;
        if (str.length() >= str2.length()) {
            bArr2 = str.getBytes();
            bArr = str2.getBytes();
        } else {
            bArr2 = str2.getBytes();
            bArr = str.getBytes();
        }
        int min = Math.min(bArr2.length, bArr.length);
        for (int i = 0; i < min; i++) {
            bArr2[i] = (byte) (bArr2[i] | bArr[i]);
        }
        return bArr2;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static byte[] m3811(byte[] bArr, int i) {
        if (bArr == null) {
            throw new IllegalArgumentException("Input array is null!");
        }
        C1283.m16854("nf_crypto", "Array size: " + bArr.length);
        C1283.m16854("nf_crypto", "Block size: " + i);
        byte length = (byte) (i - (bArr.length % i));
        C1283.m16854("nf_crypto", "Padding: " + ((int) length));
        byte[] bArr2 = new byte[(bArr.length + length)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = bArr[i2];
        }
        for (int i3 = 0; i3 < length; i3++) {
            bArr2[bArr.length + i3] = length;
        }
        return bArr2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static byte[] m3814(byte[] bArr, int i) {
        if (bArr == null || bArr.length < 1) {
            throw new IllegalArgumentException("Input array is null or 0!");
        }
        byte[] bArr2 = new byte[(bArr.length - bArr[bArr.length - 1])];
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            bArr2[i2] = bArr[i2];
        }
        return bArr2;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static byte[] m3818(String str) {
        return Base64.decode(str, 0);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m3816(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }
}
