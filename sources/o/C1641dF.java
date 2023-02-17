package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dF  reason: case insensitive filesystem */
public final class C1641dF extends AbstractC1679ds {
    public C1641dF(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "SelectPlan";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C1725el m6001(IClientLogging.CompletionReason completionReason, UIError uIError, int i) {
        C1725el elVar = new C1725el(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, i);
        elVar.setCategory(mo5643());
        elVar.setSessionId(this.f6158);
        return elVar;
    }
}
