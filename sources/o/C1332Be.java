package o;
/* renamed from: o.Be  reason: case insensitive filesystem */
public final class C1332Be {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static Integer m4015(String str, Integer num) {
        if (C1349Bv.m4113(str)) {
            return num;
        }
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException e) {
            return num;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m4016(String str) {
        if (C1349Bv.m4113(str)) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Long m4014(String str) {
        try {
            return Long.valueOf(str);
        } catch (Throwable th) {
            C1283.m16867("nf_numbers", th, "Failed to translate String to Long!");
            return -1L;
        }
    }
}
