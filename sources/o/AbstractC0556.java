package o;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.ך  reason: contains not printable characters */
public abstract class AbstractC0556 implements AbstractC0503 {

    /* renamed from: ˎ  reason: contains not printable characters */
    protected List<String> f13794 = new ArrayList();

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final long f13795 = C0590.m14711();

    protected AbstractC0556() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m14630(String str) {
        this.f13794.add(0, str);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public long m14625() {
        return this.f13795;
    }

    @Override // o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f13795);
        JSONArray jSONArray = new JSONArray();
        jSONObject.put("type", jSONArray);
        for (String str : this.f13794) {
            jSONArray.put(str);
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public JSONObject m14626(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            jSONObject.put(str, str2);
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public JSONObject m14628(JSONObject jSONObject, String str, Enum r4) {
        if (r4 != null) {
            jSONObject.put(str, r4.name());
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public JSONObject m14624(JSONObject jSONObject, String str, AbstractC0503 r4) {
        if (r4 != null) {
            jSONObject.put(str, r4.toJSONObject());
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public JSONObject m14629(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject2 != null) {
            jSONObject.put(str, jSONObject2);
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public JSONObject m14627(JSONObject jSONObject, String str, long j) {
        jSONObject.put(str, j);
        return jSONObject;
    }
}
