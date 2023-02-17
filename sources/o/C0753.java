package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* renamed from: o.ᐳ  reason: contains not printable characters */
public class C0753 extends AbstractRunnableC0373 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0859 f14363 = C0859.m15528("videos", this.f14364, "offlineAvailable");

    /* renamed from: ˏ  reason: contains not printable characters */
    private final List<String> f14364;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0753(C0876<?> r4, List<String> list, AbstractC1203 r6) {
        super(r4, r6);
        this.f14364 = list;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(this.f14363);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r10, C0856 r11) {
        HashMap hashMap = new HashMap();
        for (String str : this.f14364) {
            Object r7 = this.f13290.mo15251(C0859.m15528("videos", str, "offlineAvailable"));
            if (r7 == null || !(r7 instanceof CH)) {
                hashMap.put(str, false);
            } else {
                hashMap.put(str, Boolean.valueOf(((CH) r7).isAvailableOffline()));
            }
        }
        if (hashMap.size() == 0) {
            C1283.m16865("CmpTask", "received 0 videos inside FetchOfflineGeoPlayabilityTask");
            C1276.m16820().mo5727("received 0 videos inside FetchOfflineGeoPlayabilityTask");
        }
        r10.mo7348(hashMap, AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo7348(Collections.emptyMap(), status);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊॱ */
    public boolean mo14116() {
        return true;
    }
}
