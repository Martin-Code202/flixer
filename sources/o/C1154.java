package o;

import com.netflix.mediaclient.android.app.Status;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* renamed from: o.ﱟ  reason: contains not printable characters */
public class C1154 extends AbstractC1110<String> {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f15403 = "['reportVoipPostCallInfo']";

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private String f15404;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private String f15405;

    public C1154(String str, AbstractC2033oi oiVar) {
        C1283.m16848("nf_voip", "PQL = %s", this.f15403);
        this.f15404 = str;
        if (oiVar != null) {
            this.f15405 = oiVar.m9654();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1094, o.AbstractC1807gM, com.android.volley.Request
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("authtoken", this.f15404);
        params.put("callstats", this.f15405);
        return params;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo986(String str) {
        return str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1807gM
    /* renamed from: ˎ */
    public List<String> mo989() {
        return Arrays.asList(this.f15403);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo992(String str) {
        C1283.m16854("nf_voip", "VoIP call stats sent successfully");
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        C1283.m16865("nf_voip", "Failed to send VoIP call stats");
    }
}
