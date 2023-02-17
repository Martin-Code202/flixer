package o;

import android.text.TextUtils;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.model.leafs.originals.BigRowSummary;
import java.util.Collections;
import java.util.List;
/* renamed from: o.ԍ  reason: contains not printable characters */
public class C0535 extends AbstractRunnableC0373 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f13744;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f13745;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final String f13746;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final boolean f13747;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0535(C0876<?> r1, int i, int i2, String str, boolean z, AbstractC1203 r6) {
        super(r1, r6);
        this.f13744 = i;
        this.f13745 = i2;
        this.f13747 = z;
        this.f13746 = str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        C0506.m14517(list, this.f13290.m15575(), this.f13746, this.f13744, this.f13745, true);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r11, C0856 r12) {
        List list;
        List<AbstractC2070ps> list2;
        BigRowSummary bigRowSummary;
        List r4 = C0859.m15523("summary", "detail", "inQueue");
        if (TextUtils.isEmpty(this.f13746)) {
            list2 = this.f13290.mo15259(C0859.m15528("lolomo", "bigRow", "videoEvidence", C0859.m15519(this.f13745), r4));
            list = this.f13290.mo15259(C0859.m15528("lolomo", "bigRow", "bigRowData", C0859.m15519(this.f13745), "bigRowSummary"));
        } else {
            list2 = this.f13290.mo15259(C0859.m15528("lists", this.f13746, "videoEvidence", C0859.m15519(this.f13745), r4));
            list = this.f13290.mo15259(C0859.m15528("lists", this.f13746, "bigRowData", C0859.m15519(this.f13745), "bigRowSummary"));
        }
        for (int i = 0; i < list2.size(); i++) {
            CH ch = (CH) list2.get(i);
            if (i < list.size() && (bigRowSummary = (BigRowSummary) list.get(i)) != null) {
                ch.set("bigRowSummary", bigRowSummary);
            }
        }
        r11.mo7397(list2, AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo7397(Collections.emptyList(), status);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˋॱ */
    public boolean mo14118() {
        return this.f13747;
    }
}
