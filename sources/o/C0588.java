package o;

import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* renamed from: o.ٱ  reason: contains not printable characters */
public class C0588 extends AbstractRunnableC0373 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final CmpTaskMode f13857;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0859 f13858;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0588(C0876<?> r4, String str, CmpTaskMode cmpTaskMode, AbstractC1203 r7) {
        super(r4, r7);
        this.f13858 = C0859.m15528("filteredGenreList", str);
        this.f13857 = cmpTaskMode;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(this.f13858);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r8, C0856 r9) {
        C0993 r5 = (C0993) this.f13290.mo15251(this.f13858);
        if (r5 == null) {
            C1283.m16844("FetchFilteredGenres", "Null response for %s", this.f13858);
            r8.mo8534(null, AbstractC0367.f13245);
            return;
        }
        r8.mo8534(new ArrayList((List) r5.m15933()), AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo8534(Collections.emptyList(), status);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˋॱ */
    public boolean mo14118() {
        return this.f13857 == CmpTaskMode.FROM_CACHE_ONLY;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊॱ */
    public boolean mo14116() {
        return this.f13857 == CmpTaskMode.FROM_NETWORK;
    }
}
