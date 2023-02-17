package org.chromium.net.impl;

import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.chromium.net.ExperimentalUrlRequest;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UrlRequest;
public class UrlRequestBuilderImpl extends ExperimentalUrlRequest.Builder {
    private static final String TAG = UrlRequestBuilderImpl.class.getSimpleName();
    private boolean mAllowDirectExecutor = false;
    private final UrlRequest.Callback mCallback;
    private final CronetEngineBase mCronetEngine;
    private boolean mDisableCache;
    private boolean mDisableConnectionMigration;
    private final Executor mExecutor;
    private String mMethod;
    private int mPriority = 3;
    private Collection<Object> mRequestAnnotations;
    private final ArrayList<Pair<String, String>> mRequestHeaders = new ArrayList<>();
    private UploadDataProvider mUploadDataProvider;
    private Executor mUploadDataProviderExecutor;
    private final String mUrl;

    UrlRequestBuilderImpl(String str, UrlRequest.Callback callback, Executor executor, CronetEngineBase cronetEngineBase) {
        if (str == null) {
            throw new NullPointerException("URL is required.");
        } else if (callback == null) {
            throw new NullPointerException("Callback is required.");
        } else if (executor == null) {
            throw new NullPointerException("Executor is required.");
        } else if (cronetEngineBase == null) {
            throw new NullPointerException("CronetEngine is required.");
        } else {
            this.mUrl = str;
            this.mCallback = callback;
            this.mExecutor = executor;
            this.mCronetEngine = cronetEngineBase;
        }
    }

    @Override // org.chromium.net.ExperimentalUrlRequest.Builder, org.chromium.net.UrlRequest.Builder
    public ExperimentalUrlRequest.Builder setHttpMethod(String str) {
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.mMethod = str;
        return this;
    }

    @Override // org.chromium.net.ExperimentalUrlRequest.Builder, org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl addHeader(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        } else if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        } else if ("Accept-Encoding".equalsIgnoreCase(str)) {
            Log.w(TAG, "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
            return this;
        } else {
            this.mRequestHeaders.add(Pair.create(str, str2));
            return this;
        }
    }

    @Override // org.chromium.net.ExperimentalUrlRequest.Builder, org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl disableCache() {
        this.mDisableCache = true;
        return this;
    }

    @Override // org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setPriority(int i) {
        this.mPriority = i;
        return this;
    }

    @Override // org.chromium.net.ExperimentalUrlRequest.Builder, org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor) {
        if (uploadDataProvider == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        } else if (executor == null) {
            throw new NullPointerException("Invalid UploadDataProvider Executor.");
        } else {
            if (this.mMethod == null) {
                this.mMethod = "POST";
            }
            this.mUploadDataProvider = uploadDataProvider;
            this.mUploadDataProviderExecutor = executor;
            return this;
        }
    }

    @Override // org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl allowDirectExecutor() {
        this.mAllowDirectExecutor = true;
        return this;
    }

    @Override // org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl addRequestAnnotation(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Invalid metrics annotation.");
        }
        if (this.mRequestAnnotations == null) {
            this.mRequestAnnotations = new ArrayList();
        }
        this.mRequestAnnotations.add(obj);
        return this;
    }

    @Override // org.chromium.net.ExperimentalUrlRequest.Builder, org.chromium.net.UrlRequest.Builder
    public UrlRequestBase build() {
        UrlRequestBase createRequest = this.mCronetEngine.createRequest(this.mUrl, this.mCallback, this.mExecutor, this.mPriority, this.mRequestAnnotations, this.mDisableCache, this.mDisableConnectionMigration, this.mAllowDirectExecutor);
        if (this.mMethod != null) {
            createRequest.setHttpMethod(this.mMethod);
        }
        Iterator<Pair<String, String>> it = this.mRequestHeaders.iterator();
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            createRequest.addHeader((String) next.first, (String) next.second);
        }
        if (this.mUploadDataProvider != null) {
            createRequest.setUploadDataProvider(this.mUploadDataProvider, this.mUploadDataProviderExecutor);
        }
        return createRequest;
    }
}
