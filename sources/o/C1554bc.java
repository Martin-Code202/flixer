package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONObject;
/* renamed from: o.bc  reason: case insensitive filesystem */
public final class C1554bc extends SessionEndedEvent {

    /* renamed from: ॱ  reason: contains not printable characters */
    private IClientLogging.ModalView f6152;

    public C1554bc(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView) {
        super("uiModelessView", deviceUniqueId, j);
        this.modalView = modalView;
        this.f6152 = modalView;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (this.f6152 != null) {
            data.put("modelessView", this.f6152.name());
        }
        return data;
    }
}
