package o;

import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONObject;
/* renamed from: o.ex  reason: case insensitive filesystem */
public class C1737ex extends AbstractC1735ev {

    /* renamed from: ˊ  reason: contains not printable characters */
    private JSONObject f6702;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f6703;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f6704;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Error f6705;

    /* renamed from: ॱ  reason: contains not printable characters */
    private IClientLogging.ModalView f6706;

    public C1737ex(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, String str, boolean z, Error error) {
        super("impression", deviceUniqueId, j);
        this.f6706 = modalView;
        this.f6703 = str;
        this.f6704 = z;
        this.f6705 = error;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6348(JSONObject jSONObject) {
        this.f6702 = jSONObject;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (this.f6706 != null) {
            data.put("view", this.f6706);
        }
        if (this.f6705 != null) {
            data.put(ExceptionClEvent.CATEGORY_VALUE, this.f6705.toJSONObject());
        }
        if (this.f6703 != null) {
            data.put("originatingRequestGuid", this.f6703);
        }
        if (this.f6702 != null) {
            data.put(Device.MODEL, this.f6702);
        }
        data.put(FalkorPathResult.SUCCESS, this.f6704);
        return data;
    }
}
