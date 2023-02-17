package o;

import java.util.List;
final class EV<T> extends AbstractC1436Ew<T> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final List<T> f5511;

    public EV(List<T> list) {
        C1457Fr.m5025(list, "delegate");
        this.f5511 = list;
    }

    @Override // o.AbstractC1436Ew
    /* renamed from: ॱ  reason: contains not printable characters */
    public int mo4857() {
        return this.f5511.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.f5511.get(EN.m4844(this, i));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public void clear() {
        this.f5511.clear();
    }

    @Override // o.AbstractC1436Ew
    /* renamed from: ˏ  reason: contains not printable characters */
    public T mo4856(int i) {
        return this.f5511.remove(EN.m4844(this, i));
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        return this.f5511.set(EN.m4844(this, i), t);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        this.f5511.add(EN.m4847(this, i), t);
    }
}
