package o;

import java.util.List;
/* renamed from: o.ˑ  reason: contains not printable characters */
public class C0440 extends AbstractC0746<C1009> {

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C1009 f13475;

    public C0440(List<? extends C1297AUx<C1009>> list) {
        super(list);
        T t = ((C1297AUx) list.get(0)).f4310;
        int r4 = t == null ? 0 : t.m15964();
        this.f13475 = new C1009(new float[r4], new int[r4]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public C1009 mo4283(C1297AUx<C1009> aUx, float f) {
        this.f13475.m15965(aUx.f4310, aUx.f4309, f);
        return this.f13475;
    }
}
