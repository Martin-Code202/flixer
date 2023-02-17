package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import java.util.Map;
/* access modifiers changed from: package-private */
/* renamed from: o.bw  reason: case insensitive filesystem */
public class C1574bw extends AbstractC1568bq {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6188;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6189;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC1562bk f6190;

    C1574bw(String str, String str2, AbstractC1562bk bkVar) {
        C1283.m16854("nf_log_cl", "LoggingEventsWebRequest::");
        this.f6190 = bkVar;
        this.f6188 = str;
        this.f6189 = str2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1568bq
    /* renamed from: ˎ */
    public String mo5639() {
        return this.f6189;
    }

    @Override // o.AbstractC2040op, com.android.volley.Request
    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        headers.put("X-Netflix.ichnaea.request.type", "UiRequest");
        return headers;
    }

    @Override // com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.LOG_CL;
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
        if (this.f6190 != null) {
            this.f6190.onEventsDeliveryFailed(this.f6188);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo5640(String str) {
        if (this.f6190 != null) {
            this.f6190.onEventsDelivered(this.f6188);
        }
    }
}
