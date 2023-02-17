package o;

import java.util.List;
class EN extends EH {
    /* access modifiers changed from: private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public static final int m4844(List<?> list, int i) {
        int r0 = EI.m4801((List) list);
        if (0 <= i && r0 >= i) {
            return EI.m4801((List) list) - i;
        }
        throw new IndexOutOfBoundsException("Element index " + i + " must be in range [" + new FE(0, EI.m4801((List) list)) + "].");
    }

    /* access modifiers changed from: private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public static final int m4847(List<?> list, int i) {
        int size = list.size();
        if (0 <= i && size >= i) {
            return list.size() - i;
        }
        throw new IndexOutOfBoundsException("Position index " + i + " must be in range [" + new FE(0, list.size()) + "].");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final <T> List<T> m4845(List<T> list) {
        C1457Fr.m5025(list, "$receiver");
        return new EV(list);
    }
}
