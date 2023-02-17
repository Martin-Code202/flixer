package o;

import com.netflix.mediaclient.service.mdx.protocol.event.Events;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.fv  reason: case insensitive filesystem */
public class C1789fv extends AbstractC1787ft {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final Events f6819 = Events.mdx_discovery_devicelost;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String[] f6820;

    public C1789fv(JSONObject jSONObject) {
        super(f6819.m750(), jSONObject);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1787ft
    /* renamed from: ˏ */
    public void mo6437(JSONObject jSONObject) {
        JSONArray jSONArray;
        if (!jSONObject.has("devicelist") || (jSONArray = jSONObject.getJSONArray("devicelist")) == null) {
            this.f6820 = new String[0];
            return;
        }
        this.f6820 = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f6820[i] = C1785fr.m6453(jSONArray.getString(i));
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String[] m6460() {
        return this.f6820;
    }
}
