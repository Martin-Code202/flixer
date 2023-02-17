package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import o.AbstractC1463Fx;
import o.C1455Fp;
import o.C1457Fr;
import o.EO;
public final class EmptySet implements Set, Serializable, AbstractC1463Fx {
    private static final long serialVersionUID = 3406603774387020532L;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final EmptySet f4245 = new EmptySet();

    @Override // java.util.Set, java.util.Collection
    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return C1455Fp.m5012(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) C1455Fp.m5014(this, tArr);
    }

    private EmptySet() {
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Void) {
            return m3239((Void) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return m3238();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return "[]";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m3238() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m3239(Void r2) {
        C1457Fr.m5025(r2, "element");
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        C1457Fr.m5025(collection, "elements");
        return collection.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return EO.f5507;
    }

    private final Object readResolve() {
        return f4245;
    }
}
