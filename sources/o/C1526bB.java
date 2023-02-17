package o;

import com.netflix.mediaclient.service.logging.client.model.DiscreteEvent;
import org.json.JSONObject;
/* renamed from: o.bB  reason: case insensitive filesystem */
public class C1526bB extends DiscreteEvent {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6115;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6116;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f6117;

    public C1526bB(String str, String str2, String str3) {
        this.category = "dial";
        this.name = "serverDiscovered";
        this.f6117 = str;
        this.f6116 = str3;
        this.f6115 = str2;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (C1349Bv.m4107(this.f6117)) {
            data.put("uuid", this.f6117);
        }
        if (C1349Bv.m4107(this.f6115)) {
            data.put("discoveryResponseHeaders", this.f6115);
        }
        if (C1349Bv.m4107(this.f6116)) {
            data.put("deviceDescription", this.f6116);
        }
        return data;
    }
}
