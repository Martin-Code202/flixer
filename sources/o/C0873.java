package o;

import android.util.Pair;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.model.leafs.FlatGenreListOfVideosSummary;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* renamed from: o.ᔪ  reason: contains not printable characters */
public class C0873 extends AbstractRunnableC0373 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final boolean f14743;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final boolean f14744;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final boolean f14745;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected final pC f14746;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final int f14747;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected final int f14748;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final boolean f14749;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0873(C0876<?> r1, pC pCVar, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, AbstractC1203 r9) {
        super(r1, r9);
        this.f14746 = pCVar;
        this.f14747 = i;
        this.f14748 = i2;
        this.f14749 = z;
        this.f14743 = z2;
        this.f14744 = z3;
        this.f14745 = z4;
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
        Pair<pC, String> r4;
        String id = this.f14746.getId();
        if (!(!this.f14744 || (r4 = this.f13290.m15579(this.f14746.getType())) == null || r4.first == null)) {
            id = ((pC) r4.first).getId();
        }
        String str = LoMoType.FLAT_GENRE == this.f14746.getType() ? "flatGenre" : "lists";
        ArrayList arrayList = new ArrayList();
        arrayList.add("summary");
        if (this.f14745) {
            arrayList.add("detail");
        }
        if (this.f14746.getType() == LoMoType.FLAT_GENRE) {
            list.add(C0859.m15528(str, id, "summary"));
        }
        list.add(C0859.m15528(str, id, C0859.m15532(this.f14747, this.f14748), arrayList));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r6, C0856 r7) {
        List<pJ> r4 = this.f13290.m15255(r7.f14697);
        if (this.f14746.getType() == LoMoType.FLAT_GENRE) {
            r6.mo8538((FlatGenreListOfVideosSummary) this.f13290.mo15251(C0859.m15528("flatGenre", this.f14746.getId(), "summary")), r4, AbstractC0367.f13235);
        } else {
            r6.mo7398(r4, AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo7398(Collections.emptyList(), status);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˋॱ */
    public boolean mo14118() {
        return this.f14749;
    }
}
