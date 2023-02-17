package o;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
public class EF extends EB {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static final <T> boolean m4798(T[] tArr, T t) {
        C1457Fr.m5025(tArr, "$receiver");
        return ED.m4790(tArr, t) >= 0;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final <T> int m4790(T[] tArr, T t) {
        C1457Fr.m5025(tArr, "$receiver");
        if (t == null) {
            int length = tArr.length;
            for (int i = 0; i < length; i++) {
                if (tArr[i] == null) {
                    return i;
                }
            }
            return -1;
        }
        int length2 = tArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            if (C1457Fr.m5018((Object) t, (Object) tArr[i2])) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final char m4794(char[] cArr) {
        C1457Fr.m5025(cArr, "$receiver");
        switch (cArr.length) {
            case 0:
                throw new NoSuchElementException("Array is empty.");
            case 1:
                return cArr[0];
            default:
                throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final <T> int m4789(T[] tArr) {
        C1457Fr.m5025(tArr, "$receiver");
        return tArr.length - 1;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final int[] m4796(Integer[] numArr) {
        C1457Fr.m5025(numArr, "$receiver");
        int[] iArr = new int[numArr.length];
        int length = numArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final <T> List<T> m4795(T[] tArr) {
        C1457Fr.m5025(tArr, "$receiver");
        switch (tArr.length) {
            case 0:
                return EI.m4805();
            case 1:
                return EI.m4806((Object) tArr[0]);
            default:
                return ED.m4797(tArr);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final <T> List<T> m4797(T[] tArr) {
        C1457Fr.m5025(tArr, "$receiver");
        return new ArrayList(EI.m4799(tArr));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final <T extends Comparable<? super T>> T m4791(T[] tArr) {
        C1457Fr.m5025(tArr, "$receiver");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int i = 1;
        int r3 = ED.m4789(tArr);
        if (1 <= r3) {
            while (true) {
                T t2 = tArr[i];
                if (t.compareTo(t2) > 0) {
                    t = t2;
                }
                if (i == r3) {
                    break;
                }
                i++;
            }
        }
        return t;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final <T> List<T> m4792(T[] tArr) {
        C1457Fr.m5025(tArr, "$receiver");
        List<T> r0 = EC.m4788(tArr);
        C1457Fr.m5016((Object) r0, "ArraysUtilJVM.asList(this)");
        return r0;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final <T> void m4793(T[] tArr, Comparator<? super T> comparator) {
        C1457Fr.m5025(tArr, "$receiver");
        C1457Fr.m5025(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
