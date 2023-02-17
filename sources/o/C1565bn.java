package o;

import com.android.volley.Request;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import java.util.Map;
/* renamed from: o.bn  reason: case insensitive filesystem */
public class C1565bn extends AbstractC1564bm<String> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6162;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f6163;

    /* renamed from: ˎ  reason: contains not printable characters */
    private AbstractC1562bk f6164;

    C1565bn(String str, String str2, AbstractC1562bk bkVar) {
        C1283.m16854("nf_log", "LoggingEventsMslRequest::");
        this.f6164 = bkVar;
        this.f6162 = str;
        this.f6163 = str2;
    }

    @Override // o.AbstractC1564bm, com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    @Override // o.AbstractC1564bm, com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.LOG_CL;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1564bm
    /* renamed from: ॱ */
    public String mo5635() {
        return "/ichnaea/log";
    }

    @Override // o.gV
    /* renamed from: ˏ */
    public String mo5634() {
        return this.f6163;
    }

    @Override // o.gV, com.android.volley.Request
    public String getBodyContentType() {
        return "application/json";
    }

    @Override // o.AbstractC1564bm, o.gV, com.android.volley.Request
    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        headers.put("X-Netflix.ichnaea.request.type", "UiRequest");
        headers.put("Content-Type", getBodyContentType());
        return headers;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo992(String str) {
        if (this.f6164 != null) {
            this.f6164.onEventsDelivered(this.f6162);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        if (this.f6164 != null) {
            this.f6164.onEventsDeliveryFailed(this.f6162);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1564bm
    /* renamed from: ॱ */
    public byte[] mo5636(byte[] bArr, Map<String, String> map, String str, AbstractC1412Ec ec) {
        return m6614().m6499(bArr, map, str, ec);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public String mo5632(byte[] bArr) {
        return "OK";
    }
}
