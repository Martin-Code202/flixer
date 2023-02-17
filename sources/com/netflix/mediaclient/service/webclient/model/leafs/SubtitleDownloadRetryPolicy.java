package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
public class SubtitleDownloadRetryPolicy {
    public static final int DEFAULT_INITIAL_INTERVAL_MS = 10000;
    public static final int DEFAULT_MAX_ELAPSED_TIME_MS = 900000;
    public static final int DEFAULT_MAX_INTERVAL_MS = 60000;
    public static final double DEFAULT_MULTIPLIER = 2.0d;
    public static final double DEFAULT_RANDOMIZATION_FACTOR = 0.5d;
    private static String TAG = "nf_log";
    @SerializedName("initialIntervalInMs")
    private int initialIntervalInMs = DEFAULT_INITIAL_INTERVAL_MS;
    @SerializedName("maxElapsedTimeInMs")
    private int maxElapsedTimeInMs;
    @SerializedName("maxIntervalInMs")
    private int maxIntervalInMs = DEFAULT_MAX_INTERVAL_MS;
    @SerializedName("multiplier")
    private double multiplier = 2.0d;
    @SerializedName("randomizationFactor")
    private double randomizationFactor = 0.5d;

    public int getInitialIntervalInMs() {
        return this.initialIntervalInMs;
    }

    public double getRandomizationFactor() {
        return this.randomizationFactor;
    }

    public double getMultiplier() {
        return this.multiplier;
    }

    public int getMaxIntervalInMs() {
        return this.maxIntervalInMs;
    }

    public int getMaxElapsedTimeInMs() {
        return this.maxElapsedTimeInMs;
    }

    public static SubtitleDownloadRetryPolicy getDefault() {
        return new SubtitleDownloadRetryPolicy();
    }

    public String toString() {
        return "SubtitleDownloadRetryPolicy{initialIntervalInMs=" + this.initialIntervalInMs + ", randomizationFactor=" + this.randomizationFactor + ", multiplier=" + this.multiplier + ", maxIntervalInMs=" + this.maxIntervalInMs + ", maxElapsedTimeInMs=" + this.maxElapsedTimeInMs + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SubtitleDownloadRetryPolicy subtitleDownloadRetryPolicy = (SubtitleDownloadRetryPolicy) obj;
        return this.initialIntervalInMs == subtitleDownloadRetryPolicy.initialIntervalInMs && Double.compare(subtitleDownloadRetryPolicy.randomizationFactor, this.randomizationFactor) == 0 && Double.compare(subtitleDownloadRetryPolicy.multiplier, this.multiplier) == 0 && this.maxIntervalInMs == subtitleDownloadRetryPolicy.maxIntervalInMs && this.maxElapsedTimeInMs == subtitleDownloadRetryPolicy.maxElapsedTimeInMs;
    }

    public int hashCode() {
        int i = this.initialIntervalInMs;
        long doubleToLongBits = Double.doubleToLongBits(this.randomizationFactor);
        int i2 = (i * 31) + ((int) ((doubleToLongBits >>> 32) ^ doubleToLongBits));
        long doubleToLongBits2 = Double.doubleToLongBits(this.multiplier);
        return (((((i2 * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2))) * 31) + this.maxIntervalInMs) * 31) + this.maxElapsedTimeInMs;
    }
}
