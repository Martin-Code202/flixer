package o;

import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.model.leafs.SearchResults;
import com.netflix.model.leafs.SearchTrackableListSummary;
import java.util.List;
/* renamed from: o.ᓕ  reason: contains not printable characters */
public class C0823 extends AbstractRunnableC0373 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final CmpTaskMode f14613;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0859 f14614;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0859 f14615;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final C0859 f14616;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0823(C0876<?> r5, CmpTaskMode cmpTaskMode, String str, boolean z, int i, int i2, AbstractC1203 r11) {
        super(r5, r11);
        this.f14613 = cmpTaskMode;
        this.f14614 = C0859.m15528("searchSuggestionByEntityId", str, "summary");
        this.f14615 = C0859.m15528("searchSuggestionByEntityId", str, C0859.m15532(i, i2), "summary");
        if (z) {
            this.f14616 = C0859.m15528("searchSuggestionByEntityId", str, C0859.m15532(i, i2), "item", C0859.m15523("summary", "searchTitle"));
        } else {
            this.f14616 = C0859.m15528("searchSuggestionByEntityId", str, C0859.m15532(i, i2), "item", "summary");
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(this.f14614);
        list.add(this.f14615);
        list.add(this.f14616);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r7, C0856 r8) {
        SearchResults.Builder builder = new SearchResults.Builder();
        builder.setVideoListSummary((SearchTrackableListSummary) this.f13290.mo15251(this.f14614));
        List r4 = this.f13290.mo15259(this.f14615);
        if (!r4.isEmpty()) {
            builder.addCollection(r4);
            List r5 = this.f13290.mo15259(this.f14616);
            if (!r5.isEmpty()) {
                builder.addVideos(r5);
            }
        }
        r7.mo8526(builder.getResults(), AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r3, Status status) {
        r3.mo8526(new SearchResults.Builder().getResults(), status);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˋॱ */
    public boolean mo14118() {
        return this.f14613 == CmpTaskMode.FROM_CACHE_ONLY;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊॱ */
    public boolean mo14116() {
        return this.f14613 == CmpTaskMode.FROM_NETWORK;
    }
}
