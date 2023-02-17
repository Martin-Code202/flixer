package o;

import android.net.Uri;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class AB {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3273(String str, Uri uri) {
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static List<String> m3272(List<?> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            arrayList.add(next == null ? null : next.toString());
        }
        return arrayList;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3274(String str, String str2, Object... objArr) {
        if (objArr == null) {
            C1283.m16846(str, "Objects array is null - " + str2);
            return true;
        }
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] == null) {
                C1283.m16846(str, "Object " + i + " is null - " + str2);
                return true;
            }
        }
        return false;
    }

    public static class If extends Pair<String, String> {
        public If(String str, String str2) {
            super(str, str2);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3275(List<pI> list) {
        for (int i = 0; i < list.size(); i++) {
            pI pIVar = list.get(i);
            if (!(pIVar == null || pIVar.isAvailableToStream())) {
                return true;
            }
        }
        return false;
    }
}
