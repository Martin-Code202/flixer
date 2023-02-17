package o;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.msl.MslException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
public abstract class gV<T> extends Request<T> implements oO {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected long f6918;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    protected boolean f6919;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected oR f6920;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected UserAgentInterface f6921;

    /* renamed from: ˊ  reason: contains not printable characters */
    private C1796gB f6922;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected String f6923;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f6924;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected long f6925 = -1;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f6926;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected AbstractC2049oy f6927;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected long f6928;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected long f6929;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected AbstractC1221 f6930;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected UUID f6931;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    protected String f6932;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected int f6933;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected oD f6934;

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public abstract void mo5787();

    /* renamed from: ˊ */
    public abstract byte[] mo5788(Map<String, String> map);

    /* renamed from: ˏ */
    public abstract void mo991(Status status);

    /* renamed from: ˏ */
    public abstract void mo992(T t);

    public gV(int i) {
        super(i, null, null);
        setShouldCache(false);
        this.f6931 = UUID.randomUUID();
        this.f6918 = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻ  reason: contains not printable characters */
    public void m6615(String str) {
        if (this.f6923 != null) {
            C1283.m16854("nf_volleyrequest", "Reusing existing request...");
            return;
        }
        this.f6923 = str;
        if (TextUtils.isEmpty(this.f6923)) {
            this.f6926 = 0;
            return;
        }
        Uri parse = Uri.parse(this.f6923);
        String host = parse.getHost();
        this.f6924 = parse.getPath();
        if (this.f6924.startsWith("/msl")) {
            this.f6924 = this.f6924.substring(4);
        }
        if (host == null) {
            this.f6926 = 0;
        } else {
            this.f6926 = host.hashCode();
        }
    }

    @Override // com.android.volley.Request
    public String getUrl() {
        return this.f6923;
    }

    @Override // com.android.volley.Request
    public void changeHostUrl(String str) {
        this.f6923 = Request.buildNewUrlString(this.f6923, str);
        this.f6926 = str.hashCode();
        this.f6922.m6495().mo1449(str);
        super.changeHostUrl(str);
    }

    @Override // com.android.volley.Request
    public int getTrafficStatsTag() {
        return this.f6926;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean mo6620() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public void deliverResponse(T t) {
        this.f6918 = SystemClock.elapsedRealtime() - this.f6918;
        m6616();
        if (!(this.f6922 == null || this.f6922.m6500() == null)) {
            C1860hr.m7330(this.f6922.m6500());
        }
        mo992((gV<T>) t);
    }

    @Override // com.android.volley.Request
    public void deliverError(VolleyError volleyError) {
        if (volleyError.f128 != null) {
            C1283.m16854("nf_volleyrequest", "Error on response:" + new String(volleyError.f128.f15530));
        }
        if (this.f6919) {
            this.f6919 = false;
            if (this.f6934 != null) {
                C1283.m16851("nf_volleyrequest", "Retry request %s", getClass().getSimpleName());
                this.f6934.mo6791(this);
                return;
            }
        }
        this.f6918 = SystemClock.elapsedRealtime() - this.f6918;
        NetflixStatus r5 = BK.m3875(volleyError, this.f6927, StatusCode.NET_GENERAL_NETWORK_ERROR);
        m6622(r5);
        if ((this.f6922 != null && ConnectivityUtils.m2954(this.f6922.m6500())) && new Random().nextInt(1000) == 31) {
            C1276.m16820().mo5729(volleyError.getMessage(), volleyError);
        }
        mo991((Status) r5);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6622(NetflixStatus netflixStatus) {
        if (netflixStatus != null && netflixStatus.mo302() == StatusCode.MSL_USERAUTH_ENTITY_MISMATCH) {
            C1283.m16854("nf_volleyrequest", "processStatus:: MSL_USERAUTH_ENTITY_MISMATCH, clear ESN depended saved data...");
            this.f6930.mo16510();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʼ  reason: contains not printable characters */
    public long m6616() {
        return this.f6918;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6625(AbstractC2049oy oyVar) {
        this.f6927 = oyVar;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public C1796gB m6614() {
        return this.f6922;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6623(C1796gB gBVar) {
        this.f6922 = gBVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6626(AbstractC1221 r1) {
        this.f6930 = r1;
        mo5787();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6618(UserAgentInterface userAgentInterface) {
        this.f6921 = userAgentInterface;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6624(oD oDVar) {
        this.f6934 = oDVar;
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        if (headers == null || headers == Collections.EMPTY_MAP) {
            headers = new HashMap<>();
        }
        headers.put("X-Netflix.request.uuid", "" + this.f6931);
        if (!(this.f6930 == null || this.f6930.d_() == null || this.f6922 == null)) {
            headers.put("X-Netflix.esnPrefix", this.f6930.d_().mo14442());
            headers.put("X-Netflix.appVer", C1318At.m3776(this.f6922.m6500()));
        }
        return headers;
    }

    @Override // com.android.volley.Request
    public String getBodyContentType() {
        return "application/msl; charset=" + getParamsEncoding();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6628(int i) {
        this.f6933 = i;
    }

    /* renamed from: ʽ */
    public String mo6586() {
        return this.f6924;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public String m6627() {
        if (getMethod() != 0) {
            return null;
        }
        return m6613();
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public Map<String, String> m6629() {
        try {
            return getHeaders();
        } catch (Throwable th) {
            C1283.m16856("nf_volleyrequest", th, "Failed to get MSL headers", new Object[0]);
            return null;
        }
    }

    /* renamed from: ˏ */
    public String mo5634() {
        if (getMethod() == 0) {
            return null;
        }
        return m6613();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private String m6613() {
        try {
            Map<String, String> params = getParams();
            if (params == null || params.size() <= 0) {
                return null;
            }
            return m6611(params, getParamsEncoding());
        } catch (Throwable th) {
            C1283.m16856("nf_volleyrequest", th, "Failed to get BODY as string", new Object[0]);
            return null;
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public oR m6621() {
        return this.f6920;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6619(oR oRVar) {
        this.f6920 = oRVar;
    }

    /* renamed from: ˊॱ */
    public Boolean mo987() {
        return Boolean.FALSE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public final Boolean m6617(AbstractC1412Ec ec) {
        if (ec != null) {
            return Boolean.TRUE;
        }
        return mo987();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m6611(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (null != entry.getValue()) {
                    sb.append(URLEncoder.encode(entry.getKey(), str));
                    sb.append('=');
                    sb.append(URLEncoder.encode(entry.getValue(), str));
                    sb.append('&');
                }
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    protected static Throwable m6612(MslException mslException) {
        if (mslException == null) {
            return null;
        }
        if (mslException.getCause() == null) {
            return mslException;
        }
        return m6610(mslException.getCause());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    protected static Throwable m6610(Throwable th) {
        if (th == null) {
            return null;
        }
        if (!(th instanceof IOException) && th.getCause() != null) {
            return m6610(th.getCause());
        }
        return th;
    }
}
