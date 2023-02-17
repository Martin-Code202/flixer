package o;

import com.netflix.mediaclient.service.logging.client.model.SessionStartedEvent;
import org.json.JSONObject;
/* renamed from: o.aT  reason: case insensitive filesystem */
public class C1488aT extends SessionStartedEvent {

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f5918;

    public C1488aT(String str) {
        super("sharedContext");
        this.f5918 = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put("uuid", this.f5918);
        data.put("role", "initiator");
        data.put("trigger", "signup");
        return data;
    }
}
