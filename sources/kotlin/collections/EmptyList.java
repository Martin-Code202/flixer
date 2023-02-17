package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import o.AbstractC1463Fx;
import o.C1455Fp;
import o.C1457Fr;
import o.EO;
public final class EmptyList implements List, Serializable, RandomAccess, AbstractC1463Fx {
    private static final long serialVersionUID = -7390468764508069838L;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final EmptyList f4243 = new EmptyList();

    @Override // java.util.List
    public /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* synthetic */ Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return C1455Fp.m5012(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) C1455Fp.m5014(this, tArr);
    }

    private EmptyList() {
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Void) {
            return m3228((Void) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Void) {
            return m3230((Void) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Void) {
            return m3227((Void) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return m3229();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Object
    public int hashCode() {
        return 1;
    }

    @Override // java.lang.Object
    public String toString() {
        return "[]";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m3229() {
        return 0;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m3228(Void r2) {
        C1457Fr.m5025(r2, "element");
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        C1457Fr.m5025(collection, "elements");
        return collection.isEmpty();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public Void get(int i) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i + '.');
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m3230(Void r2) {
        C1457Fr.m5025(r2, "element");
        return -1;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int m3227(Void r2) {
        C1457Fr.m5025(r2, "element");
        return -1;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return EO.f5507;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return EO.f5507;
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        if (i == 0) {
            return EO.f5507;
        }
        throw new IndexOutOfBoundsException("Index: " + i);
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2);
    }

    private final Object readResolve() {
        return f4243;
    }
}
