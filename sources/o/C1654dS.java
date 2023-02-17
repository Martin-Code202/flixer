package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dS  reason: case insensitive filesystem */
public class C1654dS extends AbstractC1679ds {
    public C1654dS(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "command";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1652dQ m6009(IClientLogging.CompletionReason completionReason, UIError uIError, String str) {
        C1652dQ dQVar = new C1652dQ(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, str);
        dQVar.setCategory(mo5643());
        dQVar.setSessionId(this.f6158);
        return dQVar;
    }
}
