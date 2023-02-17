package o;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
/* renamed from: o.Fp  reason: case insensitive filesystem */
public class C1455Fp {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final Object[] f5672 = new Object[0];

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Object[] m5012(Collection<?> collection) {
        int size = collection.size();
        if (size == 0) {
            return f5672;
        }
        Object[] objArr = new Object[size];
        Iterator<?> it = collection.iterator();
        for (int i = 0; i < size; i++) {
            if (!it.hasNext()) {
                return Arrays.copyOf(objArr, i);
            }
            objArr[i] = it.next();
        }
        return it.hasNext() ? m5013(objArr, it) : objArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ˏ  reason: contains not printable characters */
    public static <T, E> T[] m5014(Collection<E> collection, T[] tArr) {
        int size = collection.size();
        T[] tArr2 = tArr.length >= size ? tArr : (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        Iterator<E> it = collection.iterator();
        for (int i = 0; i < tArr2.length; i++) {
            if (it.hasNext()) {
                tArr2[i] = it.next();
            } else if (tArr != tArr2) {
                return (T[]) Arrays.copyOf(tArr2, i);
            } else {
                tArr2[i] = null;
                return tArr2;
            }
        }
        return it.hasNext() ? (T[]) m5013(tArr2, it) : tArr2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v9, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ˎ  reason: contains not printable characters */
    private static <T> T[] m5013(T[] tArr, Iterator<?> it) {
        int length = tArr.length;
        while (it.hasNext()) {
            int length2 = tArr.length;
            if (length == length2) {
                int i = ((length2 / 2) + 1) * 3;
                if (i <= length2) {
                    if (length2 == Integer.MAX_VALUE) {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    i = Integer.MAX_VALUE;
                }
                tArr = (T[]) Arrays.copyOf(tArr, i);
            }
            length++;
            tArr[length] = it.next();
        }
        return length == tArr.length ? tArr : (T[]) Arrays.copyOf(tArr, length);
    }
}
