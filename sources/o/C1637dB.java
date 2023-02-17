package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dB  reason: case insensitive filesystem */
public final class C1637dB extends AbstractC1679ds {
    public C1637dB(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "rateTitle";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1720eg m5997(IClientLogging.CompletionReason completionReason, UIError uIError, Integer num, int i, String str, int i2, boolean z) {
        C1720eg egVar = new C1720eg(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, num, i, str, i2, z);
        egVar.setCategory(mo5643());
        egVar.setSessionId(this.f6158);
        return egVar;
    }
}
