package org.chromium.net.impl;

import java.util.Collection;
import java.util.Collections;
import org.chromium.net.CronetException;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UrlResponseInfo;
public class RequestFinishedInfoImpl extends RequestFinishedInfo {
    private final Collection<Object> mAnnotations;
    private final CronetException mException;
    private final int mFinishedReason;
    private final RequestFinishedInfo.Metrics mMetrics;
    private final UrlResponseInfo mResponseInfo;
    private final String mUrl;

    public RequestFinishedInfoImpl(String str, Collection<Object> collection, RequestFinishedInfo.Metrics metrics, int i, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        this.mUrl = str;
        this.mAnnotations = collection;
        this.mMetrics = metrics;
        this.mFinishedReason = i;
        this.mResponseInfo = urlResponseInfo;
        this.mException = cronetException;
    }

    @Override // org.chromium.net.RequestFinishedInfo
    public String getUrl() {
        return this.mUrl;
    }

    @Override // org.chromium.net.RequestFinishedInfo
    public Collection<Object> getAnnotations() {
        if (this.mAnnotations == null) {
            return Collections.emptyList();
        }
        return this.mAnnotations;
    }

    @Override // org.chromium.net.RequestFinishedInfo
    public RequestFinishedInfo.Metrics getMetrics() {
        return this.mMetrics;
    }

    @Override // org.chromium.net.RequestFinishedInfo
    public int getFinishedReason() {
        return this.mFinishedReason;
    }

    @Override // org.chromium.net.RequestFinishedInfo
    public UrlResponseInfo getResponseInfo() {
        return this.mResponseInfo;
    }

    @Override // org.chromium.net.RequestFinishedInfo
    public CronetException getException() {
        return this.mException;
    }
}
