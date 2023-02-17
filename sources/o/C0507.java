package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.List;
/* renamed from: o.є  reason: contains not printable characters */
public class C0507 extends AbstractRunnableC0373 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0859 f13641;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0507(C0876<?> r4, String str, AbstractC1203 r6) {
        super(r4, r6);
        this.f13641 = C0859.m15528("videos", str, "advisories");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(this.f13641);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊॱ */
    public boolean mo14116() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r4, C0856 r5) {
        CH ch = (CH) this.f13290.m15584(this.f13641);
        if (ch == null || C1349Bv.m4113(ch.getId())) {
            r4.mo8522(null, AbstractC0367.f13234);
        } else {
            r4.mo8522(ch.getAdvisories(), AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo8522(null, status);
    }
}
