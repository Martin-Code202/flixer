package o;

import java.util.Map;
import java.util.NoSuchElementException;
public class ET {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static final <K, V> V m4853(Map<K, ? extends V> map, K k) {
        C1457Fr.m5025(map, "$receiver");
        if (map instanceof EQ) {
            return (V) ((EQ) map).m4851(k);
        }
        V v = (V) map.get(k);
        if (v != null || map.containsKey(k)) {
            return v;
        }
        throw new NoSuchElementException("Key " + ((Object) k) + " is missing in the map.");
    }
}
