package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import java.util.Collections;
import java.util.List;
public class DashManifest {
    public final long availabilityStartTime;
    public final long duration;
    public final boolean dynamic;
    public final Uri location;
    public final long minBufferTime;
    public final long minUpdatePeriod;
    private final List<Period> periods;
    public final long suggestedPresentationDelay;
    public final long timeShiftBufferDepth;
    public final UtcTimingElement utcTiming;

    public DashManifest(long j, long j2, long j3, boolean z, long j4, long j5, long j6, UtcTimingElement utcTimingElement, Uri uri, List<Period> list) {
        this.availabilityStartTime = j;
        this.duration = j2;
        this.minBufferTime = j3;
        this.dynamic = z;
        this.minUpdatePeriod = j4;
        this.timeShiftBufferDepth = j5;
        this.suggestedPresentationDelay = j6;
        this.utcTiming = utcTimingElement;
        this.location = uri;
        this.periods = list == null ? Collections.emptyList() : list;
    }

    public final int getPeriodCount() {
        return this.periods.size();
    }

    public final Period getPeriod(int i) {
        return this.periods.get(i);
    }

    public final long getPeriodDurationMs(int i) {
        if (i != this.periods.size() - 1) {
            return this.periods.get(i + 1).startMs - this.periods.get(i).startMs;
        }
        if (this.duration == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.duration - this.periods.get(i).startMs;
    }

    public final long getPeriodDurationUs(int i) {
        return C.msToUs(getPeriodDurationMs(i));
    }
}
