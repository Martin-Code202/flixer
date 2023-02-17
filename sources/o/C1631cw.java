package o;

import com.android.volley.Request;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import java.util.Map;
/* access modifiers changed from: package-private */
/* renamed from: o.cw  reason: case insensitive filesystem */
public class C1631cw extends AbstractC1564bm<String> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC1634cz f6396;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C1632cx f6397;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f6398;

    C1631cw(String str, C1632cx cxVar, AbstractC1634cz czVar) {
        C1283.m16854("nf_presentation", "PresentationEventMslRequest::");
        this.f6396 = czVar;
        this.f6398 = str;
        this.f6397 = cxVar;
    }

    @Override // o.AbstractC1564bm, com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.LOG_PRESENTATION;
    }

    @Override // o.AbstractC1564bm, com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1564bm
    /* renamed from: ॱ */
    public String mo5635() {
        return "/presentationtracking/users/presentationtracking";
    }

    @Override // com.android.volley.Request
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        if (params == null) {
            params = new AW<>();
        }
        params.putAll(this.f6397.m5991());
        return params;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo5632(byte[] bArr) {
        return "OK";
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo992(String str) {
        C1283.m16846("nf_presentation", "presentationEvent OK : ");
        if (this.f6396 != null) {
            this.f6396.onEventsDelivered(this.f6398);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1564bm
    /* renamed from: ॱ */
    public byte[] mo5636(byte[] bArr, Map<String, String> map, String str, AbstractC1412Ec ec) {
        return m6614().m6512(bArr, map, str, ec);
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        if (this.f6396 != null) {
            this.f6396.onEventsDeliveryFailed(this.f6398);
        }
    }
}
