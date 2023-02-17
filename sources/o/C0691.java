package o;

import android.text.TextUtils;
import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.ui.search.SearchUtils;
import com.netflix.model.leafs.SearchResults;
import com.netflix.model.leafs.SearchTrackableListSummary;
import java.util.ArrayList;
import java.util.List;
/* renamed from: o.ย  reason: contains not printable characters */
public class C0691 extends AbstractRunnableC0373 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final CmpTaskMode f14185;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final C0859 f14186;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C0859 f14187;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0859 f14188;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0859 f14189;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0691(C0876<?> r5, String str, CmpTaskMode cmpTaskMode, boolean z, AbstractC1203 r9) {
        super(r5, r9);
        this.f14185 = cmpTaskMode;
        String r6 = SearchUtils.m2913(str);
        this.f14188 = C0859.m15528("newSearch", r6, "titles", "summary");
        this.f14189 = C0859.m15528("newSearch", r6, "titleSuggestions", "summary");
        if (z) {
            this.f14186 = C0859.m15528("newSearch", r6, "titles", C0859.m15519(20), "item", C0859.m15523("summary", "searchTitle"));
        } else {
            this.f14186 = C0859.m15528("newSearch", r6, "titles", C0859.m15519(20), "item", "summary");
        }
        this.f14187 = C0859.m15528("newSearch", r6, "titleSuggestions", C0859.m15519(19), "summary");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(this.f14188);
        list.add(this.f14189);
        list.add(this.f14186);
        list.add(this.f14187);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r10, C0856 r11) {
        SearchResults.Builder builder = new SearchResults.Builder();
        builder.setVideoListSummary((SearchTrackableListSummary) this.f13290.mo15251(this.f14188));
        builder.setSuggestionsListSummary((SearchTrackableListSummary) this.f13290.mo15251(this.f14189));
        List r4 = this.f13290.mo15259(this.f14186);
        if (!r4.isEmpty()) {
            builder.addVideos(r4);
        }
        List<AbstractC0851> r5 = this.f13290.mo15259(this.f14187);
        if (!r5.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (AbstractC0851 r8 : r5) {
                if ((r8 instanceof AbstractC2083qd) && !TextUtils.isEmpty(((AbstractC2083qd) r8).getEntityId())) {
                    arrayList.add((AbstractC2083qd) r8);
                }
            }
            builder.addSuggestions(arrayList);
        }
        r10.mo8526(builder.getResults(), AbstractC0367.f13235);
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
        return this.f14185 == CmpTaskMode.FROM_CACHE_ONLY;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊॱ */
    public boolean mo14116() {
        return this.f14185 == CmpTaskMode.FROM_NETWORK;
    }
}
