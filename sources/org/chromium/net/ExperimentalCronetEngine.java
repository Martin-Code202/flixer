package org.chromium.net;

import android.content.Context;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Executor;
import org.chromium.net.CronetEngine;
import org.chromium.net.ExperimentalUrlRequest;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UrlRequest;
public abstract class ExperimentalCronetEngine extends CronetEngine {
    @Override // org.chromium.net.CronetEngine
    public abstract ExperimentalUrlRequest.Builder newUrlRequestBuilder(String str, UrlRequest.Callback callback, Executor executor);

    public static class Builder extends CronetEngine.Builder {
        public Builder(Context context) {
            super(context);
        }

        public Builder(ICronetEngineBuilder iCronetEngineBuilder) {
            super(iCronetEngineBuilder);
        }

        public Builder enableNetworkQualityEstimator(boolean z) {
            this.mBuilderDelegate.enableNetworkQualityEstimator(z);
            return this;
        }

        @Override // org.chromium.net.CronetEngine.Builder
        public Builder setStoragePath(String str) {
            super.setStoragePath(str);
            return this;
        }

        @Override // org.chromium.net.CronetEngine.Builder
        public Builder enableHttp2(boolean z) {
            super.enableHttp2(z);
            return this;
        }

        @Override // org.chromium.net.CronetEngine.Builder
        public Builder enableHttpCache(int i, long j) {
            super.enableHttpCache(i, j);
            return this;
        }

        public ExperimentalCronetEngine build() {
            return this.mBuilderDelegate.build();
        }
    }

    public URLConnection openConnection(URL url, Proxy proxy) {
        return url.openConnection(proxy);
    }

    public void addRequestFinishedListener(RequestFinishedInfo.Listener listener) {
    }

    public int getDownstreamThroughputKbps() {
        return -1;
    }
}
