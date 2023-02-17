package o;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* access modifiers changed from: package-private */
/* renamed from: o.Fn  reason: case insensitive filesystem */
public final class C1453Fn<T> implements Iterator<T>, AbstractC1463Fx {

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f5670;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final T[] f5671;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public C1453Fn(T[] tArr) {
        C1457Fr.m5025(tArr, "array");
        this.f5671 = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f5670 < this.f5671.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f5671;
            int i = this.f5670;
            this.f5670 = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f5670--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
