package o;

import com.google.gson.JsonObject;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.model.leafs.advisory.ExpiringContentAdvisory;
import java.util.List;
import java.util.Locale;
/* renamed from: o.ｉ  reason: contains not printable characters */
public class C1228 extends AbstractRunnableC0373 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private C0859 f15754;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C1228(C0876<?> r4, String str, ExpiringContentAdvisory.ContentAction contentAction) {
        super(r4, AbstractC1222.m16563());
        this.f15754 = C0859.m15528("expiringContentNotice", str, contentAction.name().toLowerCase(Locale.ENGLISH));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(this.f15754);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ͺ */
    public boolean mo14125() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14113(JsonObject jsonObject) {
        if (C0848.m15504(jsonObject.getAsJsonObject("value"))) {
            throw new FalkorException("Empty value");
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r1, C0856 r2) {
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r1, Status status) {
    }
}
