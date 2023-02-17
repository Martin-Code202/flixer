package kotlin;

import java.io.Serializable;
import o.AbstractC1433Et;
final class InitializedLazyImpl<T> implements AbstractC1433Et<T>, Serializable {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final T f4236;

    public InitializedLazyImpl(T t) {
        this.f4236 = t;
    }

    @Override // o.AbstractC1433Et
    /* renamed from: ˏ  reason: contains not printable characters */
    public T mo3220() {
        return this.f4236;
    }

    @Override // java.lang.Object
    public String toString() {
        return String.valueOf(mo3220());
    }
}
