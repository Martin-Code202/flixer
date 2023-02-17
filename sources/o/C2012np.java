package o;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.util.HashMap;
import java.util.Map;
import o.C0524;
/* renamed from: o.np  reason: case insensitive filesystem */
public class C2012np extends Request<byte[]> {

    /* renamed from: ˎ  reason: contains not printable characters */
    private AbstractC2006nj f9200;

    /* renamed from: ˏ  reason: contains not printable characters */
    private long f9201;

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f9202;

    public C2012np(String str, long j, long j2, AbstractC2006nj njVar, C0524.AbstractC2398iF iFVar, int i) {
        super(0, str, iFVar);
        this.f9200 = njVar;
        this.f9202 = j2;
        this.f9201 = j;
        setShouldCache(false);
        setRetryPolicy(new C1040(i, 2, 2.0f));
    }

    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public C0524<byte[]> parseNetworkResponse(C1181 r5) {
        getUrl();
        if (r5.f15527 != 206) {
            return C0524.m14562(new VolleyError("Received invalid status " + r5.f15527));
        }
        C1283.m16854("nf_service_httprangerequest", "Received partial content as expected");
        return C0524.m14563(r5.f15530, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void deliverResponse(byte[] bArr) {
        if (this.f9200 != null) {
            this.f9200.mo7553(getUrl(), bArr, AbstractC0367.f13235);
        }
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("Range", "bytes=" + this.f9201 + "-" + ((this.f9201 + this.f9202) - 1));
        return hashMap;
    }
}
