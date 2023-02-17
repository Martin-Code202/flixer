package com.google.android.exoplayer2.trackselection;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public abstract class MappingTrackSelector extends TrackSelector {
    private MappedTrackInfo currentMappedTrackInfo;
    private final SparseBooleanArray rendererDisabledFlags = new SparseBooleanArray();
    private final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides = new SparseArray<>();
    private int tunnelingAudioSessionId = 0;

    /* access modifiers changed from: protected */
    public abstract TrackSelection[] selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr);

    public static final class MappedTrackInfo {
        private final int[][][] formatSupport;
        public final int length;
        private final int[] mixedMimeTypeAdaptiveSupport;
        private final int[] rendererTrackTypes;
        private final TrackGroupArray[] trackGroups;
        private final TrackGroupArray unassociatedTrackGroups;

        MappedTrackInfo(int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.rendererTrackTypes = iArr;
            this.trackGroups = trackGroupArrayArr;
            this.formatSupport = iArr3;
            this.mixedMimeTypeAdaptiveSupport = iArr2;
            this.unassociatedTrackGroups = trackGroupArray;
            this.length = trackGroupArrayArr.length;
        }

        public TrackGroupArray getTrackGroups(int i) {
            return this.trackGroups[i];
        }
    }

    public static final class SelectionOverride {
        public final TrackSelection.Factory factory;
        public final int groupIndex;
        public final int length;
        public final int[] tracks;

        public SelectionOverride(TrackSelection.Factory factory2, int i, int... iArr) {
            this.factory = factory2;
            this.groupIndex = i;
            this.tracks = iArr;
            this.length = iArr.length;
        }

        public TrackSelection createTrackSelection(TrackGroupArray trackGroupArray) {
            return this.factory.createTrackSelection(trackGroupArray.get(this.groupIndex), this.tracks);
        }
    }

    public final MappedTrackInfo getCurrentMappedTrackInfo() {
        return this.currentMappedTrackInfo;
    }

    public final void setSelectionOverride(int i, TrackGroupArray trackGroupArray, SelectionOverride selectionOverride) {
        Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i);
        if (map == null) {
            map = new HashMap<>();
            this.selectionOverrides.put(i, map);
        }
        if (!map.containsKey(trackGroupArray) || !Util.areEqual(map.get(trackGroupArray), selectionOverride)) {
            map.put(trackGroupArray, selectionOverride);
            invalidate();
        }
    }

    public final boolean hasSelectionOverride(int i, TrackGroupArray trackGroupArray) {
        Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i);
        return map != null && map.containsKey(trackGroupArray);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray) {
        TrackSelection trackSelection;
        int[] iArr;
        int[] iArr2 = new int[(rendererCapabilitiesArr.length + 1)];
        TrackGroup[][] trackGroupArr = new TrackGroup[(rendererCapabilitiesArr.length + 1)][];
        int[][][] iArr3 = new int[(rendererCapabilitiesArr.length + 1)][][];
        for (int i = 0; i < trackGroupArr.length; i++) {
            trackGroupArr[i] = new TrackGroup[trackGroupArray.length];
            iArr3[i] = new int[trackGroupArray.length][];
        }
        int[] mixedMimeTypeAdaptationSupport = getMixedMimeTypeAdaptationSupport(rendererCapabilitiesArr);
        for (int i2 = 0; i2 < trackGroupArray.length; i2++) {
            TrackGroup trackGroup = trackGroupArray.get(i2);
            int findRenderer = findRenderer(rendererCapabilitiesArr, trackGroup);
            if (findRenderer == rendererCapabilitiesArr.length) {
                iArr = new int[trackGroup.length];
            } else {
                iArr = getFormatSupport(rendererCapabilitiesArr[findRenderer], trackGroup);
            }
            int i3 = iArr2[findRenderer];
            trackGroupArr[findRenderer][i3] = trackGroup;
            iArr3[findRenderer][i3] = iArr;
            iArr2[findRenderer] = iArr2[findRenderer] + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr.length];
        int[] iArr4 = new int[rendererCapabilitiesArr.length];
        for (int i4 = 0; i4 < rendererCapabilitiesArr.length; i4++) {
            int i5 = iArr2[i4];
            trackGroupArrayArr[i4] = new TrackGroupArray((TrackGroup[]) Arrays.copyOf(trackGroupArr[i4], i5));
            iArr3[i4] = (int[][]) Arrays.copyOf(iArr3[i4], i5);
            iArr4[i4] = rendererCapabilitiesArr[i4].getTrackType();
        }
        TrackGroupArray trackGroupArray2 = new TrackGroupArray((TrackGroup[]) Arrays.copyOf(trackGroupArr[rendererCapabilitiesArr.length], iArr2[rendererCapabilitiesArr.length]));
        TrackSelection[] selectTracks = selectTracks(rendererCapabilitiesArr, trackGroupArrayArr, iArr3);
        for (int i6 = 0; i6 < rendererCapabilitiesArr.length; i6++) {
            if (this.rendererDisabledFlags.get(i6)) {
                selectTracks[i6] = null;
            } else {
                TrackGroupArray trackGroupArray3 = trackGroupArrayArr[i6];
                if (hasSelectionOverride(i6, trackGroupArray3)) {
                    SelectionOverride selectionOverride = this.selectionOverrides.get(i6).get(trackGroupArray3);
                    if (selectionOverride == null) {
                        trackSelection = null;
                    } else {
                        trackSelection = selectionOverride.createTrackSelection(trackGroupArray3);
                    }
                    selectTracks[i6] = trackSelection;
                }
            }
        }
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(iArr4, trackGroupArrayArr, mixedMimeTypeAdaptationSupport, iArr3, trackGroupArray2);
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[rendererCapabilitiesArr.length];
        for (int i7 = 0; i7 < rendererCapabilitiesArr.length; i7++) {
            rendererConfigurationArr[i7] = selectTracks[i7] != null ? RendererConfiguration.DEFAULT : null;
        }
        maybeConfigureRenderersForTunneling(rendererCapabilitiesArr, trackGroupArrayArr, iArr3, rendererConfigurationArr, selectTracks, this.tunnelingAudioSessionId);
        return new TrackSelectorResult(trackGroupArray, new TrackSelectionArray(selectTracks), mappedTrackInfo, rendererConfigurationArr);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final void onSelectionActivated(Object obj) {
        this.currentMappedTrackInfo = (MappedTrackInfo) obj;
    }

    private static int findRenderer(RendererCapabilities[] rendererCapabilitiesArr, TrackGroup trackGroup) {
        int length = rendererCapabilitiesArr.length;
        int i = 0;
        for (int i2 = 0; i2 < rendererCapabilitiesArr.length; i2++) {
            RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i2];
            for (int i3 = 0; i3 < trackGroup.length; i3++) {
                int supportsFormat = rendererCapabilities.supportsFormat(trackGroup.getFormat(i3)) & 7;
                if (supportsFormat > i) {
                    length = i2;
                    i = supportsFormat;
                    if (i == 4) {
                        return length;
                    }
                }
            }
        }
        return length;
    }

    private static int[] getFormatSupport(RendererCapabilities rendererCapabilities, TrackGroup trackGroup) {
        int[] iArr = new int[trackGroup.length];
        for (int i = 0; i < trackGroup.length; i++) {
            iArr[i] = rendererCapabilities.supportsFormat(trackGroup.getFormat(i));
        }
        return iArr;
    }

    private static int[] getMixedMimeTypeAdaptationSupport(RendererCapabilities[] rendererCapabilitiesArr) {
        int[] iArr = new int[rendererCapabilitiesArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = rendererCapabilitiesArr[i].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }

    private static void maybeConfigureRenderersForTunneling(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, TrackSelection[] trackSelectionArr, int i) {
        if (i != 0) {
            int i2 = -1;
            int i3 = -1;
            boolean z = true;
            int i4 = 0;
            while (true) {
                if (i4 >= rendererCapabilitiesArr.length) {
                    break;
                }
                int trackType = rendererCapabilitiesArr[i4].getTrackType();
                TrackSelection trackSelection = trackSelectionArr[i4];
                if ((trackType == 1 || trackType == 2) && trackSelection != null && rendererSupportsTunneling(iArr[i4], trackGroupArrayArr[i4], trackSelection)) {
                    if (trackType == 1) {
                        if (i2 != -1) {
                            z = false;
                            break;
                        }
                        i2 = i4;
                    } else if (i3 != -1) {
                        z = false;
                        break;
                    } else {
                        i3 = i4;
                    }
                }
                i4++;
            }
            if (z && ((i2 == -1 || i3 == -1) ? false : true)) {
                RendererConfiguration rendererConfiguration = new RendererConfiguration(i);
                rendererConfigurationArr[i2] = rendererConfiguration;
                rendererConfigurationArr[i3] = rendererConfiguration;
            }
        }
    }

    private static boolean rendererSupportsTunneling(int[][] iArr, TrackGroupArray trackGroupArray, TrackSelection trackSelection) {
        if (trackSelection == null) {
            return false;
        }
        int indexOf = trackGroupArray.indexOf(trackSelection.getTrackGroup());
        for (int i = 0; i < trackSelection.length(); i++) {
            if ((iArr[indexOf][trackSelection.getIndexInTrackGroup(i)] & 32) != 32) {
                return false;
            }
        }
        return true;
    }
}
