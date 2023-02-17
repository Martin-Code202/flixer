package com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.netflixdatasource.cronetdatasource;

import android.net.Uri;
import android.os.ConditionVariable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Predicate;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.netflixdatasource.NetflixNetworkError;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o.AbstractC1959lq;
import o.AbstractC1966ly;
import o.C1963lv;
import o.C1964lw;
import o.lS;
import org.chromium.net.CronetException;
import org.chromium.net.ExperimentalCronetEngine;
import org.chromium.net.ExperimentalUrlRequest;
import org.chromium.net.NetworkException;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;
public class CronetDataSource extends UrlRequest.Callback implements HttpDataSource {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final Pattern f1885 = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: ʻ  reason: contains not printable characters */
    private final AbstractC1959lq f1886;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private ByteBuffer f1887;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final boolean f1888;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private IOException f1889;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final int f1890;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private UrlResponseInfo f1891;

    /* renamed from: ʾ  reason: contains not printable characters */
    private volatile long f1892;

    /* renamed from: ʿ  reason: contains not printable characters */
    private boolean f1893;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Executor f1894;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final int f1895;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Predicate<String> f1896;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f1897;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final ExperimentalCronetEngine f1898;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private lS f1899;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final Clock f1900;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1966ly f1901;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final ConditionVariable f1902;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private UrlRequest f1903;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private long f1904;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Map<String, String> f1905;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private DataSpec f1906;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final int f1907;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private long f1908;

    public static class CronetDataSourceException extends HttpDataSource.HttpDataSourceException {

        /* renamed from: ˊ  reason: contains not printable characters */
        public final int f1911;

        public CronetDataSourceException(IOException iOException, DataSpec dataSpec, int i, int i2) {
            super(iOException, dataSpec, i);
            this.f1911 = i2;
        }

        public CronetDataSourceException(String str, DataSpec dataSpec, int i, int i2) {
            super(str, dataSpec, i);
            this.f1911 = i2;
        }
    }

    public static final class OpenException extends CronetDataSourceException {
        public OpenException(IOException iOException, DataSpec dataSpec, int i) {
            super(iOException, dataSpec, 1, i);
        }

        public OpenException(String str, DataSpec dataSpec, int i) {
            super(str, dataSpec, 1, i);
        }
    }

    public CronetDataSource(ExperimentalCronetEngine experimentalCronetEngine, Executor executor, Predicate<String> predicate, AbstractC1966ly lyVar, int i, int i2, boolean z, lS lSVar, AbstractC1959lq lqVar, int i3) {
        this(experimentalCronetEngine, executor, predicate, lyVar, i, i2, z, new C1964lw(), lSVar, lqVar, i3);
    }

