package o;

import java.util.HashMap;
import java.util.Map;
/* renamed from: o.Eg  reason: case insensitive filesystem */
public class C1416Eg {

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final C1416Eg f5533 = new C1416Eg("EMAIL_PASSWORD");

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final C1416Eg f5534 = new C1416Eg("USER_ID_TOKEN");

    /* renamed from: ˎ  reason: contains not printable characters */
    private static Map<String, C1416Eg> f5535 = new HashMap();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f5536;

    protected C1416Eg(String str) {
        this.f5536 = str;
        synchronized (f5535) {
            f5535.put(str, this);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C1416Eg m4879(String str) {
        return f5535.get(str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m4880() {
        return this.f5536;
    }

    public String toString() {
        return m4880();
    }

    public int hashCode() {
        return this.f5536.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1416Eg)) {
            return false;
        }
        return this.f5536.equals(((C1416Eg) obj).f5536);
    }
}
