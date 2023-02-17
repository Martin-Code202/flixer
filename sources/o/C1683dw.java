package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dw  reason: case insensitive filesystem */
public class C1683dw extends AbstractC1679ds {
    public C1683dw(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "NewLolomo";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1659dX m6027(IClientLogging.CompletionReason completionReason, UIError uIError, IClientLogging.ModalView modalView, String str, String str2, long j, String str3, String str4) {
        C1659dX dXVar = new C1659dX(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, str, str2, j, str3, str4);
        dXVar.setCategory(mo5643());
        dXVar.setSessionId(this.f6158);
        return dXVar;
    }
}
