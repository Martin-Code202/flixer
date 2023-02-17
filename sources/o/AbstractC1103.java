package o;

import android.content.Context;
import android.os.SystemClock;
import com.android.volley.AuthFailureError;
import com.android.volley.VolleyError;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.webclient.AUIApiEndpointRegistry;
import com.netflix.mediaclient.service.webclient.model.leafs.NonMemberData;
import com.netflix.mediaclient.service.webclient.volley.StatusCodeError;
import com.netflix.mediaclient.util.net.AuthorizationCredentials;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/* renamed from: o.宀  reason: contains not printable characters */
public abstract class AbstractC1103<T> extends AbstractC2040op<T> {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected String f15286;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected long f15287 = -1;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected AbstractC1194 f15288;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected long f15289;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected AUIApiEndpointRegistry f15290;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected AbstractC1221 f15291;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected long f15292;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected Context f15293;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected AUIApiEndpointRegistry.ResponsePathFormat f15294;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected UUID f15295;

    /* access modifiers changed from: protected */
    /* renamed from: ʼ */
    public abstract List<String> mo16174();

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public abstract T mo16175(String str);

    protected AbstractC1103(Context context, AbstractC1221 r4) {
        super(0);
        this.f15291 = r4;
        m16208(context, null);
    }

    protected AbstractC1103(Context context, AbstractC1221 r4, int i) {
        super(i);
        this.f15291 = r4;
        m16208(context, null);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m16208(Context context, AUIApiEndpointRegistry.ResponsePathFormat responsePathFormat) {
        this.f15295 = UUID.randomUUID();
        this.f15293 = context;
        if (responsePathFormat == null) {
            this.f15294 = AUIApiEndpointRegistry.ResponsePathFormat.HIERARCHICAL;
        } else {
            this.f15294 = responsePathFormat;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    protected static String m16209(String str, String str2) {
        return "&" + str + "=" + BE.m3842(str2);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˏ */
    public String mo5784(String str) {
        String r4 = m16213();
        StringBuilder sb = new StringBuilder(str);
        sb.append(BG.m3860("method", mo5781(), "?"));
        if (m16210()) {
            sb.append(BG.m3860("materialize", "true", "&"));
        }
        sb.append(r4);
        AW aw = (AW) this.f15290.mo1450(this.f15294);
        for (String str2 : aw.keySet()) {
            for (String str3 : aw.mo3487(str2)) {
                sb.append(BG.m3860(str2, str3, "&"));
            }
        }
        String r7 = mo9695();
        if (C1349Bv.m4107(r7)) {
            sb.append(r7);
        }
        m16211(sb);
        String sb2 = sb.toString();
        C1283.m16848("AUIFalkorVolleyWebClientRequest", "VolleyWebClientRequest URL = %s", sb2);
        return sb2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ॱ */
    public String mo9695() {
        return BG.m3860("languages", C1061.m16114().mo14164(this.f15293).getLanguage(), "&");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public StringBuilder m16211(StringBuilder sb) {
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
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m16210() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public String m16213() {
        List<String> r2 = mo16174();
        if (r2 == null) {
            throw new IllegalArgumentException("List of queries is null!");
        }
        StringBuilder sb = new StringBuilder();
        for (String str : r2) {
            sb.append(m16209(m16212(), str));
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op, com.android.volley.Request
    public C0524<T> parseNetworkResponse(C1181 r11) {
        if (r11 == null || r11.f15528 == null) {
            C1283.m16865("AUIFalkorVolleyWebClientRequest", "execTime not found!");
        } else {
            String str = r11.f15528.get("X-Netflix.api-script-execution-time");
            String str2 = r11.f15528.get("X-Netflix.execution-time");
            C2034oj.m9659(r11);
            this.f15286 = r11.f15528.get("X-Netflix.api-script-revision");
            AuthorizationCredentials r8 = C1376Cs.m4548("TEMP_PROFILE_ID", r11.f15528.get("Set-Cookie"));
            if (!(r8 == null || r8.netflixId == null || r8.secureNetflixId == null)) {
                this.f15291.mo16517(new NonMemberData(r8.netflixId, r8.secureNetflixId));
            }
            if (C1349Bv.m4107(str2)) {
                try {
                    this.f15287 = Long.parseLong(str2);
                } catch (Throwable th) {
                    C1283.m16847("AUIFalkorVolleyWebClientRequest", "Failed to parse server execution time!", th);
                }
            }
            if (C1349Bv.m4107(str)) {
                try {
                    this.f15292 = Long.parseLong(str);
                } catch (Throwable th2) {
                    C1283.m16847("AUIFalkorVolleyWebClientRequest", "Failed to parse api script execution time!", th2);
                }
            }
        }
        return super.parseNetworkResponse(r11);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ॱ */
    public T mo5785(String str) {
        this.f15289 = SystemClock.elapsedRealtime();
        try {
            T r4 = mo16175(str);
            this.f15289 = SystemClock.elapsedRealtime() - this.f15289;
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
        if (this.f15293 != null) {
            C1860hr.m7330(this.f15293);
        }
    }

    @Override // o.AbstractC2040op, com.android.volley.Request
    public void deliverError(VolleyError volleyError) {
        C1283.m16851("AUIFalkorVolleyWebClientRequest", "request duration time (ms): %d, class: %s, error: %s", Long.valueOf(m9696()), getClass().getSimpleName(), volleyError);
        NetflixStatus r7 = BK.m3875(volleyError, this.f9354, StatusCode.NET_GENERAL_NETWORK_ERROR);
        if (this.f15293 != null && AI.m3356(r7.mo302())) {
            AI.m3355(this.f15293, r7.mo302());
        }
        mo5637(r7);
    }

    @Override // o.AbstractC2040op, com.android.volley.Request
    public void changeHostUrl(String str) {
        super.changeHostUrl(str);
        this.f15290.mo1449(str);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˊ */
    public String mo5781() {
        return "get";
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public String m16212() {
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
            headers.put("X-Netflix.request.uuid", "" + this.f15295);
            if (this.f15288 != null) {
                headers.put("X-Netflix.appVer", C1318At.m3776(this.f15293));
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
