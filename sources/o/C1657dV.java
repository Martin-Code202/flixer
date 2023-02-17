package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.dV  reason: case insensitive filesystem */
public final class C1657dV extends AbstractC1653dR {

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6425;

    public C1657dV(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, String str) {
        super("deleteProfile", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6425 = str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (this.f6425 != null) {
            data.put("profileId", this.f6425);
        }
        return data;
    }
}
