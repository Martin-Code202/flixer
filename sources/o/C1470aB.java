package o;

import com.netflix.mediaclient.service.logging.client.model.DiscreteEvent;
import org.json.JSONObject;
/* renamed from: o.aB  reason: case insensitive filesystem */
public class C1470aB extends DiscreteEvent {

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f5890;

    public C1470aB(String str) {
        this.category = "settings";
        this.name = "localSettingChange";
        this.f5890 = str;
        setTime(System.currentTimeMillis());
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            return new JSONObject();
        }
        return data;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getCustomData() {
        return new JSONObject(this.f5890);
    }
}
