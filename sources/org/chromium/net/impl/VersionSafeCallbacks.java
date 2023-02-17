package org.chromium.net.impl;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import org.chromium.net.BidirectionalStream;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetException;
import org.chromium.net.NetworkQualityRttListener;
import org.chromium.net.NetworkQualityThroughputListener;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;
public class VersionSafeCallbacks {

    public static final class UrlRequestCallback extends UrlRequest.Callback {
        private final UrlRequest.Callback mWrappedCallback;

        public UrlRequestCallback(UrlRequest.Callback callback) {
            this.mWrappedCallback = callback;
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            this.mWrappedCallback.onRedirectReceived(urlRequest, urlResponseInfo, str);
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            this.mWrappedCallback.onResponseStarted(urlRequest, urlResponseInfo);
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            this.mWrappedCallback.onReadCompleted(urlRequest, urlResponseInfo, byteBuffer);
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            this.mWrappedCallback.onSucceeded(urlRequest, urlResponseInfo);
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
            this.mWrappedCallback.onFailed(urlRequest, urlResponseInfo, cronetException);
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            this.mWrappedCallback.onCanceled(urlRequest, urlResponseInfo);
        }
    }

    public static final class UrlRequestStatusListener extends UrlRequest.StatusListener {
        private final UrlRequest.StatusListener mWrappedListener;

        public UrlRequestStatusListener(UrlRequest.StatusListener statusListener) {
            this.mWrappedListener = statusListener;
        }

        @Override // org.chromium.net.UrlRequest.StatusListener
        public void onStatus(int i) {
            this.mWrappedListener.onStatus(i);
        }
    }

    public static final class BidirectionalStreamCallback extends BidirectionalStream.Callback {
        private final BidirectionalStream.Callback mWrappedCallback;

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onStreamReady(BidirectionalStream bidirectionalStream) {
            this.mWrappedCallback.onStreamReady(bidirectionalStream);
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onResponseHeadersReceived(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
            this.mWrappedCallback.onResponseHeadersReceived(bidirectionalStream, urlResponseInfo);
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onReadCompleted(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z) {
            this.mWrappedCallback.onReadCompleted(bidirectionalStream, urlResponseInfo, byteBuffer, z);
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onWriteCompleted(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z) {
            this.mWrappedCallback.onWriteCompleted(bidirectionalStream, urlResponseInfo, byteBuffer, z);
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onResponseTrailersReceived(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, UrlResponseInfo.HeaderBlock headerBlock) {
            this.mWrappedCallback.onResponseTrailersReceived(bidirectionalStream, urlResponseInfo, headerBlock);
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onSucceeded(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
            this.mWrappedCallback.onSucceeded(bidirectionalStream, urlResponseInfo);
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onFailed(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
            this.mWrappedCallback.onFailed(bidirectionalStream, urlResponseInfo, cronetException);
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onCanceled(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
            this.mWrappedCallback.onCanceled(bidirectionalStream, urlResponseInfo);
        }
    }

    public static final class UploadDataProviderWrapper extends UploadDataProvider {
        private final UploadDataProvider mWrappedProvider;

        public UploadDataProviderWrapper(UploadDataProvider uploadDataProvider) {
            this.mWrappedProvider = uploadDataProvider;
        }

        @Override // org.chromium.net.UploadDataProvider
        public long getLength() {
            return this.mWrappedProvider.getLength();
        }

        @Override // org.chromium.net.UploadDataProvider
        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            this.mWrappedProvider.read(uploadDataSink, byteBuffer);
        }

        @Override // org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink uploadDataSink) {
            this.mWrappedProvider.rewind(uploadDataSink);
        }

        @Override // org.chromium.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.mWrappedProvider.close();
        }
    }

    public static final class RequestFinishedInfoListener extends RequestFinishedInfo.Listener {
        private final RequestFinishedInfo.Listener mWrappedListener;

        public RequestFinishedInfoListener(RequestFinishedInfo.Listener listener) {
            super(listener.getExecutor());
            this.mWrappedListener = listener;
        }

        @Override // org.chromium.net.RequestFinishedInfo.Listener
        public void onRequestFinished(RequestFinishedInfo requestFinishedInfo) {
            this.mWrappedListener.onRequestFinished(requestFinishedInfo);
        }

        @Override // org.chromium.net.RequestFinishedInfo.Listener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }
    }

    public static final class NetworkQualityRttListenerWrapper extends NetworkQualityRttListener {
        private final NetworkQualityRttListener mWrappedListener;

        @Override // org.chromium.net.NetworkQualityRttListener
        public void onRttObservation(int i, long j, int i2) {
            this.mWrappedListener.onRttObservation(i, j, i2);
        }

        @Override // org.chromium.net.NetworkQualityRttListener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        public int hashCode() {
            return this.mWrappedListener.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof NetworkQualityRttListenerWrapper)) {
                return false;
            }
            return this.mWrappedListener.equals(((NetworkQualityRttListenerWrapper) obj).mWrappedListener);
        }
    }

    public static final class NetworkQualityThroughputListenerWrapper extends NetworkQualityThroughputListener {
        private final NetworkQualityThroughputListener mWrappedListener;

        @Override // org.chromium.net.NetworkQualityThroughputListener
        public void onThroughputObservation(int i, long j, int i2) {
            this.mWrappedListener.onThroughputObservation(i, j, i2);
        }

        @Override // org.chromium.net.NetworkQualityThroughputListener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        public int hashCode() {
            return this.mWrappedListener.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof NetworkQualityThroughputListenerWrapper)) {
                return false;
            }
            return this.mWrappedListener.equals(((NetworkQualityThroughputListenerWrapper) obj).mWrappedListener);
        }
    }

    public static final class LibraryLoader extends CronetEngine.Builder.LibraryLoader {
        private final CronetEngine.Builder.LibraryLoader mWrappedLoader;

        @Override // org.chromium.net.CronetEngine.Builder.LibraryLoader
        public void loadLibrary(String str) {
            this.mWrappedLoader.loadLibrary(str);
        }
    }
}
