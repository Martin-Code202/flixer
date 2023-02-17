package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
public final class CacheUtil {
    public static String generateKey(Uri uri) {
        return uri.toString();
    }

    public static String getKey(DataSpec dataSpec) {
        return dataSpec.key != null ? dataSpec.key : generateKey(dataSpec.uri);
    }
}
