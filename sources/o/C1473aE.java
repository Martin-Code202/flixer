package o;

import com.netflix.mediaclient.servicemgr.IClientLogging;
/* renamed from: o.aE  reason: case insensitive filesystem */
public final class C1473aE extends AbstractC1523az {

    /* renamed from: ˎ  reason: contains not printable characters */
    private IClientLogging.ModalView f5891;

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "uiModelessView";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1494aY m5369(boolean z, IClientLogging.ModalView modalView) {
        this.f5891 = modalView;
        C1494aY aYVar = new C1494aY(z, modalView);
        aYVar.setCategory(mo5643());
        aYVar.setSessionId(this.f6158);
        aYVar.setModalView(modalView);
        return aYVar;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1554bc m5370() {
        C1554bc bcVar = new C1554bc(this.f6158, System.currentTimeMillis() - this.f6160, this.f5891);
        bcVar.setCategory(mo5643());
        bcVar.setSessionId(this.f6158);
        bcVar.setModalView(this.f5891);
        return bcVar;
    }
}
