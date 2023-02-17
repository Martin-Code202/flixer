package o;

import java.util.List;
/* renamed from: o.CoN  reason: case insensitive filesystem */
public class C1371CoN extends AbstractC0746<Integer> {
    public C1371CoN(List<C1297AUx<Integer>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public Integer mo4283(C1297AUx<Integer> aUx, float f) {
        if (aUx.f4310 != null && aUx.f4309 != null) {
            return Integer.valueOf(C1150.m16330(aUx.f4310.intValue(), aUx.f4309.intValue(), f));
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
