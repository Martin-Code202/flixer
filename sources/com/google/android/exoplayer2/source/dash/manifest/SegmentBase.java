package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.util.Util;
import java.util.List;
public abstract class SegmentBase {
    final RangedUri initialization;
    final long presentationTimeOffset;
    final long timescale;

    public static class SegmentTimelineElement {
        final long duration;
        final long startTime;
    }

    public SegmentBase(RangedUri rangedUri, long j, long j2) {
        this.initialization = rangedUri;
        this.timescale = j;
        this.presentationTimeOffset = j2;
    }

    public RangedUri getInitialization(Representation representation) {
        return this.initialization;
    }

    public long getPresentationTimeOffsetUs() {
        return Util.scaleLargeTimestamp(this.presentationTimeOffset, 1000000, this.timescale);
    }

    public static class SingleSegmentBase extends SegmentBase {
        final long indexLength;
        final long indexStart;

        public SingleSegmentBase(RangedUri rangedUri, long j, long j2, long j3, long j4) {
            super(rangedUri, j, j2);
            this.indexStart = j3;
            this.indexLength = j4;
        }

        public SingleSegmentBase() {
            this(null, 1, 0, 0, 0);
        }

        public RangedUri getIndex() {
            if (this.indexLength <= 0) {
                return null;
            }
            return new RangedUri(null, this.indexStart, this.indexLength);
        }
    }

    public static abstract class MultiSegmentBase extends SegmentBase {
        final long duration;
        final List<SegmentTimelineElement> segmentTimeline;
        final int startNumber;

        public abstract int getSegmentCount(long j);

        public abstract RangedUri getSegmentUrl(Representation representation, int i);

        public int getSegmentNum(long j, long j2) {
            int firstSegmentNum = getFirstSegmentNum();
            int segmentCount = getSegmentCount(j2);
            if (segmentCount == 0) {
                return firstSegmentNum;
            }
            if (this.segmentTimeline == null) {
                int i = this.startNumber + ((int) (j / ((this.duration * 1000000) / this.timescale)));
                if (i < firstSegmentNum) {
                    return firstSegmentNum;
                }
                if (segmentCount == -1) {
                    return i;
                }
                return Math.min(i, (firstSegmentNum + segmentCount) - 1);
            }
            int i2 = firstSegmentNum;
            int i3 = (firstSegmentNum + segmentCount) - 1;
            while (i2 <= i3) {
                int i4 = i2 + ((i3 - i2) / 2);
                long segmentTimeUs = getSegmentTimeUs(i4);
                if (segmentTimeUs < j) {
                    i2 = i4 + 1;
                } else if (segmentTimeUs <= j) {
                    return i4;
                } else {
                    i3 = i4 - 1;
                }
            }
            return i2 == firstSegmentNum ? i2 : i3;
        }

        public final long getSegmentDurationUs(int i, long j) {
            if (this.segmentTimeline != null) {
                return (1000000 * this.segmentTimeline.get(i - this.startNumber).duration) / this.timescale;
            }
            int segmentCount = getSegmentCount(j);
            return (segmentCount == -1 || i != (getFirstSegmentNum() + segmentCount) + -1) ? (this.duration * 1000000) / this.timescale : j - getSegmentTimeUs(i);
        }

        public final long getSegmentTimeUs(int i) {
            long j;
            if (this.segmentTimeline != null) {
                j = this.segmentTimeline.get(i - this.startNumber).startTime - this.presentationTimeOffset;
            } else {
                j = ((long) (i - this.startNumber)) * this.duration;
            }
            return Util.scaleLargeTimestamp(j, 1000000, this.timescale);
        }

        public int getFirstSegmentNum() {
            return this.startNumber;
        }

        public boolean isExplicit() {
            return this.segmentTimeline != null;
        }
    }
}
