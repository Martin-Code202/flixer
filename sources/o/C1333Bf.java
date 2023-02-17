package o;

import android.content.Intent;
/* renamed from: o.Bf  reason: case insensitive filesystem */
public final class C1333Bf {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final String f4645 = C1333Bf.class.getSimpleName();

    private C1333Bf() {
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m4017(String str) {
        if (str != null) {
            return str;
        }
        return "=NULL=";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m4018(Intent intent, String str) {
        return intent.getBooleanExtra(str, false);
    }
}
