package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.List;
/* renamed from: o.ن  reason: contains not printable characters */
public class C0585 extends AbstractRunnableC0373 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0859 f13855;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f13856;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0585(C0876<?> r5, String str, AbstractC1203 r7) {
        super(r5, r7);
        this.f13856 = str;
        this.f13855 = C0859.m15528("videos", str, C0859.m15523("summary", "detail"));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(this.f13855);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r5, C0856 r6) {
        CH ch = (CH) this.f13290.m15584(this.f13855);
        if (ch == null || C1349Bv.m4113(ch.getId())) {
            String str = "SPY-7519: FetchFalkorVideoTask got weird movie id: " + (ch == null ? "null" : ch.getId()) + " requested videoId " + this.f13856;
            C1276.m16820().mo5727(str);
            C1283.m16850("CmpTask", str);
            r5.mo8177((CH) null, (Status) AbstractC0367.f13245);
            return;
        }
        r5.mo8177(ch, (Status) AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo8177((CH) null, status);
    }
}
