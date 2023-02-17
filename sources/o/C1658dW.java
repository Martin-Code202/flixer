package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.dW  reason: case insensitive filesystem */
public final class C1658dW extends AbstractC1653dR {

    /* renamed from: ˏ  reason: contains not printable characters */
    private UserActionLogging.C0029 f6426;

    public C1658dW(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, UserActionLogging.C0029 r17) {
        super("editProfile", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        if (r17 == null) {
            C1283.m16865("profile", "EditProfileEndedEvent: Profile object missing!");
        } else {
            this.f6426 = r17;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (this.f6426 != null) {
            data.put("profile", this.f6426.m1567());
        }
        return data;
    }
}
