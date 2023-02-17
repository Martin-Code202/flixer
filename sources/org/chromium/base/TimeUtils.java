package org.chromium.base;
public class TimeUtils {
    public static native long nativeGetTimeTicksNowUs();

    private TimeUtils() {
    }
}
