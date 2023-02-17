package o;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.EmptyList;
public class EG {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static final <T> Collection<T> m4799(T[] tArr) {
        C1457Fr.m5025(tArr, "$receiver");
        return new C1439Ez(tArr, false);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final <T> List<T> m4805() {
        return EmptyList.f4243;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final <T> List<T> m4804(T... tArr) {
        C1457Fr.m5025(tArr, "elements");
        return tArr.length > 0 ? ED.m4792((Object[]) tArr) : EI.m4805();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final <T> List<T> m4806(T t) {
        List<T> singletonList = Collections.singletonList(t);
        C1457Fr.m5016((Object) singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final <T> List<T> m4802(T... tArr) {
        C1457Fr.m5025(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new C1439Ez(tArr, true));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final <T> int m4801(List<? extends T> list) {
        C1457Fr.m5025(list, "$receiver");
        return list.size() - 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ॱ  reason: contains not printable characters */
    public static final <T> List<T> m4807(List<? extends T> list) {
        C1457Fr.m5025(list, "$receiver");
        switch (list.size()) {
            case 0:
                return EI.m4805();
            case 1:
                return EI.m4806(list.get(0));
            default:
                return list;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public static final <T> Object[] m4803(T[] tArr, boolean z) {
        if (!z || !C1457Fr.m5018(tArr.getClass(), Object[].class)) {
            Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
            C1457Fr.m5016((Object) copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
            return copyOf;
        } else if (tArr != null) {
            return tArr;
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
    }
}
