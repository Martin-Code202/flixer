package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.eb  reason: case insensitive filesystem */
public class C1715eb extends AbstractC1653dR {

    /* renamed from: ˏ  reason: contains not printable characters */
    private IClientLogging.ModalView f6665;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private IClientLogging.ModalView f6666;

    public C1715eb(DeviceUniqueId deviceUniqueId, long j, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, IClientLogging.ModalView modalView, IClientLogging.ModalView modalView2) {
        super("navigate", deviceUniqueId, j, modalView2, commandName, completionReason, uIError);
        this.f6666 = modalView;
        this.f6665 = modalView2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (this.f6665 != null) {
            data.put("destinationView", this.f6665.name());
        }
        if (this.f6666 != null) {
            data.put("sourceModalView", this.f6666.name());
        }
        return data;
    }
}
