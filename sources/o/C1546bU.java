package o;

import com.netflix.mediaclient.servicemgr.Logblob;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.bU  reason: case insensitive filesystem */
public final class C1546bU {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m5764(List<Logblob> list) {
        JSONArray jSONArray = new JSONArray();
        for (Logblob logblob : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("clientEpoch", logblob.mo1557());
            jSONObject.put("clientJson", logblob.mo1555());
            jSONArray.put(jSONObject);
        }
        return jSONArray.toString();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static List<Logblob> m5763(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(new Cif(jSONArray.getJSONObject(i)));
            }
        } catch (JSONException e) {
            C1283.m16847("nf_logblob", "Unable to create JSON array from payload " + str, e);
        }
        return arrayList;
    }

    /* renamed from: o.bU$if  reason: invalid class name */
    static class Cif implements Logblob {

        /* renamed from: ˋ  reason: contains not printable characters */
        private JSONObject f6142;

        /* renamed from: ॱ  reason: contains not printable characters */
        private long f6143;

        public Cif(JSONObject jSONObject) {
            if (jSONObject == null) {
                throw new IllegalStateException("Payload can not be empty");
            }
            this.f6142 = jSONObject.getJSONObject("clientJson");
            this.f6143 = jSONObject.getLong("clientEpoch");
        }

        @Override // com.netflix.mediaclient.servicemgr.Logblob
        /* renamed from: ˋ */
        public String mo680() {
            throw new IllegalAccessError("Method not implemented");
        }

        @Override // com.netflix.mediaclient.servicemgr.Logblob
        /* renamed from: ˏ */
        public boolean mo1556() {
            throw new IllegalAccessError("Method not implemented");
        }

        @Override // com.netflix.mediaclient.servicemgr.Logblob
        /* renamed from: ᐝ */
        public long mo1557() {
            return this.f6143;
        }

        @Override // com.netflix.mediaclient.servicemgr.Logblob
        /* renamed from: ˎ */
        public JSONObject mo1555() {
            return this.f6142;
        }
    }
}
