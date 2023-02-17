package o;

import java.util.List;
/* renamed from: o.cON  reason: case insensitive filesystem */
public class C1594cON extends AbstractC0746<Float> {
    public C1594cON(List<C1297AUx<Float>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public Float mo4283(C1297AUx<Float> aUx, float f) {
        if (aUx.f4310 != null && aUx.f4309 != null) {
            return Float.valueOf(C1150.m16323(aUx.f4310.floatValue(), aUx.f4309.floatValue(), f));
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
