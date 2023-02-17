package o;

import java.util.Iterator;
public final class ER<T> implements Iterator<EL<? extends T>>, AbstractC1463Fx {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Iterator<T> f5509;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f5510;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Iterator<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public ER(Iterator<? extends T> it) {
        C1457Fr.m5025(it, "iterator");
        this.f5509 = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5509.hasNext();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final EL<T> next() {
        int i = this.f5510;
        this.f5510 = i + 1;
        return new EL<>(i, this.f5509.next());
    }
}
