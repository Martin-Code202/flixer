package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dG  reason: case insensitive filesystem */
public final class C1642dG extends AbstractC1679ds {

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f6413;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private UserActionLogging.RememberProfile f6414;

    public C1642dG(String str, UserActionLogging.RememberProfile rememberProfile, UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
        if (str == null) {
            throw new IllegalArgumentException("Profile ID is null!");
        }
        this.f6413 = str;
        this.f6414 = rememberProfile;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "selectProfile";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1723ej m6002(IClientLogging.CompletionReason completionReason, UIError uIError, IClientLogging.ModalView modalView) {
        C1723ej ejVar = new C1723ej(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, this.f6413, this.f6414);
        ejVar.setCategory(mo5643());
        ejVar.setSessionId(this.f6158);
        return ejVar;
    }
}
