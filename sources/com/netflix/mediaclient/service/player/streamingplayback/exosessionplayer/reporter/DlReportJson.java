package com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.CurrentNetworkInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.lC;
import o.lS;
import org.chromium.net.NetworkException;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UrlResponseInfo;
public class DlReportJson extends lC {
    @SerializedName("connections")
    protected List<C0019> connections = new ArrayList();
    @SerializedName("urls")
    protected List<If> urls = new ArrayList();

    /* renamed from: ˏ  reason: contains not printable characters */
    private transient long f1919;

    enum DlType {
        AUDIO,
        VIDEO,
        TIMED_TEXT,
        TRICKPLAY,
        MUXED
    }

    protected DlReportJson() {
    }

    public DlReportJson(String str, long j) {
        super("dlreport", str);
        this.f1919 = System.currentTimeMillis() - j;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void m1058(long j, CurrentNetworkInfo currentNetworkInfo, RequestFinishedInfo requestFinishedInfo, DataSpec dataSpec, lS.IF r17) {
        long j2;
        if (requestFinishedInfo.getMetrics() == null || requestFinishedInfo.getMetrics().getRequestStart() == null) {
            j2 = j - r17.m8685();
        } else {
            j2 = requestFinishedInfo.getMetrics().getRequestStart().getTime() - this.f1919;
        }
        if (!(requestFinishedInfo.getMetrics() == null || requestFinishedInfo.getMetrics().getSocketReused() || m1056(requestFinishedInfo) == null)) {
            this.connections.add(new C0019(j2, currentNetworkInfo, requestFinishedInfo));
        }
        If r8 = null;
        Iterator<If> it = this.urls.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            If next = it.next();
            if (next.dlid.equals(r17.f8577)) {
                r8 = next;
                break;
            }
        }
        if (r8 == null) {
            r8 = new If(requestFinishedInfo, r17);
            this.urls.add(r8);
        }
        r8.m1060(j2, requestFinishedInfo, dataSpec, r17);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m1057() {
        return this.connections.isEmpty() && this.urls.isEmpty();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m1059() {
        this.connections.clear();
        this.urls.clear();
    }

    static class If {
        @SerializedName("cdnid")
        protected Integer cdnid;
        @SerializedName("id")
        protected String dlid;
        @SerializedName("dltype")
        protected DlType dltype;
        @SerializedName("downloads")
        protected List<Cif> downloads = new ArrayList();
        @SerializedName("failures")
        protected List<Failure> failures = new ArrayList();
        @SerializedName("url")
        protected String url;

        public If(RequestFinishedInfo requestFinishedInfo, lS.IF r3) {
            this.url = requestFinishedInfo.getUrl();
            switch (r3.f8578) {
                case 1:
                    this.dltype = DlType.AUDIO;
                    break;
                case 2:
                    this.dltype = DlType.VIDEO;
                    break;
                case 3:
                    this.dltype = DlType.TIMED_TEXT;
                    break;
            }
            this.dlid = r3.f8577;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void m1060(long j, RequestFinishedInfo requestFinishedInfo, DataSpec dataSpec, lS.IF r15) {
            if (DlReportJson.m1047(requestFinishedInfo)) {
                this.failures.add(new Failure(j, requestFinishedInfo, dataSpec));
                return;
            }
            Integer r6 = DlReportJson.m1056(requestFinishedInfo);
            Cif ifVar = null;
            Iterator<Cif> it = this.downloads.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Cif next = it.next();
                if (DlReportJson.m1055(next.tcpid, r6)) {
                    ifVar = next;
                    break;
                }
            }
            if (ifVar == null) {
                ifVar = new Cif(j, requestFinishedInfo);
                this.downloads.add(ifVar);
            }
            ifVar.m1061(j, requestFinishedInfo, dataSpec, r15);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.DlReportJson$if  reason: invalid class name */
    public static class Cif {
        @SerializedName("dur")
        protected Long duration;
        @SerializedName("headers")
        protected ArrayList<Long> headers = new ArrayList<>();
        @SerializedName("ranges")
        protected ArrayList<long[]> ranges = new ArrayList<>();
        @SerializedName("time")
        protected long startTimestamp;
        @SerializedName("tcpid")
        protected Integer tcpid;
        @SerializedName("trace")
        protected ArrayList<Long[]> traces = new ArrayList<>();
        @SerializedName("tresp")
        protected Long ttfb;

        /* renamed from: ॱ  reason: contains not printable characters */
        private transient long f1922 = -9223372036854775807L;

        public Cif(long j, RequestFinishedInfo requestFinishedInfo) {
            this.tcpid = DlReportJson.m1056(requestFinishedInfo);
            this.startTimestamp = j;
            this.ttfb = Long.valueOf(DlReportJson.m1044(requestFinishedInfo));
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void m1061(long j, RequestFinishedInfo requestFinishedInfo, DataSpec dataSpec, lS.IF r13) {
            long r4 = DlReportJson.m1044(requestFinishedInfo);
            if (!this.traces.isEmpty() && this.f1922 != -9223372036854775807L) {
                long j2 = j - this.f1922;
                if (j2 > 0) {
                    this.traces.add(new Long[]{Long.valueOf(j2), -2L});
                }
                if (r4 > 0) {
                    this.traces.add(new Long[]{Long.valueOf(r4), -3L});
                }
            }
            this.headers.add(Long.valueOf(DlReportJson.m1045(requestFinishedInfo)));
            this.traces.add(r13.m8687());
            this.ranges.add(DlReportJson.m1051(dataSpec));
            this.f1922 = DlReportJson.m1046(requestFinishedInfo) + j;
            this.duration = Long.valueOf(this.f1922 - this.startTimestamp);
        }
    }

    /* renamed from: com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.DlReportJson$ˋ  reason: contains not printable characters */
    static class C0019 {
        @SerializedName("cdnid")
        protected Integer cdnid;
        @SerializedName("tconn")
        protected Long connectTime;
        @SerializedName("tdns")
        protected Long dnsTime;
        @SerializedName("host")
        protected String host;
        @SerializedName("id")
        protected Integer id;
        @SerializedName("network")
        protected CurrentNetworkInfo.NetSpec network;
        @SerializedName("port")
        protected Integer port;
        @SerializedName("time")
        protected Long timestamp;

        public C0019(long j, CurrentNetworkInfo currentNetworkInfo, RequestFinishedInfo requestFinishedInfo) {
            Uri parse = Uri.parse(requestFinishedInfo.getUrl());
            this.host = parse.getHost();
            if (parse.getPort() > 0) {
                this.port = Integer.valueOf(parse.getPort());
            } else {
                this.port = Integer.valueOf("http".equals(parse.getScheme()) ? 80 : 443);
            }
            this.timestamp = Long.valueOf(j);
            RequestFinishedInfo.Metrics metrics = requestFinishedInfo.getMetrics();
            if (metrics != null) {
                if (!(metrics.getDnsEnd() == null || metrics.getDnsStart() == null)) {
                    this.dnsTime = Long.valueOf(metrics.getDnsEnd().getTime() - metrics.getDnsStart().getTime());
                }
                if (!(metrics.getConnectEnd() == null || metrics.getConnectStart() == null)) {
                    this.connectTime = Long.valueOf(metrics.getConnectEnd().getTime() - metrics.getConnectStart().getTime());
                }
            }
            this.id = DlReportJson.m1056(requestFinishedInfo);
            this.network = currentNetworkInfo.m1040();
        }
    }

    /* access modifiers changed from: package-private */
    public static class Failure {
        @SerializedName("dur")
        protected Long dur;
        @SerializedName("nwerr")
        protected String errorDescription;
        @SerializedName("httpcode")
        protected Integer httpFailureCode;
        @SerializedName("range")
        protected long[] range;
        @SerializedName("reason")
        protected Reason reason;
        @SerializedName("time")
        protected Long sessionTime;
        @SerializedName("tcpid")
        protected Integer tcpid;
        @SerializedName("tresp")
        protected Long ttfb;

        enum Reason {
            NETWORK,
            TIMEOUT,
            HTTP
        }

        public Failure(long j, RequestFinishedInfo requestFinishedInfo, DataSpec dataSpec) {
            this.sessionTime = Long.valueOf(j);
            this.range = DlReportJson.m1051(dataSpec);
            this.tcpid = DlReportJson.m1056(requestFinishedInfo);
            this.ttfb = Long.valueOf(DlReportJson.m1044(requestFinishedInfo));
            RequestFinishedInfo.Metrics metrics = requestFinishedInfo.getMetrics();
            if (!(this.ttfb == null || metrics == null || metrics.getTotalTimeMs() == null)) {
                this.dur = Long.valueOf(metrics.getTotalTimeMs().longValue() - this.ttfb.longValue());
            }
            UrlResponseInfo responseInfo = requestFinishedInfo.getResponseInfo();
            if (responseInfo != null && responseInfo.getHttpStatusCode() >= 400) {
                this.reason = Reason.HTTP;
                this.httpFailureCode = Integer.valueOf(responseInfo.getHttpStatusCode());
                this.errorDescription = responseInfo.getHttpStatusText();
            } else if (requestFinishedInfo.getException() == null) {
            } else {
                if (requestFinishedInfo.getException() instanceof NetworkException) {
                    NetworkException networkException = (NetworkException) requestFinishedInfo.getException();
                    int errorCode = networkException.getErrorCode();
                    switch (errorCode) {
                        case 4:
                        case 6:
                            this.reason = Reason.TIMEOUT;
                            break;
                        default:
                            this.reason = Reason.NETWORK;
                            break;
                    }
                    switch (errorCode) {
                        case 1:
                            this.errorDescription = "HOSTNAME_NOT_RESOLVED";
                            return;
                        case 2:
                            this.errorDescription = "INTERNET_DISCONNECTED";
                            return;
                        case 3:
                            this.errorDescription = "NETWORK_CHANGED";
                            return;
                        case 4:
                            this.errorDescription = "TIMED_OUT";
                            return;
                        case 5:
                            this.errorDescription = "CONNECTION_CLOSED";
                            return;
                        case 6:
                            this.errorDescription = "CONNECTION_TIMED_OUT";
                            return;
                        case 7:
                            this.errorDescription = "CONNECTION_REFUSED";
                            return;
                        case 8:
                            this.errorDescription = "CONNECTION_RESET";
                            return;
                        case 9:
                            this.errorDescription = "ADDRESS_UNREACHABLE";
                            return;
                        case 10:
                            this.errorDescription = "QUIC_PROTOCOL_FAILED";
                            return;
                        case 11:
                            this.errorDescription = "OTHER." + networkException.getCronetInternalErrorCode();
                            return;
                        default:
                            this.errorDescription = "UNKNOWN." + networkException.getCronetInternalErrorCode();
                            return;
                    }
                } else {
                    this.errorDescription = requestFinishedInfo.getException().getMessage();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ʼ  reason: contains not printable characters */
    public static long m1045(RequestFinishedInfo requestFinishedInfo) {
        long j = 0;
        UrlResponseInfo responseInfo = requestFinishedInfo.getResponseInfo();
        if (responseInfo != null) {
            for (Map.Entry<String, String> entry : responseInfo.getAllHeadersAsList()) {
                j += (long) (entry.getKey().length() + entry.getValue().length());
            }
        }
        return j;
    }

    /* access modifiers changed from: private */
    /* renamed from: ʻ  reason: contains not printable characters */
    public static final long m1044(RequestFinishedInfo requestFinishedInfo) {
        Long ttfbMs;
        RequestFinishedInfo.Metrics metrics = requestFinishedInfo.getMetrics();
        if (metrics == null || (ttfbMs = metrics.getTtfbMs()) == null) {
            return 0;
        }
        return ttfbMs.longValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ʽ  reason: contains not printable characters */
    public static final long m1046(RequestFinishedInfo requestFinishedInfo) {
        Long totalTimeMs;
        RequestFinishedInfo.Metrics metrics = requestFinishedInfo.getMetrics();
        if (metrics == null || (totalTimeMs = metrics.getTotalTimeMs()) == null) {
            return 0;
        }
        return totalTimeMs.longValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public static long[] m1051(DataSpec dataSpec) {
        if (dataSpec.position == 0 && dataSpec.length == -1) {
            return null;
        }
        return new long[]{dataSpec.position, (dataSpec.position + dataSpec.length) - 1};
    }

    /* access modifiers changed from: private */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public static Integer m1056(RequestFinishedInfo requestFinishedInfo) {
        UrlResponseInfo responseInfo = requestFinishedInfo.getResponseInfo();
        if (responseInfo == null) {
            return null;
        }
        for (Map.Entry<String, String> entry : responseInfo.getAllHeadersAsList()) {
            if ("X-Session-Info".equalsIgnoreCase(entry.getKey())) {
                return Integer.valueOf(Math.abs(entry.getValue().hashCode()));
            }
        }
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m1047(RequestFinishedInfo requestFinishedInfo) {
        if (requestFinishedInfo.getFinishedReason() == 1 || requestFinishedInfo.getResponseInfo() == null || requestFinishedInfo.getResponseInfo().getHttpStatusCode() >= 400) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public static final boolean m1055(Integer num, Integer num2) {
        if (num == null) {
            return num2 == null;
        }
        return num.equals(num2);
    }
}
