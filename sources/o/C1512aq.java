package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import java.util.Map;
/* access modifiers changed from: package-private */
/* renamed from: o.aq  reason: case insensitive filesystem */
public final class C1512aq extends AbstractC1564bm<String> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6049;

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC1505aj f6050;

    C1512aq(String str, AbstractC1505aj ajVar) {
        C1283.m16854("nf_volleyrequest", "AdvertiserIdLoggingMslRequest::");
        this.f6049 = str;
        this.f6050 = ajVar;
    }

    @Override // o.AbstractC1564bm, com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.LOG_ADV_ID;
    }

    @Override // o.AbstractC1564bm, o.gV, com.android.volley.Request
    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        headers.put("X-Netflix.ichnaea.request.type", "IchnaeaRequest");
        headers.put("Content-Type", getBodyContentType());
        return headers;
    }

    @Override // o.gV, com.android.volley.Request
    public String getBodyContentType() {
        return "application/json";
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1564bm
    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo5635() {
        return "/ichnaea/log";
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1564bm
    /* renamed from: ॱ  reason: contains not printable characters */
    public byte[] mo5636(byte[] bArr, Map<String, String> map, String str, AbstractC1412Ec ec) {
        return m6614().m6499(bArr, map, str, ec);
    }

    @Override // o.gV
    /* renamed from: ˏ  reason: contains not printable characters */
    public String mo5634() {
        return this.f6049;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo992(String str) {
        if (this.f6050 != null) {
            this.f6050.mo5603();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        if (this.f6050 != null) {
            this.f6050.mo5604();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo5632(byte[] bArr) {
        return "OK";
    }
}
