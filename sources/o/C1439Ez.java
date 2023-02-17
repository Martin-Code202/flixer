package o;

import java.util.Collection;
import java.util.Iterator;
/* renamed from: o.Ez  reason: case insensitive filesystem */
final class C1439Ez<T> implements Collection<T>, AbstractC1463Fx {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final T[] f5648;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final boolean f5649;

    @Override // java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) C1455Fp.m5014(this, tArr);
    }

    public C1439Ez(T[] tArr, boolean z) {
        C1457Fr.m5025(tArr, "values");
        this.f5648 = tArr;
        this.f5649 = z;
    }

    @Override // java.util.Collection
    public final int size() {
        return m4974();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m4974() {
        return this.f5648.length;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f5648.length == 0;
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return ED.m4798(this.f5648, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        C1457Fr.m5025(collection, "elements");
        Collection<? extends Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return C1452Fm.m5010(this.f5648);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return EG.m4800(this.f5648, this.f5649);
    }
}
