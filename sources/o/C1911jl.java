package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus;
import org.json.JSONObject;
/* renamed from: o.jl  reason: case insensitive filesystem */
public class C1911jl extends C1908ji {
    public C1911jl(Context context, String str, iX iXVar) {
        super(context, str, iXVar);
    }

    /* access modifiers changed from: protected */
    @Override // o.C1908ji
    /* renamed from: ˎ */
    public void mo992(JSONObject jSONObject) {
        JSONObject r4 = C1905jf.m7998(f8017, "link", jSONObject);
        Status r5 = C1905jf.m7995(this.f8016, r4, BladerunnerErrorStatus.BrRequestType.OfflineLicenseDelete);
        String str = null;
        if (r4 != null) {
            JSONObject optJSONObject = r4.optJSONObject("result");
            str = optJSONObject != null ? optJSONObject.optString("response") : null;
        }
        C1283.m16851(f8017, "OfflineLicenseDeactivate status %s has result %s", r5, str);
        if (this.f8019 != null) {
            this.f8019.mo6959(r5, str);
        } else {
            C1283.m16854(f8017, "no callback for licenseDeactivate");
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C1908ji, o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        if (this.f8019 != null) {
            this.f8019.mo6959(status, (String) null);
        } else {
            C1283.m16854(f8017, "no callback for link");
        }
    }
}
