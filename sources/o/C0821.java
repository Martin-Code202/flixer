package o;

import o.C0897;
/* renamed from: o.ᓒ  reason: contains not printable characters */
public final class C0821 {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final C0897.C0898 f14612 = new C0897.C0898();

    /* renamed from: ˏ  reason: contains not printable characters */
    public static C0897.If m15431(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Window start can't be less than 0");
        } else if (i2 >= i) {
            return new C0897.If(i, i2);
        } else {
            throw new IllegalArgumentException("Window end can't be less than window start");
        }
    }
}
