package o;

import android.os.SystemClock;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.netflix.android.org.json.JSONException;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.msl.client.MslErrorException;
import com.netflix.mediaclient.service.webclient.volley.ParseException;
import com.netflix.mediaclient.service.webclient.volley.StatusCodeError;
import com.netflix.msl.MslException;
import java.io.IOException;
import java.util.Map;
/* renamed from: o.bm  reason: case insensitive filesystem */
public abstract class AbstractC1564bm<T> extends gV<T> {
    /* access modifiers changed from: protected */
    /* renamed from: ˋ */
    public abstract T mo5632(byte[] bArr);

    /* access modifiers changed from: protected */
    /* renamed from: ॱ */
    public abstract String mo5635();

    /* access modifiers changed from: protected */
    /* renamed from: ॱ */
    public abstract byte[] mo5636(byte[] bArr, Map<String, String> map, String str, AbstractC1412Ec ec);

    protected AbstractC1564bm() {
        super(1);
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    @Override // com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.LOG;
    }

    @Override // o.gV, com.android.volley.Request
    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        headers.put("Content-Encoding", "msl_v1");
        return headers;
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo5787() {
        m6615(m6614().m6495().mo1455(mo5635()));
    }

    @Override // o.gV
    /* renamed from: ˊ  reason: contains not printable characters */
    public byte[] mo5788(Map<String, String> map) {
        try {
            m6629();
            String r5 = mo5634();
            m6627();
            String str = null;
            AbstractC1412Ec ec = null;
            if (m6621() != null) {
                str = m6621().mo1403();
                ec = m6621().L_();
            }
            C1283.m16854("nf_client_log_msl_equest", "Executing ichnaea (logging) request...");
            return mo5636(r5.getBytes("UTF-8"), getHeaders(), str, ec);
        } catch (JSONException e) {
            C1283.m16856("nf_client_log_msl_equest", e, "API request failed with JSON exception", new Object[0]);
            throw new IOException(e);
        } catch (MslErrorException e2) {
            C1283.m16856("nf_client_log_msl_equest", e2, "API request failed with MSL Error exception", new Object[0]);
            throw new IOException(e2);
        } catch (MslException e3) {
            C1283.m16856("nf_client_log_msl_equest", e3, "API request failed with MSL exception", new Object[0]);
            throw new IOException(e3);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public C0524<T> parseNetworkResponse(C1181 r7) {
        if (r7 == null || r7.f15528 == null) {
            C1283.m16865("nf_client_log_msl_equest", "execTime not found!");
        } else {
            String str = r7.f15528.get("X-Netflix.api-script-execution-time");
            String str2 = r7.f15528.get("X-Netflix.execution-time");
            this.f6932 = r7.f15528.get("X-Netflix.api-script-revision");
            if (C1349Bv.m4107(str2)) {
                try {
                    this.f6925 = Long.parseLong(str2);
                } catch (Throwable th) {
                    C1283.m16856("nf_client_log_msl_equest", th, "Failed to parse server execution time!", new Object[0]);
                }
            }
            if (C1349Bv.m4107(str)) {
                try {
                    this.f6928 = Long.parseLong(str);
                } catch (Throwable th2) {
                    C1283.m16856("nf_client_log_msl_equest", th2, "Failed to parse api script execution time!", new Object[0]);
                }
            }
        }
        if (!(r7 == null || r7.f15530 == null)) {
            this.mResponseSizeInBytes = r7.f15530.length;
        }
        try {
            T r3 = m5789(r7.f15530);
            if (mo6620() || r3 != null) {
                return C0524.m14563(r3, null);
            }
            return C0524.m14562(new ParseException("Parsing returned null."));
        } catch (Exception e) {
            if (e instanceof VolleyError) {
                return C0524.m14562((VolleyError) e);
            }
            return C0524.m14562(new VolleyError(e));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public T m5789(byte[] bArr) {
        this.f6929 = SystemClock.elapsedRealtime();
        try {
            T r4 = mo5632(bArr);
            this.f6929 = SystemClock.elapsedRealtime() - this.f6929;
            if (mo6620() || r4 != null) {
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
}
