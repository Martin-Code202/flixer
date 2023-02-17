package o;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
public class EX extends EY {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static final <K, V> List<Pair<K, V>> m4858(Map<? extends K, ? extends V> map) {
        C1457Fr.m5025(map, "$receiver");
        if (map.size() == 0) {
            return EI.m4805();
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return EI.m4805();
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            return EI.m4806(new Pair(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new Pair(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new Pair(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }
}
