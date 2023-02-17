package o;

import java.util.HashMap;
import java.util.Map;
/* renamed from: o.Dx  reason: case insensitive filesystem */
public class C1407Dx {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Map<Byte, C1407Dx> f5469 = new HashMap();

    /* renamed from: ˏ  reason: contains not printable characters */
    private static Map<String, C1407Dx> f5470 = new HashMap();

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final C1407Dx f5471 = new C1407Dx("JSON", (byte) 123);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f5472;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final byte f5473;

    protected C1407Dx(String str, byte b) {
        this.f5472 = str;
        this.f5473 = b;
        synchronized (f5470) {
            f5470.put(str, this);
        }
        synchronized (f5469) {
            f5469.put(Byte.valueOf(b), this);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C1407Dx m4769(String str) {
        return f5470.get(str);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C1407Dx m4768(byte b) {
        return f5469.get(Byte.valueOf(b));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m4770() {
        return this.f5472;
    }

    public String toString() {
        return m4770();
    }

    public int hashCode() {
        return this.f5472.hashCode() ^ Byte.valueOf(this.f5473).hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1407Dx)) {
            return false;
        }
        C1407Dx dx = (C1407Dx) obj;
        return this.f5472.equals(dx.f5472) && this.f5473 == dx.f5473;
    }
}
