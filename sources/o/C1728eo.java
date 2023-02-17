package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.eo  reason: case insensitive filesystem */
public final class C1728eo extends AbstractC1653dR {

    /* renamed from: ʻ  reason: contains not printable characters */
    private UserActionLogging.PaymentType f6686;

    /* renamed from: ʼ  reason: contains not printable characters */
    private JSONObject f6687;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f6688;

    public C1728eo(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, boolean z, UserActionLogging.PaymentType paymentType, JSONObject jSONObject) {
        super("submitPayment", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6688 = z;
        this.f6686 = paymentType;
        this.f6687 = jSONObject;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (this.f6686 != null) {
            data.put("paymentType", this.f6686.name());
        }
        if (this.f6687 != null) {
            data.put("errorCode", this.f6687);
        }
        data.put(FalkorPathResult.SUCCESS, this.f6688);
        return data;
    }
}
