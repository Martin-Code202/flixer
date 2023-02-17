package o;

import android.content.Context;
import com.netflix.mediaclient.service.player.StreamProfileType;
import com.netflix.mediaclient.util.ConnectivityUtils;
import org.json.JSONException;
import org.json.JSONObject;
public final class jX {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static JSONObject m7979(Context context, jG jGVar, AbstractC2055pd pdVar) {
        String r4 = C1339Bl.m4045(context, "streamingConfig", (String) null);
        if (r4 != null) {
            C1283.m16851("StreamingConfigHelper", "StreamingConfig :%s", r4);
        }
        JSONObject jSONObject = null;
        if (r4 != null) {
            try {
                jSONObject = m7977(context, new JSONObject(r4), jGVar != null ? jGVar.m7926() : StreamProfileType.CE3);
                if (jSONObject != null) {
                    C2065pn.m9853(jSONObject, pdVar.mo9715().m9854());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static JSONObject m7977(Context context, JSONObject jSONObject, StreamProfileType streamProfileType) {
        JSONObject jSONObject2 = null;
        switch (streamProfileType) {
            case AL0:
                if (jSONObject.has(StreamProfileType.AL0.m934().toLowerCase())) {
                    jSONObject2 = m7978(context, jSONObject.getJSONObject(StreamProfileType.AL0.m934().toLowerCase()));
                    break;
                }
                break;
            case AL1:
                if (jSONObject.has(StreamProfileType.AL1.m934().toLowerCase())) {
                    jSONObject2 = m7978(context, jSONObject.getJSONObject(StreamProfileType.AL1.m934().toLowerCase()));
                    break;
                }
                break;
        }
        if (jSONObject2 == null) {
            return m7978(context, jSONObject);
        }
        return jSONObject2;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static JSONObject m7978(Context context, JSONObject jSONObject) {
        if (!ConnectivityUtils.m2952(context) || !jSONObject.has("cellular")) {
            return jSONObject.getJSONObject("wifi");
        }
        return jSONObject.getJSONObject("cellular");
    }
}
