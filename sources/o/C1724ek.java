package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.ek  reason: case insensitive filesystem */
public final class C1724ek extends AbstractC1653dR {

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6681;

    public C1724ek(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, String str) {
        super("search", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6681 = str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (this.f6681 != null) {
            data.put("term", this.f6681);
        }
        return data;
    }
}
