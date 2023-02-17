package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Predicate;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public interface HttpDataSource extends DataSource {
    public static final Predicate<String> REJECT_PAYWALL_TYPES = new Predicate<String>() { // from class: com.google.android.exoplayer2.upstream.HttpDataSource.1
        public boolean evaluate(String str) {
            String lowerInvariant = Util.toLowerInvariant(str);
            return !TextUtils.isEmpty(lowerInvariant) && (!lowerInvariant.contains("text") || lowerInvariant.contains("text/vtt")) && !lowerInvariant.contains("html") && !lowerInvariant.contains("xml");
        }
    };

    public interface Factory extends DataSource.Factory {
    }

    public static final class RequestProperties {
        private final Map<String, String> requestProperties = new HashMap();
        private Map<String, String> requestPropertiesSnapshot;

        public synchronized Map<String, String> getSnapshot() {
            if (this.requestPropertiesSnapshot == null) {
                this.requestPropertiesSnapshot = Collections.unmodifiableMap(new HashMap(this.requestProperties));
            }
            return this.requestPropertiesSnapshot;
        }
    }

    public static abstract class BaseFactory implements Factory {
        private final RequestProperties defaultRequestProperties = new RequestProperties();

        /* access modifiers changed from: protected */
        public abstract HttpDataSource createDataSourceInternal(RequestProperties requestProperties);

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        public final HttpDataSource createDataSource() {
            return createDataSourceInternal(this.defaultRequestProperties);
        }
    }

    public static class HttpDataSourceException extends IOException {
        public final DataSpec dataSpec;
        public final int type;

        public HttpDataSourceException(String str, DataSpec dataSpec2, int i) {
            super(str);
            this.dataSpec = dataSpec2;
            this.type = i;
        }

        public HttpDataSourceException(IOException iOException, DataSpec dataSpec2, int i) {
            super(iOException);
            this.dataSpec = dataSpec2;
            this.type = i;
        }

        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec2, int i) {
            super(str, iOException);
            this.dataSpec = dataSpec2;
            this.type = i;
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;

        public InvalidContentTypeException(String str, DataSpec dataSpec) {
            super("Invalid content type: " + str, dataSpec, 1);
            this.contentType = str;
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final int responseCode;

        public InvalidResponseCodeException(int i, Map<String, List<String>> map, DataSpec dataSpec) {
            super("Response code: " + i, dataSpec, 1);
            this.responseCode = i;
            this.headerFields = map;
        }
    }
}
