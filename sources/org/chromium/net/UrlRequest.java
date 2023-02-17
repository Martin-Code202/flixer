package org.chromium.net;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
public abstract class UrlRequest {

    public static abstract class Builder {
        public abstract Builder addHeader(String str, String str2);

        public abstract UrlRequest build();

        public abstract Builder disableCache();

        public abstract Builder setHttpMethod(String str);

        public abstract Builder setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor);
    }

    public static abstract class StatusListener {
        public abstract void onStatus(int i);
    }

    public abstract void cancel();

    public abstract void followRedirect();

    public abstract void getStatus(StatusListener statusListener);

    public abstract void read(ByteBuffer byteBuffer);

    public abstract void start();

    public static abstract class Callback {
        public abstract void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException);

        public abstract void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer);

        public abstract void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str);

        public abstract void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);

        public abstract void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);

        public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }
    }
}
