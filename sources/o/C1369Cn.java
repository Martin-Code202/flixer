package o;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.Cn  reason: case insensitive filesystem */
public class C1369Cn implements AbstractC0574 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private JSONObject f5181;

    public C1369Cn(String str, AbstractC2087qh qhVar, int i, String str2, int i2, long j, JSONObject jSONObject) {
        m4513(str, qhVar, i, str2, i2, j);
        if (jSONObject != null) {
            m4512(jSONObject);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m4513(String str, AbstractC2087qh qhVar, int i, String str2, int i2, long j) {
        String requestId = qhVar.getRequestId();
        String impressionToken = qhVar.getImpressionToken();
        int heroTrackId = qhVar.isHero() ? qhVar.getHeroTrackId() : qhVar.getTrackId();
        int listPos = qhVar.getListPos();
        boolean isHero = qhVar.isHero();
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            jSONObject.putOpt("listId", str);
        }
        jSONObject.putOpt("time", Long.valueOf(j));
        jSONObject.putOpt("videoId", Integer.valueOf(i));
        jSONObject.putOpt("requestId", requestId);
        if (impressionToken != null) {
            jSONObject.putOpt("impressionToken", impressionToken);
        }
        jSONObject.putOpt("trackId", Integer.valueOf(heroTrackId));
        jSONObject.putOpt("row", Integer.valueOf(listPos));
        jSONObject.putOpt("rank", Integer.valueOf(i2));
        jSONObject.putOpt("isHero", Boolean.valueOf(isHero));
        if (C1349Bv.m4107(str2)) {
            jSONObject.putOpt("imageKey", str2);
        }
        this.f5181 = jSONObject;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m4512(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f5181.put(next, jSONObject.get(next));
            } catch (JSONException e) {
                C1276.m16820().mo5729(String.format("Failed to add additional info for key: %s to Tracking Info json %s.", next, jSONObject.toString()), e);
            }
        }
    }

    @Override // o.AbstractC0503
    public JSONObject toJSONObject() {
        return this.f5181;
    }
}
