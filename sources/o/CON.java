package o;

import android.graphics.PointF;
import java.util.List;
public class CON extends AbstractC0746<PointF> {

    /* renamed from: ॱ  reason: contains not printable characters */
    private final PointF f4989 = new PointF();

    public CON(List<C1297AUx<PointF>> list) {
        super(list);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public PointF mo4283(C1297AUx<PointF> aUx, float f) {
        if (aUx.f4310 == null || aUx.f4309 == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        T t = aUx.f4310;
        T t2 = aUx.f4309;
        this.f4989.set(((PointF) t).x + ((((PointF) t2).x - ((PointF) t).x) * f), ((PointF) t).y + ((((PointF) t2).y - ((PointF) t).y) * f));
        return this.f4989;
    }
}
