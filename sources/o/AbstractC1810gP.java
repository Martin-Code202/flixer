package o;

import android.os.SystemClock;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
import java.util.Map;
/* renamed from: o.gP  reason: case insensitive filesystem */
public abstract class AbstractC1810gP<T> extends AbstractC1807gM<T> {
    public AbstractC1810gP() {
    }

    public AbstractC1810gP(ApiEndpointRegistry.ResponsePathFormat responsePathFormat) {
        super(responsePathFormat);
    }

    @Override // o.gV
    /* renamed from: ʽ  reason: contains not printable characters */
    public String mo6586() {
        return "/android/6.1/api";
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˊ */
    public void mo5787() {
        ApiEndpointRegistry r1 = this.f6930.mo16547();
        if (!mo5769() || !r1.mo1457().mo1471()) {
            m6615(r1.mo9651(null).toExternalForm());
        } else {
            m6615(r1.mo1452(null).toExternalForm());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ */
    public boolean mo5769() {
        return true;
    }

    @Override // com.android.volley.Request
    public void checkFtlFallback() {
        ApiEndpointRegistry r1 = this.f6930.mo16547();
        if (mo5769() && !r1.mo1457().mo1471() && isFtlEndpoint()) {
            this.f6923 = AbstractC1807gM.buildNewUrlString(this.f6923, r1.mo9651(null).getHost());
        }
    }

    @Override // com.android.volley.Request
    public void triggerFtlFallback(VolleyError volleyError) {
        ApiEndpointRegistry r6 = this.f6930.mo16547();
        C2034oj.m9660(volleyError, r6.mo1457(), getTag(), SystemClock.elapsedRealtime() - this.mRequestBirthTime);
        this.f6923 = AbstractC1807gM.buildNewUrlString(this.f6923, r6.mo9651(null).getHost());
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.HIGH;
    }

    @Override // com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.BROWSE;
    }

    @Override // o.AbstractC1807gM, com.android.volley.Request
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        Map<String, String> r3 = m6614().m6495().mo1456(this.f6901);
        if (params == null) {
            return r3;
        }
        params.putAll(r3);
        return params;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1807gM, com.android.volley.Request
    public C0524<T> parseNetworkResponse(C1181 r3) {
        if (!(r3 == null || r3.f15528 == null || !mo5769())) {
            String r1 = C2034oj.m9659(r3);
            if (C1349Bv.m4107(r1)) {
                this.f6930.mo16547().mo1457().mo1466(r1);
            }
        }
        return super.parseNetworkResponse(r3);
    }
}
