package o;
/* renamed from: o.Fc  reason: case insensitive filesystem */
class C1442Fc {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static final <T extends Comparable<?>> int m5000(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }
}
