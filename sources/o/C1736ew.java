package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONObject;
/* renamed from: o.ew  reason: case insensitive filesystem */
public class C1736ew extends AbstractC1735ev {

    /* renamed from: ˎ  reason: contains not printable characters */
    private IClientLogging.ModalView f6700;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f6701 = false;

    public C1736ew(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, boolean z) {
        super("viewName", deviceUniqueId, j);
        this.f6700 = modalView;
        this.f6701 = z;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (this.f6700 != null) {
            data.put("view", this.f6700.name());
        }
        data.put("isModal", this.f6701);
        return data;
    }
}
