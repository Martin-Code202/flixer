package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dr  reason: case insensitive filesystem */
public final class C1678dr extends AbstractC1679ds {
    public C1678dr(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "addToPlaylist";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1650dO m6020(IClientLogging.CompletionReason completionReason, UIError uIError, int i) {
        C1650dO dOVar = new C1650dO(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, i);
        dOVar.setCategory(mo5643());
        dOVar.setSessionId(this.f6158);
        return dOVar;
    }
}
