package o;

import android.content.Context;
import android.os.Build;
import com.android.volley.Request;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus;
import com.netflix.mediaclient.servicemgr.Logblob;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import o.O;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.bV  reason: case insensitive filesystem */
public class C1547bV extends AbstractC1810gP<JSONObject> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final AtomicLong f6144 = new AtomicLong(0);

    /* renamed from: ˎ  reason: contains not printable characters */
    private final O.If f6145;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final JSONObject f6146;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private Context f6147;

    public C1547bV(Context context, List<Logblob> list, Logblob.C0028 r11, O.If r12) {
        long incrementAndGet = f6144.incrementAndGet();
        this.f6147 = context;
        this.f6146 = m5766(context, incrementAndGet, r11, list);
        this.f6145 = r12;
    }

    @Override // o.AbstractC1810gP, com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    @Override // o.AbstractC1810gP, com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.LOG_BLOB;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1810gP
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean mo5769() {
        return false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private long m5765(long j) {
        return j;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private JSONObject m5766(Context context, long j, Logblob.C0028 r11, List<Logblob> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            JSONObject r6 = list.get(i).mo1555();
            r6.put("clienttime", m5765(list.get(i).mo1557()));
            r6.put("snum", j);
            r6.put("lnum", i + 1);
            r6.put(Device.ESN, r11.f2635);
            r6.put("devmod", r11.f2636);
            r6.put("platformVersion", C1318At.m3776(context));
            r6.put("platformBuildNum", C1318At.m3778(context));
            r6.put("platformType", "Android Tanto");
            r6.put("uiver", C1318At.m3776(context));
            r6.put("via", "br");
            r6.put("fingerprint", Build.FINGERPRINT);
            jSONArray.put(r6);
        }
        jSONObject.put("entries", jSONArray);
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1810gP, o.AbstractC1807gM, com.android.volley.Request
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", "logblob");
            jSONObject.put("logblobs", this.f6146);
        } catch (Exception e) {
            C1283.m16847("nf_msl_volley_SendLogblobs", "error creating logblob params", e);
        }
        params.put("bladerunnerParams", jSONObject.toString());
        return params;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1807gM
    /* renamed from: ˎ */
    public List<String> mo989() {
        return Arrays.asList("['logblobs']");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public JSONObject mo986(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            C1283.m16847("nf_msl_volley_SendLogblobs", "error parsing json", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo992(JSONObject jSONObject) {
        if (this.f6145 != null) {
            this.f6145.mo5228(C1905jf.m7995(this.f6147, C1905jf.m7998("nf_msl_volley_SendLogblobs", "logblobs", jSONObject), BladerunnerErrorStatus.BrRequestType.other));
            return;
        }
        C1283.m16865("nf_msl_volley_SendLogblobs", "callback null?");
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        if (this.f6145 != null) {
            this.f6145.mo5228(status);
        } else {
            C1283.m16865("nf_msl_volley_SendLogblobs", "callback null?");
        }
    }
}
