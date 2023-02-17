package o;

import android.util.Pair;
/* renamed from: o.Aa  reason: case insensitive filesystem */
public class C1298Aa {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m3505(C2059ph phVar) {
        if (!m3504(phVar)) {
            C1283.m16850("ServiceManagerUtils", "Service manager is not available!");
            return "";
        }
        String r2 = phVar.m9811().mo6171();
        Pair<String, String>[] r3 = phVar.m9811().mo6163();
        if (r3 == null || r3.length < 1 || r2 == null) {
            return "";
        }
        for (int i = 0; i < r3.length; i++) {
            if (r2.equals(r3[i].first)) {
                return (String) r3[i].second;
            }
        }
        return "";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3504(C2059ph phVar) {
        return (phVar == null || !phVar.mo9519() || phVar.m9811() == null) ? false : true;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static oG m3506(C2059ph phVar) {
        if (phVar == null || !phVar.mo9519()) {
            return null;
        }
        return phVar.m9811();
    }
}
