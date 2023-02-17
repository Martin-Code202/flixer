package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
public class EK extends EG {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static final <T> int m4812(Iterable<? extends T> iterable, int i) {
        C1457Fr.m5025(iterable, "$receiver");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final <T> boolean m4813(Collection<? extends T> collection) {
        return collection.size() > 2 && (collection instanceof ArrayList);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final <T> Collection<T> m4811(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        C1457Fr.m5025(iterable, "$receiver");
        C1457Fr.m5025(iterable2, NetflixActivity.EXTRA_SOURCE);
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (!(iterable instanceof Collection)) {
            return EI.m4830(iterable);
        }
        if (!(iterable2 instanceof Collection) || ((Collection) iterable2).size() >= 2) {
            return m4813((Collection) iterable) ? EI.m4830(iterable) : (Collection) iterable;
        }
        return (Collection) iterable;
    }
}
