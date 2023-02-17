package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.model.leafs.LoLoMoSummary;
import java.util.ArrayList;
import java.util.List;
import o.AB;
/* renamed from: o.ڙ  reason: contains not printable characters */
public class C0620 extends AbstractRunnableC0373 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f13928;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0620(C0876<?> r1, String str, AbstractC1203 r3) {
        super(r1, r3);
        this.f13928 = str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public List<AB.If> mo14120() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new AB.If("ggbb", C0727.m15069() ? "false" : "true"));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(C0859.m15528("topGenres", this.f13928, "summary"));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r7, C0856 r8) {
        Object r4 = this.f13290.mo15251(C0859.m15528("topGenres", this.f13928, "summary"));
        r7.mo8531((pA) (r4 instanceof LoLoMoSummary ? (LoLoMoSummary) r4 : null), (Status) AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo8531((pA) null, status);
    }
}
