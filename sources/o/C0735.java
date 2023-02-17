package o;

import android.graphics.PointF;
/* renamed from: o.ᐟ  reason: contains not printable characters */
public class C0735 implements AbstractC0923<PointF, PointF> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0761 f14303;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0761 f14304;

    C0735(C0761 r1, C0761 r2) {
        this.f14304 = r1;
        this.f14303 = r2;
    }

    @Override // o.AbstractC0923
    /* renamed from: ˎ */
    public AbstractC1622coN<PointF, PointF> mo14241() {
        return new C0591(this.f14304.mo14241(), this.f14303.mo14241());
    }
}
