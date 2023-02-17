package org.chromium.net.impl;

import android.os.ConditionVariable;
import android.os.Process;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.base.Log;
import org.chromium.base.ObserverList;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.UsedByReflection;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UrlRequest;
import org.chromium.net.impl.CronetEngineBuilderImpl;
import org.chromium.net.impl.VersionSafeCallbacks;
import org.chromium.net.urlconnection.CronetHttpURLConnection;
@UsedByReflection
public class CronetUrlRequestContext extends CronetEngineBase {
    static final String LOG_TAG = CronetUrlRequestContext.class.getSimpleName();
    private final AtomicInteger mActiveRequestCount = new AtomicInteger(0);
    private String mCertVerifierData;
    private int mDownstreamThroughputKbps = -1;
    private int mEffectiveConnectionType = 0;
    private final Object mFinishedListenerLock = new Object();
    private final Map<RequestFinishedInfo.Listener, VersionSafeCallbacks.RequestFinishedInfoListener> mFinishedListenerMap = new HashMap();
    private int mHttpRttMs = -1;
    private final ConditionVariable mInitCompleted = new ConditionVariable(false);
    private final Object mLock = new Object();
    private final boolean mNetworkQualityEstimatorEnabled;
    private final Object mNetworkQualityLock = new Object();
    private Thread mNetworkThread;
    private final int mNetworkThreadPriority;
    private final ObserverList<VersionSafeCallbacks.NetworkQualityRttListenerWrapper> mRttListenerList = new ObserverList<>();
    private volatile ConditionVariable mStopNetLogCompleted;
    private final ObserverList<VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper> mThroughputListenerList = new ObserverList<>();
    private int mTransportRttMs = -1;
    private long mUrlRequestContextAdapter = 0;
    private ConditionVariable mWaitGetCertVerifierDataComplete = new ConditionVariable();

    private static native void nativeAddPkp(long j, String str, byte[][] bArr, boolean z, long j2);

    private static native void nativeAddQuicHint(long j, String str, int i, int i2);

    private native void nativeConfigureNetworkQualityEstimatorForTesting(long j, boolean z, boolean z2, boolean z3);

    private static native long nativeCreateRequestContextAdapter(long j);

    private static native long nativeCreateRequestContextConfig(String str, String str2, boolean z, String str3, boolean z2, boolean z3, boolean z4, boolean z5, int i, long j, String str4, long j2, boolean z6, boolean z7, String str5);

    private native void nativeDestroy(long j);

    private native void nativeGetCertVerifierData(long j);

    private static native byte[] nativeGetHistogramDeltas();

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private native void nativeInitRequestContextOnInitThread(long j);

    private native void nativeProvideRTTObservations(long j, boolean z);

    private native void nativeProvideThroughputObservations(long j, boolean z);

    private static native int nativeSetMinLogLevel(int i);

    private native void nativeStartNetLogToDisk(long j, String str, boolean z, int i);

    private native boolean nativeStartNetLogToFile(long j, String str, boolean z);

    private native void nativeStopNetLog(long j);

    @UsedByReflection
    public CronetUrlRequestContext(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        this.mNetworkQualityEstimatorEnabled = cronetEngineBuilderImpl.networkQualityEstimatorEnabled();
        this.mNetworkThreadPriority = cronetEngineBuilderImpl.threadPriority(10);
        CronetLibraryLoader.ensureInitialized(cronetEngineBuilderImpl.getContext(), cronetEngineBuilderImpl);
        nativeSetMinLogLevel(getLoggingLevel());
        synchronized (this.mLock) {
            this.mUrlRequestContextAdapter = nativeCreateRequestContextAdapter(createNativeUrlRequestContextConfig(cronetEngineBuilderImpl));
            if (this.mUrlRequestContextAdapter == 0) {
                throw new NullPointerException("Context Adapter creation failed.");
            }
        }
        CronetLibraryLoader.postToInitThread(new Runnable() { // from class: org.chromium.net.impl.CronetUrlRequestContext.1
            @Override // java.lang.Runnable
            public void run() {
                CronetLibraryLoader.ensureInitializedOnInitThread();
                synchronized (CronetUrlRequestContext.this.mLock) {
                    CronetUrlRequestContext.this.nativeInitRequestContextOnInitThread(CronetUrlRequestContext.this.mUrlRequestContextAdapter);
                }
            }
        });
    }

