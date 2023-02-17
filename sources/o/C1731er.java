package o;

import com.netflix.mediaclient.servicemgr.IClientLogging;
/* renamed from: o.er  reason: case insensitive filesystem */
public final class C1731er extends AbstractC1730eq {
    public C1731er(IClientLogging.ModalView modalView) {
        super(modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "viewName";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1691eD m6341() {
        C1691eD eDVar = new C1691eD(m6340());
        eDVar.setCategory(mo5643());
        eDVar.setSessionId(this.f6158);
        return eDVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1736ew m6342(boolean z) {
        C1736ew ewVar = new C1736ew(this.f6158, System.currentTimeMillis() - this.f6160, m6340(), z);
        ewVar.setCategory(mo5643());
        ewVar.setSessionId(this.f6158);
        return ewVar;
    }
}
