package org.chromium.net.impl;

import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.net.CronetException;
import org.chromium.net.ExperimentalBidirectionalStream;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.impl.UrlResponseInfoImpl;
import org.chromium.net.impl.VersionSafeCallbacks;
public class CronetBidirectionalStream extends ExperimentalBidirectionalStream {
    static final /* synthetic */ boolean $assertionsDisabled = (!CronetBidirectionalStream.class.desiredAssertionStatus());
    private final VersionSafeCallbacks.BidirectionalStreamCallback mCallback;
    private boolean mEndOfStreamWritten;
    private CronetException mException;
    private final Executor mExecutor;
    private LinkedList<ByteBuffer> mFlushData;
    private final String mInitialMethod;
    private final String mInitialUrl;
    private RequestFinishedInfo.Metrics mMetrics;
    private long mNativeStream;
    private final Object mNativeStreamLock;
    private Runnable mOnDestroyedCallbackForTesting;
    private OnReadCompletedRunnable mOnReadCompletedTask;
    private LinkedList<ByteBuffer> mPendingData;
    private State mReadState;
    private final Collection<Object> mRequestAnnotations;
    private final CronetUrlRequestContext mRequestContext;
    private boolean mRequestHeadersSent;
    private UrlResponseInfoImpl mResponseInfo;
    private State mWriteState;

    /* access modifiers changed from: package-private */
    public enum State {
        NOT_STARTED,
        STARTED,
        WAITING_FOR_READ,
        READING,
        READING_DONE,
        CANCELED,
        ERROR,
        SUCCESS,
        WAITING_FOR_FLUSH,
        WRITING,
        WRITING_DONE
    }

    private native long nativeCreateBidirectionalStream(long j, boolean z, boolean z2);

    private native void nativeDestroy(long j, boolean z);

    private native boolean nativeReadData(long j, ByteBuffer byteBuffer, int i, int i2);

    private native void nativeSendRequestHeaders(long j);

    private native int nativeStart(long j, String str, int i, String str2, String[] strArr, boolean z);

    private native boolean nativeWritevData(long j, ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z);

    final class OnReadCompletedRunnable implements Runnable {
        ByteBuffer mByteBuffer;
        boolean mEndOfStream;
        final /* synthetic */ CronetBidirectionalStream this$0;

