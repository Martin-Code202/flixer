package org.chromium.base.metrics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
public class RecordHistogram {
    private static Map<String, Long> sCache = Collections.synchronizedMap(new HashMap());
    private static Throwable sDisabledBy;

    private static native int nativeGetHistogramTotalCountForTesting(String str);

    private static native int nativeGetHistogramValueCountForTesting(String str, int i);

    private static native void nativeInitialize();

    private static native long nativeRecordBooleanHistogram(String str, long j, boolean z);

    private static native long nativeRecordCustomCountHistogram(String str, long j, int i, int i2, int i3, int i4);

    private static native long nativeRecordCustomTimesHistogramMilliseconds(String str, long j, int i, int i2, int i3, int i4);

    private static native long nativeRecordEnumeratedHistogram(String str, long j, int i, int i2);

    private static native long nativeRecordLinearCountHistogram(String str, long j, int i, int i2, int i3, int i4);

    private static native long nativeRecordSparseHistogram(String str, long j, int i);

    private static long getCachedHistogramKey(String str) {
        Long l = sCache.get(str);
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public static void recordTimesHistogram(String str, long j, TimeUnit timeUnit) {
        recordCustomTimesHistogramMilliseconds(str, timeUnit.toMillis(j), 1, TimeUnit.SECONDS.toMillis(10), 50);
    }

    private static int clampToInt(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    private static void recordCustomTimesHistogramMilliseconds(String str, long j, long j2, long j3, int i) {
        if (sDisabledBy == null) {
            long cachedHistogramKey = getCachedHistogramKey(str);
            long nativeRecordCustomTimesHistogramMilliseconds = nativeRecordCustomTimesHistogramMilliseconds(str, cachedHistogramKey, clampToInt(j), clampToInt(j2), clampToInt(j3), i);
            if (nativeRecordCustomTimesHistogramMilliseconds != cachedHistogramKey) {
                sCache.put(str, Long.valueOf(nativeRecordCustomTimesHistogramMilliseconds));
            }
        }
    }
}
