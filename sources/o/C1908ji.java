package o;

import android.content.Context;
import com.android.volley.Request;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.ji  reason: case insensitive filesystem */
public class C1908ji extends AbstractC1907jh {

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    protected static final String f8017 = iT.f7647;

    /* renamed from: ˈ  reason: contains not printable characters */
    private final String f8018;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    protected final iX f8019;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final String f8020 = "['link']";

    public C1908ji(Context context, String str, iX iXVar) {
        super(context);
        this.f8018 = str;
        this.f8019 = iXVar;
    }

    @Override // o.AbstractC1810gP, com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.HIGH;
    }

    @Override // o.AbstractC1810gP, com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.PLAY_OTHER;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1810gP, o.AbstractC1807gM, com.android.volley.Request
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("bladerunnerParams", this.f8018);
        return params;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1807gM
    /* renamed from: ˎ */
    public List<String> mo989() {
        return Arrays.asList(this.f8020);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public JSONObject mo986(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            C1283.m16847(f8017, "error parsing json", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo992(JSONObject jSONObject) {
        JSONObject r2 = C1905jf.m7998(f8017, "link", jSONObject);
        JSONObject jSONObject2 = null;
        Status status = AbstractC0367.f13251;
        if (r2 != null) {
            JSONObject optJSONObject = r2.optJSONObject("result");
            status = C1905jf.m7995(this.f8016, r2, BladerunnerErrorStatus.BrRequestType.Link);
            if (optJSONObject != null) {
                jSONObject2 = optJSONObject.optJSONObject("links");
            }
        }
        if (this.f8019 != null) {
            this.f8019.mo7576(jSONObject2, status);
        } else {
            C1283.m16854(f8017, "no callback for link");
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        if (this.f8019 != null) {
            this.f8019.mo7576((JSONObject) null, status);
        } else {
            C1283.m16854(f8017, "no callback for link");
        }
    }
}
