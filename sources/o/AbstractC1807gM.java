package o;

import android.os.SystemClock;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.netflix.android.org.json.JSONException;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.msl.client.MslErrorException;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
import com.netflix.mediaclient.service.webclient.volley.ParseException;
import com.netflix.mediaclient.service.webclient.volley.StatusCodeError;
import com.netflix.mediaclient.util.net.AuthorizationCredentials;
import com.netflix.msl.MslException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import o.oD;
/* renamed from: o.gM  reason: case insensitive filesystem */
public abstract class AbstractC1807gM<T> extends gV<T> {

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private static AtomicBoolean f6900 = new AtomicBoolean(false);

    /* renamed from: ˊ  reason: contains not printable characters */
    protected ApiEndpointRegistry.ResponsePathFormat f6901;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f6902;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f6903;

    /* renamed from: ˊ */
    public abstract T mo986(String str);

    /* renamed from: ˎ */
    public abstract List<String> mo989();

    public AbstractC1807gM() {
        super(0);
        this.f6901 = ApiEndpointRegistry.ResponsePathFormat.HIERARCHICAL;
    }

    public AbstractC1807gM(ApiEndpointRegistry.ResponsePathFormat responsePathFormat) {
        super(0);
        this.f6901 = responsePathFormat;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo6583() {
        return "get";
    }

    @Override // com.android.volley.Request
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        if (params == null) {
            params = new AW<>();
        } else if (!(params instanceof AbstractC1329Bb)) {
            AW aw = new AW(params.size());
            aw.putAll(params);
            params = aw;
        }
        params.put("method", mo6583());
        if (a_()) {
            params.put("materialize", "true");
        }
        List<String> r3 = mo989();
        if (r3 == null) {
            throw new IllegalArgumentException("List of queries is null!");
        }
        for (String str : r3) {
            params.put(m6584(), str);
        }
        return params;
    }

    /* access modifiers changed from: protected */
    public boolean a_() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public String m6584() {
        if ("get".equals(mo6583())) {
            return FalkorPathResult.PATH;
        }
        return "callPath";
    }

