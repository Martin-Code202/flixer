package o;

import java.util.Iterator;
public final class EP<T> implements Iterable<EL<? extends T>>, AbstractC1463Fx {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC1449Fj<Iterator<T>> f5508;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: o.Fj<? extends java.util.Iterator<? extends T>> */
    /* JADX WARN: Multi-variable type inference failed */
    public EP(AbstractC1449Fj<? extends Iterator<? extends T>> fj) {
        C1457Fr.m5025(fj, "iteratorFactory");
        this.f5508 = fj;
    }

    @Override // java.lang.Iterable
    public Iterator<EL<T>> iterator() {
        return new ER(this.f5508.invoke());
    }
}
