package o;

import android.content.Context;
import org.json.JSONObject;
/* renamed from: o.aV  reason: case insensitive filesystem */
public class C1491aV {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f5931;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f5932;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f5933;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static C1491aV m5403(Context context) {
        return new C1491aV((int) (Runtime.getRuntime().maxMemory() / 1048576), C1122.m16272(context), AD.m3282(context));
    }

    private C1491aV(int i, int i2, String str) {
        this.f5931 = i;
        this.f5932 = i2;
        this.f5933 = str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public JSONObject m5404() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("heapSize", this.f5931);
        jSONObject.put("yearClass", this.f5932);
        jSONObject.put("screenCat", this.f5933);
        return jSONObject;
    }
}
