package o;

import android.content.Context;
import com.android.volley.Request;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.jg  reason: case insensitive filesystem */
public class C1906jg extends AbstractC1907jh {

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final String f8011;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    protected final iX f8012;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    protected final IBladeRunnerClient.ManifestRequestFlavor f8013;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final String f8014 = "['manifests']";

    public C1906jg(Context context, String str, IBladeRunnerClient.ManifestRequestFlavor manifestRequestFlavor, iX iXVar) {
        super(context);
        this.f8011 = str;
        this.f8012 = iXVar;
        this.f8013 = manifestRequestFlavor;
    }

    @Override // o.AbstractC1810gP, com.android.volley.Request
    public Request.Priority getPriority() {
        return IBladeRunnerClient.ManifestRequestFlavor.PREFETCH == this.f8013 ? Request.Priority.NORMAL : Request.Priority.IMMEDIATE;
    }

    @Override // o.AbstractC1810gP, com.android.volley.Request
    public Object getTag() {
        return IBladeRunnerClient.ManifestRequestFlavor.PREFETCH == this.f8013 ? NetworkRequestType.PLAY_PREFETCH_MANIFEST : NetworkRequestType.PLAY_MANIFEST;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1810gP, o.AbstractC1807gM, com.android.volley.Request
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("bladerunnerParams", this.f8011);
        return params;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1807gM
    /* renamed from: ˎ */
    public List<String> mo989() {
        return Arrays.asList(this.f8014);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public JSONObject mo986(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            C1283.m16847("nf_bladerunner", "error parsing json", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public JSONObject m8004(JSONObject jSONObject) {
        JSONObject r2 = C1905jf.m7998("nf_bladerunner", "manifests", jSONObject);
        if (r2 != null) {
            return r2.optJSONObject("result");
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.netflix.mediaclient.android.app.Status] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.netflix.mediaclient.android.app.Status] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: ˏ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.netflix.mediaclient.android.app.Status m8000(org.json.JSONObject r11) {
        /*
            r10 = this;
            com.netflix.mediaclient.android.app.NetflixImmutableStatus r5 = o.AbstractC0367.f13231
            com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient$ManifestRequestFlavor r0 = r10.f8013
            com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient$ManifestRequestFlavor r1 = com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient.ManifestRequestFlavor.OFFLINE
            if (r0 != r1) goto L_0x000b
            com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus$BrRequestType r6 = com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus.BrRequestType.OfflineManifest
            goto L_0x000d
        L_0x000b:
            com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus$BrRequestType r6 = com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus.BrRequestType.StreamingManifest
        L_0x000d:
            if (r11 != 0) goto L_0x0010
            return r5
        L_0x0010:
            android.content.Context r0 = r10.f8016     // Catch:{ JSONException -> 0x0068 }
            com.netflix.mediaclient.android.app.Status r0 = o.C1905jf.m7995(r0, r11, r6)     // Catch:{ JSONException -> 0x0068 }
            r5 = r0
            boolean r0 = r5.mo301()     // Catch:{ JSONException -> 0x0068 }
            if (r0 == 0) goto L_0x002f
            java.lang.String r0 = "nf_bladerunner"
            java.lang.String r1 = "manifests has errors, status: %s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ JSONException -> 0x0068 }
            com.netflix.mediaclient.StatusCode r3 = r5.mo302()     // Catch:{ JSONException -> 0x0068 }
            r4 = 0
            r2[r4] = r3     // Catch:{ JSONException -> 0x0068 }
            o.C1283.m16851(r0, r1, r2)     // Catch:{ JSONException -> 0x0068 }
            return r5
        L_0x002f:
            java.util.Iterator r7 = r11.keys()
        L_0x0033:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0067
            java.lang.Object r0 = r7.next()
            r8 = r0
            java.lang.String r8 = (java.lang.String) r8
            org.json.JSONObject r9 = r11.getJSONObject(r8)
            android.content.Context r0 = r10.f8016
            com.netflix.mediaclient.android.app.Status r0 = o.C1905jf.m7995(r0, r9, r6)
            r5 = r0
            boolean r0 = r5.mo301()
            if (r0 == 0) goto L_0x0066
            java.lang.String r0 = "nf_bladerunner"
            java.lang.String r1 = "manifest for %s has errors, status: %s"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r8
            com.netflix.mediaclient.StatusCode r3 = r5.mo302()
            r4 = 1
            r2[r4] = r3
            o.C1283.m16851(r0, r1, r2)
            goto L_0x0067
        L_0x0066:
            goto L_0x0033
        L_0x0067:
            goto L_0x0070
        L_0x0068:
            r7 = move-exception
            java.lang.String r0 = "nf_bladerunner"
            java.lang.String r1 = "parsing manifest error"
            o.C1283.m16847(r0, r1, r7)
        L_0x0070:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C1906jg.m8000(org.json.JSONObject):com.netflix.mediaclient.android.app.Status");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private JSONObject m7999(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject3 = jSONObject.getJSONObject(next);
                    if (jSONObject3 != null) {
                        jSONObject3.put("timestamp", System.currentTimeMillis());
                        long optLong = jSONObject3.optLong("expiration", 0);
                        if (optLong < System.currentTimeMillis() + 3600000) {
                            C1283.m16850("nf_bladerunner", "server manifest expiring...  " + optLong);
                            jSONObject3.put("expiration", System.currentTimeMillis() + 3600000);
                        }
                        jSONObject2.put(next, jSONObject3);
                    }
                }
            } catch (JSONException e) {
                C1283.m16847("nf_bladerunner", "parsing manifest error", e);
            }
        }
        return jSONObject2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo992(JSONObject jSONObject) {
        JSONObject r1 = m8004(jSONObject);
        Status r2 = m8000(r1);
        JSONObject jSONObject2 = r1;
        if (r2.mo298()) {
            jSONObject2 = m7999(r1);
        }
        mo8001(jSONObject2, r2);
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        mo8001((JSONObject) null, status);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8001(JSONObject jSONObject, Status status) {
        if (this.f8012 != null) {
            this.f8012.mo7615(jSONObject, status);
        } else {
            C1283.m16865("nf_bladerunner", "callback null?");
        }
    }
}
