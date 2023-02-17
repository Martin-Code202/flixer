package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.model.leafs.LoLoMoSummary;
import java.util.ArrayList;
import java.util.List;
import o.AB;
/* renamed from: o.ᵂ  reason: contains not printable characters */
public class C0999 extends AbstractRunnableC0373 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f15068;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f15069;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f15070;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final int f15071;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0999(C0876<?> r1, String str, int i, int i2, int i3, AbstractC1203 r6) {
        super(r1, r6);
        this.f15069 = str;
        this.f15070 = i;
        this.f15071 = i2;
        this.f15068 = i3;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ᐝ */
    public void mo14133() {
        boolean r5 = m15943();
        C1283.m16851("CmpTask", "Checking if - refreshType = %s & if lolomoExpired = %s", Integer.valueOf(this.f15068), Boolean.valueOf(r5));
        if (this.f15068 == 1 || r5) {
            this.f13290.m15254(C0859.m15528("topGenres", this.f15069));
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊॱ */
    public boolean mo14116() {
        return this.f15068 == 2;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private boolean m15943() {
        Object r4 = this.f13290.mo15251(C0859.m15528("topGenres", this.f15069, "summary"));
        LoLoMoSummary loLoMoSummary = r4 instanceof LoLoMoSummary ? (LoLoMoSummary) r4 : null;
        if (loLoMoSummary != null) {
            return (System.currentTimeMillis() - loLoMoSummary.getExpiryTimeStamp()) / 1000 > 0;
        }
        C1283.m16854("CmpTask", "Lolomosummary is null, expired is true by defualt");
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public List<AB.If> mo14120() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new AB.If("ggbb", C0727.m15069() ? "false" : "true"));
        if (this.f15068 == 2) {
            arrayList.add(new AB.If("refreshContent", Boolean.TRUE.toString()));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(C0859.m15528("topGenres", this.f15069, "summary"));
        list.add(C0859.m15528("topGenres", this.f15069, C0859.m15519(this.f15070), "summary"));
        list.add(C0859.m15528("topGenres", this.f15069, C0859.m15519(this.f15070), C0859.m15519(this.f15071), "summary"));
        if (C0727.m15067()) {
            list.add(C0859.m15528("topGenres", this.f15069, "queue", "summary"));
            C0859 r3 = C0859.m15528("topGenres", this.f15069, "continueWatching", C0859.m15519(this.f15071));
            list.add(C0506.m14508(true).m15540(r3));
            list.add(C0506.f13635.m15540(r3));
            C0859 r4 = C0859.m15528("topGenres", this.f15069, "billboard", "videoEvidence", C0859.m15519(this.f15071));
            list.add(C0506.m14502(true).m15540(r4));
            list.add(C0506.f13636.m15540(r4));
            list.add(C0859.m15528("topGenres", this.f15069, "billboard", "billboardData", C0859.m15519(this.f15071), "billboardSummary"));
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r7, C0856 r8) {
        Object r4 = this.f13290.mo15251(C0859.m15528("topGenres", this.f15069, "summary"));
        r7.mo8528(r4 instanceof LoLoMoSummary ? (LoLoMoSummary) r4 : null, (Status) AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo8528((LoLoMoSummary) null, status);
    }
}
