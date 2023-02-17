package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dt  reason: case insensitive filesystem */
public final class C1680dt extends AbstractC1679ds {

    /* renamed from: ᐝ  reason: contains not printable characters */
    private IClientLogging.ModalView f6438;

    public C1680dt(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6022(IClientLogging.ModalView modalView) {
        this.f6438 = modalView;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public IClientLogging.ModalView m6024() {
        return this.f6438;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "navigate";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1715eb m6023(IClientLogging.ModalView modalView, IClientLogging.CompletionReason completionReason, UIError uIError) {
        if (this.f6438 != null) {
            modalView = this.f6438;
        }
        if (modalView == this.f6437) {
            return null;
        }
        C1715eb ebVar = new C1715eb(this.f6158, System.currentTimeMillis() - this.f6160, this.f6436, completionReason, uIError, modalView, this.f6437);
        ebVar.setCategory(mo5643());
        ebVar.setSessionId(this.f6158);
        return ebVar;
    }
}
