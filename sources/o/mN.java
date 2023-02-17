package o;

import android.util.Pair;
public class mN {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final mN f8727 = new mN(40, 19);

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final mN f8728 = new mN(52, 19);

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f8729;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f8730;

    private mN(int i, int i2) {
        this.f8729 = i;
        this.f8730 = i2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m8851() {
        return this.f8729;
    }

    public String toString() {
        return "CellResolution [width count=" + this.f8729 + ", height count=" + this.f8730 + "]";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static mN m8850(String str, String str2, String str3, float f) {
        Pair<Integer, Integer> r4;
        if (!C1349Bv.m4113(str) && (r4 = C1349Bv.m4115(str)) != null && ((Integer) r4.first).intValue() > 0 && ((Integer) r4.second).intValue() > 0) {
            return new mN(((Integer) r4.first).intValue(), ((Integer) r4.second).intValue());
        }
        if (!C1349Bv.m4113(str2)) {
            Pair<Integer, Integer> r42 = C1349Bv.m4115(str2);
            Pair<Integer, Integer> r5 = C1349Bv.m4115(str3);
            if (r5 != null) {
                r5 = new Pair<>(1, 1);
            }
            if (r42 != null) {
                if (((double) ((float) ((((Integer) r42.first).intValue() * ((Integer) r5.first).intValue()) / (((Integer) r42.second).intValue() * ((Integer) r5.second).intValue())))) > 1.5d) {
                    return f8728;
                }
                return f8727;
            }
        } else {
            C1283.m16854("nf_subtitles", "Find cell resolution not ajusted to extent");
        }
        if (((double) f) > 1.5d) {
            return f8728;
        }
        return f8727;
    }
}
