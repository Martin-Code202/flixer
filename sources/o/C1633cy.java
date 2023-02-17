package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import java.util.Map;
/* access modifiers changed from: package-private */
/* renamed from: o.cy  reason: case insensitive filesystem */
public class C1633cy extends AbstractC1563bl {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC1634cz f6408;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C1632cx f6409;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f6410;

    C1633cy(String str, C1632cx cxVar, AbstractC1634cz czVar) {
        C1283.m16854("nf_presentation", "PresentationEventWebRequest::");
        this.f6408 = czVar;
        this.f6410 = str;
        this.f6409 = cxVar;
    }

    @Override // com.android.volley.Request
    public Map<String, String> getParams() {
        return this.f6409.m5991();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo5640(String str) {
        C1283.m16846("nf_presentation", "presentationEvent OK : ");
        if (this.f6408 != null) {
            this.f6408.onEventsDelivered(this.f6410);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˋ */
    public void mo5637(Status status) {
        if (this.f6408 != null) {
            this.f6408.onEventsDeliveryFailed(this.f6410);
        }
    }

    @Override // o.AbstractC1563bl
    /* renamed from: ॱॱ */
    public String mo5786() {
        return this.f6161.mo1455("/presentationtracking/users/presentationtracking");
    }

    @Override // com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.LOG_PRESENTATION;
    }

    @Override // o.AbstractC1563bl
    /* renamed from: ᐝ */
    public String mo5641() {
        return "nf_presentation";
    }
}
