package o;
/* renamed from: o.ᴽ  reason: contains not printable characters */
public class C0993<T> implements AbstractC0989 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final T f15052;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0855<C1049> f15053;

    private C0993(T t) {
        this.f15052 = t;
    }

    C0993() {
        this.f15052 = null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static <T> C0993<T> m15932(T t) {
        return new C0993<>(t);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public T m15933() {
        return this.f15052;
    }

    @Override // o.AbstractC0989
    public C0855<C1049> getReferences() {
        return this.f15053;
    }

    @Override // o.AbstractC0989
    public void setReferences(C0855<C1049> r1) {
        this.f15053 = r1;
    }

    public String toString() {
        return "Sentinel [value=" + ((Object) this.f15052) + "]";
    }
}
