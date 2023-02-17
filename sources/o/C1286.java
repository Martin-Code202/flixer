package o;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* renamed from: o.ﾞ  reason: contains not printable characters */
public class C1286 extends AbstractC0746<PointF> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final float[] f15994 = new float[2];

    /* renamed from: ˎ  reason: contains not printable characters */
    private PathMeasure f15995;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1161 f15996;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final PointF f15997 = new PointF();

    public C1286(List<? extends C1297AUx<PointF>> list) {
        super(list);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public PointF mo4283(C1297AUx<PointF> aUx, float f) {
        C1161 r4 = (C1161) aUx;
        Path r5 = r4.m16350();
        if (r5 == null) {
            return aUx.f4310;
        }
        if (this.f15996 != r4) {
            this.f15995 = new PathMeasure(r5, false);
            this.f15996 = r4;
        }
        this.f15995.getPosTan(this.f15995.getLength() * f, this.f15994, null);
        this.f15997.set(this.f15994[0], this.f15994[1]);
        return this.f15997;
    }
}
