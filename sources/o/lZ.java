package o;
public class lZ {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final lZ f8621 = new lZ(10.0f, 10.0f);

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final lZ f8622 = new lZ(0.0f, 0.0f);

    /* renamed from: ˎ  reason: contains not printable characters */
    private float f8623;

    /* renamed from: ॱ  reason: contains not printable characters */
    private float f8624;

    private lZ() {
    }

    private lZ(float f, float f2) {
        this.f8624 = f;
        this.f8623 = f2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public float m8743() {
        return this.f8624;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public float m8744() {
        return this.f8623;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m8742() {
        return m8740(this.f8624) && m8740(this.f8623);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m8740(float f) {
        return f > 0.0f && f <= 1.0f;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static lZ m8739(String str, mN mNVar) {
        String[] r2;
        if (C1349Bv.m4113(str) || (r2 = C1349Bv.m4118(str, " ")) == null || r2.length < 2) {
            return null;
        }
        int i = 0;
        if (mNVar != null) {
            i = mNVar.m8851();
        }
        Float r4 = C1984mo.m9057(r2[0], i);
        Float r5 = C1984mo.m9057(r2[1], i);
        if (r4 == null || r5 == null) {
            return null;
        }
        return new lZ(r4.floatValue(), r5.floatValue());
    }

    public String toString() {
        return "DoubleLength [mFirst=" + this.f8624 + ", mSecond=" + this.f8623 + "]";
    }

    public int hashCode() {
        return ((Float.floatToIntBits(this.f8624) + 31) * 31) + Float.floatToIntBits(this.f8623);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof lZ)) {
            return false;
        }
        lZ lZVar = (lZ) obj;
        if (Float.floatToIntBits(this.f8624) == Float.floatToIntBits(lZVar.f8624) && Float.floatToIntBits(this.f8623) == Float.floatToIntBits(lZVar.f8623)) {
            return true;
        }
        return false;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m8741(lZ lZVar) {
        return lZVar != null && lZVar.m8742();
    }
}
