package o;

import com.netflix.mediaclient.service.logging.client.model.DiscreteEvent;
import org.json.JSONObject;
/* renamed from: o.af  reason: case insensitive filesystem */
public class C1501af extends DiscreteEvent {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f6023;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f6024;

    public C1501af(String str, int i) {
        this.f6023 = str;
        this.f6024 = i;
        this.category = "abTest";
        this.name = "abTestLoaded";
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put("abTestID", this.f6023);
        data.put("abTestCellID", this.f6024);
        return data;
    }
}
