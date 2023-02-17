package o;

import com.android.volley.Request;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.model.leafs.social.IrisNotificationsListImpl;
import com.netflix.model.leafs.social.IrisNotificationsListSummary;
import java.util.List;
/* renamed from: o.ᒉ  reason: contains not printable characters */
public class C0770 extends AbstractRunnableC0373 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f14399;

    /* renamed from: ʼ  reason: contains not printable characters */
    private List<C1382Cy> f14400;

    /* renamed from: ʽ  reason: contains not printable characters */
    private C0859 f14401;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f14402;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final boolean f14403;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C0859 f14404;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final C0859 f14405;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0770(C0876<?> r4, int i, int i2, boolean z, AbstractC1203 r8) {
        super(r4, r8);
        this.f14402 = i;
        this.f14399 = i2;
        this.f14403 = z;
        this.f14405 = C0859.m15528("notificationsList", C0859.m15532(i, i2), "summary");
        if (z) {
            this.f14400 = this.f13290.mo15259(this.f14405);
        }
    }

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˋ */
    public Request.Priority mo14117() {
        return Request.Priority.NORMAL;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public boolean mo14121(List<C0859> list) {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊॱ */
    public boolean mo14116() {
        return this.f14403;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        this.f14401 = C0859.m15528("notificationsList", C0859.m15532(this.f14402, this.f14399), "notificationVideo", C0859.m15523("summary", "inQueue", "tvCardArt"));
        this.f14404 = C0859.m15528("notificationsList", "summary");
        list.add(this.f14405);
        list.add(this.f14401);
        list.add(this.f14404);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r5, C0856 r6) {
        List<C1382Cy> r2 = this.f13290.mo15259(this.f14405);
        if (this.f14403 && !m15223(r2)) {
            m15224();
        }
        r5.mo8174(new IrisNotificationsListImpl((IrisNotificationsListSummary) this.f13290.mo15251(this.f14404), r2, this.f13290), AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo8174((AbstractC2082qc) null, status);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m15223(List<C1382Cy> list) {
        if (this.f14400 == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        if (this.f14400.size() != list.size()) {
            return true;
        }
        int i = 0;
        for (C1382Cy cy : this.f14400) {
            if (!C1349Bv.m4126(cy.f5241.getId(), list.get(i).f5241.getId())) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m15224() {
        List r6 = this.f13290.mo15259(C0859.m15528("notificationsList", C0859.m15532(this.f14399 + 1, this.f14399 + ((this.f14399 - this.f14402) * 10)), "summary"));
        if (r6 != null) {
            int size = r6.size();
            for (int i = this.f14399 + 1; i < this.f14399 + 1 + size; i++) {
                this.f13290.m15254(C0859.m15528("notificationsList", Integer.valueOf(i)));
            }
        }
    }
}
