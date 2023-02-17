package kotlin;

import java.io.Serializable;
import o.C1457Fr;
public final class Pair<A, B> implements Serializable {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final B f4237;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final A f4238;

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return C1457Fr.m5018(this.f4238, pair.f4238) && C1457Fr.m5018(this.f4237, pair.f4237);
    }

    @Override // java.lang.Object
    public int hashCode() {
        A a = this.f4238;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b = this.f4237;
        return hashCode + (b != null ? b.hashCode() : 0);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final B m3222() {
        return this.f4237;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final A m3224() {
        return this.f4238;
    }

    public Pair(A a, B b) {
        this.f4238 = a;
        this.f4237 = b;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final A m3221() {
        return this.f4238;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final B m3223() {
        return this.f4237;
    }

    @Override // java.lang.Object
    public String toString() {
        return '(' + ((Object) this.f4238) + ", " + ((Object) this.f4237) + ')';
    }
}
