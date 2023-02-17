package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.ClientActionFromLase;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.jn  reason: case insensitive filesystem */
public class C1913jn extends C1908ji {
    public C1913jn(Context context, String str, iX iXVar) {
        super(context, str, iXVar);
    }

    /* access modifiers changed from: protected */
    @Override // o.C1908ji
    /* renamed from: ˎ */
    public void mo992(JSONObject jSONObject) {
        C1283.m16862(f8017, "parsing license sync response");
        Status status = AbstractC0367.f13235;
        HashMap hashMap = new HashMap();
        JSONObject jSONObject2 = null;
        JSONObject jSONObject3 = null;
        JSONObject r8 = C1905jf.m7998(f8017, "link", jSONObject);
        if (r8 != null) {
            status = C1905jf.m7995(this.f8016, r8, BladerunnerErrorStatus.BrRequestType.SyncLicense);
            jSONObject2 = r8.optJSONObject("result");
        }
        if (jSONObject2 != null) {
            jSONObject3 = jSONObject2.optJSONObject("actions");
        }
        if (jSONObject3 != null) {
            try {
                Iterator<String> keys = jSONObject3.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject3.getString(next);
                    C1283.m16863(f8017, "OfflineLicenseSyncRequest response movieId=%s action=%s", next, string);
                    hashMap.put(next, ClientActionFromLase.m971(C1332Be.m4015(string, Integer.valueOf(ClientActionFromLase.NO_ACTION.m972())).intValue()));
                }
            } catch (JSONException e) {
                C1283.m16847(f8017, "JSONException", e);
            }
        }
        if (this.f8019 != null) {
            this.f8019.mo6977(hashMap, status);
        } else {
            C1283.m16854(f8017, "no callback for OfflineLicenseSyncRequest");
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C1908ji, o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        if (this.f8019 != null) {
            this.f8019.mo6977(Collections.emptyMap(), status);
        } else {
            C1283.m16854(f8017, "no callback for OfflineLicenseSyncRequest");
        }
    }
}
