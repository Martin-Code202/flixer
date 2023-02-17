package o;

import com.android.volley.Request;
import java.net.HttpURLConnection;
import java.net.URL;
/* renamed from: o.ns  reason: case insensitive filesystem */
public class C2015ns extends C1016 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC0661 f9207;

    public C2015ns(AbstractC0661 r1) {
        this.f9207 = r1;
    }

    /* access modifiers changed from: protected */
    @Override // o.C1016
    /* renamed from: ˊ */
    public HttpURLConnection mo6593(URL url) {
        return this.f9207.mo14823(url);
    }

    /* access modifiers changed from: protected */
    @Override // o.C1016
    /* renamed from: ˊ */
    public HttpURLConnection mo6594(URL url, Request<?> request) {
        HttpURLConnection r0 = super.mo6594(url, request);
        request.setHttpURLConnection(r0);
        return r0;
    }
}
