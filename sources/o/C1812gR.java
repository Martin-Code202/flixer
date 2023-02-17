package o;

import android.content.Context;
import com.android.volley.Request;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import o.C1016;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
/* renamed from: o.gR  reason: case insensitive filesystem */
public class C1812gR extends C1016 {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected int f6912;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC0661 f6913;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected Context f6914;

    public C1812gR(Context context, AbstractC0661 r3, int i) {
        this(context, r3, null, i);
    }

    public C1812gR(Context context, AbstractC0661 r8, C1016.iF iFVar, int i) {
        this(context, r8, iFVar, null, i);
    }

    public C1812gR(Context context, AbstractC0661 r4, C1016.iF iFVar, SSLSocketFactory sSLSocketFactory, int i) {
        super(iFVar, sSLSocketFactory);
        this.f6913 = r4;
        if (context == null) {
            throw new IllegalStateException("If context is null!");
        }
        this.f6914 = context;
        this.f6912 = i;
    }

    @Override // o.C1016, o.AbstractC0894
    /* renamed from: ˋ  reason: contains not printable characters */
    public HttpResponse mo6595(Request<?> request, Map<String, String> map) {
        if (request instanceof gV) {
            return m6596((gV) request, map);
        }
        return super.mo6595(request, map);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public HttpResponse m6596(gV<?> gVVar, Map<String, String> map) {
        byte[] r3 = gVVar.mo5788(map);
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), 200, "OK"));
        basicHttpResponse.setEntity(m6592(r3));
        return basicHttpResponse;
    }

    /* access modifiers changed from: protected */
    @Override // o.C1016
    /* renamed from: ˊ  reason: contains not printable characters */
    public HttpURLConnection mo6594(URL url, Request<?> request) {
        HttpURLConnection r0 = super.mo6594(url, request);
        request.setHttpURLConnection(r0);
        return r0;
    }

    /* access modifiers changed from: protected */
    @Override // o.C1016
    /* renamed from: ˊ  reason: contains not printable characters */
    public HttpURLConnection mo6593(URL url) {
        return this.f6913.mo14823(url);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static HttpEntity m6592(byte[] bArr) {
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(bArr);
        byteArrayEntity.setContentEncoding("identity");
        byteArrayEntity.setContentType("text/plain");
        return byteArrayEntity;
    }
}
