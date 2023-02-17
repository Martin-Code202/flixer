package o;

import com.netflix.mediaclient.service.logging.client.model.DiscreteEvent;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import org.json.JSONObject;
/* renamed from: o.ey  reason: case insensitive filesystem */
public class C1738ey extends DiscreteEvent {

    /* renamed from: ˋ  reason: contains not printable characters */
    private UIViewLogging.UIViewCommandName f6707;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f6708;

    public C1738ey(UIViewLogging.UIViewCommandName uIViewCommandName, int i) {
        this.name = "impression";
        this.category = "uiView";
        this.f6707 = uIViewCommandName;
        this.f6708 = i;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (this.f6707 != null) {
            data.put("view", this.f6707.name());
        }
        data.put("trackId", this.f6708);
        return data;
    }
}
