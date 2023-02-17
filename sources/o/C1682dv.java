package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dv  reason: case insensitive filesystem */
public final class C1682dv extends AbstractC1679ds {
    public C1682dv(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "editProfile";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1658dW m6026(IClientLogging.CompletionReason completionReason, UIError uIError, IClientLogging.ModalView modalView, UserActionLogging.C0029 r16) {
        C1658dW dWVar = new C1658dW(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, r16);
        dWVar.setCategory(mo5643());
        dWVar.setSessionId(this.f6158);
        return dWVar;
    }
}
