package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.jm  reason: case insensitive filesystem */
public class C1912jm extends C1906jg {

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private static final String f8023 = iT.f7647;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final JSONObject f8024;

    public C1912jm(Context context, String str, jG jGVar, iX iXVar) {
        super(context, str, IBladeRunnerClient.ManifestRequestFlavor.OFFLINE, iXVar);
        this.f8024 = jGVar.mo7915();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8013(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("links");
            Object optJSONObject2 = jSONObject2.optJSONObject("license");
            if (optJSONObject2 != null) {
                optJSONObject.put("license", optJSONObject2);
            }
            jSONObject.putOpt("links", optJSONObject);
        } catch (JSONException e) {
            C1283.m16847(f8023, "error injecting old links into manifest", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.netflix.mediaclient.android.app.Status] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: ˊ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.netflix.mediaclient.android.app.Status m8012(org.json.JSONObject r10) {
        /*
            r9 = this;
            com.netflix.mediaclient.android.app.NetflixImmutableStatus r5 = o.AbstractC0367.f13231
            if (r10 == 0) goto L_0x0050
            java.util.Iterator r6 = r10.keys()     // Catch:{ JSONException -> 0x0048 }
        L_0x0008:
            boolean r0 = r6.hasNext()     // Catch:{ JSONException -> 0x0048 }
            if (r0 == 0) goto L_0x0047
            java.lang.Object r0 = r6.next()     // Catch:{ JSONException -> 0x0048 }
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ JSONException -> 0x0048 }
            org.json.JSONObject r8 = r10.getJSONObject(r7)     // Catch:{ JSONException -> 0x0048 }
            android.content.Context r0 = r9.f8016     // Catch:{ JSONException -> 0x0048 }
            com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus$BrRequestType r1 = com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus.BrRequestType.OfflineManifestRefresh     // Catch:{ JSONException -> 0x0048 }
            com.netflix.mediaclient.android.app.Status r0 = o.C1905jf.m7995(r0, r8, r1)     // Catch:{ JSONException -> 0x0048 }
            r5 = r0
            boolean r0 = r5.mo301()     // Catch:{ JSONException -> 0x0048 }
            if (r0 == 0) goto L_0x003d
            java.lang.String r0 = o.C1912jm.f8023     // Catch:{ JSONException -> 0x0048 }
            java.lang.String r1 = "manifest for %s has errors, status: %s"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ JSONException -> 0x0048 }
            r3 = 0
            r2[r3] = r7     // Catch:{ JSONException -> 0x0048 }
            com.netflix.mediaclient.StatusCode r3 = r5.mo302()     // Catch:{ JSONException -> 0x0048 }
            r4 = 1
            r2[r4] = r3     // Catch:{ JSONException -> 0x0048 }
            o.C1283.m16851(r0, r1, r2)     // Catch:{ JSONException -> 0x0048 }
            goto L_0x0047
        L_0x003d:
            org.json.JSONObject r0 = r9.f8024     // Catch:{ JSONException -> 0x0048 }
            if (r0 == 0) goto L_0x0046
            org.json.JSONObject r0 = r9.f8024     // Catch:{ JSONException -> 0x0048 }
            r9.m8013(r8, r0)     // Catch:{ JSONException -> 0x0048 }
        L_0x0046:
            goto L_0x0008
        L_0x0047:
            goto L_0x0050
        L_0x0048:
            r6 = move-exception
            java.lang.String r0 = o.C1912jm.f8023
            java.lang.String r1 = "parsing manifest error"
            o.C1283.m16847(r0, r1, r6)
        L_0x0050:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C1912jm.m8012(org.json.JSONObject):com.netflix.mediaclient.android.app.Status");
    }

    /* access modifiers changed from: protected */
    @Override // o.C1906jg
    /* renamed from: ˎ */
    public void mo992(JSONObject jSONObject) {
        JSONObject r2 = m8004(jSONObject);
        Status r3 = m8012(r2);
        if (this.f8012 != null) {
            this.f8012.mo7615(r2, r3);
        } else {
            C1283.m16865(f8023, "callback null?");
        }
    }
}
