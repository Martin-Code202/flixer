package o;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
class EH extends EJ {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static final <T> boolean m4810(Collection<? super T> collection, Iterable<? extends T> iterable) {
        C1457Fr.m5025(collection, "$receiver");
        C1457Fr.m5025(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add((Object) it.next())) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final <T> boolean m4809(Collection<? super T> collection, Iterable<? extends T> iterable) {
        C1457Fr.m5025(collection, "$receiver");
        C1457Fr.m5025(iterable, "elements");
        return C1462Fw.m5043(collection).retainAll(EI.m4811(iterable, collection));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final <T> void m4808(List<T> list, Comparator<? super T> comparator) {
        C1457Fr.m5025(list, "$receiver");
        C1457Fr.m5025(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
