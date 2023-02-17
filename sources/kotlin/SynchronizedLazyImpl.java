package kotlin;

import java.io.Serializable;
import o.AbstractC1433Et;
import o.AbstractC1449Fj;
import o.C1437Ex;
import o.C1456Fq;
import o.C1457Fr;
public final class SynchronizedLazyImpl<T> implements AbstractC1433Et<T>, Serializable {

    /* renamed from: ˋ  reason: contains not printable characters */
    private volatile Object f4239;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Object f4240;

    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractC1449Fj<? extends T> f4241;

    public SynchronizedLazyImpl(AbstractC1449Fj<? extends T> fj, Object obj) {
        C1457Fr.m5025(fj, "initializer");
        this.f4241 = fj;
        this.f4239 = C1437Ex.f5647;
        Object obj2 = obj;
        this.f4240 = obj2 == null ? this : obj2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SynchronizedLazyImpl(AbstractC1449Fj fj, Object obj, int i, C1456Fq fq) {
        this(fj, (i & 2) != 0 ? null : obj);
    }

    @Override // o.AbstractC1433Et
    /* renamed from: ˏ */
    public T mo3220() {
        T t;
        T t2 = (T) this.f4239;
        if (t2 != C1437Ex.f5647) {
            return t2;
        }
        synchronized (this.f4240) {
            Object obj = this.f4239;
            if (obj != C1437Ex.f5647) {
                t = (T) obj;
            } else {
                AbstractC1449Fj<? extends T> fj = this.f4241;
                if (fj == null) {
                    C1457Fr.m5019();
                }
                Object invoke = fj.invoke();
                this.f4239 = invoke;
                this.f4241 = null;
                t = (T) invoke;
            }
        }
        return t;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m3225() {
        return this.f4239 != C1437Ex.f5647;
    }

    @Override // java.lang.Object
    public String toString() {
        return m3225() ? String.valueOf(mo3220()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(mo3220());
    }
}
