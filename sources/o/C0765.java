package o;

import com.android.volley.Request;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
/* renamed from: o.ᑦ  reason: contains not printable characters */
public class C0765 implements AbstractC0894 {

    /* renamed from: ॱ  reason: contains not printable characters */
    protected final HttpClient f14394;

    public C0765(HttpClient httpClient) {
        this.f14394 = httpClient;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m15211(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, map.get(str));
        }
    }

    @Override // o.AbstractC0894
    /* renamed from: ˋ */
    public HttpResponse mo6595(Request<?> request, Map<String, String> map) {
        HttpUriRequest r1 = m15212(request, map);
        m15211(r1, map);
        m15211(r1, request.getHeaders());
        m15215(r1);
        HttpParams params = r1.getParams();
        int timeoutMs = request.getTimeoutMs();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, timeoutMs);
        HttpResponse execute = this.f14394.execute(r1);
        m15213(execute);
        return execute;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m15213(HttpResponse httpResponse) {
        StringBuilder sb = new StringBuilder();
        Header[] allHeaders = httpResponse.getAllHeaders();
        for (Header header : allHeaders) {
            if (header.getName() != null && header.getName().equalsIgnoreCase("Set-Cookie")) {
                if (sb.length() > 0) {
                    sb.append("; ");
                }
                sb.append(header.getValue());
            }
        }
        if (sb.length() > 0) {
            httpResponse.removeHeaders("Set-Cookie");
            httpResponse.addHeader("Set-Cookie", sb.toString());
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static HttpUriRequest m15212(Request<?> request, Map<String, String> map) {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody == null) {
                    return new HttpGet(request.getUrl());
                }
                HttpPost httpPost = new HttpPost(request.getUrl());
                httpPost.addHeader("Content-Type", request.getPostBodyContentType());
                httpPost.setEntity(new ByteArrayEntity(postBody));
                return httpPost;
            case 0:
                return new HttpGet(request.getUrl());
            case 1:
                HttpPost httpPost2 = new HttpPost(request.getUrl());
                httpPost2.addHeader("Content-Type", request.getBodyContentType());
                m15214(httpPost2, request);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(request.getUrl());
                httpPut.addHeader("Content-Type", request.getBodyContentType());
                m15214(httpPut, request);
                return httpPut;
            case 3:
                return new HttpDelete(request.getUrl());
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m15214(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, Request<?> request) {
        byte[] body = request.getBody();
        if (body != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(body));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15215(HttpUriRequest httpUriRequest) {
    }
}
