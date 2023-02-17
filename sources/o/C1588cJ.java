package o;

import android.content.Context;
import com.android.volley.Request;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import o.V;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.cJ  reason: case insensitive filesystem */
public class C1588cJ extends AbstractC1810gP<JSONObject> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final V.AbstractC1467iF f6223;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6224;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private Context f6225;

    public C1588cJ(Context context, String str, V.AbstractC1467iF iFVar) {
        this.f6225 = context;
        this.f6224 = str;
        this.f6223 = iFVar;
    }

    @Override // o.AbstractC1810gP, com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.HIGH;
    }

    @Override // o.AbstractC1810gP, com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.RELEASE_LICENSE;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1810gP, o.AbstractC1807gM, com.android.volley.Request
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("bladerunnerParams", this.f6224);
        return params;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1807gM
    /* renamed from: ˎ */
    public List<String> mo989() {
        return Arrays.asList("['link']");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public JSONObject mo986(String str) {
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
        }
        return C1905jf.m7998("nf_msl_volley_SendReleaseLicense", "link", jSONObject);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo992(JSONObject jSONObject) {
        Status status = AbstractC0367.f13251;
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            jSONObject2 = jSONObject.optJSONObject("result");
            status = C1905jf.m7995(this.f6225, jSONObject, BladerunnerErrorStatus.BrRequestType.Link);
        }
        if (this.f6223 != null) {
            this.f6223.mo5307(jSONObject2, status);
        } else {
            C1283.m16865("nf_msl_volley_SendReleaseLicense", "callback null?");
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        if (this.f6223 != null) {
            this.f6223.mo5307(null, status);
        } else {
            C1283.m16865("nf_msl_volley_SendReleaseLicense", "callback null?");
        }
    }
}
