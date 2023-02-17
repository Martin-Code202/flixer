package org.chromium.net.impl;

import java.util.Collection;
import java.util.concurrent.Executor;
import org.chromium.net.ExperimentalCronetEngine;
import org.chromium.net.ExperimentalUrlRequest;
import org.chromium.net.UrlRequest;
public abstract class CronetEngineBase extends ExperimentalCronetEngine {
    /* access modifiers changed from: protected */
    public abstract UrlRequestBase createRequest(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3);

    @Override // org.chromium.net.ExperimentalCronetEngine, org.chromium.net.CronetEngine
    public ExperimentalUrlRequest.Builder newUrlRequestBuilder(String str, UrlRequest.Callback callback, Executor executor) {
        return new UrlRequestBuilderImpl(str, callback, executor, this);
    }
}
