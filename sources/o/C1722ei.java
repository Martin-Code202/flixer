package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.ei  reason: case insensitive filesystem */
public class C1722ei extends AbstractC1653dR {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final long f6678;

    public C1722ei(String str, DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, long j2) {
        super(str, deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6678 = j2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (this.f6678 > -1) {
            data.put("lolomoFetchedTime", this.f6678);
        }
        return data;
    }
}
