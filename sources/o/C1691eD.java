package o;

import com.netflix.mediaclient.service.logging.client.model.SessionStartedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONObject;
/* renamed from: o.eD  reason: case insensitive filesystem */
public class C1691eD extends SessionStartedEvent {

    /* renamed from: ˏ  reason: contains not printable characters */
    private IClientLogging.ModalView f6458;

    public C1691eD(IClientLogging.ModalView modalView) {
        super("viewName");
        this.f6458 = modalView;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (this.f6458 != null) {
            data.put("view", this.f6458.name());
        }
        return data;
    }
}
