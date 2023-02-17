package o;

import com.netflix.mediaclient.service.logging.client.model.DiscreteEvent;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import org.json.JSONObject;
/* renamed from: o.bx  reason: case insensitive filesystem */
public class C1575bx extends DiscreteEvent {

    /* renamed from: ˏ  reason: contains not printable characters */
    private CustomerServiceLogging.Action f6191;

    public C1575bx(CustomerServiceLogging.Action action) {
        this.f6191 = action;
        this.category = "customerSupport";
        this.name = "dialScreenDismissed";
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (this.f6191 != null) {
            data.put("action", this.f6191.name());
        }
        return data;
    }
}
