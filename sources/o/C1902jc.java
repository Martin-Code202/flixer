package o;

import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import java.util.Arrays;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.jc  reason: case insensitive filesystem */
public class C1902jc {

    /* renamed from: ˊ  reason: contains not printable characters */
    UserAgentInterface f8003;

    /* renamed from: ˋ  reason: contains not printable characters */
    String f8004;

    /* renamed from: ˎ  reason: contains not printable characters */
    IBladeRunnerClient.LicenseRequestFlavor f8005;

    /* renamed from: ˏ  reason: contains not printable characters */
    String f8006;

    /* renamed from: ॱ  reason: contains not printable characters */
    String f8007;

    public C1902jc(UserAgentInterface userAgentInterface) {
        this.f8003 = userAgentInterface;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public C1902jc m7991(String str) {
        this.f8004 = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public C1902jc m7988(String str) {
        this.f8007 = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public C1902jc m7993(IBladeRunnerClient.LicenseRequestFlavor licenseRequestFlavor) {
        this.f8005 = licenseRequestFlavor;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public C1902jc m7989(String str) {
        this.f8006 = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public final String m7992() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LoggingRequest.VERSION, 2);
            jSONObject.put("url", this.f8007);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("clientTime", Long.valueOf(System.currentTimeMillis()));
            jSONObject2.put("challengeBase64", this.f8004);
            String[] languages = this.f8003.mo1383().getLanguages();
            if (IBladeRunnerClient.LicenseRequestFlavor.STANDARD == this.f8005) {
                jSONObject2.put("xid", this.f8006);
            }
            jSONObject.put("params", jSONObject2);
            jSONObject.put("languages", new JSONArray((Collection) Arrays.asList(languages)));
            C1283.m16851("nf_msl_volley_FetchLicenseRequest", "licenseRequestParams, %s", jSONObject);
        } catch (Exception e) {
            C1283.m16856("nf_msl_volley_FetchLicenseRequest", e, "error creating manifest params", new Object[0]);
        }
        return jSONObject.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public C1902jc m7990(C1923jx jxVar) {
        return m7988(jxVar.m8084()).m7991(jxVar.m8092()).m7989(jxVar.m8094());
    }
}
