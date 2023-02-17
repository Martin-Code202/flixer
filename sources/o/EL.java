package o;
public final class EL<T> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final T f5504;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f5505;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EL)) {
            return false;
        }
        EL el = (EL) obj;
        return (this.f5505 == el.f5505) && C1457Fr.m5018(this.f5504, el.f5504);
    }

    public int hashCode() {
        int i = this.f5505 * 31;
        T t = this.f5504;
        return i + (t != null ? t.hashCode() : 0);
    }

    public String toString() {
        return "IndexedValue(index=" + this.f5505 + ", value=" + ((Object) this.f5504) + ")";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final int m4814() {
        return this.f5505;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final T m4815() {
        return this.f5504;
    }

    public EL(int i, T t) {
        this.f5505 = i;
        this.f5504 = t;
    }
}
