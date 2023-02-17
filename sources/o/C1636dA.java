package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dA  reason: case insensitive filesystem */
public final class C1636dA extends AbstractC1679ds {
    public C1636dA(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "register";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1719ef m5996(IClientLogging.CompletionReason completionReason, UIError uIError) {
        C1719ef efVar = new C1719ef(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError);
        efVar.setCategory(mo5643());
        efVar.setSessionId(this.f6158);
        return efVar;
    }
}
