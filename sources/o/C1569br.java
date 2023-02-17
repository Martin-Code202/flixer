package o;

import com.android.volley.Request;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import java.util.Map;
/* access modifiers changed from: package-private */
/* renamed from: o.br  reason: case insensitive filesystem */
public class C1569br extends AbstractC1564bm<String> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6171;

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC1562bk f6172;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6173;

    C1569br(String str, String str2, AbstractC1562bk bkVar) {
        C1283.m16854("nf_log", "LoggingEventsCLv2MslRequest::");
        this.f6172 = bkVar;
        this.f6171 = str;
        this.f6173 = str2;
    }

    @Override // o.AbstractC1564bm, com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    @Override // o.AbstractC1564bm, com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.LOG_CLV2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1564bm
    /* renamed from: ॱ */
    public String mo5635() {
        return "/ichnaea/cl2";
    }

    @Override // o.gV
    /* renamed from: ˏ */
    public String mo5634() {
        return this.f6173;
    }

    @Override // o.gV, com.android.volley.Request
    public String getBodyContentType() {
        return "application/json";
    }

    @Override // o.AbstractC1564bm, o.gV, com.android.volley.Request
    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        headers.put("Content-Type", getBodyContentType());
        return headers;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo992(String str) {
        if (this.f6172 != null) {
            this.f6172.onEventsDelivered(this.f6171);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        if (this.f6172 != null) {
            this.f6172.onEventsDeliveryFailed(this.f6171);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1564bm
    /* renamed from: ॱ */
    public byte[] mo5636(byte[] bArr, Map<String, String> map, String str, AbstractC1412Ec ec) {
        return m6614().m6501(bArr, map, str, ec);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo5632(byte[] bArr) {
        return "OK";
    }
}
