package o;

import com.netflix.mediaclient.service.logging.client.model.EventType;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.logging.client.model.SessionStartedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.cK  reason: case insensitive filesystem */
public class C1589cK extends SessionStartedEvent {

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f6226;

    public C1589cK(String str) {
        super("focus");
        this.f6226 = str;
        m5827();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5827() {
        this.sessionName = "focus";
        this.type = EventType.sessionStarted;
        this.modalView = IClientLogging.ModalView.search;
        this.category = "uiView";
        this.name = "focus.started";
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        JSONArray jSONArray = new JSONArray();
        if (C1349Bv.m4107(this.f6226)) {
            jSONArray.put(this.f6226);
        }
        data.put(FalkorPathResult.PATH, jSONArray);
        return data;
    }
}
