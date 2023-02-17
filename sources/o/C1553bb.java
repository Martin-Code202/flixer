package o;

import com.netflix.mediaclient.service.logging.apm.model.Orientation;
import com.netflix.mediaclient.service.logging.client.model.DiscreteEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONObject;
/* renamed from: o.bb  reason: case insensitive filesystem */
public class C1553bb extends DiscreteEvent {

    /* renamed from: ˋ  reason: contains not printable characters */
    private Orientation f6151;

    public C1553bb(boolean z, IClientLogging.ModalView modalView) {
        this.f6151 = z ? Orientation.portrait : Orientation.landscape;
        this.modalView = modalView;
        this.category = "uiView";
        this.name = "impression";
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put("orientation", this.f6151.name());
        return data;
    }
}
