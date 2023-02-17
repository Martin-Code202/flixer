package o;

import java.util.List;
/* renamed from: o.ᴵ  reason: contains not printable characters */
public class C0983 extends AbstractC0746<C0736> {
    public C0983(List<C1297AUx<C0736>> list) {
        super(list);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C0736 mo4283(C1297AUx<C0736> aUx, float f) {
        if (aUx.f4310 == null || aUx.f4309 == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        T t = aUx.f4310;
        T t2 = aUx.f4309;
        return new C0736(C1150.m16323(t.m15109(), t2.m15109(), f), C1150.m16323(t.m15108(), t2.m15108(), f));
    }
}
