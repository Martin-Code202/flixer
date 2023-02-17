package o;

import com.google.android.exoplayer2.C;
import java.util.List;
/* renamed from: o.ks  reason: case insensitive filesystem */
public class C1948ks extends C1950ku {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f8457;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f8458;

    public C1948ks(long j, long j2, long j3, long j4, String str, int i) {
        super(j, j2, j3, j4);
        this.f8458 = str;
        this.f8457 = i;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m8439() {
        return this.f8458;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int m8438() {
        return this.f8457;
    }

    @Override // o.C1950ku
    public String toString() {
        return "CachedFragmentInfo{trackType=" + (this.f8457 == 1 ? "A" : "V") + ", streamId='" + this.f8458 + "', pts=(" + C.usToMs(m8441()) + "ms," + C.usToMs(m8445()) + "ms), bytes=(" + m8443() + "," + m8444() + ")}";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static C1948ks m8437(String str, List<C1950ku> list, long j, long j2, int i) {
        List<C1950ku> r11 = kC.m8188(list, j, j + j2);
        if (r11.isEmpty()) {
            return null;
        }
        long r12 = r11.get(0).m8441();
        return new C1948ks(r12, r11.get(r11.size() - 1).m8445() - r12, j, j2, str, i);
    }
}
