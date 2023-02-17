package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dM  reason: case insensitive filesystem */
public final class C1648dM extends AbstractC1679ds {
    public C1648dM(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "surveyQuestion";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1726em m6008(IClientLogging.CompletionReason completionReason, UIError uIError, String str, String str2) {
        C1726em emVar = new C1726em(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, str, str2);
        emVar.setCategory(mo5643());
        emVar.setSessionId(this.f6158);
        return emVar;
    }
}
