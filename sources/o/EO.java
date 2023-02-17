package o;

import java.util.ListIterator;
import java.util.NoSuchElementException;
public final class EO implements ListIterator, AbstractC1463Fx {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final EO f5507 = new EO();

    @Override // java.util.ListIterator
    public /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private EO() {
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return false;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return 0;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return -1;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Void next() {
        throw new NoSuchElementException();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public Void previous() {
        throw new NoSuchElementException();
    }
}
