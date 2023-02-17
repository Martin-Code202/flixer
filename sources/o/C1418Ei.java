package o;

import java.util.regex.Pattern;
/* renamed from: o.Ei  reason: case insensitive filesystem */
public class C1418Ei {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static AbstractC0086 f5537 = new C1421El();

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final Pattern f5538 = Pattern.compile("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$");

    /* renamed from: o.Ei$ˋ  reason: contains not printable characters */
    public interface AbstractC0086 {
        /* renamed from: ˋ  reason: contains not printable characters */
        byte[] mo4895(String str);

        /* renamed from: ˏ  reason: contains not printable characters */
        String mo4896(byte[] bArr);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4893(AbstractC0086 r2) {
        if (r2 == null) {
            throw new NullPointerException("Base64 implementation cannot be null.");
        }
        f5537 = r2;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m4892(byte[] bArr) {
        return f5537.mo4896(bArr);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static byte[] m4894(String str) {
        return f5537.mo4895(str);
    }
}
