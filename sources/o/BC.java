package o;
public class BC<T, U, V> {

    /* renamed from: ˊ  reason: contains not printable characters */
    public final T f4573;

    /* renamed from: ˏ  reason: contains not printable characters */
    public final V f4574;

    /* renamed from: ॱ  reason: contains not printable characters */
    public final U f4575;

    public BC(T t, U u, V v) {
        this.f4573 = t;
        this.f4575 = u;
        this.f4574 = v;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static <T, U, V> BC<T, U, V> m3837(T t, U u, V v) {
        return new BC<>(t, u, v);
    }

    public int hashCode() {
        return (((((this.f4573 == null ? 0 : this.f4573.hashCode()) + 31) * 31) + (this.f4575 == null ? 0 : this.f4575.hashCode())) * 31) + (this.f4574 == null ? 0 : this.f4574.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BC)) {
            return false;
        }
        BC bc = (BC) obj;
        if (this.f4573 == null) {
            if (bc.f4573 != null) {
                return false;
            }
        } else if (!this.f4573.equals(bc.f4573)) {
            return false;
        }
        if (this.f4575 == null) {
            if (bc.f4575 != null) {
                return false;
            }
        } else if (!this.f4575.equals(bc.f4575)) {
            return false;
        }
        if (this.f4574 == null) {
            if (bc.f4574 != null) {
                return false;
            }
            return true;
        } else if (!this.f4574.equals(bc.f4574)) {
            return false;
        } else {
            return true;
        }
    }
}
