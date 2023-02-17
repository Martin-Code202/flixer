package o;

import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import org.json.JSONObject;
/* renamed from: o.cn  reason: case insensitive filesystem */
public class C1620cn {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final String f6300 = C1620cn.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f6301;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f6302;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f6303;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6304;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f6305 = -1;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6306;

    /* renamed from: ॱ  reason: contains not printable characters */
    private JSONObject f6307;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f6308;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C1618cl f6309;

    public C1620cn(JSONObject jSONObject, String str, String str2, String str3) {
        this.f6307 = jSONObject;
        this.f6301 = str;
        this.f6304 = str2;
        this.f6306 = str3;
        this.f6302 = -1;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1620cn m5889(C1618cl clVar) {
        this.f6309 = clVar;
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1620cn m5890(int i) {
        this.f6302 = i;
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1620cn m5891(String str, String str2) {
        this.f6303 = str;
        this.f6308 = str2;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public final String m5888() {
        JSONObject jSONObject = new JSONObject();
        if (this.f6307 == null) {
            return jSONObject.toString();
        }
        try {
            jSONObject.put(LoggingRequest.VERSION, 2);
            jSONObject.put("url", this.f6307.optString("href"));
            long r4 = BA.m3835();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", this.f6301);
            jSONObject2.put("clientTime", r4);
            jSONObject2.put("appSessionId", this.f6304);
            jSONObject2.put("userSessionId", this.f6306);
            jSONObject2.put("isInBackground", !AbstractApplicationC1258.m16693());
            jSONObject2.put("trackerId", this.f6309.m5862());
            if (this.f6302 != -1) {
                jSONObject2.put("progressPercentage", this.f6302);
            }
            if (C1349Bv.m4107(this.f6303)) {
                jSONObject2.put("errorCode", this.f6303);
            }
            if (C1349Bv.m4107(this.f6308)) {
                jSONObject2.put("errorMessage", this.f6308);
            }
            jSONObject2.put("uiDownloadContext", this.f6309.m5856().toString());
            jSONObject.putOpt("params", jSONObject2);
        } catch (Exception e) {
            C1283.m16856(f6300, e, "error creating pds download event params", new Object[0]);
        }
        return jSONObject.toString();
    }
}
