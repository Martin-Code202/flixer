package o;
class Gh extends FY {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static final boolean m5060(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        if (Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2)) {
            return true;
        }
        return false;
    }
}
