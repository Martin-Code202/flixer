package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.bZ  reason: case insensitive filesystem */
public final class C1551bZ extends AbstractC1679ds {

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f6149;

    public C1551bZ(String str, UserActionLogging.CommandName commandName) {
        super(commandName, null);
        this.f6149 = str;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "RemoveCachedVideo";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1611ce m5774(IClientLogging.CompletionReason completionReason, UIError uIError, IClientLogging.ModalView modalView) {
        C1611ce ceVar = new C1611ce(this.f6158, System.currentTimeMillis() - this.f6160, this.f6149, modalView, this.f6436, completionReason, uIError);
        ceVar.setCategory(mo5643());
        ceVar.setSessionId(this.f6158);
        return ceVar;
    }
}
