package o;

import java.util.HashMap;
import java.util.Map;
/* renamed from: o.Dz  reason: case insensitive filesystem */
public class C1409Dz {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static Map<String, C1409Dz> f5475 = new HashMap();

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final C1409Dz f5476 = new C1409Dz("JWE_LADDER");

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final C1409Dz f5477 = new C1409Dz("DIFFIE_HELLMAN");

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final C1409Dz f5478 = new C1409Dz("JWK_LADDER");

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C1409Dz f5479 = new C1409Dz("ASYMMETRIC_WRAPPED");

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final C1409Dz f5480 = new C1409Dz("SYMMETRIC_WRAPPED");

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f5481;

    protected C1409Dz(String str) {
        this.f5481 = str;
        synchronized (f5475) {
            f5475.put(str, this);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C1409Dz m4773(String str) {
        return f5475.get(str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m4774() {
        return this.f5481;
    }

    public String toString() {
        return m4774();
    }

    public int hashCode() {
        return this.f5481.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1409Dz)) {
            return false;
        }
        return this.f5481.equals(((C1409Dz) obj).f5481);
    }
}
