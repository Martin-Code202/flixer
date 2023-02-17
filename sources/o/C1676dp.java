package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dp  reason: case insensitive filesystem */
public class C1676dp extends AbstractC1679ds {
    public C1676dp(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "deserializeLolomo";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1656dU m6018(IClientLogging.CompletionReason completionReason, UIError uIError, long j) {
        C1656dU dUVar = new C1656dU("deserializeLolomo", this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, j);
        dUVar.setCategory(mo5643());
        dUVar.setSessionId(this.f6158);
        return dUVar;
    }
}
