package o;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.FixedTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
/* renamed from: o.js  reason: case insensitive filesystem */
public class C1918js {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m8042(MappingTrackSelector mappingTrackSelector, String str) {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = mappingTrackSelector.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo == null) {
            C1283.m16854("StreamingPlayback_ExoSessionPlayerInternal", "selectAudioTrack is skipped because CurrentMappedTrackInfo is not set");
            return;
        }
        for (int i = 0; i < currentMappedTrackInfo.length; i++) {
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i);
            for (int i2 = 0; i2 < trackGroups.length; i2++) {
                TrackGroup trackGroup = trackGroups.get(i2);
                for (int i3 = 0; i3 < trackGroup.length; i3++) {
                    Metadata metadata = trackGroup.getFormat(i3).metadata;
                    if (metadata != null) {
                        for (int i4 = 0; i4 < metadata.length(); i4++) {
                            Metadata.Entry entry = metadata.get(i4);
                            if (entry != null && (entry instanceof C1921jv) && str.equals(((C1921jv) entry).m8081())) {
                                C1283.m16851("StreamingPlayback_ExoSessionPlayerInternal", "selectAudioTrack, will override render %d, trackgroup %d, track %d.", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                                mappingTrackSelector.setSelectionOverride(i, trackGroups, new MappingTrackSelector.SelectionOverride(new FixedTrackSelection.Factory(), i2, i3));
                                return;
                            }
                        }
                        continue;
                    }
                }
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m8041(TrackSelection trackSelection) {
        Metadata metadata;
        Metadata.Entry entry;
        int selectedIndex = trackSelection.getSelectedIndex();
        if (trackSelection.length() <= selectedIndex || (metadata = trackSelection.getFormat(selectedIndex).metadata) == null || (entry = metadata.get(selectedIndex)) == null || !(entry instanceof C1921jv)) {
            return null;
        }
        return ((C1921jv) entry).m8081();
    }
}
