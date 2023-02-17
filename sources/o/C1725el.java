package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.el  reason: case insensitive filesystem */
public class C1725el extends AbstractC1653dR {

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f6682;

    public C1725el(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, int i) {
        super("SelectPlan", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6682 = i;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        return super.getData().put("planID", this.f6682);
    }
}
