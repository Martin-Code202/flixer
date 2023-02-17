package o;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.EmptyMap;
public class EY extends EW {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static final <K, V> Map<K, V> m4861() {
        EmptyMap emptyMap = EmptyMap.f4244;
        if (emptyMap != null) {
            return emptyMap;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final <K, V> Map<K, V> m4862(Pair<? extends K, ? extends V>... pairArr) {
        C1457Fr.m5025(pairArr, "pairs");
        return pairArr.length > 0 ? ES.m4859(pairArr, new LinkedHashMap(ES.m4860(pairArr.length))) : ES.m4861();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final <K, V> Map<K, V> m4864(Pair<? extends K, ? extends V> pair) {
        C1457Fr.m5025(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.m3221(), pair.m3223());
        C1457Fr.m5016((Object) singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final <K, V> Map<K, V> m4863(Pair<? extends K, ? extends V>... pairArr) {
        C1457Fr.m5025(pairArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(ES.m4860(pairArr.length));
        ES.m4865(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final int m4860(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (i / 3) + i;
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final <K, V> void m4865(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        C1457Fr.m5025(map, "$receiver");
        C1457Fr.m5025(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put((Object) pair.m3224(), (Object) pair.m3222());
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final <K, V, M extends Map<? super K, ? super V>> M m4859(Pair<? extends K, ? extends V>[] pairArr, M m) {
        C1457Fr.m5025(pairArr, "$receiver");
        C1457Fr.m5025(m, "destination");
        ES.m4865(m, pairArr);
        return m;
    }
}