    public static long createNativeUrlRequestContextConfig(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        long nativeCreateRequestContextConfig = nativeCreateRequestContextConfig(cronetEngineBuilderImpl.getUserAgent(), cronetEngineBuilderImpl.storagePath(), cronetEngineBuilderImpl.quicEnabled(), cronetEngineBuilderImpl.getDefaultQuicUserAgentId(), cronetEngineBuilderImpl.http2Enabled(), cronetEngineBuilderImpl.sdchEnabled(), cronetEngineBuilderImpl.brotliEnabled(), cronetEngineBuilderImpl.cacheDisabled(), cronetEngineBuilderImpl.httpCacheMode(), cronetEngineBuilderImpl.httpCacheMaxSize(), cronetEngineBuilderImpl.experimentalOptions(), cronetEngineBuilderImpl.mockCertVerifier(), cronetEngineBuilderImpl.networkQualityEstimatorEnabled(), cronetEngineBuilderImpl.publicKeyPinningBypassForLocalTrustAnchorsEnabled(), cronetEngineBuilderImpl.certVerifierData());
        for (CronetEngineBuilderImpl.QuicHint quicHint : cronetEngineBuilderImpl.quicHints()) {
            nativeAddQuicHint(nativeCreateRequestContextConfig, quicHint.mHost, quicHint.mPort, quicHint.mAlternatePort);
        }
        for (CronetEngineBuilderImpl.Pkp pkp : cronetEngineBuilderImpl.publicKeyPins()) {
            nativeAddPkp(nativeCreateRequestContextConfig, pkp.mHost, pkp.mHashes, pkp.mIncludeSubdomains, pkp.mExpirationDate.getTime());
        }
        return nativeCreateRequestContextConfig;
    }

    @Override // org.chromium.net.impl.CronetEngineBase
    public UrlRequestBase createRequest(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3) {
        CronetUrlRequest cronetUrlRequest;
        synchronized (this.mLock) {
            checkHaveAdapter();
            cronetUrlRequest = new CronetUrlRequest(this, str, i, callback, executor, collection, z, z2, z3);
        }
        return cronetUrlRequest;
    }

