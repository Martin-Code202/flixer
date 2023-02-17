package org.chromium.net.impl;

import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.net.CronetException;
import org.chromium.net.InlineExecutionProhibitedException;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UrlRequest;
import org.chromium.net.impl.VersionSafeCallbacks;
public final class CronetUrlRequest extends UrlRequestBase {
    static final /* synthetic */ boolean $assertionsDisabled = (!CronetUrlRequest.class.desiredAssertionStatus());
    private final boolean mAllowDirectExecutor;
    private final VersionSafeCallbacks.UrlRequestCallback mCallback;
    private final boolean mDisableCache;
    private final boolean mDisableConnectionMigration;
    private CronetException mException;
    private final Executor mExecutor;
    private int mFinishedReason;
    private String mInitialMethod;
    private final String mInitialUrl;
    private CronetMetrics mMetrics;
    private Runnable mOnDestroyedCallbackForTesting;
    private OnReadCompletedRunnable mOnReadCompletedTask;
    private final int mPriority;
    private long mReceivedByteCountFromRedirects;
    private final Collection<Object> mRequestAnnotations;
    private final CronetUrlRequestContext mRequestContext;
    private final HeadersList mRequestHeaders = new HeadersList();
    private UrlResponseInfoImpl mResponseInfo;
    private boolean mStarted;
    private CronetUploadDataStream mUploadDataStream;
    private final List<String> mUrlChain = new ArrayList();
    private long mUrlRequestAdapter;
    private final Object mUrlRequestAdapterLock = new Object();
    private boolean mWaitingOnRead;
    private boolean mWaitingOnRedirect;

    private native boolean nativeAddRequestHeader(long j, String str, String str2);

    private native long nativeCreateRequestAdapter(long j, String str, int i, boolean z, boolean z2, boolean z3);

    private native void nativeDestroy(long j, boolean z);

    private native void nativeFollowDeferredRedirect(long j);

    private native void nativeGetStatus(long j, VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener);

    private native boolean nativeReadData(long j, ByteBuffer byteBuffer, int i, int i2);

    private native boolean nativeSetHttpMethod(long j, String str);

    private native void nativeStart(long j);

