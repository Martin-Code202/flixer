package o;

import com.netflix.mediaclient.net.NetworkRequestType;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.র  reason: contains not printable characters */
public class C0666 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Map<String, C0660> f14034 = new HashMap();

    /* renamed from: ˏ  reason: contains not printable characters */
    private NetworkRequestType f14035;

    public C0666(NetworkRequestType networkRequestType) {
        if (networkRequestType == null) {
            throw new IllegalArgumentException("Network type can not be null!");
        }
        this.f14035 = networkRequestType;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m14862(String str, Long l, Long l2) {
        C0660 r1 = this.f14034.get(str);
        if (r1 == null) {
            r1 = new C0660();
            this.f14034.put(str, r1);
        }
        r1.m14832(l, l2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized JSONObject m14861() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("type", this.f14035.name());
        JSONArray jSONArray = new JSONArray();
        jSONObject.put("allocation", jSONArray);
        for (String str : this.f14034.keySet()) {
            JSONObject r7 = this.f14034.get(str).m14829();
            jSONArray.put(r7);
            r7.put("networkType", str);
        }
        return jSONObject;
    }
}
