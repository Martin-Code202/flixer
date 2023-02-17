package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dz  reason: case insensitive filesystem */
public class C1686dz extends AbstractC1679ds {
    public C1686dz(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "RegisterForPushNotifications";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1717ed m6030() {
        return new C1717ed();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1718ee m6031(String str, boolean z, boolean z2, IClientLogging.CompletionReason completionReason, UIError uIError, String str2) {
        C1718ee eeVar = new C1718ee(str, z, z2, this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, str2);
        eeVar.setCategory(mo5643());
        eeVar.setSessionId(this.f6158);
        return eeVar;
    }
}
