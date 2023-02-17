package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.bW  reason: case insensitive filesystem */
public final class C1548bW extends AbstractC1679ds {
    public C1548bW(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "Download";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1608cb m5771(String str) {
        C1608cb cbVar = new C1608cb(str);
        cbVar.setCategory(mo5643());
        cbVar.setSessionId(this.f6158);
        return cbVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1612cf m5770(IClientLogging.CompletionReason completionReason, UIError uIError, IClientLogging.ModalView modalView) {
        C1612cf cfVar = new C1612cf(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError);
        cfVar.setCategory(mo5643());
        cfVar.setSessionId(this.f6158);
        return cfVar;
    }
}
