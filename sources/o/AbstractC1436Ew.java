package o;

import java.util.AbstractList;
import java.util.List;
/* renamed from: o.Ew  reason: case insensitive filesystem */
public abstract class AbstractC1436Ew<E> extends AbstractList<E> implements List<E>, FB {
    /* renamed from: ˏ */
    public abstract E mo4856(int i);

    /* renamed from: ॱ */
    public abstract int mo4857();

    protected AbstractC1436Ew() {
    }

    @Override // java.util.AbstractList, java.util.List
    public final E remove(int i) {
        return mo4856(i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return mo4857();
    }
}
