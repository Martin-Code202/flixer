package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.dU  reason: case insensitive filesystem */
public class C1656dU extends AbstractC1653dR {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final long f6424;

    public C1656dU(String str, DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, long j2) {
        super(str, deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6424 = j2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (this.f6424 > -1) {
            data.put("lolomoTtl", this.f6424);
        }
        return data;
    }
}
