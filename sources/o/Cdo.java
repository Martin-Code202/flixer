package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.do  reason: invalid class name */
public final class Cdo extends AbstractC1679ds {
    public Cdo(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "addProfile";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1649dN m6017(IClientLogging.CompletionReason completionReason, UIError uIError, IClientLogging.ModalView modalView, UserActionLogging.C0029 r16) {
        C1649dN dNVar = new C1649dN(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, r16);
        dNVar.setCategory(mo5643());
        dNVar.setSessionId(this.f6158);
        return dNVar;
    }
}
