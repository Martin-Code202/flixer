package o;

import com.netflix.mediaclient.service.logging.apm.model.Orientation;
import com.netflix.mediaclient.service.logging.client.model.DiscreteEvent;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONObject;
/* renamed from: o.bu  reason: case insensitive filesystem */
public class C1572bu extends DiscreteEvent {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Orientation f6175;

    /* renamed from: ˎ  reason: contains not printable characters */
    private IClientLogging.ModalView f6176;

    /* renamed from: ॱ  reason: contains not printable characters */
    private CustomerServiceLogging.ReturnToDialScreenFrom f6177;

    public C1572bu(IClientLogging.ModalView modalView, Orientation orientation, CustomerServiceLogging.ReturnToDialScreenFrom returnToDialScreenFrom) {
        this.category = "customerSupport";
        this.name = "backToDialScreen";
        this.f6176 = modalView;
        this.f6175 = orientation;
        this.f6177 = returnToDialScreenFrom;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (this.f6176 != null) {
            data.put("sourceModalView", this.f6176.name());
        }
        if (this.f6175 != null) {
            data.put("orientation", this.f6175.name());
        }
        if (this.f6177 != null) {
            data.put("entryPoint", this.f6177.name());
        }
        return data;
    }
}
