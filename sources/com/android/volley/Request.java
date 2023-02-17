package com.android.volley;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import o.AbstractC0573;
import o.AbstractC1001;
import o.C0482;
import o.C0509;
import o.C0524;
import o.C1040;
import o.C1181;
public abstract class Request<T> implements Comparable<Request<T>> {
    protected static final boolean DEBUG = false;
    private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
    private static final long SLOW_REQUEST_THRESHOLD_MS = 3000;
    private AbstractC1001.Cif mCacheEntry;
    private boolean mCanceled;
    private boolean mConnected;
    private int mDefaultTrafficStatsTag;
    private final C0524.AbstractC2398iF mErrorListener;
    private final C0509.iF mEventLog;
    private HttpURLConnection mHttpURLConnection;
    private final int mMethod;
    protected final long mRequestBirthTime;
    private boolean mRequestInFlight;
    private C0482 mRequestQueue;
    private ResourceLocationType mResourceLocationType;
    private boolean mResponseDelivered;
    protected int mResponseSizeInBytes;
    private AbstractC0573 mRetryPolicy;
    private Integer mSequence;
    private boolean mShouldCache;
    private Object mTag;
    private String mUrl;

    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public enum ResourceLocationType {
        UNSET,
        CACHE,
        NETWORK
    }

    public abstract void deliverResponse(T t);

