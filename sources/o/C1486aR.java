package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import org.json.JSONObject;
/* renamed from: o.aR  reason: case insensitive filesystem */
public class C1486aR extends SessionEndedEvent {

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f5915;

    public C1486aR(DeviceUniqueId deviceUniqueId, long j, String str) {
        super("sharedContext", deviceUniqueId, j);
        this.f5915 = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put("uuid", this.f5915);
        data.put("role", "initiator");
        return data;
    }
}
