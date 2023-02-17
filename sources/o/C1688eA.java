package o;

import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.logging.client.model.SessionStartedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.eA  reason: case insensitive filesystem */
public class C1688eA extends SessionStartedEvent {

    /* renamed from: ˋ  reason: contains not printable characters */
    private IClientLogging.ModalView f6443;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f6444;

    public C1688eA(IClientLogging.ModalView modalView, String str) {
        super("focus");
        this.f6443 = modalView;
        this.f6444 = str;
        this.category = "uiView";
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (this.f6443 != null) {
            data.put("view", this.f6443.name());
        }
        JSONArray jSONArray = new JSONArray();
        if (C1349Bv.m4107(this.f6444)) {
            jSONArray.put(this.f6444);
        }
        data.put(FalkorPathResult.PATH, jSONArray);
        return data;
    }
}
