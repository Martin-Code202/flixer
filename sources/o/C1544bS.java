package o;

import android.content.Context;
import com.android.volley.Request;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.logging.pdslogging.streaming.PdsStreamingPlaySession;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import o.U;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.bS  reason: case insensitive filesystem */
public class C1544bS extends AbstractC1810gP<JSONObject> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final JSONObject f6137;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final U.AbstractC0101 f6138;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private NetworkRequestType f6139 = NetworkRequestType.PDS_KEEP_ALIVE;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private Context f6140;

    public C1544bS(Context context, String[] strArr, U.AbstractC0101 r13) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (String str : strArr) {
                JSONObject jSONObject2 = new JSONObject(str);
                NetworkRequestType r9 = PdsStreamingPlaySession.m626(jSONObject2);
                if (this.f6139 == NetworkRequestType.PDS_EVENT || r9 == NetworkRequestType.PDS_EVENT) {
                    this.f6139 = NetworkRequestType.PDS_EVENT;
                } else {
                    this.f6139 = r9;
                }
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("pdsBundle", jSONArray);
        } catch (Exception e) {
            C1283.m16850("nf_msl_volley_SendPdsBundle", "error in creating json array");
        }
        this.f6140 = context;
        this.f6137 = jSONObject;
        this.f6138 = r13;
    }

    @Override // o.AbstractC1810gP, com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.HIGH;
    }

    @Override // o.AbstractC1810gP, com.android.volley.Request
    public Object getTag() {
        return this.f6139;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1810gP, o.AbstractC1807gM, com.android.volley.Request
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("bladerunnerParams", this.f6137.toString());
        return params;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1807gM
    /* renamed from: ˎ */
    public List<String> mo989() {
        return Arrays.asList("['pdsEventBundle']");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public JSONObject mo986(String str) {
        C1283.m16845("nf_msl_volley_SendPdsBundle", "parseFalkorResponse " + str);
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            C1283.m16847("nf_msl_volley_SendPdsBundle", "error parsing json", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo992(JSONObject jSONObject) {
        if (this.f6138 != null) {
            this.f6138.mo5282(C1905jf.m7995(this.f6140, C1905jf.m7998("nf_msl_volley_SendPdsBundle", "pdsEventBundle", jSONObject), BladerunnerErrorStatus.BrRequestType.other));
            return;
        }
        C1283.m16865("nf_msl_volley_SendPdsBundle", "callback null?");
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        if (this.f6138 != null) {
            this.f6138.mo5282(status);
        } else {
            C1283.m16865("nf_msl_volley_SendPdsBundle", "callback null?");
        }
    }
}
