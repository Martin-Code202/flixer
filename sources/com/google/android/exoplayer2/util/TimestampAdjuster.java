package com.google.android.exoplayer2.util;
public final class TimestampAdjuster {
    private long firstSampleTimestampUs;
    private volatile long lastSampleTimestamp = -9223372036854775807L;
    private long timestampOffsetUs;

    public TimestampAdjuster(long j) {
        setFirstSampleTimestampUs(j);
    }

    public synchronized void setFirstSampleTimestampUs(long j) {
        Assertions.checkState(this.lastSampleTimestamp == -9223372036854775807L);
        this.firstSampleTimestampUs = j;
    }

    public long getTimestampOffsetUs() {
        if (this.firstSampleTimestampUs == Long.MAX_VALUE) {
            return 0;
        }
        if (this.lastSampleTimestamp == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.timestampOffsetUs;
    }

    public long adjustTsTimestamp(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.lastSampleTimestamp != -9223372036854775807L) {
            long usToPts = usToPts(this.lastSampleTimestamp);
            long j2 = (4294967296L + usToPts) / 8589934592L;
            long j3 = j + ((j2 - 1) * 8589934592L);
            long j4 = j + (8589934592L * j2);
            j = Math.abs(j3 - usToPts) < Math.abs(j4 - usToPts) ? j3 : j4;
        }
        return adjustSampleTimestamp(ptsToUs(j));
    }

    public long adjustSampleTimestamp(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.lastSampleTimestamp != -9223372036854775807L) {
            this.lastSampleTimestamp = j;
        } else {
            if (this.firstSampleTimestampUs != Long.MAX_VALUE) {
                this.timestampOffsetUs = this.firstSampleTimestampUs - j;
            }
            synchronized (this) {
                this.lastSampleTimestamp = j;
                notifyAll();
            }
        }
        return this.timestampOffsetUs + j;
    }

    public static long ptsToUs(long j) {
        return (1000000 * j) / 90000;
    }

    public static long usToPts(long j) {
        return (90000 * j) / 1000000;
    }
}
