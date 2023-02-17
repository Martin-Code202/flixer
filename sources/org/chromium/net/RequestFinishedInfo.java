package org.chromium.net;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.Executor;
public abstract class RequestFinishedInfo {

    public static abstract class Metrics {
        public abstract Date getConnectEnd();

        public abstract Date getConnectStart();

        public abstract Date getDnsEnd();

        public abstract Date getDnsStart();

        public abstract Long getReceivedByteCount();

        public abstract Date getRequestEnd();

        public abstract Date getRequestStart();

        public abstract Long getSentByteCount();

        public abstract boolean getSocketReused();

        public abstract Date getSslEnd();

        public abstract Date getSslStart();

        public abstract Long getTotalTimeMs();

        public abstract Long getTtfbMs();
    }

    public abstract Collection<Object> getAnnotations();

    public abstract CronetException getException();

    public abstract int getFinishedReason();

    public abstract Metrics getMetrics();

    public abstract UrlResponseInfo getResponseInfo();

    public abstract String getUrl();

    public static abstract class Listener {
        private final Executor mExecutor;

        public abstract void onRequestFinished(RequestFinishedInfo requestFinishedInfo);

        public Listener(Executor executor) {
            if (executor == null) {
                throw new IllegalStateException("Executor must not be null");
            }
            this.mExecutor = executor;
        }

        public Executor getExecutor() {
            return this.mExecutor;
        }
    }
}
