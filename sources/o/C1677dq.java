package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dq  reason: case insensitive filesystem */
public final class C1677dq extends AbstractC1679ds {

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f6435;

    public C1677dq(String str, UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
        if (str == null) {
            throw new IllegalArgumentException("Profile ID is null!");
        }
        this.f6435 = str;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "deleteProfile";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C1657dV m6019(IClientLogging.CompletionReason completionReason, UIError uIError, IClientLogging.ModalView modalView) {
        C1657dV dVVar = new C1657dV(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, this.f6435);
        dVVar.setCategory(mo5643());
        dVVar.setSessionId(this.f6158);
        return dVVar;
    }
}
