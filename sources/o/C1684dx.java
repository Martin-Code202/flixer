package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dx  reason: case insensitive filesystem */
public final class C1684dx extends AbstractC1679ds {
    public C1684dx(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "logIn";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C1660dY m6028(IClientLogging.CompletionReason completionReason, UIError uIError) {
        C1660dY dYVar = new C1660dY(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError);
        dYVar.setCategory(mo5643());
        dYVar.setSessionId(this.f6158);
        return dYVar;
    }
}
