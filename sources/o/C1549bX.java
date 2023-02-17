package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.bX  reason: case insensitive filesystem */
public class C1549bX extends AbstractC1679ds {
    public C1549bX(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "CachedPlay";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1609cc m5773(String str, String str2, int i, int i2, int i3) {
        C1609cc ccVar = new C1609cc(str, str2, i, i2, i3);
        ccVar.setCategory(mo5643());
        ccVar.setSessionId(this.f6158);
        return ccVar;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1610cd m5772(IClientLogging.CompletionReason completionReason, UIError uIError, IClientLogging.ModalView modalView) {
        C1610cd cdVar = new C1610cd(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError);
        cdVar.setCategory(mo5643());
        cdVar.setSessionId(this.f6158);
        return cdVar;
    }
}
