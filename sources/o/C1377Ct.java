package o;

import android.util.Patterns;
/* renamed from: o.Ct  reason: case insensitive filesystem */
public class C1377Ct {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m4558(String str) {
        if (C1349Bv.m4113(str)) {
            return false;
        }
        return Patterns.WEB_URL.matcher(str.toLowerCase()).matches();
    }
}