    public abstract C0524<T> parseNetworkResponse(C1181 v);

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((Request) ((Request) obj));
    }

    public ResourceLocationType getResourceLocationType() {
        return this.mResourceLocationType;
    }

    public void setResourceLocationType(ResourceLocationType resourceLocationType) {
        if (this.mResourceLocationType == ResourceLocationType.UNSET) {
            this.mResourceLocationType = resourceLocationType;
        }
    }

    public Request(String str, C0524.AbstractC2398iF iFVar) {
        this(-1, str, iFVar);
    }

    public Request(int i, String str, C0524.AbstractC2398iF iFVar) {
        this.mConnected = true;
        this.mResourceLocationType = ResourceLocationType.UNSET;
        this.mEventLog = null;
        this.mShouldCache = true;
        this.mCanceled = false;
        this.mResponseDelivered = false;
        this.mResponseSizeInBytes = 0;
        this.mRequestInFlight = false;
        this.mCacheEntry = null;
        this.mMethod = i;
        this.mUrl = str;
        this.mErrorListener = iFVar;
        setRetryPolicy(new C1040());
        this.mRequestBirthTime = SystemClock.elapsedRealtime();
        this.mDefaultTrafficStatsTag = TextUtils.isEmpty(str) ? 0 : Uri.parse(str).getHost().hashCode();
    }

    public void setHttpURLConnection(HttpURLConnection httpURLConnection) {
        this.mHttpURLConnection = httpURLConnection;
    }

    public void setConnected() {
        this.mConnected = true;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002d: APUT  (r1v1 java.lang.Object[]), (2 ??[int, float, short, byte, char]), (r2v5 java.lang.String) */
    public void releaseResources() {
        if (isCronetConnection()) {
            try {
                Object[] objArr = new Object[3];
                objArr[0] = Boolean.valueOf(this.mConnected);
                objArr[1] = getClass().getSimpleName();
                objArr[2] = this.mHttpURLConnection != null ? this.mHttpURLConnection.toString() : "null";
                C0509.m14520("Request::releaseResources: Cronet:: HTTP disconnect! connected: %b, class: %s, to: %s", objArr);
                if (this.mConnected) {
                    this.mConnected = false;
                    this.mHttpURLConnection.disconnect();
                }
            } catch (Throwable th) {
            }
        }
    }

    public boolean isCronetConnection() {
        return this.mHttpURLConnection != null && "org.chromium.net.urlconnection.CronetHttpURLConnection".equals(this.mHttpURLConnection.getClass().getName());
    }

    public boolean isFtlEndpoint() {
        String url = getUrl();
        return url != null && url.contains("ftl.netflix.com");
    }

    public void checkFtlFallback() {
    }

    public void triggerFtlFallback(VolleyError volleyError) {
        C0509.m14519("ftl fallback requested for non-FTL-aware request", new Object[0]);
    }

    public int getMethod() {
        return this.mMethod;
    }

    public void setTag(Object obj) {
        this.mTag = obj;
    }

    public Object getTag() {
        return this.mTag;
    }

    public int getTrafficStatsTag() {
        return this.mDefaultTrafficStatsTag;
    }

    public void setRetryPolicy(AbstractC0573 r1) {
        this.mRetryPolicy = r1;
    }

    public void addMarker(String str) {
    }

    public void finish(String str) {
        if (this.mRequestQueue != null) {
            this.mRequestQueue.m14414(this);
        }
        int i = ((SystemClock.elapsedRealtime() - this.mRequestBirthTime) > SLOW_REQUEST_THRESHOLD_MS ? 1 : ((SystemClock.elapsedRealtime() - this.mRequestBirthTime) == SLOW_REQUEST_THRESHOLD_MS ? 0 : -1));
    }

    public void setRequestQueue(C0482 r1) {
        this.mRequestQueue = r1;
    }

    public final void setSequence(int i) {
        this.mSequence = Integer.valueOf(i);
    }

    public final int getSequence() {
        if (this.mSequence != null) {
            return this.mSequence.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public String getUrl() {
        return this.mUrl;
    }

    public static String buildNewUrlString(String str, String str2) {
        try {
            URL url = new URL(str);
            StringBuilder sb = new StringBuilder();
            sb.append(url.getProtocol()).append("://").append(str2).append(url.getPath()).append("?").append(url.getQuery());
            C0509.m14519("Redirect: newUrl %s", sb.toString());
            return sb.toString();
        } catch (MalformedURLException e) {
            C0509.m14522(e, "failed in build redirected url redirectedHost %s, oldUrl %s", str2, str);
            return str;
        }
    }

    public void changeHostUrl(String str) {
        this.mUrl = buildNewUrlString(this.mUrl, str);
        this.mDefaultTrafficStatsTag = str.hashCode();
    }

    public void changeToRedirectedUrl(String str) {
        this.mUrl = str;
    }

    public String getCacheKey() {
        return getUrl();
    }

    public void setCacheEntry(AbstractC1001.Cif ifVar) {
        this.mCacheEntry = ifVar;
    }

    public AbstractC1001.Cif getCacheEntry() {
        return this.mCacheEntry;
    }

    public void cancel() {
        this.mCanceled = true;
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }

    public Map<String, String> getHeaders() {
        return Collections.emptyMap();
    }

    /* access modifiers changed from: protected */
    public Map<String, String> getPostParams() {
        return getParams();
    }

    /* access modifiers changed from: protected */
    public String getPostParamsEncoding() {
        return getParamsEncoding();
    }

    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    public byte[] getPostBody() {
        Map<String, String> postParams = getPostParams();
        if (postParams == null || postParams.size() <= 0) {
            return null;
        }
        return encodeParameters(postParams, getPostParamsEncoding());
    }

    public Map<String, String> getParams() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getParamsEncoding() {
        return DEFAULT_PARAMS_ENCODING;
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + getParamsEncoding();
    }

    public byte[] getBody() {
        Map<String, String> params = getParams();
        if (params == null || params.size() <= 0) {
            return null;
        }
        return encodeParameters(params, getParamsEncoding());
    }

    private byte[] encodeParameters(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (null != entry.getValue()) {
                    sb.append(URLEncoder.encode(entry.getKey(), str));
                    sb.append('=');
                    sb.append(URLEncoder.encode(entry.getValue(), str));
                    sb.append('&');
                }
            }
            return sb.toString().getBytes(str);
        } catch (Exception e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    public final void setShouldCache(boolean z) {
        this.mShouldCache = z;
    }

    public final boolean shouldCache() {
        return this.mShouldCache;
    }

    public Priority getPriority() {
        return Priority.NORMAL;
    }

    public final int getTimeoutMs() {
        return this.mRetryPolicy.mo14675();
    }

    public AbstractC0573 getRetryPolicy() {
        return this.mRetryPolicy;
    }

    public void markDelivered() {
        this.mResponseDelivered = true;
    }

    public boolean hasHadResponseDelivered() {
        return this.mResponseDelivered;
    }

    public int getResponseSizeInBytes() {
        return this.mResponseSizeInBytes;
    }

    public VolleyError parseNetworkError(VolleyError volleyError) {
        return volleyError;
    }

    public void deliverError(VolleyError volleyError) {
        if (this.mErrorListener != null) {
            this.mErrorListener.onErrorResponse(volleyError);
        }
    }

    public void markInFlight(boolean z) {
        this.mRequestInFlight = z;
    }

    public boolean isRequestInFlight() {
        return this.mRequestInFlight;
    }

    public int compareTo(Request<T> request) {
        Priority priority = getPriority();
        Priority priority2 = request.getPriority();
        if (priority == priority2) {
            return this.mSequence.intValue() - request.mSequence.intValue();
        }
        return priority2.ordinal() - priority.ordinal();
    }

    @Override // java.lang.Object
    public String toString() {
        return (this.mCanceled ? "[X] " : "[ ] ") + getUrl() + " " + ("0x" + Integer.toHexString(getTrafficStatsTag())) + " " + getPriority() + " " + this.mSequence + " " + getTag();
    }
}
