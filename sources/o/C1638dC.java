package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dC  reason: case insensitive filesystem */
public class C1638dC extends AbstractC1679ds {
    public C1638dC(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "prefetchLolomoJob";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1661dZ m5998(IClientLogging.CompletionReason completionReason, UIError uIError) {
        C1661dZ dZVar = new C1661dZ("prefetchLolomoJob", this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError);
        dZVar.setCategory(mo5643());
        dZVar.setSessionId(this.f6158);
        return dZVar;
    }
}
