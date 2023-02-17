package o;

import java.util.HashMap;
import java.util.Map;
/* renamed from: o.Dh  reason: case insensitive filesystem */
public class C1391Dh {

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final C1391Dh f5418 = new C1391Dh("MT_PROTECTED", false, false);

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final C1391Dh f5419 = new C1391Dh("NONE_SUFFIXED", false, false);

    /* renamed from: ʽ  reason: contains not printable characters */
    public static final C1391Dh f5420 = new C1391Dh("NONE", false, false);

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final C1391Dh f5421 = new C1391Dh("X509", false, true);

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final C1391Dh f5422 = new C1391Dh("RSA", false, true);

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final C1391Dh f5423 = new C1391Dh("PSK", true, true);

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C1391Dh f5424 = new C1391Dh("PSK_PROFILE", true, true);

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final C1391Dh f5425 = new C1391Dh("ECC", false, true);

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static Map<String, C1391Dh> f5426 = new HashMap();

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static final C1391Dh f5427 = new C1391Dh("PROVISIONED", false, false);

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final boolean f5428;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final boolean f5429;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final String f5430;

    protected C1391Dh(String str, boolean z, boolean z2) {
        this.f5430 = str;
        this.f5429 = z;
        this.f5428 = z2;
        synchronized (f5426) {
            f5426.put(str, this);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static C1391Dh m4715(String str) {
        return f5426.get(str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m4716() {
        return this.f5430;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m4717() {
        return this.f5429;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m4718() {
        return this.f5428;
    }

    public String toString() {
        return m4716();
    }

    public int hashCode() {
        return this.f5430.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1391Dh)) {
            return false;
        }
        return this.f5430.equals(((C1391Dh) obj).f5430);
    }
}
