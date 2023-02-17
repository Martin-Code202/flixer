package o;

import android.text.TextUtils;
/* renamed from: o.Bm  reason: case insensitive filesystem */
public final class C1340Bm {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean f4656 = false;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m4052(CharSequence charSequence) {
        return m4055(charSequence, false, "String cannot be empty") && m4054(charSequence, false, "String cannot be empty");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean m4055(Object obj, boolean z, String str) {
        if (obj != null) {
            return true;
        }
        m4053(new NullPointerException(str), z);
        return false;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean m4054(CharSequence charSequence, boolean z, String str) {
        if (!TextUtils.isEmpty(charSequence)) {
            return true;
        }
        m4053(new IllegalArgumentException(str), z);
        return false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m4053(RuntimeException runtimeException, boolean z) {
        if (f4656 || z) {
            throw runtimeException;
        }
        C1276.m16820().mo5730(runtimeException);
        return false;
    }
}
