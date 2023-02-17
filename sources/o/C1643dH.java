package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dH  reason: case insensitive filesystem */
public class C1643dH extends AbstractC1679ds {
    public C1643dH(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "serializeLolomo";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1722ei m6003(IClientLogging.CompletionReason completionReason, UIError uIError, long j) {
        C1722ei eiVar = new C1722ei("serializeLolomo", this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, j);
        eiVar.setCategory(mo5643());
        eiVar.setSessionId(this.f6158);
        return eiVar;
    }
}
