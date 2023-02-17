package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dD  reason: case insensitive filesystem */
public final class C1639dD extends AbstractC1679ds {
    public C1639dD(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "removeFromPlaylist";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1716ec m5999(IClientLogging.CompletionReason completionReason, UIError uIError) {
        C1716ec ecVar = new C1716ec(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError);
        ecVar.setCategory(mo5643());
        ecVar.setSessionId(this.f6158);
        return ecVar;
    }
}
