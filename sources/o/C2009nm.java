package o;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import o.C0524;
import o.C2008nl;
/* renamed from: o.nm  reason: case insensitive filesystem */
public class C2009nm extends Request<Integer> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC2006nj f9167;

    /* renamed from: ˋ  reason: contains not printable characters */
    private C2008nl f9168;

    public C2009nm(String str, AbstractC2006nj njVar, C0524.AbstractC2398iF iFVar, int i, C2008nl nlVar) {
        super(0, str, iFVar);
        this.f9167 = njVar;
        this.f9168 = nlVar;
        setShouldCache(true);
        setRetryPolicy(new C1040(i, 2, 2.0f));
    }

    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public C0524<Integer> parseNetworkResponse(C1181 r5) {
        if (C0833.m15449(r5) != null) {
            return C0524.m14563(Integer.valueOf(r5.f15530.length), C0833.m15449(r5));
        }
        C1283.m16850("DownloadAndCacheRequest", "Request to cache response is not allowed because the response has no-cache param in header");
        return C0524.m14562(new VolleyError("Request to cache response is not allowed because the response has no-cache param in header"));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void deliverResponse(Integer num) {
        C2008nl.Cif r8 = this.f9168.m9313(getCacheKey());
        if (r8 != null && this.f9167 != null) {
            this.f9167.mo9311(getUrl(), r8.m9315(), r8.m9316(), r8.m9317(), AbstractC0367.f13235);
        }
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.NORMAL;
    }

    @Override // com.android.volley.Request
    public String getCacheKey() {
        return BG.m3859(getUrl());
    }
}
