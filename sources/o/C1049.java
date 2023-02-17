package o;

import java.util.concurrent.atomic.AtomicReference;
/* renamed from: o.ℐ  reason: contains not printable characters */
public final class C1049 extends AbstractC0847 implements AbstractC0989 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AtomicReference<Object> f15183 = new AtomicReference<>();

    /* renamed from: ˎ  reason: contains not printable characters */
    private C0859 f15184;

    /* renamed from: ॱ  reason: contains not printable characters */
    private C0855<C1049> f15185;

    public C1049() {
    }

    public C1049(C0859 r2) {
        this.f15184 = r2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Object m16079() {
        return this.f15183.get();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C0859 m16080() {
        return this.f15184;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m16077(C0859 r3) {
        if (r3 == null || !r3.equals(this.f15184)) {
            this.f15184 = r3;
            this.f15183.set(null);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public Object m16078(AbstractC0929<?> r6) {
        Object obj = this.f15183.get();
        if (obj != null) {
            return obj;
        }
        if (this.f15184 == null || this.f15184.m15543()) {
            return null;
        }
        Object r3 = r6.mo15251(this.f15184);
        if (r3 instanceof AbstractC0989) {
            AbstractC0989 r4 = (AbstractC0989) r3;
            r4.setReferences(new C0855<>(this, r4.getReferences()));
            this.f15183.set(r3);
        }
        return r3;
    }

    @Override // o.AbstractC0989
    public C0855<C1049> getReferences() {
        return this.f15185;
    }

    @Override // o.AbstractC0989
    public void setReferences(C0855<C1049> r1) {
        this.f15185 = r1;
    }

    public String toString() {
        return String.format("Ref path: %s", m16080());
    }
}
