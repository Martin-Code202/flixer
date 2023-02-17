package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.ej  reason: case insensitive filesystem */
public final class C1723ej extends AbstractC1653dR {

    /* renamed from: ʼ  reason: contains not printable characters */
    private UserActionLogging.RememberProfile f6679;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6680;

    public C1723ej(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, String str, UserActionLogging.RememberProfile rememberProfile) {
        super("selectProfile", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6680 = str;
        this.f6679 = rememberProfile;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (this.f6680 != null) {
            data.put("profileId", this.f6680);
        }
        if (this.f6679 != null) {
            data.put("rememberProfile", this.f6679.name());
        }
        return data;
    }
}
