package o;

import android.content.Context;
import com.netflix.mediaclient.service.logging.client.model.HttpResponse;
import java.util.Date;
import java.util.List;
import org.chromium.net.CronetException;
import org.chromium.net.NetworkException;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UrlResponseInfo;
import org.json.JSONObject;
/* renamed from: o.ฅ  reason: contains not printable characters */
public class C0678 implements AbstractC0633 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private long f14108 = -1;

    /* renamed from: ʼ  reason: contains not printable characters */
    private long f14109 = -1;

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f14110 = -1;

    /* renamed from: ˊ  reason: contains not printable characters */
    private long f14111 = -1;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private String f14112;

    /* renamed from: ˋ  reason: contains not printable characters */
    private long f14113 = -1;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private int f14114 = -1;

    /* renamed from: ˎ  reason: contains not printable characters */
    private long f14115 = -1;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final boolean f14116;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private String f14117;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final String f14118;

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f14119 = -1;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private int f14120 = -1;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f14121 = -1;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private String f14122;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f14123;

    public C0678(Context context, RequestFinishedInfo requestFinishedInfo) {
        CronetException exception;
        boolean z = requestFinishedInfo.getFinishedReason() == 2;
        this.f14116 = requestFinishedInfo.getFinishedReason() == 0;
        this.f14118 = requestFinishedInfo.getUrl();
        RequestFinishedInfo.Metrics metrics = requestFinishedInfo.getMetrics();
        if (metrics == null) {
            C1283.m16850("nf_cr_stats", "missing metrics for " + requestFinishedInfo.getUrl());
            return;
        }
        Date dnsStart = metrics.getDnsStart();
        Date dnsEnd = metrics.getDnsEnd();
        if (!(dnsStart == null || dnsEnd == null)) {
            this.f14113 = dnsEnd.getTime() - dnsStart.getTime();
        }
        Date sslStart = metrics.getSslStart();
        Date sslEnd = metrics.getSslEnd();
        if (!(sslStart == null || sslEnd == null)) {
            this.f14115 = sslEnd.getTime() - sslStart.getTime();
        }
        Date connectStart = metrics.getConnectStart();
        Date connectEnd = metrics.getConnectEnd();
        if (!(connectStart == null || connectEnd == null)) {
            this.f14119 = connectEnd.getTime() - connectStart.getTime();
            if (this.f14115 <= 0 || this.f14119 <= this.f14115) {
                this.f14111 = this.f14119;
            } else {
                this.f14111 = this.f14119 - this.f14115;
            }
        }
        Long ttfbMs = metrics.getTtfbMs();
        this.f14108 = ttfbMs != null ? ttfbMs.longValue() : -1;
        Date requestStart = metrics.getRequestStart();
        Date requestEnd = metrics.getRequestEnd();
        if (!(requestStart == null || requestEnd == null)) {
            this.f14110 = requestEnd.getTime() - requestStart.getTime();
        }
        Long receivedByteCount = metrics.getReceivedByteCount();
        if (receivedByteCount != null) {
            this.f14109 = receivedByteCount.longValue();
        }
        this.f14123 = metrics.getSocketReused();
        UrlResponseInfo responseInfo = requestFinishedInfo.getResponseInfo();
        if (responseInfo != null) {
            this.f14121 = responseInfo.getHttpStatusCode();
            this.f14117 = m14915(responseInfo.getNegotiatedProtocol());
            List<String> list = responseInfo.getAllHeaders().get("Via");
            if (list != null && !list.isEmpty()) {
                this.f14122 = list.get(0);
            }
        }
        if (!this.f14116 && !z && (exception = requestFinishedInfo.getException()) != null && (exception instanceof NetworkException)) {
            NetworkException networkException = (NetworkException) exception;
            this.f14114 = networkException.getErrorCode();
            this.f14120 = networkException.getCronetInternalErrorCode();
        }
        this.f14112 = C0655.m14816(context);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public JSONObject m14916() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(HttpResponse.DNS_TIME, this.f14113);
        jSONObject.put("connectionTime", this.f14119);
        jSONObject.put(HttpResponse.SSL_TIME, this.f14115);
        jSONObject.put("ttfb", this.f14108);
        jSONObject.put("remainingDownloadTime", this.f14110 - this.f14108);
        jSONObject.put("receivedBytesCount", this.f14109);
        jSONObject.put("socketReused", this.f14123);
        if (this.f14121 >= 0) {
            jSONObject.put("httpStatusCode", this.f14121);
        }
        if (this.f14114 >= 0) {
            jSONObject.put("cronetErrorCode", this.f14114);
            jSONObject.put("cronetInternalErrorCode", this.f14120);
        }
        jSONObject.put("httpVersion", this.f14117);
        jSONObject.put("networkType", this.f14112);
        return jSONObject;
    }

    @Override // o.AbstractC0633
    /* renamed from: ॱ */
    public String mo14768() {
        return this.f14118;
    }

    @Override // o.AbstractC0633
    /* renamed from: ˋ */
    public boolean mo14765() {
        return this.f14116;
    }

    @Override // o.AbstractC0633
    /* renamed from: ˊ */
    public long mo14764() {
        return this.f14113;
    }

    @Override // o.AbstractC0633
    /* renamed from: ˎ */
    public long mo14766() {
        return this.f14111;
    }

    @Override // o.AbstractC0633
    /* renamed from: ˏ */
    public long mo14767() {
        return this.f14115;
    }

    @Override // o.AbstractC0633
    /* renamed from: ᐝ */
    public long mo14770() {
        return this.f14108;
    }

    @Override // o.AbstractC0633
    /* renamed from: ॱॱ */
    public long mo14769() {
        return this.f14110;
    }

    @Override // o.AbstractC0633
    /* renamed from: ʼ */
    public int mo14762() {
        return this.f14121;
    }

    @Override // o.AbstractC0633
    /* renamed from: ʻ */
    public int mo14761() {
        return this.f14114;
    }

    @Override // o.AbstractC0633
    /* renamed from: ʽ */
    public String mo14763() {
        return this.f14122;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m14915(String str) {
        if (str == null || !str.equals("h2")) {
            return "1.x";
        }
        return "2";
    }
}
