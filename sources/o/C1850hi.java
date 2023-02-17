package o;

import java.util.List;
/* renamed from: o.hi  reason: case insensitive filesystem */
class C1850hi {
    C1850hi() {
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static boolean m7056(String str, String str2, List<hI> list) {
        for (hI hIVar : list) {
            if (hIVar.mo6890().isGeoBlocked()) {
                return true;
            }
        }
        return str2 != null && !str2.equals(str);
    }
}
