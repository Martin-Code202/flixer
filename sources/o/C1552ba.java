package o;

import com.netflix.mediaclient.service.logging.apm.model.Orientation;
import com.netflix.mediaclient.service.logging.client.model.DiscreteEvent;
import com.netflix.mediaclient.service.logging.client.model.SessionEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONObject;
/* renamed from: o.ba  reason: case insensitive filesystem */
public final class C1552ba extends DiscreteEvent {

    /* renamed from: ˋ  reason: contains not printable characters */
    private Orientation f6150;

    public C1552ba(boolean z, IClientLogging.ModalView modalView) {
        this.f6150 = z ? Orientation.portrait : Orientation.landscape;
        this.modalView = modalView;
        this.category = SessionEvent.CATEGORY_VALUE;
        this.name = "uiModalViewChanged";
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put("orientation", this.f6150.name());
        return data;
    }
}
