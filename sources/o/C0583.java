package o;

import java.util.List;
/* renamed from: o.ـ  reason: contains not printable characters */
public class C0583 extends AbstractC0746<Integer> {
    public C0583(List<C1297AUx<Integer>> list) {
        super(list);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Integer mo4283(C1297AUx<Integer> aUx, float f) {
        if (aUx.f4310 != null && aUx.f4309 != null) {
            return Integer.valueOf(C1010.m15969(f, aUx.f4310.intValue(), aUx.f4309.intValue()));
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
