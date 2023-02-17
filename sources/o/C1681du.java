package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.du  reason: case insensitive filesystem */
public final class C1681du extends AbstractC1679ds {
    public C1681du(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "hideFromHistory";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1655dT m6025(IClientLogging.CompletionReason completionReason, UIError uIError) {
        C1655dT dTVar = new C1655dT(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError);
        dTVar.setCategory(mo5643());
        dTVar.setSessionId(this.f6158);
        return dTVar;
    }
}
