package org.chromium.net.impl;

import android.annotation.SuppressLint;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;
import org.chromium.net.impl.VersionSafeCallbacks;
public final class CronetUploadDataStream extends UploadDataSink {
    private static final String TAG = CronetUploadDataStream.class.getSimpleName();
    private ByteBuffer mByteBuffer = null;
    private final VersionSafeCallbacks.UploadDataProviderWrapper mDataProvider;
    private boolean mDestroyAdapterPostponed = false;
    private final Executor mExecutor;
    private UserCallback mInWhichUserCallback = UserCallback.NOT_IN_CALLBACK;
    private long mLength;
    private final Object mLock = new Object();
    private Runnable mOnDestroyedCallbackForTesting;
    private final Runnable mReadTask = new Runnable() { // from class: org.chromium.net.impl.CronetUploadDataStream.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.mLock) {
                if (CronetUploadDataStream.this.mUploadDataStreamAdapter != 0) {
                    CronetUploadDataStream.this.checkState(UserCallback.NOT_IN_CALLBACK);
                    if (CronetUploadDataStream.this.mByteBuffer == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    CronetUploadDataStream.this.mInWhichUserCallback = UserCallback.READ;
                    try {
                        CronetUploadDataStream.this.checkCallingThread();
                        CronetUploadDataStream.this.mDataProvider.read(CronetUploadDataStream.this, CronetUploadDataStream.this.mByteBuffer);
                    } catch (Exception e) {
                        CronetUploadDataStream.this.onError(e);
                    }
                }
            }
        }
    };
    private long mRemainingLength;
    private CronetUrlRequest mRequest;
    private long mUploadDataStreamAdapter = 0;

    /* access modifiers changed from: package-private */
    public enum UserCallback {
        READ,
        REWIND,
        GET_LENGTH,
        NOT_IN_CALLBACK
    }

    private native long nativeAttachUploadDataToRequest(long j, long j2);

    private native long nativeCreateAdapterForTesting();

    private native long nativeCreateUploadDataStreamForTesting(long j, long j2);

    private static native void nativeDestroy(long j);

    private native void nativeOnReadSucceeded(long j, int i, boolean z);

    private native void nativeOnRewindSucceeded(long j);

    public CronetUploadDataStream(UploadDataProvider uploadDataProvider, Executor executor) {
        this.mExecutor = executor;
        this.mDataProvider = new VersionSafeCallbacks.UploadDataProviderWrapper(uploadDataProvider);
    }

    /* access modifiers changed from: package-private */
    @CalledByNative
    public void readData(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
        postTaskToExecutor(this.mReadTask);
    }

    /* access modifiers changed from: package-private */
    @CalledByNative
    public void rewind() {
        postTaskToExecutor(new Runnable() { // from class: org.chromium.net.impl.CronetUploadDataStream.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetUploadDataStream.this.mLock) {
                    if (CronetUploadDataStream.this.mUploadDataStreamAdapter != 0) {
                        CronetUploadDataStream.this.checkState(UserCallback.NOT_IN_CALLBACK);
                        CronetUploadDataStream.this.mInWhichUserCallback = UserCallback.REWIND;
                        try {
                            CronetUploadDataStream.this.checkCallingThread();
                            CronetUploadDataStream.this.mDataProvider.rewind(CronetUploadDataStream.this);
                        } catch (Exception e) {
                            CronetUploadDataStream.this.onError(e);
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkCallingThread() {
        if (this.mRequest != null) {
            this.mRequest.checkCallingThread();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkState(UserCallback userCallback) {
        if (this.mInWhichUserCallback != userCallback) {
            throw new IllegalStateException("Expected " + userCallback + ", but was " + this.mInWhichUserCallback);
        }
    }

    /* access modifiers changed from: package-private */
    @CalledByNative
    public void onUploadDataStreamDestroyed() {
        destroyAdapter();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onError(Throwable th) {
        boolean z;
        synchronized (this.mLock) {
            if (this.mInWhichUserCallback == UserCallback.NOT_IN_CALLBACK) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            z = this.mInWhichUserCallback == UserCallback.GET_LENGTH;
            this.mInWhichUserCallback = UserCallback.NOT_IN_CALLBACK;
            this.mByteBuffer = null;
            destroyAdapterIfPostponed();
        }
        if (z) {
            try {
                this.mDataProvider.close();
            } catch (Exception e) {
                Log.e(TAG, "Failure closing data provider", e);
            }
        }
        this.mRequest.onUploadException(th);
    }

    @Override // org.chromium.net.UploadDataSink
    @SuppressLint({"DefaultLocale"})
    public void onReadSucceeded(boolean z) {
        synchronized (this.mLock) {
            checkState(UserCallback.READ);
            if (!z || this.mLength < 0) {
                int position = this.mByteBuffer.position();
                this.mRemainingLength -= (long) position;
                if (this.mRemainingLength >= 0 || this.mLength < 0) {
                    this.mByteBuffer = null;
                    this.mInWhichUserCallback = UserCallback.NOT_IN_CALLBACK;
                    destroyAdapterIfPostponed();
                    if (this.mUploadDataStreamAdapter != 0) {
                        nativeOnReadSucceeded(this.mUploadDataStreamAdapter, position, z);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.mLength - this.mRemainingLength), Long.valueOf(this.mLength)));
            }
            throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
        }
    }

    @Override // org.chromium.net.UploadDataSink
    public void onRewindSucceeded() {
        synchronized (this.mLock) {
            checkState(UserCallback.REWIND);
            this.mInWhichUserCallback = UserCallback.NOT_IN_CALLBACK;
            this.mRemainingLength = this.mLength;
            if (this.mUploadDataStreamAdapter != 0) {
                nativeOnRewindSucceeded(this.mUploadDataStreamAdapter);
            }
        }
    }

    @Override // org.chromium.net.UploadDataSink
    public void onRewindError(Exception exc) {
        synchronized (this.mLock) {
            checkState(UserCallback.REWIND);
            onError(exc);
        }
    }

    /* access modifiers changed from: package-private */
    public void postTaskToExecutor(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (Throwable th) {
            this.mRequest.onUploadException(th);
        }
    }

    private void destroyAdapter() {
        synchronized (this.mLock) {
            if (this.mInWhichUserCallback == UserCallback.READ) {
                this.mDestroyAdapterPostponed = true;
            } else if (this.mUploadDataStreamAdapter != 0) {
                nativeDestroy(this.mUploadDataStreamAdapter);
                this.mUploadDataStreamAdapter = 0;
                if (this.mOnDestroyedCallbackForTesting != null) {
                    this.mOnDestroyedCallbackForTesting.run();
                }
                postTaskToExecutor(new Runnable() { // from class: org.chromium.net.impl.CronetUploadDataStream.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CronetUploadDataStream.this.checkCallingThread();
                            CronetUploadDataStream.this.mDataProvider.close();
                        } catch (Exception e) {
                            Log.e(CronetUploadDataStream.TAG, "Exception thrown when closing", e);
                        }
                    }
                });
            }
        }
    }

    private void destroyAdapterIfPostponed() {
        synchronized (this.mLock) {
            if (this.mInWhichUserCallback == UserCallback.READ) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            } else if (this.mDestroyAdapterPostponed) {
                destroyAdapter();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void initializeWithRequest(CronetUrlRequest cronetUrlRequest) {
        synchronized (this.mLock) {
            this.mRequest = cronetUrlRequest;
            this.mInWhichUserCallback = UserCallback.GET_LENGTH;
        }
        try {
            cronetUrlRequest.checkCallingThread();
            this.mLength = this.mDataProvider.getLength();
            this.mRemainingLength = this.mLength;
        } catch (Throwable th) {
            onError(th);
        }
        synchronized (this.mLock) {
            this.mInWhichUserCallback = UserCallback.NOT_IN_CALLBACK;
        }
    }

    /* access modifiers changed from: package-private */
    public void attachNativeAdapterToRequest(long j) {
        synchronized (this.mLock) {
            this.mUploadDataStreamAdapter = nativeAttachUploadDataToRequest(j, this.mLength);
        }
    }
}
