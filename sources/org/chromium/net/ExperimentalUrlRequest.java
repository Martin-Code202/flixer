package org.chromium.net;

import java.util.concurrent.Executor;
import org.chromium.net.UrlRequest;
public abstract class ExperimentalUrlRequest extends UrlRequest {

    public static abstract class Builder extends UrlRequest.Builder {
        @Override // org.chromium.net.UrlRequest.Builder
        public abstract Builder addHeader(String str, String str2);

        public abstract Builder allowDirectExecutor();

        @Override // org.chromium.net.UrlRequest.Builder
        public abstract ExperimentalUrlRequest build();

        @Override // org.chromium.net.UrlRequest.Builder
        public abstract Builder disableCache();

        @Override // org.chromium.net.UrlRequest.Builder
        public abstract Builder setHttpMethod(String str);

        public abstract Builder setPriority(int i);

        @Override // org.chromium.net.UrlRequest.Builder
        public abstract Builder setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor);

        public Builder addRequestAnnotation(Object obj) {
            return this;
        }
    }
}
