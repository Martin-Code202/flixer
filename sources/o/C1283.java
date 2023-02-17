package o;

import android.content.Intent;
import android.util.Log;
/* renamed from: o.ﾚ  reason: contains not printable characters */
public final class C1283 {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m16852(String str, Exception exc) {
        m16856(str, exc, "Exception msg: " + exc.getMessage(), new Object[0]);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m16846(String str, String str2) {
        return 0;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m16848(String str, String str2, Object... objArr) {
        return 0;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m16866(String str, String str2, Object... objArr) {
        return 0;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m16854(String str, String str2) {
        return 0;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static int m16851(String str, String str2, Object... objArr) {
        return 0;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static int m16864(String str, Throwable th, String str2, Object... objArr) {
        return 0;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static int m16862(String str, String str2) {
        return 0;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static int m16863(String str, String str2, Object... objArr) {
        return 0;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m16865(String str, String str2) {
        return 0;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m16855(String str, String str2, Object... objArr) {
        return 0;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m16867(String str, Throwable th, String str2) {
        return 0;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m16868(String str, Throwable th, String str2, Object... objArr) {
        return 0;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static int m16861(String str) {
        return 0;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static int m16850(String str, String str2) {
        return 0;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m16847(String str, String str2, Throwable th) {
        return 0;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static int m16844(String str, String str2, Object... objArr) {
        return 0;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m16856(String str, Throwable th, String str2, Object... objArr) {
        return 0;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static void m16845(String str, String str2) {
        if (str2 != null) {
            if (str2.length() > 4000) {
                int length = str2.length() / 4000;
                for (int i = 0; i <= length; i++) {
                    int i2 = (i + 1) * 4000;
                    if (i2 >= str2.length()) {
                        m16846(str, str2.substring(i * 4000));
                    } else {
                        m16846(str, str2.substring(i * 4000, i2));
                    }
                }
                return;
            }
            m16846(str, str2);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m16853(String str, String str2, Intent intent) {
        m16854(str, str2);
        m16849(str, intent);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m16849(String str, Intent intent) {
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m16859(String str, Intent intent) {
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m16857(Throwable th) {
        if (th == null) {
            return "";
        }
        return Log.getStackTraceString(th);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m16858(Throwable th, int i) {
        String r1 = m16857(th);
        if (i < 0 || r1.length() <= i) {
            return r1;
        }
        return r1.substring(0, i);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m16860(String str, String str2, byte[] bArr) {
    }
}