    @Override // o.gV
    /* renamed from: ˊ */
    public byte[] mo5788(Map<String, String> map) {
        C1796gB r7 = m6614();
        try {
            oD.Cif r9 = m6571(map);
            String str = null;
            AbstractC1412Ec ec = null;
            if (m6621() != null) {
                str = m6621().mo1403();
                ec = m6621().L_();
            }
            return r7.m6498(getUrl(), r7.m6508(r9.f9230, r9.f9229, r9.f9228, r9.f9226, r9.f9227).getBytes("UTF-8"), str, ec, m6617(ec), getTag());
        } catch (JSONException e) {
            C1283.m16856("FalkorMSLVolleyRequest", e, "API request failed with JSON exception", new Object[0]);
            throw new IOException(e);
        } catch (MslErrorException e2) {
            C1283.m16856("FalkorMSLVolleyRequest", e2, "API request failed with MSL error exception, message: %s, errorHeader: %s, toString: %s", e2.getMessage(), e2.m809(), e2.toString());
            throw new IOException(e2);
        } catch (MslException e3) {
            C1283.m16856("FalkorMSLVolleyRequest", e3, "API request failed with MSL exception", new Object[0]);
            Throwable r10 = m6612(e3);
            if (r10 instanceof IOException) {
                throw ((IOException) r10);
            }
            throw new IOException(e3);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private oD.Cif m6571(Map<String, String> map) {
        m6629();
        String r7 = mo5634();
        return new oD.Cif(mo6586(), getMethod() == 0 ? "GET" : "POST", map, m6627(), r7);
    }

    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public C0524<T> parseNetworkResponse(C1181 r8) {
        if (r8 == null || r8.f15528 == null) {
            C1283.m16865("FalkorMSLVolleyRequest", "execTime not found!");
        } else {
            String str = r8.f15528.get("X-Netflix.api-script-execution-time");
            String str2 = r8.f15528.get("X-Netflix.execution-time");
            this.f6932 = r8.f15528.get("X-Netflix.api-script-revision");
            if (C1349Bv.m4107(str2)) {
                try {
                    this.f6925 = Long.parseLong(str2);
                } catch (Throwable th) {
                    C1283.m16856("FalkorMSLVolleyRequest", th, "Failed to parse server execution time!", new Object[0]);
                }
            }
            if (C1349Bv.m4107(str)) {
                try {
                    this.f6928 = Long.parseLong(str);
                } catch (Throwable th2) {
                    C1283.m16856("FalkorMSLVolleyRequest", th2, "Failed to parse api script execution time!", new Object[0]);
                }
            }
        }
        if (!(r8 == null || r8.f15530 == null)) {
            this.mResponseSizeInBytes = r8.f15530.length;
        }
        try {
            try {
                T r5 = m6581(m6614().m6496(r8.f15530));
                if (mo6620() || r5 != null) {
                    return C0524.m14563(r5, null);
                }
                return C0524.m14562(new ParseException("Parsing returned null."));
            } catch (Exception e) {
                if (e instanceof VolleyError) {
                    return C0524.m14562((VolleyError) e);
                }
                return C0524.m14562(new VolleyError(e));
            }
        } catch (JSONException | UnsupportedEncodingException e2) {
            C1283.m16856("FalkorMSLVolleyRequest", e2, "Failed to unwrap response ", new Object[0]);
            return C0524.m14562(new ParseException(e2));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public T m6581(CR cr) {
        this.f6929 = SystemClock.elapsedRealtime();
        try {
            m6575(cr);
            T r4 = mo6580(cr);
            m6578();
            this.f6929 = SystemClock.elapsedRealtime() - this.f6929;
            if (mo6620() || r4 != null) {
                return r4;
            }
            throw new FalkorException("Parsing returned null.");
        } catch (Exception e) {
            if (e instanceof FalkorException) {
                this.f6919 = m6582((FalkorException) e);
                throw ((VolleyError) e);
            } else if (e instanceof StatusCodeError) {
                m6578();
                throw ((VolleyError) e);
            } else {
                m6578();
                if (e instanceof VolleyError) {
                    throw ((VolleyError) e);
                }
                throw new VolleyError(e);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6575(CR cr) {
        C1283.m16851("FalkorMSLVolleyRequest", "checkForErrors ApiHttpWrapper status: %s, ", Integer.valueOf(cr.m4301()));
        if (cr.m4301() == 404) {
            throw new StatusCodeError(StatusCode.HTTP_ERR_404, String.format("%d bad url? %s", Integer.valueOf(cr.m4301()), getUrl()));
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m6578() {
        if (m6577()) {
            f6900.set(false);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m6582(FalkorException falkorException) {
        NetflixStatus r2 = BK.m3875(falkorException, this.f6927, StatusCode.INT_ERR_FALKOR_EXCEPTION);
        if (r2 != null && r2.mo302() == StatusCode.USER_NOT_AUTHORIZED) {
            if (this.f6902 >= 2) {
                C1283.m16854("FalkorMSLVolleyRequest", "handleNotAuthorized:: regular API failure");
                return false;
            } else if (f6900.get()) {
                C1283.m16865("FalkorMSLVolleyRequest", "User relogin attempt is in process, just retry later...");
                this.f6902++;
                return true;
            } else {
                C1283.m16865("FalkorMSLVolleyRequest", "handleNotAuthorized:: User is not authorized, see if we can relogin...");
                if (m6576()) {
                    C1283.m16865("FalkorMSLVolleyRequest", "handleNotAuthorized:: Trying to relogin using old master token and user id token...");
                    return true;
                } else if (m6573()) {
                    C1283.m16865("FalkorMSLVolleyRequest", "handleNotAuthorized:: Trying to relogin using cookies....");
                    return true;
                } else if (!this.f6921.mo1333() || this.f6903) {
                    C1283.m16854("FalkorMSLVolleyRequest", "handleNotAuthorized:: User is NOT currently logged in, pass this failure regular way...");
                } else {
                    C1283.m16854("FalkorMSLVolleyRequest", "handleNotAuthorized:: User is currently logged in, logged him out...");
                    this.f6921.mo1368(false);
                }
            }
        }
        C1283.m16854("FalkorMSLVolleyRequest", "handleNotAuthorized:: regular API failure");
        return false;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean m6573() {
        if (m6579()) {
            C1283.m16854("FalkorMSLVolleyRequest", "handleNotAuthorized:: Already tried to relogin using cookies...");
            f6900.set(false);
            return false;
        } else if (!this.f6921.mo1333()) {
            C1283.m16854("FalkorMSLVolleyRequest", "handleNotAuthorized:: User is NOT currently logged in, pass this failure regular way...");
            return false;
        } else {
            AbstractC2031og r2 = this.f6921.mo1362();
            if (r2 == null || C1349Bv.m4113(r2.mo1396()) || C1349Bv.m4113(r2.mo1399()) || C1349Bv.m4113(r2.mo1397())) {
                C1283.m16865("FalkorMSLVolleyRequest", "handleNotAuthorized:: Missing cookies, force user out... This should NOT happen here!");
                this.f6903 = true;
                this.f6921.mo1360();
                return false;
            }
            C1283.m16854("FalkorMSLVolleyRequest", "handleNotAuthorized:: Mismatch between user agent and MSL store, user is logged in according to user agent. We have cookies, just retry");
            this.f6902++;
            m6619(m6572(r2));
            f6900.set(true);
            return true;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private oR m6574(final String str, final AbstractC1412Ec ec) {
        return new oR() { // from class: o.gM.2
            @Override // o.oR
            /* renamed from: ˊ */
            public String mo1403() {
                return str;
            }

            @Override // o.oR
            public AbstractC1412Ec L_() {
                return ec;
            }
        };
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private oR m6572(AbstractC2031og ogVar) {
        return m6574(ogVar.mo1396(), new DZ(ogVar.mo1399(), ogVar.mo1397()));
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private boolean m6576() {
        if (m6566()) {
            C1283.m16854("FalkorMSLVolleyRequest", "handleNotAuthorized:: Already tried to relogin using tokens...");
            f6900.set(false);
            return false;
        }
        oD.If r2 = m6614().m6514();
        if (r2 == null || r2.f9225 == null || r2.f9224 == null) {
            return false;
        }
        C1283.m16865("FalkorMSLVolleyRequest", "handleNotAuthorized:: According to MSL store, user was logged in before, check user agent");
        if (!this.f6921.mo1333()) {
            C1283.m16850("FalkorMSLVolleyRequest", "handleNotAuthorized:: Mismatch between user agent and MSL store, user is NOT logged in according to user agent, but its credentials are found in MSL store. We can not renew its credentials, log user out!");
            this.f6903 = true;
            this.f6921.mo1368(false);
            return false;
        }
        C1283.m16854("FalkorMSLVolleyRequest", "handleNotAuthorized:: User is currently logged in, we will try to refresh his credentials, since we received that he/she is not authorized.");
        m6619(m6568(r2));
        this.f6902++;
        f6900.set(true);
        return true;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private oR m6568(oD.If r4) {
        return m6574(r4.f9223, new C1413Ed(r4.f9225, r4.f9224));
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private boolean m6577() {
        return m6566() || m6579();
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private boolean m6566() {
        oR r1 = m6621();
        if (r1 == null) {
            return false;
        }
        return r1.L_() instanceof C1413Ed;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private boolean m6579() {
        oR r1 = m6621();
        if (r1 == null) {
            return false;
        }
        return r1.L_() instanceof DZ;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public T mo6580(CR cr) {
        return mo986(cr.m4302());
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    protected static boolean m6567(String str) {
        if (C1349Bv.m4107(str)) {
            return FalkorException.m157(str.toLowerCase());
        }
        return false;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    protected static AuthorizationCredentials m6569(String str, Map<String, String> map) {
        if (map == null || map.size() < 1) {
            C1283.m16850("FalkorMSLVolleyRequest", "MSL headers not found!");
            return null;
        }
        boolean z = false;
        String str2 = map.get(C1376Cs.m4554(false));
        if (C1349Bv.m4113(str2)) {
            z = true;
            str2 = map.get(C1376Cs.m4554(true));
        }
        String str3 = map.get(C1376Cs.m4549(z));
        if (!C1349Bv.m4107(str2) || !C1349Bv.m4107(str3)) {
            return null;
        }
        C1283.m16851("FalkorMSLVolleyRequest", "Update cookies for user %s: newId %s", str, str2);
        return new AuthorizationCredentials(str, str2, str3);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    protected static String m6570(String str, Map<String, String> map) {
        if (map == null || map.size() < 1) {
            C1283.m16850("FalkorMSLVolleyRequest", "MSL headers not found!");
            return null;
        }
        String str2 = map.get(str);
        C1283.m16851("FalkorMSLVolleyRequest", "key: %s, value: %s", str, str2);
        return str2;
    }

    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public VolleyError parseNetworkError(VolleyError volleyError) {
        StatusCode r3 = BK.m3869(volleyError);
        if (r3 != null) {
            return new StatusCodeError(r3, volleyError.getCause());
        }
        if (volleyError instanceof ServerError) {
            return new StatusCodeError(StatusCode.MSL_GENERIC_NETWORK_ERROR, volleyError.getCause());
        }
        if (isCronetConnection()) {
            return BK.m3872(volleyError);
        }
        return volleyError;
    }
}
