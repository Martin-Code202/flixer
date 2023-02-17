package o;

import com.netflix.mediaclient.service.api.diagnostics.IDiagnosis;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import org.json.JSONObject;
/* renamed from: o.ぃ  reason: contains not printable characters */
public class C1072 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f15229 = 0;

    /* renamed from: ˋ  reason: contains not printable characters */
    private IDiagnosis.UrlStatus f15230 = IDiagnosis.UrlStatus.NOT_TESTED;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f15231 = 0;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f15232;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f15233 = false;

    public C1072(String str, IDiagnosis.UrlStatus urlStatus) {
        this.f15232 = str;
        this.f15230 = urlStatus;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m16150() {
        return this.f15232;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public IDiagnosis.UrlStatus m16143() {
        return this.f15230;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m16149(IDiagnosis.UrlStatus urlStatus) {
        this.f15230 = urlStatus;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m16148() {
        return this.f15231;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m16144(int i) {
        this.f15231 = i;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int m16142() {
        return this.f15229;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m16145(int i) {
        this.f15229 = i;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m16147() {
        return this.f15233;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m16146(boolean z) {
        this.f15233 = z;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public boolean m16152() {
        return this.f15232 != null && this.f15232.contains("netflix");
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public JSONObject m16151() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("URL", this.f15232);
        jSONObject.put("errorgroup", this.f15229);
        jSONObject.put("errorcode", this.f15231);
        jSONObject.put(FalkorPathResult.SUCCESS, this.f15233);
        jSONObject.put("urlType", m16152() ? "NETFLIX" : "INTERNET");
        return jSONObject;
    }
}
