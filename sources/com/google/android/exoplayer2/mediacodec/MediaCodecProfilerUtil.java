package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.Log;
import java.util.Locale;
@TargetApi(17)
public class MediaCodecProfilerUtil {
    private final MediaCodecProfiler[] mediaCodecProfilers = {new MediaCodecProfiler("Audio" + ProfilerId.deqInputBuffer.name(), 1000), new MediaCodecProfiler("Audio" + ProfilerId.queInputBuffer.name(), 1000), new MediaCodecProfiler("Audio" + ProfilerId.deqOutputBuffer.name(), 1000), new MediaCodecProfiler("Audio" + ProfilerId.relOutputBuffer.name(), 1000), new MediaCodecProfiler("Video" + ProfilerId.deqInputBuffer.name(), 1000), new MediaCodecProfiler("Video" + ProfilerId.queInputBuffer.name(), 1000), new MediaCodecProfiler("Video" + ProfilerId.deqOutputBuffer.name(), 1000), new MediaCodecProfiler("Video" + ProfilerId.relOutputBuffer.name(), 1000)};

    public enum ProfilerId {
        deqInputBuffer,
        queInputBuffer,
        deqOutputBuffer,
        relOutputBuffer
    }

    /* access modifiers changed from: package-private */
    public static class MediaCodecProfiler {
        private long lastInvoke = -1;
        private long lastLogNs = -1;
        private final long logIntervalNs;
        private long maxTimeSpent = 0;
        private long minTimeSpent = 2147483647L;
        private final String name;
        private int numOfInvoke = 0;
        protected double totalMs;

        public MediaCodecProfiler(String str, long j) {
            this.name = str;
            this.logIntervalNs = 1000000 * j;
        }

        public void begin() {
            this.lastInvoke = SystemClock.elapsedRealtimeNanos();
        }

        public void end() {
            if (this.lastInvoke >= 0) {
                long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                long j = elapsedRealtimeNanos - this.lastInvoke;
                this.minTimeSpent = Math.min(this.minTimeSpent, j);
                this.maxTimeSpent = Math.max(this.maxTimeSpent, j);
                this.totalMs += ((double) j) / 1000000.0d;
                this.numOfInvoke++;
                tryLog(elapsedRealtimeNanos);
            }
        }

        private String getLogString() {
            return String.format(Locale.US, "%s #%d  minmax [%f, %f] Average %f ms", this.name, Integer.valueOf(this.numOfInvoke), Float.valueOf(((float) this.minTimeSpent) / 1000000.0f), Float.valueOf(((float) this.maxTimeSpent) / 1000000.0f), Double.valueOf(this.totalMs / ((double) this.numOfInvoke)));
        }

        private void tryLog(long j) {
            if (j - this.lastLogNs >= this.logIntervalNs) {
                this.lastLogNs = j;
                Log.d("MediaCodecProfiler", getLogString());
            }
        }
    }

    public void invokeBegin(int i, ProfilerId profilerId) {
        int length = ((i - 1) * ProfilerId.values().length) + profilerId.ordinal();
        if (length >= 0 && length < this.mediaCodecProfilers.length) {
            this.mediaCodecProfilers[length].begin();
        }
    }

    public void invokeEnd(int i, ProfilerId profilerId) {
        int length = ((i - 1) * ProfilerId.values().length) + profilerId.ordinal();
        if (length >= 0 && length < this.mediaCodecProfilers.length) {
            this.mediaCodecProfilers[length].end();
        }
    }
}
