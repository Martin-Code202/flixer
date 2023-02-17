package o;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
import com.netflix.mediaclient.service.webclient.volley.ParseException;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.util.net.AuthorizationCredentials;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
/* renamed from: o.op  reason: case insensitive filesystem */
public abstract class AbstractC2040op<T> extends Request<T> implements NetflixDataRequest {

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC2031og f9353;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected AbstractC2049oy f9354;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Map<String, String> f9355 = new HashMap(1);

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f9356;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected long f9357;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected AbstractC1378Cu f9358;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f9359;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    protected int f9360;

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public abstract String mo5781();

    /* access modifiers changed from: protected */
    /* renamed from: ˋ */
    public abstract void mo5637(Status status);

    /* renamed from: ˋ */
    public abstract void mo5783(ApiEndpointRegistry apiEndpointRegistry);

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public abstract String mo5784(String str);

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public abstract void mo5640(T t);

    /* access modifiers changed from: protected */
    /* renamed from: ॱ */
    public abstract T mo5785(String str);

    protected AbstractC2040op(int i) {
        super(i, null, null);
        setShouldCache(false);
        this.f9357 = SystemClock.elapsedRealtime();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public boolean m9690() {
        return this.f9353 != null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9687(AbstractC2031og ogVar) {
        this.f9353 = ogVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9691(AbstractC1378Cu cu) {
        this.f9358 = cu;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻ  reason: contains not printable characters */
    public void m9684(String str) {
        if (this.f9356 != null) {
            throw new IllegalStateException("Can not change the URL of a VolleyWebCLientRequest.");
        }
        this.f9356 = mo5784(str);
        this.f9359 = TextUtils.isEmpty(this.f9356) ? 0 : Uri.parse(this.f9356).getHost().hashCode();
        if (TextUtils.isEmpty(this.f9356)) {
            this.f9359 = 0;
            return;
        }
        String host = Uri.parse(this.f9356).getHost();
        if (host == null) {
            this.f9359 = 0;
        } else {
            this.f9359 = host.hashCode();
        }
    }

    @Override // com.android.volley.Request
    public String getUrl() {
        return this.f9356;
    }

    @Override // com.android.volley.Request
    public void changeHostUrl(String str) {
        this.f9356 = Request.buildNewUrlString(this.f9356, str);
        this.f9359 = str.hashCode();
    }

    @Override // com.android.volley.Request
    public int getTrafficStatsTag() {
        return this.f9359;
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.HIGH;
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() {
        StringBuilder sb = new StringBuilder();
        if (!m9694()) {
            m9682(sb, this.f9358.mo4540(), this.f9358.mo4542());
        }
        if (!m9693()) {
            m9682(sb, this.f9358.mo4541(), this.f9358.mo4538());
        }
        if (!m9688()) {
            m9682(sb, this.f9353.mo1401(), this.f9353.mo1399());
            m9681(sb, this.f9353.mo1398(), this.f9353.mo1397(), true);
        }
        String sb2 = sb.toString();
        this.f9355.put("Cookie", sb2);
        if (this.f9353 != null) {
            String r5 = this.f9353.mo1396();
            if (C1349Bv.m4107(r5)) {
                this.f9355.put("X-Netflix.request.client.user.guid", r5);
            }
        }
        this.f9355.put("Cookie", sb2);
        return this.f9355;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m9682(StringBuilder sb, String str, String str2) {
        m9681(sb, str, str2, false);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m9681(StringBuilder sb, String str, String str2, boolean z) {
        sb.append(str).append("=").append(str2);
        if (!z) {
            sb.append("; ");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public boolean m9688() {
        return C1349Bv.m4113(this.f9353.mo1399()) || C1349Bv.m4113(this.f9353.mo1397());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ͺ  reason: contains not printable characters */
    public boolean m9694() {
        return C1349Bv.m4113(this.f9358.mo4542());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public boolean m9693() {
        return C1349Bv.m4113(this.f9358.mo4538());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    protected static boolean m9683(C1181 r3) {
        if (r3 == null || r3.f15528 == null) {
            return false;
        }
        String str = r3.f15528.get("X-Netflix.eas.identity.mismatchack");
        if (C1349Bv.m4113(str)) {
            return false;
        }
        return "true".equalsIgnoreCase(str);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0071: APUT  (r2v3 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r3v3 java.lang.String) */
    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public C0524<T> parseNetworkResponse(C1181 r15) {
        String str;
        if (!(r15 == null || r15.f15530 == null)) {
            this.f9360 = r15.f15530.length;
        }
        boolean r5 = (!mo9692() || !mo9685()) ? true : m9697();
        C1283.m16851("nf_volleyrequest", "Response status %d", Integer.valueOf(r15.f15527));
        String str2 = r15.f15528.get("Set-Cookie");
        AuthorizationCredentials r7 = C1376Cs.m4548(this.f9353.mo1396(), str2);
        String r8 = C1376Cs.m4552(str2);
        String r9 = C1376Cs.m4556(str2);
        C2036ol.m9674(r15.f15528.get("X-Netflix.deviceIpAddr"));
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(r5);
        objArr[1] = r7 != null ? r7.netflixId : "null";
        C1283.m16851("nf_volleyrequest", "can process ? %b -  newId %s", objArr);
        if (!(!r5 || r7 == null || this.f9353 == null)) {
            this.f9353.mo1400(r7);
        }
        if (C1349Bv.m4107(r8)) {
            this.f9358.mo4539(r8);
        }
        if (C1349Bv.m4107(r9)) {
            this.f9358.mo4543(r9);
        }
        if (m9683(r15)) {
            C1283.m16850("nf_volleyrequest", "Identity mismatch detected on server side");
            C1276.m16820().mo5727("Wrong state. Identity mismatch detected on server side");
            return C0524.m14562(new ParseException("Wrong state. Identity mismatch detected on server side"));
        } else if (!m9697()) {
            C1283.m16850("nf_volleyrequest", "Identity mismatch detected on client side");
            C1276.m16820().mo5727("Wrong state. Identity mismatch detected on client side");
            return C0524.m14562(new ParseException("Wrong state. Identity mismatch detected on client side"));
        } else {
            try {
                str = new String(r15.f15530, C0833.m15448(r15.f15528));
            } catch (UnsupportedEncodingException e) {
                str = new String(r15.f15530);
            }
            try {
                T r12 = mo5785(str);
                if (mo9686() || r12 != null) {
                    return C0524.m14563(r12, null);
                }
                return C0524.m14562(new ParseException("Parsing returned null."));
            } catch (Exception e2) {
                if (e2 instanceof VolleyError) {
                    return C0524.m14562((VolleyError) e2);
                }
                return C0524.m14562(new VolleyError(e2));
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean mo9686() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public void deliverResponse(T t) {
        this.f9357 = SystemClock.elapsedRealtime() - this.f9357;
        mo5640((AbstractC2040op<T>) t);
    }

    @Override // com.android.volley.Request
    public void deliverError(VolleyError volleyError) {
        C1283.m16855("nf_volleyrequest", "VolleyError: %s", volleyError.getMessage());
        this.f9357 = SystemClock.elapsedRealtime() - this.f9357;
        if (volleyError.f128 != null) {
            C1283.m16854("nf_volleyrequest", "Error on response:" + new String(volleyError.f128.f15530));
        }
        mo5637(BK.m3875(volleyError, this.f9354, StatusCode.NET_GENERAL_NETWORK_ERROR));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˋ  reason: contains not printable characters */
    public long m9696() {
        return this.f9357;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean mo9685() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean mo9689() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˎ  reason: contains not printable characters */
    public boolean m9697() {
        String str = null;
        String str2 = null;
        if (this.f9353 != null) {
            str = this.f9353.mo1396();
            str2 = this.f9353.mo1395();
        }
        if (mo9689() && (C1349Bv.m4113(str) || C1349Bv.m4113(str2))) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo9692() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo9695() {
        return null;
    }
}