    @CalledByNative
    public void stopNetLogCompleted() {
        this.mStopNetLogCompleted.open();
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public int getDownstreamThroughputKbps() {
        int i;
        if (!this.mNetworkQualityEstimatorEnabled) {
            throw new IllegalStateException("Network quality estimator must be enabled");
        }
        synchronized (this.mNetworkQualityLock) {
            i = this.mDownstreamThroughputKbps != -1 ? this.mDownstreamThroughputKbps : -1;
        }
        return i;
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public void addRequestFinishedListener(RequestFinishedInfo.Listener listener) {
        synchronized (this.mFinishedListenerLock) {
            this.mFinishedListenerMap.put(listener, new VersionSafeCallbacks.RequestFinishedInfoListener(listener));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasRequestFinishedListener() {
        boolean z;
        synchronized (this.mFinishedListenerLock) {
            z = !this.mFinishedListenerMap.isEmpty();
        }
        return z;
    }

    @Override // org.chromium.net.CronetEngine
    public URLConnection openConnection(URL url) {
        return openConnection(url, Proxy.NO_PROXY);
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public URLConnection openConnection(URL url, Proxy proxy) {
        if (proxy.type() != Proxy.Type.DIRECT) {
            throw new UnsupportedOperationException();
        }
        String protocol = url.getProtocol();
        if ("http".equals(protocol) || "https".equals(protocol)) {
            return new CronetHttpURLConnection(url, this);
        }
        throw new UnsupportedOperationException("Unexpected protocol:" + protocol);
    }

    /* access modifiers changed from: package-private */
    public void onRequestStarted() {
        this.mActiveRequestCount.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public void onRequestDestroyed() {
        this.mActiveRequestCount.decrementAndGet();
    }

    public long getUrlRequestContextAdapter() {
        long j;
        synchronized (this.mLock) {
            checkHaveAdapter();
            j = this.mUrlRequestContextAdapter;
        }
        return j;
    }

    private void checkHaveAdapter() {
        if (!haveRequestContextAdapter()) {
            throw new IllegalStateException("Engine is shut down.");
        }
    }

    private boolean haveRequestContextAdapter() {
        return this.mUrlRequestContextAdapter != 0;
    }

    private int getLoggingLevel() {
        if (Log.isLoggable(LOG_TAG, 2)) {
            return -2;
        }
        if (Log.isLoggable(LOG_TAG, 3)) {
            return -1;
        }
        return 3;
    }

    @CalledByNative
    private void initNetworkThread() {
        this.mNetworkThread = Thread.currentThread();
        this.mInitCompleted.open();
        Thread.currentThread().setName("ChromiumNet");
        Process.setThreadPriority(this.mNetworkThreadPriority);
    }

    @CalledByNative
    private void onEffectiveConnectionTypeChanged(int i) {
        synchronized (this.mNetworkQualityLock) {
            this.mEffectiveConnectionType = i;
        }
    }

    @CalledByNative
    private void onRTTOrThroughputEstimatesComputed(int i, int i2, int i3) {
        synchronized (this.mNetworkQualityLock) {
            this.mHttpRttMs = i;
            this.mTransportRttMs = i2;
            this.mDownstreamThroughputKbps = i3;
        }
    }

    @CalledByNative
    private void onRttObservation(final int i, final long j, final int i2) {
        synchronized (this.mNetworkQualityLock) {
            Iterator<VersionSafeCallbacks.NetworkQualityRttListenerWrapper> it = this.mRttListenerList.iterator();
            while (it.hasNext()) {
                final VersionSafeCallbacks.NetworkQualityRttListenerWrapper next = it.next();
                postObservationTaskToExecutor(next.getExecutor(), new Runnable() { // from class: org.chromium.net.impl.CronetUrlRequestContext.2
                    @Override // java.lang.Runnable
                    public void run() {
                        next.onRttObservation(i, j, i2);
                    }
                });
            }
        }
    }

    @CalledByNative
    private void onThroughputObservation(final int i, final long j, final int i2) {
        synchronized (this.mNetworkQualityLock) {
            Iterator<VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper> it = this.mThroughputListenerList.iterator();
            while (it.hasNext()) {
                final VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper next = it.next();
                postObservationTaskToExecutor(next.getExecutor(), new Runnable() { // from class: org.chromium.net.impl.CronetUrlRequestContext.3
                    @Override // java.lang.Runnable
                    public void run() {
                        next.onThroughputObservation(i, j, i2);
                    }
                });
            }
        }
    }

    @CalledByNative
    private void onGetCertVerifierData(String str) {
        this.mCertVerifierData = str;
        this.mWaitGetCertVerifierDataComplete.open();
    }

    /* access modifiers changed from: package-private */
    public void reportFinished(final RequestFinishedInfo requestFinishedInfo) {
        ArrayList arrayList;
        synchronized (this.mFinishedListenerLock) {
            arrayList = new ArrayList(this.mFinishedListenerMap.values());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final VersionSafeCallbacks.RequestFinishedInfoListener requestFinishedInfoListener = (VersionSafeCallbacks.RequestFinishedInfoListener) it.next();
            postObservationTaskToExecutor(requestFinishedInfoListener.getExecutor(), new Runnable() { // from class: org.chromium.net.impl.CronetUrlRequestContext.4
                @Override // java.lang.Runnable
                public void run() {
                    requestFinishedInfoListener.onRequestFinished(requestFinishedInfo);
                }
            });
        }
    }

    private static void postObservationTaskToExecutor(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (RejectedExecutionException e) {
            Log.e(LOG_TAG, "Exception posting task to executor", e);
        }
    }

    public boolean isNetworkThread(Thread thread) {
        return thread == this.mNetworkThread;
    }
}
