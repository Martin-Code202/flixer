package o;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import o.AbstractC1001;
import org.apache.http.impl.cookie.DateUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.হ  reason: contains not printable characters */
public class C0669 {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static Map<String, String> m14867(AbstractC1001.Cif ifVar) {
        if (ifVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (ifVar.f15078 != null) {
            hashMap.put("If-None-Match", ifVar.f15078);
        }
        if (ifVar.f15079 > 0) {
            hashMap.put("If-Modified-Since", DateUtils.formatDate(new Date(ifVar.f15079)));
        }
        return hashMap;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m14866(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            if (jSONObject.has("host")) {
                return jSONObject.getString("host");
            }
            return null;
        } catch (JSONException e) {
            C0509.m14519("Json exception reading redirect response %s", e);
            return null;
        }
    }
}
