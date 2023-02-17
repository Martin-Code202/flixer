package o;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.Pair;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.regex.Pattern;
/* renamed from: o.Bv  reason: case insensitive filesystem */
public final class C1349Bv {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final Pattern f4663 = Pattern.compile("^[0-9]");

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final char[] f4664 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m4105(String str, String str2) {
        if (str2 != null) {
            return str2;
        }
        throw new IllegalArgumentException(str + " can not be null!");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m4104(String str, char c, int i) {
        if (i <= 0) {
            return -1;
        }
        int indexOf = str.indexOf(c, 0);
        while (true) {
            i--;
            if (i <= 1 || indexOf == -1) {
                break;
            }
            indexOf = str.indexOf(c, indexOf + 1);
        }
        return indexOf;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m4110(String str, String str2) {
        return m4124(str, str2, true);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m4124(String str, String str2, boolean z) {
        if (str == null) {
            return "";
        }
        if (z) {
            return str.trim().replaceAll("\\s", str2);
        }
        return str.replaceAll("\\s", str2);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m4119(String str) {
        if (str == null) {
            return "";
        }
        return str.trim().replaceAll("\\s+", " ");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m4107(String str) {
        return !m4113(str);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m4113(String str) {
        return str == null || "".equals(str.trim());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m4112(CharSequence charSequence) {
        return !m4121(charSequence);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m4121(CharSequence charSequence) {
        return charSequence == null || "".contentEquals(charSequence);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m4117(String[] strArr) {
        return m4120(strArr, (String) null);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m4120(String[] strArr, String str) {
        if (strArr == null || strArr.length < 1) {
            return "";
        }
        if (str == null) {
            str = ",";
        }
        boolean z = true;
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArr) {
            if (str2 != null) {
                if (z) {
                    z = false;
                } else {
                    sb.append(str);
                }
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m4126(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String[] m4118(String str, String str2) {
        if (m4113(str)) {
            return new String[0];
        }
        return str.split(str2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Pair<Integer, Integer> m4115(String str) {
        String[] r3 = m4118(str, "\\s+");
        if (r3.length >= 2) {
            return new Pair<>(Integer.valueOf(Integer.parseInt(r3[0])), Integer.valueOf(Integer.parseInt(r3[1])));
        }
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m4125(String str) {
        if (m4113(str)) {
            return false;
        }
        return f4663.matcher(str).find();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static String m4129(String str) {
        return m4106(str, (Locale) null);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m4106(String str, Locale locale) {
        if (m4113(str)) {
            return str;
        }
        Locale locale2 = locale;
        if (locale2 == null) {
            locale2 = Locale.getDefault();
        }
        char[] charArray = str.toCharArray();
        StringBuilder append = new StringBuilder().append(str.toUpperCase(locale2).charAt(0));
        for (int i = 1; i < charArray.length; i++) {
            append.append(charArray[i]);
        }
        return append.toString();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static String m4128(String str) {
        if (m4113(str)) {
            return str;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(str, 0).toString();
        }
        return Html.fromHtml(str).toString();
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static Spanned m4102(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(str, 0);
        }
        return Html.fromHtml(str);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m4101(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 4);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\"':
                case '\'':
                case '\\':
                    sb.append('\\');
                    sb.append(charAt);
                    break;
                default:
                    sb.append(charAt);
                    break;
            }
        }
        return sb.toString();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static boolean m4103(String str) {
        return m4122(str, 10);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m4122(String str, int i) {
        if (m4113(str)) {
            return false;
        }
        String trim = str.trim();
        for (int i2 = 0; i2 < trim.length(); i2++) {
            if (i2 == 0 && trim.charAt(i2) == '-') {
                if (trim.length() == 1) {
                    return false;
                }
            } else if (Character.digit(trim.charAt(i2), i) < 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public static int m4114(String str) {
        if (m4113(str)) {
            return 0;
        }
        return str.split(",").length;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m4109(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0 || str.length() <= i) {
            return str;
        }
        return str.substring(0, i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m4111(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            C1283.m16847("StringUtils", "byteArrayToString error", e);
            return null;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m4123(String str, String str2) {
        if (m4113(str)) {
            return false;
        }
        return str.equals(str2);
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public static long m4108(String str) {
        if (str == null) {
            return 0;
        }
        String trim = str.trim();
        if ("".equals(trim) || "null".equalsIgnoreCase(trim)) {
            return 0;
        }
        try {
            return m4127(str);
        } catch (Throwable th) {
            C1283.m16850("StringUtils", "Got exception inside toLongSafe: " + th);
            return 0;
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private static long m4127(String str) {
        return Long.parseLong(str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m4116(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (str3 != null) {
            sb.append(str3);
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        return sb.toString();
    }
}
