package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.model.leafs.SearchResults;
import com.netflix.model.leafs.SearchTrackableListSummary;
import java.util.List;
/* renamed from: o.ᓚ  reason: contains not printable characters */
public class C0831 extends AbstractRunnableC0373 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private C0859 f14636;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0859 f14637;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0831(C0876<?> r4, String str, AbstractC1203 r6, int i, int i2) {
        super(r4, r6);
        this.f14636 = C0859.m15528("searchByReference", str, "summary");
        this.f14637 = C0859.m15528("searchByReference", str, C0859.m15532(i, i2), "summary");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public boolean mo14121(List<C0859> list) {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(this.f14636);
        list.add(this.f14637);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r6, C0856 r7) {
        SearchResults.Builder builder = new SearchResults.Builder();
        builder.setVideoListSummary((SearchTrackableListSummary) this.f13290.mo15251(this.f14636));
        List r4 = this.f13290.mo15259(this.f14637);
        if (!r4.isEmpty()) {
            builder.addCollection(r4);
        }
        r6.mo8526(builder.getResults(), AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r3, Status status) {
        r3.mo8526(new SearchResults.Builder().getResults(), status);
    }
}
