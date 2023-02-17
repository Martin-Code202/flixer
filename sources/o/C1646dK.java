package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.dK  reason: case insensitive filesystem */
public final class C1646dK extends AbstractC1679ds {
    public C1646dK(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "submitPayment";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1728eo m6006(IClientLogging.CompletionReason completionReason, UIError uIError, boolean z, UserActionLogging.PaymentType paymentType, JSONObject jSONObject) {
        C1728eo eoVar = new C1728eo(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, z, paymentType, jSONObject);
        eoVar.setCategory(mo5643());
        eoVar.setSessionId(this.f6158);
        return eoVar;
    }
}
