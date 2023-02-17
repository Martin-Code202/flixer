package o;
/* renamed from: o.Bk  reason: case insensitive filesystem */
public final class C1338Bk {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m4035(String str, AbstractC2088qi qiVar) {
        if (C1349Bv.m4113(str)) {
            return false;
        }
        if (qiVar == null) {
            C1283.m16850("nf_privacy", "User is NULL!");
            return true;
        } else if (m4036(str, qiVar.getEmail())) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m4036(String str, String str2) {
        if (!C1349Bv.m4113(str2) && !C1349Bv.m4113(str) && str.trim().toLowerCase().contains(str2.toLowerCase())) {
            return true;
        }
        return false;
    }
}
