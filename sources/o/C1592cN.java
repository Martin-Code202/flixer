package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.EventType;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.cN  reason: case insensitive filesystem */
public final class C1592cN extends SessionEndedEvent {
    public C1592cN(long j) {
        super("focus", new DeviceUniqueId(), j);
        m5832();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5832() {
        this.sessionName = "focus";
        this.type = EventType.sessionEnded;
        this.modalView = IClientLogging.ModalView.search;
        this.category = "uiView";
        this.name = "focus.ended";
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put(FalkorPathResult.PATH, new JSONArray());
        return data;
    }
}