    CronetDataSource(ExperimentalCronetEngine experimentalCronetEngine, Executor executor, Predicate<String> predicate, AbstractC1966ly lyVar, int i, int i2, boolean z, Clock clock, lS lSVar, AbstractC1959lq lqVar, int i3) {
        this.f1898 = (ExperimentalCronetEngine) Assertions.checkNotNull(experimentalCronetEngine);
        this.f1894 = (Executor) Assertions.checkNotNull(executor);
        this.f1896 = predicate;
        this.f1901 = lyVar;
        this.f1890 = i;
        this.f1907 = i2;
        this.f1888 = z;
        this.f1900 = (Clock) Assertions.checkNotNull(clock);
        this.f1905 = new HashMap();
        this.f1902 = new ConditionVariable();
        this.f1899 = lSVar;
        this.f1886 = lqVar;
        this.f1895 = i3;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m1035(lS lSVar) {
        this.f1899 = lSVar;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        if (this.f1891 == null) {
            return null;
        }
        return Uri.parse(this.f1891.getUrl());
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        Assertions.checkNotNull(dataSpec);
        Assertions.checkState(!this.f1897);
        this.f1902.close();
        m1028();
        this.f1906 = dataSpec;
        if (this.f1901 != null) {
            this.f1901.m8772(this, dataSpec);
        }
        this.f1903 = m1034(dataSpec);
        this.f1903.start();
        boolean r4 = m1032();
        if (this.f1889 != null) {
            if (this.f1901 != null) {
                this.f1901.m8771(this);
            }
            if (this.f1886 != null) {
                this.f1886.mo8747(dataSpec, m1031(this.f1889, false));
            }
            throw new OpenException(this.f1889, this.f1906, m1030(this.f1903));
        } else if (!r4) {
            if (this.f1901 != null) {
                this.f1901.m8771(this);
            }
            if (this.f1886 != null) {
                this.f1886.mo8747(dataSpec, NetflixNetworkError.CONNECTION_TIMEOUT);
            }
            this.f1889 = new SocketTimeoutException();
            throw new OpenException(this.f1889, dataSpec, m1030(this.f1903));
        } else {
            int httpStatusCode = this.f1891.getHttpStatusCode();
            if (httpStatusCode < 200 || httpStatusCode > 299) {
                HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = new HttpDataSource.InvalidResponseCodeException(httpStatusCode, this.f1891.getAllHeaders(), this.f1906);
                if (httpStatusCode == 416) {
                    invalidResponseCodeException.initCause(new DataSourceException(0));
                }
                if (this.f1901 != null) {
                    this.f1901.m8771(this);
                }
                throw invalidResponseCodeException;
            }
            if (this.f1896 != null) {
                List<String> list = this.f1891.getAllHeaders().get("Content-Type");
                String str = m1033(list) ? null : list.get(0);
                if (!this.f1896.evaluate(str)) {
                    if (this.f1901 != null) {
                        this.f1901.m8771(this);
                    }
                    if (this.f1886 != null) {
                        this.f1886.mo8747(dataSpec, NetflixNetworkError.HTTP_CONTENT_TYPE);
                    }
                    throw new HttpDataSource.InvalidContentTypeException(str, this.f1906);
                }
            }
            this.f1904 = (httpStatusCode != 200 || dataSpec.position == 0) ? 0 : dataSpec.position;
            if (m1029(this.f1891)) {
                this.f1908 = this.f1906.length;
            } else if (dataSpec.length != -1) {
                this.f1908 = dataSpec.length;
            } else {
                this.f1908 = m1027(this.f1891);
            }
            this.f1897 = true;
            if (this.f1899 != null) {
                this.f1899.m8671(dataSpec);
            }
            if (this.f1901 != null) {
                this.f1901.onTransferStart(this, dataSpec);
            }
            return this.f1908;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) {
        Assertions.checkState(this.f1897);
        if (i2 == 0) {
            return 0;
        }
        if (this.f1908 == 0) {
            return -1;
        }
        if (this.f1887 == null) {
            this.f1887 = ByteBuffer.allocateDirect(this.f1895);
            this.f1887.limit(0);
        }
        while (!this.f1887.hasRemaining()) {
            this.f1902.close();
            this.f1887.clear();
            this.f1903.read(this.f1887);
            if (!this.f1902.block((long) this.f1907)) {
                this.f1887 = null;
                if (this.f1886 != null) {
                    this.f1886.mo8747(this.f1906, NetflixNetworkError.HTTP_CONNECTION_STALL);
                }
                this.f1889 = new SocketTimeoutException();
                throw new CronetDataSourceException(this.f1889, this.f1906, 2, m1030(this.f1903));
            } else if (this.f1889 != null) {
                if (this.f1886 != null) {
                    this.f1886.mo8747(this.f1906, m1031(this.f1889, true));
                }
                throw new CronetDataSourceException(this.f1889, this.f1906, 2, m1030(this.f1903));
            } else if (this.f1893) {
                return -1;
            } else {
                this.f1887.flip();
                Assertions.checkState(this.f1887.hasRemaining());
                if (this.f1899 != null) {
                    this.f1899.m8681(this.f1906, (long) this.f1887.remaining());
                }
                if (this.f1901 != null) {
                    this.f1901.onBytesTransferred(this, this.f1887.remaining());
                }
                if (this.f1904 > 0) {
                    int min = (int) Math.min((long) this.f1887.remaining(), this.f1904);
                    this.f1887.position(this.f1887.position() + min);
                    this.f1904 -= (long) min;
                }
            }
        }
        int min2 = Math.min(this.f1887.remaining(), i2);
        this.f1887.get(bArr, i, min2);
        if (this.f1908 != -1) {
            this.f1908 -= (long) min2;
        }
        return min2;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public synchronized void close() {
        if (this.f1903 != null) {
            this.f1903.cancel();
            this.f1903 = null;
        }
        if (this.f1887 != null) {
            this.f1887.limit(0);
        }
        this.f1906 = null;
        this.f1891 = null;
        if (this.f1897 && this.f1889 == null && this.f1886 != null) {
            this.f1886.mo8748(this.f1906);
        }
        this.f1889 = null;
        this.f1893 = false;
        if (this.f1897) {
            this.f1897 = false;
            if (this.f1901 != null) {
                this.f1901.onTransferEnd(this);
            }
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public synchronized void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
        int httpStatusCode;
        if (urlRequest == this.f1903) {
            if (this.f1906.postBody == null || !((httpStatusCode = urlResponseInfo.getHttpStatusCode()) == 307 || httpStatusCode == 308)) {
                if (this.f1888) {
                    m1028();
                }
                urlRequest.followRedirect();
                return;
            }
            this.f1889 = new HttpDataSource.InvalidResponseCodeException(httpStatusCode, urlResponseInfo.getAllHeaders(), this.f1906);
            this.f1902.open();
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public synchronized void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        if (urlRequest == this.f1903) {
            this.f1891 = urlResponseInfo;
            this.f1902.open();
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public synchronized void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
        if (urlRequest == this.f1903) {
            this.f1902.open();
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public synchronized void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        if (urlRequest == this.f1903) {
            this.f1893 = true;
            this.f1902.open();
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public synchronized void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        if (urlRequest == this.f1903) {
            if (!(cronetException instanceof NetworkException) || ((NetworkException) cronetException).getErrorCode() != 1) {
                this.f1889 = cronetException;
            } else {
                this.f1889 = new UnknownHostException();
            }
            this.f1902.open();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private UrlRequest m1034(DataSpec dataSpec) {
        ExperimentalUrlRequest.Builder newUrlRequestBuilder = this.f1898.newUrlRequestBuilder(dataSpec.uri.toString(), (UrlRequest.Callback) this, this.f1894);
        synchronized (this.f1905) {
            if (dataSpec.postBody == null || dataSpec.postBody.length == 0 || this.f1905.containsKey("Content-Type")) {
                for (Map.Entry<String, String> entry : this.f1905.entrySet()) {
                    newUrlRequestBuilder.addHeader(entry.getKey(), entry.getValue());
                }
            } else {
                throw new OpenException("POST request with non-empty body must set Content-Type", dataSpec, 0);
            }
        }
        if (!(this.f1906.position == 0 && this.f1906.length == -1)) {
            StringBuilder sb = new StringBuilder();
            sb.append("bytes=");
            sb.append(this.f1906.position);
            sb.append("-");
            if (this.f1906.length != -1) {
                sb.append((this.f1906.position + this.f1906.length) - 1);
            }
            newUrlRequestBuilder.addHeader("Range", sb.toString());
        }
        if (dataSpec.postBody != null) {
            newUrlRequestBuilder.setHttpMethod("POST");
            if (dataSpec.postBody.length != 0) {
                newUrlRequestBuilder.setUploadDataProvider((UploadDataProvider) new C1963lv(dataSpec.postBody), this.f1894);
            }
        }
        newUrlRequestBuilder.addRequestAnnotation(dataSpec);
        if (this.f1899 != null) {
            newUrlRequestBuilder.addRequestAnnotation(this.f1899);
        }
        newUrlRequestBuilder.allowDirectExecutor();
        return newUrlRequestBuilder.build();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m1032() {
        long elapsedRealtime = this.f1900.elapsedRealtime();
        boolean z = false;
        while (!z && elapsedRealtime < this.f1892) {
            z = this.f1902.block((this.f1892 - elapsedRealtime) + 5);
            elapsedRealtime = this.f1900.elapsedRealtime();
        }
        return z;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m1028() {
        this.f1892 = this.f1900.elapsedRealtime() + ((long) this.f1890);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static boolean m1029(UrlResponseInfo urlResponseInfo) {
        for (Map.Entry<String, String> entry : urlResponseInfo.getAllHeadersAsList()) {
            if (entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                return !entry.getValue().equalsIgnoreCase("identity");
            }
        }
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static long m1027(UrlResponseInfo urlResponseInfo) {
        long j = -1;
        Map<String, List<String>> allHeaders = urlResponseInfo.getAllHeaders();
        List<String> list = allHeaders.get("Content-Length");
        String str = null;
        if (!m1033(list)) {
            str = list.get(0);
            if (!TextUtils.isEmpty(str)) {
                try {
                    j = Long.parseLong(str);
                } catch (NumberFormatException e) {
                    Log.e("CronetDataSource", "Unexpected Content-Length [" + str + "]");
                }
            }
        }
        List<String> list2 = allHeaders.get("Content-Range");
        if (m1033(list2)) {
            return j;
        }
        String str2 = list2.get(0);
        Matcher matcher = f1885.matcher(str2);
        if (!matcher.find()) {
            return j;
        }
        try {
            long parseLong = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            if (j < 0) {
                return parseLong;
            }
            if (j == parseLong) {
                return j;
            }
            Log.w("CronetDataSource", "Inconsistent headers [" + str + "] [" + str2 + "]");
            return Math.max(j, parseLong);
        } catch (NumberFormatException e2) {
            Log.e("CronetDataSource", "Unexpected Content-Range [" + str2 + "]");
            return j;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int m1030(UrlRequest urlRequest) {
        final ConditionVariable conditionVariable = new ConditionVariable();
        final int[] iArr = new int[1];
        urlRequest.getStatus(new UrlRequest.StatusListener() { // from class: com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.netflixdatasource.cronetdatasource.CronetDataSource.5
            @Override // org.chromium.net.UrlRequest.StatusListener
            public void onStatus(int i) {
                iArr[0] = i;
                conditionVariable.open();
            }
        });
        conditionVariable.block();
        return iArr[0];
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean m1033(List<?> list) {
        return list == null || list.isEmpty();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static NetflixNetworkError m1031(IOException iOException, boolean z) {
        if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
            HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = (HttpDataSource.InvalidResponseCodeException) iOException;
            if (invalidResponseCodeException.responseCode == 420) {
                return NetflixNetworkError.HTTP_RESPONSE_420;
            }
            if (invalidResponseCodeException.responseCode >= 500) {
                return NetflixNetworkError.HTTP_RESPONSE_5XX;
            }
            if (invalidResponseCodeException.responseCode >= 400) {
                return NetflixNetworkError.HTTP_RESPONSE_4XX;
            }
            return NetflixNetworkError.HTTP_RESPONSE_3XX;
        } else if (iOException instanceof UnknownHostException) {
            return NetflixNetworkError.DNS_NOT_FOUND;
        } else {
            if (iOException instanceof NetworkException) {
                switch (((NetworkException) iOException).getErrorCode()) {
                    case 1:
                        return NetflixNetworkError.DNS_NOT_FOUND;
                    case 2:
                        return NetflixNetworkError.CONNECTION_NETWORK_DOWN;
                    case 3:
                        return NetflixNetworkError.NETWORK_CHANGED;
                    case 4:
                        if (z) {
                            return NetflixNetworkError.HTTP_CONNECTION_STALL;
                        }
                        return NetflixNetworkError.HTTPS_CONNECTION_TIMEOUT;
                    case 5:
                        return NetflixNetworkError.CONNECTION_CLOSED;
                    case 6:
                        return NetflixNetworkError.CONNECTION_TIMEOUT;
                    case 7:
                        return NetflixNetworkError.CONNECTION_REFUSED;
                    case 8:
                        if (z) {
                            return NetflixNetworkError.CONNECTION_RESET_WHILE_RECEIVING;
                        }
                        return NetflixNetworkError.CONNECTION_RESET_ON_CONNECT;
                    case 9:
                        return NetflixNetworkError.CONNECTION_NO_ROUTE_TO_HOST;
                }
            }
            return NetflixNetworkError.UNKNOWN;
        }
    }
}
