package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dJ  reason: case insensitive filesystem */
public final class C1645dJ extends AbstractC1679ds {
    public C1645dJ(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "startPlay";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1721eh m6005(IClientLogging.CompletionReason completionReason, UIError uIError, Integer num, PlayLocationType playLocationType) {
        C1721eh ehVar = new C1721eh(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, num, playLocationType);
        ehVar.setCategory(mo5643());
        ehVar.setSessionId(this.f6158);
        return ehVar;
    }
}
