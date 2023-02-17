package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dL  reason: case insensitive filesystem */
public final class C1647dL extends AbstractC1679ds {

    /* renamed from: ʻ  reason: contains not printable characters */
    private UserActionLogging.Streams f6415;

    public C1647dL(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView, UserActionLogging.Streams streams) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "upgradeStreams";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C1729ep m6007(IClientLogging.CompletionReason completionReason, UIError uIError, UserActionLogging.Streams streams) {
        C1729ep epVar = new C1729ep(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, this.f6415, streams);
        epVar.setCategory(mo5643());
        epVar.setSessionId(this.f6158);
        return epVar;
    }
}
