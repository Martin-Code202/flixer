package o;

import android.support.v4.util.Pair;
/* renamed from: o.ˡ  reason: contains not printable characters */
public class C0443<T> {

    /* renamed from: ˏ  reason: contains not printable characters */
    T f13478;

    /* renamed from: ॱ  reason: contains not printable characters */
    T f13479;

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m14309(T t, T t2) {
        this.f13478 = t;
        this.f13479 = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return m14308(pair.first, this.f13478) && m14308(pair.second, this.f13479);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static boolean m14308(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        return (this.f13478 == null ? 0 : this.f13478.hashCode()) ^ (this.f13479 == null ? 0 : this.f13479.hashCode());
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f13478) + " " + String.valueOf(this.f13479) + "}";
    }
}
