package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.ez  reason: case insensitive filesystem */
public class C1739ez extends SessionEndedEvent {

    /* renamed from: ˋ  reason: contains not printable characters */
    private IClientLogging.ModalView f6709;

    public C1739ez(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView) {
        super("viewName", deviceUniqueId, j);
        this.f6709 = modalView;
        this.category = "uiView";
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (this.f6709 != null) {
            data.put("view", this.modalView.name());
        }
        data.put(FalkorPathResult.PATH, new JSONArray());
        return data;
    }
}
