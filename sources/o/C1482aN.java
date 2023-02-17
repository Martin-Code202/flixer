package o;

import com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
/* renamed from: o.aN  reason: case insensitive filesystem */
public final class C1482aN extends AbstractC1523az {

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f5909;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1558bg f5910;

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "userSession";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1556be m5384(ApplicationPerformanceMetricsLogging.Trigger trigger, long j) {
        C1556be beVar = new C1556be(trigger, j);
        beVar.setCategory(mo5643());
        return beVar;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1558bg m5385(ApplicationPerformanceMetricsLogging.EndReason endReason, long j, C1359Ce ce, IClientLogging.ModalView modalView) {
        C1558bg bgVar = new C1558bg(this.f6158, System.currentTimeMillis() - this.f6160, endReason, j);
        bgVar.setCategory(mo5643());
        bgVar.setModalView(modalView);
        bgVar.setDataContext(ce);
        if (this.f5909) {
            this.f5910 = bgVar;
            return null;
        }
        bgVar.setSessionId(m5779());
        return bgVar;
    }

    @Override // o.AbstractC1560bi
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo5386(long j) {
        super.mo5386(j);
        this.f5909 = false;
    }
}
