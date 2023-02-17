package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import java.util.Map;
/* access modifiers changed from: package-private */
/* renamed from: o.bp  reason: case insensitive filesystem */
public class C1567bp extends AbstractC1568bq {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean f6167 = true;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6168;

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC1562bk f6169;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6170;

    C1567bp(String str, String str2, AbstractC1562bk bkVar) {
        C1283.m16854("nf_log_cl", "LoggingEventsCLv2WebRequest::");
        this.f6169 = bkVar;
        this.f6168 = str;
        this.f6170 = str2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1568bq
    /* renamed from: ˎ */
    public String mo5639() {
        return this.f6170;
    }

    @Override // o.AbstractC2040op, com.android.volley.Request
    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        if (f6167) {
            headers.put("debugRequest", "true");
        }
        return headers;
    }

    @Override // o.AbstractC1568bq, o.AbstractC1563bl
    /* renamed from: ॱॱ */
    public String mo5786() {
        return this.f6161.mo1455("/ichnaea/cl2");
    }

    @Override // com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.LOG_CLV2;
    }

    @Override // o.AbstractC1563bl
    /* renamed from: ᐝ */
    public String mo5641() {
        return "nf_log_cl";
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˋ */
    public void mo5637(Status status) {
        if (this.f6169 != null) {
            this.f6169.onEventsDeliveryFailed(this.f6168);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo5640(String str) {
        if (this.f6169 != null) {
            this.f6169.onEventsDelivered(this.f6168);
        }
    }
}