        @Override // java.lang.Runnable
        public void run() {
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                boolean z = false;
                synchronized (this.this$0.mNativeStreamLock) {
                    if (!this.this$0.isDoneLocked()) {
                        if (this.mEndOfStream) {
                            this.this$0.mReadState = State.READING_DONE;
                            z = this.this$0.mWriteState == State.WRITING_DONE;
                        } else {
                            this.this$0.mReadState = State.WAITING_FOR_READ;
                        }
                    } else {
                        return;
                    }
                }
                this.this$0.mCallback.onReadCompleted(this.this$0, this.this$0.mResponseInfo, byteBuffer, this.mEndOfStream);
                if (z) {
                    this.this$0.maybeOnSucceededOnExecutor();
                }
            } catch (Exception e) {
                this.this$0.onCallbackException(e);
            }
        }
    }

    final class OnWriteCompletedRunnable implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean mEndOfStream;

        OnWriteCompletedRunnable(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.mEndOfStream = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                boolean z = false;
                synchronized (CronetBidirectionalStream.this.mNativeStreamLock) {
                    if (!CronetBidirectionalStream.this.isDoneLocked()) {
                        if (this.mEndOfStream) {
                            CronetBidirectionalStream.this.mWriteState = State.WRITING_DONE;
                            z = CronetBidirectionalStream.this.mReadState == State.READING_DONE;
                        }
                    } else {
                        return;
                    }
                }
                CronetBidirectionalStream.this.mCallback.onWriteCompleted(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mResponseInfo, byteBuffer, this.mEndOfStream);
                if (z) {
                    CronetBidirectionalStream.this.maybeOnSucceededOnExecutor();
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.onCallbackException(e);
            }
        }
    }

    private void sendFlushDataLocked() {
        if ($assertionsDisabled || this.mWriteState == State.WAITING_FOR_FLUSH) {
            int size = this.mFlushData.size();
            ByteBuffer[] byteBufferArr = new ByteBuffer[size];
            int[] iArr = new int[size];
            int[] iArr2 = new int[size];
            for (int i = 0; i < size; i++) {
                ByteBuffer poll = this.mFlushData.poll();
                byteBufferArr[i] = poll;
                iArr[i] = poll.position();
                iArr2[i] = poll.limit();
            }
            if (!$assertionsDisabled && !this.mFlushData.isEmpty()) {
                throw new AssertionError();
            } else if ($assertionsDisabled || byteBufferArr.length >= 1) {
                this.mWriteState = State.WRITING;
                this.mRequestHeadersSent = true;
                if (!nativeWritevData(this.mNativeStream, byteBufferArr, iArr, iArr2, this.mEndOfStreamWritten && this.mPendingData.isEmpty())) {
                    this.mWriteState = State.WAITING_FOR_FLUSH;
                    throw new IllegalArgumentException("Unable to call native writev.");
                }
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isDoneLocked() {
        return this.mReadState != State.NOT_STARTED && this.mNativeStream == 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void maybeOnSucceededOnExecutor() {
        synchronized (this.mNativeStreamLock) {
            if (!isDoneLocked()) {
                if (this.mWriteState == State.WRITING_DONE && this.mReadState == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.mWriteState = state;
                    this.mReadState = state;
                    destroyNativeStreamLocked(false);
                    try {
                        this.mCallback.onSucceeded(this, this.mResponseInfo);
                    } catch (Exception e) {
                        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onSucceeded method", e);
                    }
                }
            }
        }
    }

    @CalledByNative
    private void onStreamReady(final boolean z) {
        postTaskToExecutor(new Runnable() { // from class: org.chromium.net.impl.CronetBidirectionalStream.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.mNativeStreamLock) {
                    if (!CronetBidirectionalStream.this.isDoneLocked()) {
                        CronetBidirectionalStream.this.mRequestHeadersSent = z;
                        CronetBidirectionalStream.this.mReadState = State.WAITING_FOR_READ;
                        if (CronetBidirectionalStream.doesMethodAllowWriteData(CronetBidirectionalStream.this.mInitialMethod) || !CronetBidirectionalStream.this.mRequestHeadersSent) {
                            CronetBidirectionalStream.this.mWriteState = State.WAITING_FOR_FLUSH;
                        } else {
                            CronetBidirectionalStream.this.mWriteState = State.WRITING_DONE;
                        }
                        try {
                            CronetBidirectionalStream.this.mCallback.onStreamReady(CronetBidirectionalStream.this);
                        } catch (Exception e) {
                            CronetBidirectionalStream.this.onCallbackException(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onResponseHeadersReceived(int i, String str, String[] strArr, long j) {
        try {
            this.mResponseInfo = prepareResponseInfoOnNetworkThread(i, str, strArr, j);
            postTaskToExecutor(new Runnable() { // from class: org.chromium.net.impl.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.mNativeStreamLock) {
                        if (!CronetBidirectionalStream.this.isDoneLocked()) {
                            CronetBidirectionalStream.this.mReadState = State.WAITING_FOR_READ;
                            try {
                                CronetBidirectionalStream.this.mCallback.onResponseHeadersReceived(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mResponseInfo);
                            } catch (Exception e) {
                                CronetBidirectionalStream.this.onCallbackException(e);
                            }
                        }
                    }
                }
            });
        } catch (Exception e) {
            failWithException(new CronetExceptionImpl("Cannot prepare ResponseInfo", null));
        }
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i, int i2, int i3, long j) {
        this.mResponseInfo.setReceivedByteCount(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            failWithException(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
        } else if (i < 0 || i2 + i > i3) {
            failWithException(new CronetExceptionImpl("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i2 + i);
            if ($assertionsDisabled || this.mOnReadCompletedTask.mByteBuffer == null) {
                this.mOnReadCompletedTask.mByteBuffer = byteBuffer;
                this.mOnReadCompletedTask.mEndOfStream = i == 0;
                postTaskToExecutor(this.mOnReadCompletedTask);
                return;
            }
            throw new AssertionError();
        }
    }

    @CalledByNative
    private void onWritevCompleted(ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z) {
        if (!$assertionsDisabled && byteBufferArr.length != iArr.length) {
            throw new AssertionError();
        } else if ($assertionsDisabled || byteBufferArr.length == iArr2.length) {
            synchronized (this.mNativeStreamLock) {
                if (!isDoneLocked()) {
                    this.mWriteState = State.WAITING_FOR_FLUSH;
                    if (!this.mFlushData.isEmpty()) {
                        sendFlushDataLocked();
                    }
                } else {
                    return;
                }
            }
            int i = 0;
            while (i < byteBufferArr.length) {
                ByteBuffer byteBuffer = byteBufferArr[i];
                if (byteBuffer.position() == iArr[i] && byteBuffer.limit() == iArr2[i]) {
                    byteBuffer.position(byteBuffer.limit());
                    postTaskToExecutor(new OnWriteCompletedRunnable(byteBuffer, z && i == byteBufferArr.length + -1));
                    i++;
                } else {
                    failWithException(new CronetExceptionImpl("ByteBuffer modified externally during write", null));
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    @CalledByNative
    private void onResponseTrailersReceived(String[] strArr) {
        final UrlResponseInfoImpl.HeaderBlockImpl headerBlockImpl = new UrlResponseInfoImpl.HeaderBlockImpl(headersListFromStrings(strArr));
        postTaskToExecutor(new Runnable() { // from class: org.chromium.net.impl.CronetBidirectionalStream.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.mNativeStreamLock) {
                    if (!CronetBidirectionalStream.this.isDoneLocked()) {
                        try {
                            CronetBidirectionalStream.this.mCallback.onResponseTrailersReceived(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mResponseInfo, headerBlockImpl);
                        } catch (Exception e) {
                            CronetBidirectionalStream.this.onCallbackException(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onError(int i, int i2, int i3, String str, long j) {
        if (this.mResponseInfo != null) {
            this.mResponseInfo.setReceivedByteCount(j);
        }
        if (i == 10) {
            failWithException(new QuicExceptionImpl("Exception in BidirectionalStream: " + str, i2, i3));
        } else {
            failWithException(new NetworkExceptionImpl("Exception in BidirectionalStream: " + str, i, i2));
        }
    }

    @CalledByNative
    private void onCanceled() {
        postTaskToExecutor(new Runnable() { // from class: org.chromium.net.impl.CronetBidirectionalStream.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CronetBidirectionalStream.this.mCallback.onCanceled(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mResponseInfo);
                } catch (Exception e) {
                    Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onCanceled method", e);
                }
            }
        });
    }

    @CalledByNative
    private void onMetricsCollected(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z, long j14, long j15) {
        int i;
        synchronized (this.mNativeStreamLock) {
            if (this.mMetrics != null) {
                throw new IllegalStateException("Metrics collection should only happen once.");
            }
            this.mMetrics = new CronetMetrics(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, z, j14, j15);
            if (!$assertionsDisabled && this.mReadState != this.mWriteState) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.mReadState == State.SUCCESS || this.mReadState == State.ERROR || this.mReadState == State.CANCELED) {
                if (this.mReadState == State.SUCCESS) {
                    i = 0;
                } else if (this.mReadState == State.CANCELED) {
                    i = 2;
                } else {
                    i = 1;
                }
                this.mRequestContext.reportFinished(new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, this.mMetrics, i, this.mResponseInfo, this.mException));
            } else {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean doesMethodAllowWriteData(String str) {
        return !str.equals("GET") && !str.equals("HEAD");
    }

    private static ArrayList<Map.Entry<String, String>> headersListFromStrings(String[] strArr) {
        ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>(strArr.length / 2);
        for (int i = 0; i < strArr.length; i += 2) {
            arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i], strArr[i + 1]));
        }
        return arrayList;
    }

    private void postTaskToExecutor(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e) {
            Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", e);
            synchronized (this.mNativeStreamLock) {
                State state = State.ERROR;
                this.mWriteState = state;
                this.mReadState = state;
                destroyNativeStreamLocked(false);
            }
        }
    }

    private UrlResponseInfoImpl prepareResponseInfoOnNetworkThread(int i, String str, String[] strArr, long j) {
        UrlResponseInfoImpl urlResponseInfoImpl = new UrlResponseInfoImpl(Arrays.asList(this.mInitialUrl), i, "", headersListFromStrings(strArr), false, str, null);
        urlResponseInfoImpl.setReceivedByteCount(j);
        return urlResponseInfoImpl;
    }

    private void destroyNativeStreamLocked(boolean z) {
        Log.i(CronetUrlRequestContext.LOG_TAG, "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.mNativeStream != 0) {
            nativeDestroy(this.mNativeStream, z);
            this.mRequestContext.onRequestDestroyed();
            this.mNativeStream = 0;
            if (this.mOnDestroyedCallbackForTesting != null) {
                this.mOnDestroyedCallbackForTesting.run();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void failWithExceptionOnExecutor(CronetException cronetException) {
        this.mException = cronetException;
        synchronized (this.mNativeStreamLock) {
            if (!isDoneLocked()) {
                State state = State.ERROR;
                this.mWriteState = state;
                this.mReadState = state;
                destroyNativeStreamLocked(false);
                try {
                    this.mCallback.onFailed(this, this.mResponseInfo, cronetException);
                } catch (Exception e) {
                    Log.e(CronetUrlRequestContext.LOG_TAG, "Exception notifying of failed request", e);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onCallbackException(Exception exc) {
        CallbackExceptionImpl callbackExceptionImpl = new CallbackExceptionImpl("CalledByNative method has thrown an exception", exc);
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in CalledByNative method", exc);
        failWithExceptionOnExecutor(callbackExceptionImpl);
    }

    private void failWithException(final CronetException cronetException) {
        postTaskToExecutor(new Runnable() { // from class: org.chromium.net.impl.CronetBidirectionalStream.5
            @Override // java.lang.Runnable
            public void run() {
                CronetBidirectionalStream.this.failWithExceptionOnExecutor(cronetException);
            }
        });
    }
}
