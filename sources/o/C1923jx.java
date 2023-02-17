package o;

import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import com.netflix.mediaclient.service.player.drm.NfDrmManagerInterface;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.jx  reason: case insensitive filesystem */
public class C1923jx {

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f8086;

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f8087;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f8088;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f8089;

    /* renamed from: ˋ  reason: contains not printable characters */
    private IBladeRunnerClient.LicenseRequestFlavor f8090;

    /* renamed from: ˎ  reason: contains not printable characters */
    private byte[] f8091;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Long f8092;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private byte[] f8093;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f8094;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private NfDrmManagerInterface.LicenseType f8095;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f8096;

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m8092() {
        return this.f8094;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m8094() {
        return this.f8089;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public IBladeRunnerClient.LicenseRequestFlavor m8093() {
        return this.f8090;
    }

    public C1923jx(String str, byte[] bArr, String str2, String str3, Long l) {
        this.f8089 = str;
        this.f8091 = bArr;
        this.f8088 = str2;
        this.f8096 = str3;
        this.f8092 = l;
        m8088(NfDrmManagerInterface.LicenseType.LICENSE_TYPE_STANDARD);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Long m8087() {
        return this.f8092;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m8089() {
        return this.f8086;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8091(String str) {
        this.f8089 = str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8088(NfDrmManagerInterface.LicenseType licenseType) {
        this.f8095 = licenseType;
        if (licenseType == NfDrmManagerInterface.LicenseType.LICENSE_TYPE_STANDARD) {
            this.f8090 = IBladeRunnerClient.LicenseRequestFlavor.STANDARD;
        } else if (licenseType == NfDrmManagerInterface.LicenseType.LICENSE_TYPE_LDL) {
            this.f8090 = IBladeRunnerClient.LicenseRequestFlavor.LIMITED;
        } else if (licenseType == NfDrmManagerInterface.LicenseType.LICENSE_TYPE_OFFLINE) {
            this.f8090 = IBladeRunnerClient.LicenseRequestFlavor.OFFLINE;
        } else {
            this.f8090 = IBladeRunnerClient.LicenseRequestFlavor.UNKNOWN;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8095(byte[] bArr) {
        this.f8094 = C1418Ei.m4892(bArr);
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public byte[] m8086() {
        return this.f8091;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public NfDrmManagerInterface.LicenseType m8085() {
        return this.f8095;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public JSONObject m8090(JSONObject jSONObject) {
        C1283.m16854("NfPlayerDrmManager", "parsing license response start.");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("links");
            if (jSONObject2.has("releaseLicense")) {
                this.f8086 = jSONObject2.getJSONObject("releaseLicense").toString();
            }
        } catch (JSONException e) {
            C1283.m16847("NfPlayerDrmManager", "error parsing license", e);
        }
        this.f8087 = jSONObject.optString("providerSessionToken");
        this.f8093 = C1418Ei.m4894(jSONObject.optString("licenseResponseBase64"));
        C1283.m16854("NfPlayerDrmManager", "parsing license response end.");
        return jSONObject;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public byte[] m8096() {
        return this.f8093;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1923jx)) {
            return false;
        }
        C1923jx jxVar = (C1923jx) obj;
        return Arrays.equals(m8086(), jxVar.m8086()) && C1349Bv.m4126(this.f8088, jxVar.f8088);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m8084() {
        String str = this.f8088;
        if (this.f8090 == IBladeRunnerClient.LicenseRequestFlavor.LIMITED) {
            return this.f8096;
        }
        return str;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public boolean m8097() {
        return this.f8093 != null && this.f8093.length > 0;
    }
}
