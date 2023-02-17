package org.chromium.net;

import android.content.Context;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import org.chromium.net.UrlRequest;
public abstract class CronetEngine {
    public abstract UrlRequest.Builder newUrlRequestBuilder(String str, UrlRequest.Callback callback, Executor executor);

    public abstract URLConnection openConnection(URL url);

    public static class Builder {
        protected final ICronetEngineBuilder mBuilderDelegate;

        public static abstract class LibraryLoader {
            public abstract void loadLibrary(String str);
        }

        public Builder(Context context) {
            this(createBuilderDelegate(context));
        }

        public Builder(ICronetEngineBuilder iCronetEngineBuilder) {
            this.mBuilderDelegate = iCronetEngineBuilder;
        }

        public Builder setStoragePath(String str) {
            this.mBuilderDelegate.setStoragePath(str);
            return this;
        }

        public Builder enableHttp2(boolean z) {
            this.mBuilderDelegate.enableHttp2(z);
            return this;
        }

        public Builder enableHttpCache(int i, long j) {
            this.mBuilderDelegate.enableHttpCache(i, j);
            return this;
        }

        private static ICronetEngineBuilder createBuilderDelegate(Context context) {
            return getEnabledCronetProviders(context, CronetProvider.getAllProviders(context)).get(0).createBuilder().mBuilderDelegate;
        }

        static List<CronetProvider> getEnabledCronetProviders(Context context, List<CronetProvider> list) {
            if (list.size() == 0) {
                throw new RuntimeException("Unable to find any Cronet provider. Have you included all necessary jars?");
            }
            Iterator<CronetProvider> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().isEnabled()) {
                    it.remove();
                }
            }
            if (list.size() == 0) {
                throw new RuntimeException("All available Cronet providers are disabled. A provider should be enabled before it can be used.");
            }
            Collections.sort(list, new Comparator<CronetProvider>() { // from class: org.chromium.net.CronetEngine.Builder.1
                public int compare(CronetProvider cronetProvider, CronetProvider cronetProvider2) {
                    if ("Fallback-Cronet-Provider".equals(cronetProvider.getName())) {
                        return 1;
                    }
                    if ("Fallback-Cronet-Provider".equals(cronetProvider2.getName())) {
                        return -1;
                    }
                    return -Builder.compareVersions(cronetProvider.getVersion(), cronetProvider2.getVersion());
                }
            });
            return list;
        }

        static int compareVersions(String str, String str2) {
            if (str == null || str2 == null) {
                throw new IllegalArgumentException("The input values cannot be null");
            }
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            int i = 0;
            while (i < split.length && i < split2.length) {
                try {
                    int parseInt = Integer.parseInt(split[i]);
                    int parseInt2 = Integer.parseInt(split2[i]);
                    if (parseInt != parseInt2) {
                        return Integer.signum(parseInt - parseInt2);
                    }
                    i++;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Unable to convert version segments into integers: " + split[i] + " & " + split2[i], e);
                }
            }
            return Integer.signum(split.length - split2.length);
        }
    }
}
