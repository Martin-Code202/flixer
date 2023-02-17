package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.as  reason: case insensitive filesystem */
public class C1514as extends AbstractC1515at {

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f6053;

    public C1514as(String str, UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
        this.f6053 = str;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "shareOpenSheet";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1522ay m5642(IClientLogging.CompletionReason completionReason, UIError uIError, IClientLogging.ModalView modalView) {
        C1522ay ayVar = new C1522ay(this.f6053, this.f6158, System.currentTimeMillis() - this.f6160, this.f6055, this.f6054, completionReason, uIError);
        ayVar.setCategory(mo5643());
        ayVar.setSessionId(this.f6158);
        return ayVar;
    }
}
