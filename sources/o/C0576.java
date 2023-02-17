package o;

import android.text.TextUtils;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.model.leafs.originals.BillboardSummary;
import java.util.Collections;
import java.util.List;
/* renamed from: o.ة  reason: contains not printable characters */
public class C0576 extends AbstractRunnableC0373 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f13837;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f13838;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final boolean f13839;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final String f13840;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0576(C0876<?> r1, int i, int i2, String str, boolean z, AbstractC1203 r6) {
        super(r1, r6);
        this.f13837 = i;
        this.f13838 = i2;
        this.f13840 = str;
        this.f13839 = z;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        C0506.m14505(list, this.f13840, this.f13290.m15575(), this.f13837, this.f13838, true);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r11, C0856 r12) {
        List list;
        List<AbstractC2077pz> list2;
        List r4 = C0859.m15523("summary", "detail", "inQueue");
        if (TextUtils.isEmpty(this.f13840)) {
            list2 = this.f13290.mo15259(C0859.m15528("lolomo", "billboard", "videoEvidence", C0859.m15519(this.f13838), r4));
            list = this.f13290.mo15259(C0859.m15528("lolomo", "billboard", "billboardData", C0859.m15519(this.f13838), "billboardSummary"));
        } else {
            list2 = this.f13290.mo15259(C0859.m15528("lists", this.f13840, "videoEvidence", C0859.m15519(this.f13838), r4));
            list = this.f13290.mo15259(C0859.m15528("lists", this.f13840, "billboardData", C0859.m15519(this.f13838), "billboardSummary"));
        }
        int i = 0;
        while (true) {
            if (i >= list2.size()) {
                break;
            }
            BillboardSummary billboardSummary = null;
            CH ch = (CH) list2.get(i);
            if (i < list.size()) {
                billboardSummary = (BillboardSummary) list.get(i);
            }
            if (billboardSummary != null) {
                ch.set("billboardSummary", billboardSummary);
                if (!(billboardSummary.getVideoAssets() == null || billboardSummary.getVideoAssets().horizontalBackground() == null || TextUtils.isEmpty(billboardSummary.getVideoAssets().horizontalBackground().motionUrl()))) {
                    list2.clear();
                    list2.add(ch);
                    break;
                }
            }
            i++;
        }
        r11.mo7396(list2, AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo7396(Collections.emptyList(), status);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˋॱ */
    public boolean mo14118() {
        return this.f13839;
    }
}