    /* access modifiers changed from: package-private */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        private HeadersList() {
        }
    }

    final class OnReadCompletedRunnable implements Runnable {
        ByteBuffer mByteBuffer;

        private OnReadCompletedRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.this.checkCallingThread();
            ByteBuffer byteBuffer = this.mByteBuffer;
            this.mByteBuffer = null;
            try {
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (!CronetUrlRequest.this.isDoneLocked()) {
                        CronetUrlRequest.this.mWaitingOnRead = true;
                        CronetUrlRequest.this.mCallback.onReadCompleted(CronetUrlRequest.this, CronetUrlRequest.this.mResponseInfo, byteBuffer);
                    }
                }
            } catch (Exception e) {
                CronetUrlRequest.this.onCallbackException(e);
            }
        }
    }

    CronetUrlRequest(CronetUrlRequestContext cronetUrlRequestContext, String str, int i, UrlRequest.Callback callback, Executor executor, Collection<Object> collection, boolean z, boolean z2, boolean z3) {
        if (str == null) {
            throw new NullPointerException("URL is required");
        } else if (callback == null) {
            throw new NullPointerException("Listener is required");
        } else if (executor == null) {
            throw new NullPointerException("Executor is required");
        } else {
            this.mAllowDirectExecutor = z3;
            this.mRequestContext = cronetUrlRequestContext;
            this.mInitialUrl = str;
            this.mUrlChain.add(str);
            this.mPriority = convertRequestPriority(i);
            this.mCallback = new VersionSafeCallbacks.UrlRequestCallback(callback);
            this.mExecutor = executor;
            this.mRequestAnnotations = collection;
            this.mDisableCache = z;
            this.mDisableConnectionMigration = z2;
        }
    }

    @Override // org.chromium.net.impl.UrlRequestBase
    public void setHttpMethod(String str) {
        checkNotStarted();
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.mInitialMethod = str;
    }

    @Override // org.chromium.net.impl.UrlRequestBase
    public void addHeader(String str, String str2) {
        checkNotStarted();
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        } else if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        } else {
            this.mRequestHeaders.add(new AbstractMap.SimpleImmutableEntry(str, str2));
        }
    }

    @Override // org.chromium.net.impl.UrlRequestBase
    public void setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (this.mInitialMethod == null) {
            this.mInitialMethod = "POST";
        }
        this.mUploadDataStream = new CronetUploadDataStream(uploadDataProvider, executor);
    }

    @Override // org.chromium.net.UrlRequest
    public void start() {
        synchronized (this.mUrlRequestAdapterLock) {
            checkNotStarted();
            try {
                this.mUrlRequestAdapter = nativeCreateRequestAdapter(this.mRequestContext.getUrlRequestContextAdapter(), this.mInitialUrl, this.mPriority, this.mDisableCache, this.mDisableConnectionMigration, this.mRequestContext.hasRequestFinishedListener());
                this.mRequestContext.onRequestStarted();
                if (this.mInitialMethod == null || nativeSetHttpMethod(this.mUrlRequestAdapter, this.mInitialMethod)) {
                    boolean z = false;
                    Iterator it = this.mRequestHeaders.iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        if (((String) entry.getKey()).equalsIgnoreCase("Content-Type") && !((String) entry.getValue()).isEmpty()) {
                            z = true;
                        }
                        if (!nativeAddRequestHeader(this.mUrlRequestAdapter, (String) entry.getKey(), (String) entry.getValue())) {
                            throw new IllegalArgumentException("Invalid header " + ((String) entry.getKey()) + "=" + ((String) entry.getValue()));
                        }
                    }
                    if (this.mUploadDataStream == null) {
                        this.mStarted = true;
                        startInternalLocked();
                    } else if (!z) {
                        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                    } else {
                        this.mStarted = true;
                        this.mUploadDataStream.postTaskToExecutor(new Runnable() { // from class: org.chromium.net.impl.CronetUrlRequest.1
                            @Override // java.lang.Runnable
                            public void run() {
                                CronetUrlRequest.this.mUploadDataStream.initializeWithRequest(CronetUrlRequest.this);
                                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                                    if (!CronetUrlRequest.this.isDoneLocked()) {
                                        CronetUrlRequest.this.mUploadDataStream.attachNativeAdapterToRequest(CronetUrlRequest.this.mUrlRequestAdapter);
                                        CronetUrlRequest.this.startInternalLocked();
                                    }
                                }
                            }
                        });
                    }
                } else {
                    throw new IllegalArgumentException("Invalid http method " + this.mInitialMethod);
                }
            } catch (RuntimeException e) {
                destroyRequestAdapterLocked(1);
                throw e;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startInternalLocked() {
        nativeStart(this.mUrlRequestAdapter);
    }

    @Override // org.chromium.net.UrlRequest
    public void followRedirect() {
        synchronized (this.mUrlRequestAdapterLock) {
            if (!this.mWaitingOnRedirect) {
                throw new IllegalStateException("No redirect to follow.");
            }
            this.mWaitingOnRedirect = false;
            if (!isDoneLocked()) {
                nativeFollowDeferredRedirect(this.mUrlRequestAdapter);
            }
        }
    }

    @Override // org.chromium.net.UrlRequest
    public void read(ByteBuffer byteBuffer) {
        Preconditions.checkHasRemaining(byteBuffer);
        Preconditions.checkDirect(byteBuffer);
        synchronized (this.mUrlRequestAdapterLock) {
            if (!this.mWaitingOnRead) {
                throw new IllegalStateException("Unexpected read attempt.");
            }
            this.mWaitingOnRead = false;
            if (!isDoneLocked()) {
                if (!nativeReadData(this.mUrlRequestAdapter, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                    this.mWaitingOnRead = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
            }
        }
    }

    @Override // org.chromium.net.UrlRequest
    public void cancel() {
        synchronized (this.mUrlRequestAdapterLock) {
            if (!isDoneLocked() && this.mStarted) {
                destroyRequestAdapterLocked(2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isDoneLocked() {
        return this.mStarted && this.mUrlRequestAdapter == 0;
    }

    @Override // org.chromium.net.UrlRequest
    public void getStatus(UrlRequest.StatusListener statusListener) {
        final VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener = new VersionSafeCallbacks.UrlRequestStatusListener(statusListener);
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mUrlRequestAdapter != 0) {
                nativeGetStatus(this.mUrlRequestAdapter, urlRequestStatusListener);
            } else {
                postTaskToExecutor(new Runnable() { // from class: org.chromium.net.impl.CronetUrlRequest.2
                    @Override // java.lang.Runnable
                    public void run() {
                        urlRequestStatusListener.onStatus(-1);
                    }
                });
            }
        }
    }

    private void postTaskToExecutor(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e) {
            Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", e);
            failWithException(new CronetExceptionImpl("Exception posting task to executor", e));
        }
    }

    private static int convertRequestPriority(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            default:
                return 4;
        }
    }

    private UrlResponseInfoImpl prepareResponseInfoOnNetworkThread(int i, String str, String[] strArr, boolean z, String str2, String str3) {
        HeadersList headersList = new HeadersList();
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            headersList.add(new AbstractMap.SimpleImmutableEntry(strArr[i2], strArr[i2 + 1]));
        }
        return new UrlResponseInfoImpl(new ArrayList(this.mUrlChain), i, str, headersList, z, str2, str3);
    }

    private void checkNotStarted() {
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mStarted || isDoneLocked()) {
                throw new IllegalStateException("Request is already started.");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void destroyRequestAdapterLocked(int i) {
        if ($assertionsDisabled || this.mException == null || i == 1) {
            this.mFinishedReason = i;
            if (this.mUrlRequestAdapter != 0) {
                this.mRequestContext.onRequestDestroyed();
                nativeDestroy(this.mUrlRequestAdapter, i == 2);
                this.mUrlRequestAdapter = 0;
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onCallbackException(Exception exc) {
        CallbackExceptionImpl callbackExceptionImpl = new CallbackExceptionImpl("Exception received from UrlRequest.Callback", exc);
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in CalledByNative method", exc);
        failWithException(callbackExceptionImpl);
    }

    /* access modifiers changed from: package-private */
    public void onUploadException(Throwable th) {
        CallbackExceptionImpl callbackExceptionImpl = new CallbackExceptionImpl("Exception received from UploadDataProvider", th);
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in upload method", th);
        failWithException(callbackExceptionImpl);
    }

    private void failWithException(CronetException cronetException) {
        synchronized (this.mUrlRequestAdapterLock) {
            if (!isDoneLocked()) {
                if ($assertionsDisabled || this.mException == null) {
                    this.mException = cronetException;
                    destroyRequestAdapterLocked(1);
                    return;
                }
                throw new AssertionError();
            }
        }
    }

    @CalledByNative
    private void onRedirectReceived(final String str, int i, String str2, String[] strArr, boolean z, String str3, String str4, long j) {
        final UrlResponseInfoImpl prepareResponseInfoOnNetworkThread = prepareResponseInfoOnNetworkThread(i, str2, strArr, z, str3, str4);
        this.mReceivedByteCountFromRedirects += j;
        prepareResponseInfoOnNetworkThread.setReceivedByteCount(this.mReceivedByteCountFromRedirects);
        this.mUrlChain.add(str);
        postTaskToExecutor(new Runnable() { // from class: org.chromium.net.impl.CronetUrlRequest.3
            @Override // java.lang.Runnable
            public void run() {
                CronetUrlRequest.this.checkCallingThread();
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (!CronetUrlRequest.this.isDoneLocked()) {
                        CronetUrlRequest.this.mWaitingOnRedirect = true;
                        try {
                            CronetUrlRequest.this.mCallback.onRedirectReceived(CronetUrlRequest.this, prepareResponseInfoOnNetworkThread, str);
                        } catch (Exception e) {
                            CronetUrlRequest.this.onCallbackException(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onResponseStarted(int i, String str, String[] strArr, boolean z, String str2, String str3) {
        this.mResponseInfo = prepareResponseInfoOnNetworkThread(i, str, strArr, z, str2, str3);
        postTaskToExecutor(new Runnable() { // from class: org.chromium.net.impl.CronetUrlRequest.4
            @Override // java.lang.Runnable
            public void run() {
                CronetUrlRequest.this.checkCallingThread();
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (!CronetUrlRequest.this.isDoneLocked()) {
                        CronetUrlRequest.this.mWaitingOnRead = true;
                        try {
                            CronetUrlRequest.this.mCallback.onResponseStarted(CronetUrlRequest.this, CronetUrlRequest.this.mResponseInfo);
                        } catch (Exception e) {
                            CronetUrlRequest.this.onCallbackException(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i, int i2, int i3, long j) {
        this.mResponseInfo.setReceivedByteCount(this.mReceivedByteCountFromRedirects + j);
        if (byteBuffer.position() == i2 && byteBuffer.limit() == i3) {
            if (this.mOnReadCompletedTask == null) {
                this.mOnReadCompletedTask = new OnReadCompletedRunnable();
            }
            byteBuffer.position(i2 + i);
            this.mOnReadCompletedTask.mByteBuffer = byteBuffer;
            postTaskToExecutor(this.mOnReadCompletedTask);
            return;
        }
        failWithException(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
    }

    @CalledByNative
    private void onSucceeded(long j) {
        this.mResponseInfo.setReceivedByteCount(this.mReceivedByteCountFromRedirects + j);
        postTaskToExecutor(new Runnable() { // from class: org.chromium.net.impl.CronetUrlRequest.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUrlRequest.this.mUrlRequestAdapterLock) {
                    if (!CronetUrlRequest.this.isDoneLocked()) {
                        CronetUrlRequest.this.destroyRequestAdapterLocked(0);
                        try {
                            CronetUrlRequest.this.mCallback.onSucceeded(CronetUrlRequest.this, CronetUrlRequest.this.mResponseInfo);
                            CronetUrlRequest.this.maybeReportMetrics();
                        } catch (Exception e) {
                            Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onSucceeded method", e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onError(int i, int i2, int i3, String str, long j) {
        if (this.mResponseInfo != null) {
            this.mResponseInfo.setReceivedByteCount(this.mReceivedByteCountFromRedirects + j);
        }
        if (i == 10) {
            failWithException(new QuicExceptionImpl("Exception in CronetUrlRequest: " + str, i2, i3));
            return;
        }
        failWithException(new NetworkExceptionImpl("Exception in CronetUrlRequest: " + str, mapUrlRequestErrorToApiErrorCode(i), i2));
    }

    @CalledByNative
    private void onCanceled() {
        postTaskToExecutor(new Runnable() { // from class: org.chromium.net.impl.CronetUrlRequest.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CronetUrlRequest.this.mCallback.onCanceled(CronetUrlRequest.this, CronetUrlRequest.this.mResponseInfo);
                    CronetUrlRequest.this.maybeReportMetrics();
                } catch (Exception e) {
                    Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onCanceled method", e);
                }
            }
        });
    }

    @CalledByNative
    private void onStatus(final VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener, final int i) {
        postTaskToExecutor(new Runnable() { // from class: org.chromium.net.impl.CronetUrlRequest.7
            @Override // java.lang.Runnable
            public void run() {
                urlRequestStatusListener.onStatus(UrlRequestBase.convertLoadState(i));
            }
        });
    }

    @CalledByNative
    private void onMetricsCollected(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z, long j14, long j15) {
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mMetrics != null) {
                throw new IllegalStateException("Metrics collection should only happen once.");
            }
            this.mMetrics = new CronetMetrics(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, z, j14, j15);
        }
    }

    @CalledByNative
    private void onNativeAdapterDestroyed() {
        synchronized (this.mUrlRequestAdapterLock) {
            if (this.mOnDestroyedCallbackForTesting != null) {
                this.mOnDestroyedCallbackForTesting.run();
            }
            if (this.mException != null) {
                try {
                    this.mExecutor.execute(new Runnable() { // from class: org.chromium.net.impl.CronetUrlRequest.8
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                CronetUrlRequest.this.mCallback.onFailed(CronetUrlRequest.this, CronetUrlRequest.this.mResponseInfo, CronetUrlRequest.this.mException);
                                CronetUrlRequest.this.maybeReportMetrics();
                            } catch (Exception e) {
                                Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onFailed method", e);
                            }
                        }
                    });
                } catch (RejectedExecutionException e) {
                    Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", e);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void checkCallingThread() {
        if (!this.mAllowDirectExecutor && this.mRequestContext.isNetworkThread(Thread.currentThread())) {
            throw new InlineExecutionProhibitedException();
        }
    }

    private int mapUrlRequestErrorToApiErrorCode(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            case 10:
                return 10;
            case 11:
                return 11;
            default:
                Log.e(CronetUrlRequestContext.LOG_TAG, "Unknown error code: " + i, new Object[0]);
                return i;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void maybeReportMetrics() {
        if (this.mMetrics != null) {
            this.mRequestContext.reportFinished(new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, this.mMetrics, this.mFinishedReason, this.mResponseInfo, this.mException));
        }
    }
}
