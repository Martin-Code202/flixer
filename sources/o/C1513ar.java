package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import java.util.Map;
/* access modifiers changed from: package-private */
/* renamed from: o.ar  reason: case insensitive filesystem */
public class C1513ar extends AbstractC1568bq {

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC1505aj f6051;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6052;

    C1513ar(String str, AbstractC1505aj ajVar) {
        C1283.m16854("nf_adid", "AdvertiserIdLoggingWebRequest::");
        this.f6052 = str;
        this.f6051 = ajVar;
    }

    @Override // o.AbstractC2040op, com.android.volley.Request
    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        headers.put("X-Netflix.ichnaea.request.type", "IchnaeaRequest");
        return headers;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1568bq
    /* renamed from: ˎ  reason: contains not printable characters */
    public String mo5639() {
        return this.f6052;
    }

    @Override // com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.LOG_ADV_ID;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo5640(String str) {
        C1283.m16851("nf_adid", "Advertiser ID and opt in startus delivered %s", str);
        if (this.f6051 != null) {
            this.f6051.mo5603();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo5637(Status status) {
        if (this.f6051 != null) {
            this.f6051.mo5604();
        }
    }

    @Override // o.AbstractC1563bl
    /* renamed from: ᐝ  reason: contains not printable characters */
    public String mo5641() {
        return "nf_adid";
    }
}
