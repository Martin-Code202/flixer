package com.google.android.exoplayer2.util;
public interface Clock {
    public static final Clock DEFAULT = new SystemClock();

    long elapsedRealtime();
}
