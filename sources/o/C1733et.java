package o;

import com.netflix.mediaclient.servicemgr.IClientLogging;
/* renamed from: o.et  reason: case insensitive filesystem */
public final class C1733et extends AbstractC1730eq {
    public C1733et(IClientLogging.ModalView modalView) {
        super(modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "focus";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C1688eA m6345(String str) {
        C1688eA eAVar = new C1688eA(this.f6691, str);
        eAVar.setCategory(mo5643());
        eAVar.setSessionId(this.f6158);
        return eAVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1739ez m6346() {
        C1739ez ezVar = new C1739ez(m5779(), System.currentTimeMillis() - this.f6160, m6340());
        ezVar.setCategory(mo5643());
        ezVar.setSessionId(this.f6158);
        return ezVar;
    }
}
