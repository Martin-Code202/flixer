package org.chromium.net;

import java.util.List;
import java.util.Map;
public abstract class UrlResponseInfo {

    public static abstract class HeaderBlock {
    }

    public abstract Map<String, List<String>> getAllHeaders();

    public abstract List<Map.Entry<String, String>> getAllHeadersAsList();

    public abstract int getHttpStatusCode();

    public abstract String getHttpStatusText();

    public abstract String getNegotiatedProtocol();

    public abstract String getUrl();
}
