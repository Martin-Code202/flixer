package o;

import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.model.leafs.social.IrisNotificationSummary;
import java.util.ArrayList;
import java.util.List;
/* renamed from: o.ᴢ  reason: contains not printable characters */
public class C0959 extends AbstractRunnableC0373 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final List<IrisNotificationSummary> f14865;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0959(C0876<?> r3, IrisNotificationSummary irisNotificationSummary, AbstractC1203 r5) {
        super(r3, r5);
        if (irisNotificationSummary == null) {
            throw new RuntimeException("MarkNotificationAsReadTask got null notification");
        }
        this.f14865 = new ArrayList();
        this.f14865.add(irisNotificationSummary);
    }

    public C0959(C0876<?> r4, List<IrisNotificationSummary> list, AbstractC1203 r6) {
        super(r4, r6);
        if (list == null || list.size() == 0) {
            throw new RuntimeException("MarkNotificationAsReadTask got invalid notifications list: " + list);
        }
        this.f14865 = list;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        ArrayList arrayList = new ArrayList();
        for (IrisNotificationSummary irisNotificationSummary : this.f14865) {
            arrayList.add(irisNotificationSummary.getId());
        }
        list.add(C0859.m15528("notifications", arrayList, "markAsRead"));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public boolean mo14115() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r3, C0856 r4) {
        r3.mo8173(new NetflixStatus(StatusCode.OK));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r1, Status status) {
        r1.mo8173(status);
    }
}
