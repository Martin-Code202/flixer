package o;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* renamed from: o.ο  reason: contains not printable characters */
public final class C0463<T> implements Iterable<T> {

    /* renamed from: ˏ  reason: contains not printable characters */
    final Iterable<T> f13505;

    public C0463(Iterable<T> iterable) {
        this.f13505 = iterable;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static <R> C0463<R> m14349(final List<R> list) {
        return new C0463<>(new Iterable<R>() { // from class: o.ο.1
            @Override // java.lang.Iterable
            public Iterator<R> iterator() {
                return new Iterator<R>() { // from class: o.ο.1.1

                    /* renamed from: ˊ  reason: contains not printable characters */
                    Integer f13507 = null;

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        if (this.f13507 == null) {
                            this.f13507 = 0;
                        } else {
                            Integer num = this.f13507;
                            this.f13507 = Integer.valueOf(this.f13507.intValue() + 1);
                        }
                        return this.f13507.intValue() < list.size();
                    }

                    @Override // java.util.Iterator
                    public R next() {
                        return (R) list.get(this.f13507.intValue());
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public List<T> m14350() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.f13505.iterator();
    }
}
