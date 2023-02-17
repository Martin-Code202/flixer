package o;

import com.netflix.mediaclient.android.app.Status;
import java.util.Collections;
import java.util.List;
/* renamed from: o.ᓓ  reason: contains not printable characters */
public class C0822 extends C0873 {
    public C0822(C0876<?> r1, pC pCVar, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, AbstractC1203 r9) {
        super(r1, pCVar, i, i2, z, z2, z3, z4, r9);
    }

    /* access modifiers changed from: protected */
    @Override // o.C0873, o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        super.mo14127(list);
        C0506.m14516(list, this.f14746.getId(), this.f13290.m15575(), this.f14747, this.f14748);
    }

    /* access modifiers changed from: protected */
    @Override // o.C0873, o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r10, C0856 r11) {
        List<pK> list;
        String id = this.f14746.getId();
        String r5 = this.f13290.m15575();
        boolean r6 = C1349Bv.m4113(id);
        boolean r7 = C1349Bv.m4113(r5);
        if (!r6) {
            list = this.f13290.mo15259(C0859.m15528("lists", id, C0859.m15532(this.f14747, this.f14748), "tallPanelArt"));
        } else if (r7) {
            list = this.f13290.mo15259(C0859.m15528("lolomo", "netflixOriginals", C0859.m15532(this.f14747, this.f14748), "tallPanelArt"));
        } else {
            list = this.f13290.mo15259(C0859.m15528("lolomos", r5, "netflixOriginals", C0859.m15532(this.f14747, this.f14748), "tallPanelArt"));
        }
        r10.mo7394(list, AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.C0873, o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo7394(Collections.emptyList(), status);
    }
}
