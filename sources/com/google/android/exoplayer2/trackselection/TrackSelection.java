package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
public interface TrackSelection {

    public interface Factory {
        TrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr);
    }

    boolean blacklist(int i, long j);

    Format getFormat(int i);

    int getIndexInTrackGroup(int i);

    Format getSelectedFormat();

    int getSelectedIndex();

    Object getSelectionData();

    int getSelectionReason();

    TrackGroup getTrackGroup();

    int indexOf(Format format);

    int length();

    void updateSelectedTrack(long j);
}
