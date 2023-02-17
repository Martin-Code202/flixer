package org.chromium.net.impl;

import android.os.Process;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UrlRequest;
public final class JavaCronetEngine extends CronetEngineBase {
    private final ExecutorService mExecutorService;
    private final String mUserAgent;

    public JavaCronetEngine(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        final int threadPriority = cronetEngineBuilderImpl.threadPriority(9);
        this.mUserAgent = cronetEngineBuilderImpl.getUserAgent();
        this.mExecutorService = Executors.newCachedThreadPool(new ThreadFactory() { // from class: org.chromium.net.impl.JavaCronetEngine.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(final Runnable runnable) {
                return Executors.defaultThreadFactory().newThread(new Runnable() { // from class: org.chromium.net.impl.JavaCronetEngine.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Thread.currentThread().setName("JavaCronetEngine");
                        Process.setThreadPriority(threadPriority);
                        runnable.run();
                    }
                });
            }
        });
    }

    @Override // org.chromium.net.impl.CronetEngineBase
    public UrlRequestBase createRequest(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3) {
        return new JavaUrlRequest(callback, this.mExecutorService, executor, str, this.mUserAgent, z3);
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public int getDownstreamThroughputKbps() {
        return -1;
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public void addRequestFinishedListener(RequestFinishedInfo.Listener listener) {
    }

    @Override // org.chromium.net.CronetEngine
    public URLConnection openConnection(URL url) {
        return url.openConnection();
    }

    @Override // org.chromium.net.ExperimentalCronetEngine
    public URLConnection openConnection(URL url, Proxy proxy) {
        return url.openConnection(proxy);
    }
}
