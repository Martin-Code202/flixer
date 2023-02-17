package o;

import android.graphics.Rect;
/* renamed from: o.ᘂ  reason: contains not printable characters */
public final class C0926 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private Rect f14806;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f14807;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f14808;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f14809;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f14810;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f14811;

    /* renamed from: ˎ  reason: contains not printable characters */
    public static /* synthetic */ C0926 m15733(C0926 r1, String str, int i, int i2, int i3, int i4, Rect rect, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = r1.f14809;
        }
        if ((i5 & 2) != 0) {
            i = r1.f14811;
        }
        if ((i5 & 4) != 0) {
            i2 = r1.f14810;
        }
        if ((i5 & 8) != 0) {
            i3 = r1.f14808;
        }
        if ((i5 & 16) != 0) {
            i4 = r1.f14807;
        }
        if ((i5 & 32) != 0) {
            rect = r1.f14806;
        }
        return r1.m15739(str, i, i2, i3, i4, rect);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0926)) {
            return false;
        }
        C0926 r2 = (C0926) obj;
        if (!C1457Fr.m5018((Object) this.f14809, (Object) r2.f14809)) {
            return false;
        }
        if (!(this.f14811 == r2.f14811)) {
            return false;
        }
        if (!(this.f14810 == r2.f14810)) {
            return false;
        }
        if (!(this.f14808 == r2.f14808)) {
            return false;
        }
        return (this.f14807 == r2.f14807) && C1457Fr.m5018(this.f14806, r2.f14806);
    }

    public int hashCode() {
        String str = this.f14809;
        int hashCode = (((((((((str != null ? str.hashCode() : 0) * 31) + this.f14811) * 31) + this.f14810) * 31) + this.f14808) * 31) + this.f14807) * 31;
        Rect rect = this.f14806;
        return hashCode + (rect != null ? rect.hashCode() : 0);
    }

    public String toString() {
        return "TapListItem(tag=" + this.f14809 + ", validFrame=" + this.f14811 + ", startFrame=" + this.f14810 + ", endFrame=" + this.f14808 + ", resetFrame=" + this.f14807 + ", tapAreaRect=" + this.f14806 + ")";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final C0926 m15739(String str, int i, int i2, int i3, int i4, Rect rect) {
        C1457Fr.m5025(str, "tag");
        C1457Fr.m5025(rect, "tapAreaRect");
        return new C0926(str, i, i2, i3, i4, rect);
    }

    public C0926(String str, int i, int i2, int i3, int i4, Rect rect) {
        C1457Fr.m5025(str, "tag");
        C1457Fr.m5025(rect, "tapAreaRect");
        this.f14809 = str;
        this.f14811 = i;
        this.f14810 = i2;
        this.f14808 = i3;
        this.f14807 = i4;
        this.f14806 = rect;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final String m15734() {
        return this.f14809;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final int m15738() {
        return this.f14811;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final int m15737() {
        return this.f14810;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final int m15736() {
        return this.f14808;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final int m15735() {
        return this.f14807;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public final Rect m15740() {
        return this.f14806;
    }
}
