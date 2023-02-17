package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;
import java.util.Comparator;
public abstract class BaseTrackSelection implements TrackSelection {
    private final long[] blacklistUntilTimes;
    private final Format[] formats;
    protected final TrackGroup group;
    private int hashCode;
    public final int length;
    public final int[] tracks;

    public BaseTrackSelection(TrackGroup trackGroup, int... iArr) {
        Assertions.checkState(iArr.length > 0);
        this.group = (TrackGroup) Assertions.checkNotNull(trackGroup);
        this.length = iArr.length;
        this.formats = new Format[this.length];
        for (int i = 0; i < iArr.length; i++) {
            this.formats[i] = trackGroup.getFormat(iArr[i]);
        }
        Arrays.sort(this.formats, new DecreasingBandwidthComparator());
        this.tracks = new int[this.length];
        for (int i2 = 0; i2 < this.length; i2++) {
            this.tracks[i2] = trackGroup.indexOf(this.formats[i2]);
        }
        this.blacklistUntilTimes = new long[this.length];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final TrackGroup getTrackGroup() {
        return this.group;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int length() {
        return this.tracks.length;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final Format getFormat(int i) {
        return this.formats[i];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getIndexInTrackGroup(int i) {
        return this.tracks[i];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(Format format) {
        for (int i = 0; i < this.length; i++) {
            if (this.formats[i] == format) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final Format getSelectedFormat() {
        return this.formats[getSelectedIndex()];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final boolean blacklist(int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean isBlacklisted = isBlacklisted(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.length && !isBlacklisted) {
            isBlacklisted = i2 != i && !isBlacklisted(i2, elapsedRealtime);
            i2++;
        }
        if (!isBlacklisted) {
            return false;
        }
        this.blacklistUntilTimes[i] = Math.max(this.blacklistUntilTimes[i], elapsedRealtime + j);
        return true;
    }

    public final boolean isBlacklisted(int i, long j) {
        return this.blacklistUntilTimes[i] > j;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (System.identityHashCode(this.group) * 31) + Arrays.hashCode(this.tracks);
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
        return this.group == baseTrackSelection.group && Arrays.equals(this.tracks, baseTrackSelection.tracks);
    }

    static final class DecreasingBandwidthComparator implements Comparator<Format> {
        private DecreasingBandwidthComparator() {
        }

        public int compare(Format format, Format format2) {
            return format2.bitrate - format.bitrate;
        }
    }
}
