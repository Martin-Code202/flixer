package o;

import java.util.Iterator;
public abstract class EU implements Iterator<Integer>, AbstractC1463Fx {
    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public abstract int mo4855();

    /* renamed from: ˋ  reason: contains not printable characters */
    public final Integer next() {
        return Integer.valueOf(mo4855());
    }
}
