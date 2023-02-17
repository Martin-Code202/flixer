package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dI  reason: case insensitive filesystem */
public final class C1644dI extends AbstractC1679ds {
    public C1644dI(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "survey";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1727en m6004(IClientLogging.CompletionReason completionReason, UIError uIError, String str) {
        C1727en enVar = new C1727en(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, str);
        enVar.setCategory(mo5643());
        enVar.setSessionId(this.f6158);
        return enVar;
    }
}
