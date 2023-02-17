package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dm  reason: case insensitive filesystem */
public final class C1674dm extends AbstractC1679ds {
    public C1674dm(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "acknowledgeSignup";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1651dP m6016(IClientLogging.CompletionReason completionReason, UIError uIError, IClientLogging.ModalView modalView) {
        C1651dP dPVar = new C1651dP(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError);
        dPVar.setCategory(mo5643());
        dPVar.setSessionId(this.f6158);
        return dPVar;
    }
}
