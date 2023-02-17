package o;

import com.netflix.mediaclient.util.ConnectivityUtils;
import org.json.JSONException;
import org.json.JSONObject;
public final class iL {

    /* renamed from: ˋ  reason: contains not printable characters */
    private oX f7537;

    /* renamed from: ˏ  reason: contains not printable characters */
    private ConnectivityUtils.NetType f7538;

    public iL(oX oXVar, ConnectivityUtils.NetType netType) {
        if (oXVar == null) {
            throw new IllegalArgumentException("Play context can not be null!");
        }
        this.f7537 = oXVar;
        this.f7538 = netType;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public JSONObject m7448() {
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject();
            ConnectivityUtils.m2957(jSONObject, this.f7538);
            if (this.f7537 != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("request_id", this.f7537.getRequestId());
                jSONObject2.put("row", this.f7537.getListPos());
                jSONObject2.put("rank", this.f7537.mo9589());
                jSONObject.put("uiplaycontext", jSONObject2);
                jSONObject.put("isUIAutoPlay", "" + this.f7537.mo9592());
            }
        } catch (JSONException e) {
            C1283.m16847("nf_invoke", "Failed to create JSON object", e);
        }
        return jSONObject;
    }
}
