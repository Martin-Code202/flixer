package o;

import android.content.Context;
import android.os.SystemClock;
import com.android.volley.AuthFailureError;
import com.android.volley.VolleyError;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
import com.netflix.mediaclient.service.webclient.volley.StatusCodeError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/* renamed from: o.ok  reason: case insensitive filesystem */
public abstract class AbstractC2035ok<T> extends AbstractC2040op<T> {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected String f9331;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected ApiEndpointRegistry.ResponsePathFormat f9332;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected UUID f9333;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected ApiEndpointRegistry f9334;

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC1221 f9335;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected long f9336;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected Context f9337;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected long f9338 = -1;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected long f9339;

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public abstract T mo9665(String str);

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract List<String> mo9668();

    protected AbstractC2035ok(Context context) {
        super(0);
        m9662(context, null);
    }

    protected AbstractC2035ok(Context context, ApiEndpointRegistry.ResponsePathFormat responsePathFormat) {
        super(0);
        m9662(context, responsePathFormat);
    }

    protected AbstractC2035ok(Context context, int i) {
        super(i);
        m9662(context, null);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m9667(AbstractC1221 r1) {
        this.f9335 = r1;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m9662(Context context, ApiEndpointRegistry.ResponsePathFormat responsePathFormat) {
        this.f9333 = UUID.randomUUID();
        this.f9337 = context;
        if (responsePathFormat == null) {
            this.f9332 = ApiEndpointRegistry.ResponsePathFormat.HIERARCHICAL;
        } else {
            this.f9332 = responsePathFormat;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    protected static String m9663(String str, String str2) {
        return "&" + str + "=" + BE.m3842(str2);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˏ */
    public String mo5784(String str) {
        String r4 = m9671();
        StringBuilder sb = new StringBuilder(str);
        sb.append(C1349Bv.m4116("method", mo5781(), "?"));
        if (mo9670()) {
            sb.append(C1349Bv.m4116("materialize", "true", "&"));
        }
        sb.append(r4);
        AW aw = (AW) this.f9334.mo1456(this.f9332);
        for (String str2 : aw.keySet()) {
            for (String str3 : aw.mo3487(str2)) {
                sb.append(C1349Bv.m4116(str2, str3, "&"));
            }
        }
        String r7 = mo9695();
        if (C1349Bv.m4107(r7)) {
            sb.append(r7);
        }
        m9666(sb);
        String sb2 = sb.toString();
        C1283.m16848("FalkorVolleyWebClientRequest", "VolleyWebClientRequest URL = %s", sb2);
        return sb2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public StringBuilder m9666(StringBuilder sb) {
        String str = null;
        Object tag = getTag();
        if (tag instanceof String) {
            str = (String) tag;
        } else if (tag != null) {
            str = tag.toString();
        }
        if (C1349Bv.m4107(str)) {
            sb.append("&TAG=").append(str);
        }
        return sb;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean mo9670() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public String m9671() {
        List<String> r2 = mo9668();
        if (r2 == null) {
            throw new IllegalArgumentException("List of queries is null!");
        }
        StringBuilder sb = new StringBuilder();
        for (String str : r2) {
            sb.append(m9663(m9669(), str));
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op, com.android.volley.Request
    public C0524<T> parseNetworkResponse(C1181 r7) {
        if (r7 == null || r7.f15528 == null) {
            C1283.m16865("FalkorVolleyWebClientRequest", "execTime not found!");
        } else {
            String str = r7.f15528.get("X-Netflix.api-script-execution-time");
            String str2 = r7.f15528.get("X-Netflix.execution-time");
            String r4 = C2034oj.m9659(r7);
            this.f9331 = r7.f15528.get("X-Netflix.api-script-revision");
            if (C1349Bv.m4107(str2)) {
                try {
                    this.f9338 = Long.parseLong(str2);
                } catch (Throwable th) {
                    C1283.m16847("FalkorVolleyWebClientRequest", "Failed to parse server execution time!", th);
                }
            }
            if (C1349Bv.m4107(str)) {
                try {
                    this.f9339 = Long.parseLong(str);
                } catch (Throwable th2) {
                    C1283.m16847("FalkorVolleyWebClientRequest", "Failed to parse api script execution time!", th2);
                }
            }
            if (C1349Bv.m4107(r4) && mo9664()) {
                this.f9334.mo1457().mo1466(r4);
            }
        }
        return super.parseNetworkResponse(r7);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ॱ */
    public T mo5785(String str) {
        this.f9336 = SystemClock.elapsedRealtime();
        try {
            T r4 = mo9665(str);
            this.f9336 = SystemClock.elapsedRealtime() - this.f9336;
            if (mo9686() || r4 != null) {
                return r4;
            }
            throw new FalkorException("Parsing returned null.");
        } catch (Exception e) {
            if ((e instanceof FalkorException) || (e instanceof StatusCodeError)) {
                throw ((VolleyError) e);
            }
            throw new VolleyError(e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op, com.android.volley.Request
    public void deliverResponse(T t) {
        super.deliverResponse(t);
        m9696();
        if (this.f9337 != null) {
            C1860hr.m7330(this.f9337);
        }
    }

    @Override // o.AbstractC2040op, com.android.volley.Request
    public void deliverError(VolleyError volleyError) {
        C1283.m16851("FalkorVolleyWebClientRequest", "request duration time (ms): %d, class: %s, error: %s", Long.valueOf(m9696()), getClass().getSimpleName(), volleyError);
        NetflixStatus r7 = BK.m3875(volleyError, this.f9354, StatusCode.NET_GENERAL_NETWORK_ERROR);
        if (this.f9337 != null && AI.m3356(r7.mo302())) {
            AI.m3355(this.f9337, r7.mo302());
        }
        mo5637(r7);
    }

    @Override // o.AbstractC2040op
    /* renamed from: ˋ */
    public void mo5783(ApiEndpointRegistry apiEndpointRegistry) {
        this.f9334 = apiEndpointRegistry;
        if (!mo9664() || !this.f9334.mo1457().mo1471()) {
            m9684(this.f9334.mo9651(null).toExternalForm());
        } else {
            m9684(this.f9334.mo1452(null).toExternalForm());
        }
    }

    @Override // com.android.volley.Request
    public void checkFtlFallback() {
        if (mo9664() && !this.f9334.mo1457().mo1471() && isFtlEndpoint()) {
            super.changeHostUrl(this.f9334.mo9651(null).getHost());
        }
    }

    @Override // com.android.volley.Request
    public void triggerFtlFallback(VolleyError volleyError) {
        C2034oj.m9660(volleyError, this.f9334.mo1457(), getTag(), SystemClock.elapsedRealtime() - this.mRequestBirthTime);
        super.changeHostUrl(this.f9334.mo9651(null).getHost());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean mo9664() {
        return true;
    }

    @Override // o.AbstractC2040op, com.android.volley.Request
    public void changeHostUrl(String str) {
        super.changeHostUrl(str);
        this.f9334.mo1449(str);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˊ */
    public String mo5781() {
        return "get";
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public String m9669() {
        if ("get".equals(mo5781())) {
            return FalkorPathResult.PATH;
        }
        return "callPath";
    }

    @Override // o.AbstractC2040op, com.android.volley.Request
    public Map<String, String> getHeaders() {
        if (!mo9692() || !m9688()) {
            Map<String, String> headers = super.getHeaders();
            if (headers == null) {
                headers = new HashMap<>();
            }
            headers.put("X-Netflix.request.uuid", "" + this.f9333);
            if (!(this.f9335 == null || this.f9335.d_() == null)) {
                headers.put("X-Netflix.esnPrefix", this.f9335.d_().mo14442());
                headers.put("X-Netflix.appVer", C1318At.m3776(AbstractApplicationC1258.m16692()));
            }
            return headers;
        }
        throw new AuthFailureError("Can't build valid headers. Cookies are null. url=" + getUrl());
    }

    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public VolleyError parseNetworkError(VolleyError volleyError) {
        StatusCode r2 = BK.m3869(volleyError);
        if (r2 != null) {
            return new StatusCodeError(r2, volleyError.getCause());
        }
        if (isCronetConnection()) {
            return BK.m3872(volleyError);
        }
        return volleyError;
    }
}
