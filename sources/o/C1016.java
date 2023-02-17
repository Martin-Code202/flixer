package o;

import com.android.volley.Request;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
/* renamed from: o.ᵒ  reason: contains not printable characters */
public class C1016 implements AbstractC0894 {

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final SSLSocketFactory f15097;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected final iF f15098;

    /* renamed from: o.ᵒ$iF */
    public interface iF {
        /* renamed from: ˋ  reason: contains not printable characters */
        String m15974(String str);
    }

    public C1016() {
        this(null);
    }

    public C1016(iF iFVar) {
        this(iFVar, null);
    }

    public C1016(iF iFVar, SSLSocketFactory sSLSocketFactory) {
        this.f15098 = iFVar;
        this.f15097 = sSLSocketFactory;
    }

    @Override // o.AbstractC0894
    /* renamed from: ˋ */
    public HttpResponse mo6595(Request<?> request, Map<String, String> map) {
        String url = request.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(request.getHeaders());
        hashMap.putAll(map);
        if (this.f15098 != null) {
            String r5 = this.f15098.m15974(url);
            if (r5 == null) {
                throw new IOException("URL blocked by rewriter: " + url);
            }
            url = r5;
        }
        HttpURLConnection r6 = mo6594(new URL(url), request);
        for (String str : hashMap.keySet()) {
            r6.addRequestProperty(str, (String) hashMap.get(str));
        }
        m15971(r6, request);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (r6.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, r6.getResponseCode(), r6.getResponseMessage()));
        basicHttpResponse.setEntity(m15972(r6));
        for (Map.Entry<String, List<String>> entry : r6.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                if (entry.getKey().equalsIgnoreCase("Set-Cookie")) {
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    for (String str2 : entry.getValue()) {
                        if (i > 0) {
                            sb.append("; ");
                        }
                        sb.append(str2);
                        i++;
                    }
                    basicHttpResponse.addHeader(new BasicHeader(entry.getKey(), sb.toString()));
                } else {
                    basicHttpResponse.addHeader(new BasicHeader(entry.getKey(), entry.getValue().get(0)));
                }
            }
        }
        return basicHttpResponse;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static HttpEntity m15972(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public HttpURLConnection mo6593(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public HttpURLConnection mo6594(URL url, Request<?> request) {
        HttpURLConnection r2 = mo6593(url);
        int timeoutMs = request.getTimeoutMs();
        r2.setConnectTimeout(timeoutMs);
        r2.setReadTimeout(timeoutMs);
        r2.setUseCaches(false);
        r2.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.f15097 != null) {
            ((HttpsURLConnection) r2).setSSLSocketFactory(this.f15097);
        }
        return r2;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    static void m15971(HttpURLConnection httpURLConnection, Request<?> request) {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", request.getPostBodyContentType());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(postBody);
                    dataOutputStream.close();
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                m15973(httpURLConnection, request);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                m15973(httpURLConnection, request);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m15973(HttpURLConnection httpURLConnection, Request<?> request) {
        byte[] body = request.getBody();
        if (body != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", request.getBodyContentType());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(body);
            dataOutputStream.close();
        }
    }
}
