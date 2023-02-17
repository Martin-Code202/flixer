package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.model.leafs.Video;
import java.util.List;
/* renamed from: o.ᓿ  reason: contains not printable characters */
public class C0854 extends AbstractRunnableC0373 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f14692;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0859 f14693;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0854(C0876<?> r4, String str, AbstractC1203 r6) {
        super(r4, r6);
        this.f14693 = C0859.m15528("videos", str, "summary");
        this.f14692 = str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(this.f14693);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r5, C0856 r6) {
        CH ch = (CH) this.f13290.m15584(this.f14693);
        if (ch == null || C1349Bv.m4113(ch.getId())) {
            String str = "SPY-7519: FetchVideoSummaryTask got weird movie id: " + (ch == null ? "null" : ch.getId()) + " requested videoId " + this.f14692;
            C1276.m16820().mo5727(str);
            C1283.m16850("CmpTask", str);
            r5.mo8525((Video.Summary) null, AbstractC0367.f13245);
            return;
        }
        r5.mo8525(ch.getSummary(), AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo8525((Video.Summary) null, status);
    }
}
