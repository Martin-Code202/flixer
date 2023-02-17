package o;

import com.netflix.mediaclient.service.logging.client.model.DiscreteEvent;
import org.json.JSONObject;
/* renamed from: o.ah  reason: case insensitive filesystem */
public class C1503ah extends DiscreteEvent {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f6025;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f6026;

    public C1503ah(String str, int i) {
        this.f6025 = str;
        this.f6026 = i;
        this.category = "abTest";
        this.name = "abTestReceived";
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put("abTestID", this.f6025);
        data.put("abTestCellID", this.f6026);
        return data;
    }
}
