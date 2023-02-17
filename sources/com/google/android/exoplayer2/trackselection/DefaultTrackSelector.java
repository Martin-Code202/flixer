package com.google.android.exoplayer2.trackselection;

import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
public class DefaultTrackSelector extends MappingTrackSelector {
    private static final int[] NO_TRACKS = new int[0];
    private final TrackSelection.Factory adaptiveTrackSelectionFactory;
    private final AtomicReference<Parameters> paramsReference;

    public static final class Parameters {
        public final boolean allowMixedMimeAdaptiveness;
        public final boolean allowNonSeamlessAdaptiveness;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        public final int maxVideoBitrate;
        public final int maxVideoHeight;
        public final int maxVideoWidth;
        public final String preferredAudioLanguage;
        public final String preferredTextLanguage;
        public final int viewportHeight;
        public final boolean viewportOrientationMayChange;
        public final int viewportWidth;

        public Parameters() {
            this(null, null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public Parameters(String str, String str2, boolean z, boolean z2, int i, int i2, int i3, boolean z3, boolean z4, int i4, int i5, boolean z5) {
            this.preferredAudioLanguage = str;
            this.preferredTextLanguage = str2;
            this.allowMixedMimeAdaptiveness = z;
            this.allowNonSeamlessAdaptiveness = z2;
            this.maxVideoWidth = i;
            this.maxVideoHeight = i2;
            this.maxVideoBitrate = i3;
            this.exceedVideoConstraintsIfNecessary = z3;
            this.exceedRendererCapabilitiesIfNecessary = z4;
            this.viewportWidth = i4;
            this.viewportHeight = i5;
            this.viewportOrientationMayChange = z5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            return this.allowMixedMimeAdaptiveness == parameters.allowMixedMimeAdaptiveness && this.allowNonSeamlessAdaptiveness == parameters.allowNonSeamlessAdaptiveness && this.maxVideoWidth == parameters.maxVideoWidth && this.maxVideoHeight == parameters.maxVideoHeight && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.viewportOrientationMayChange == parameters.viewportOrientationMayChange && this.viewportWidth == parameters.viewportWidth && this.viewportHeight == parameters.viewportHeight && this.maxVideoBitrate == parameters.maxVideoBitrate && TextUtils.equals(this.preferredAudioLanguage, parameters.preferredAudioLanguage) && TextUtils.equals(this.preferredTextLanguage, parameters.preferredTextLanguage);
        }

        public int hashCode() {
            return (((((((((((((((((((((this.preferredAudioLanguage.hashCode() * 31) + this.preferredTextLanguage.hashCode()) * 31) + (this.allowMixedMimeAdaptiveness ? 1 : 0)) * 31) + (this.allowNonSeamlessAdaptiveness ? 1 : 0)) * 31) + this.maxVideoWidth) * 31) + this.maxVideoHeight) * 31) + this.maxVideoBitrate) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
        }
    }

    public DefaultTrackSelector() {
        this(null);
    }

    public DefaultTrackSelector(TrackSelection.Factory factory) {
        this.adaptiveTrackSelectionFactory = factory;
        this.paramsReference = new AtomicReference<>(new Parameters());
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.trackselection.MappingTrackSelector
    public TrackSelection[] selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr) {
        int length = rendererCapabilitiesArr.length;
        TrackSelection[] trackSelectionArr = new TrackSelection[length];
        Parameters parameters = this.paramsReference.get();
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < length; i++) {
            if (2 == rendererCapabilitiesArr[i].getTrackType()) {
                if (!z2) {
                    trackSelectionArr[i] = selectVideoTrack(rendererCapabilitiesArr[i], trackGroupArrayArr[i], iArr[i], parameters, this.adaptiveTrackSelectionFactory);
                    z2 = trackSelectionArr[i] != null;
                }
                z |= trackGroupArrayArr[i].length > 0;
            }
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i2 = 0; i2 < length; i2++) {
            switch (rendererCapabilitiesArr[i2].getTrackType()) {
                case 1:
                    if (!z3) {
                        trackSelectionArr[i2] = selectAudioTrack(trackGroupArrayArr[i2], iArr[i2], parameters, z ? null : this.adaptiveTrackSelectionFactory);
                        if (trackSelectionArr[i2] != null) {
                            z3 = true;
                            break;
                        } else {
                            z3 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                case 2:
                    break;
                case 3:
                    if (!z4) {
                        trackSelectionArr[i2] = selectTextTrack(trackGroupArrayArr[i2], iArr[i2], parameters);
                        if (trackSelectionArr[i2] != null) {
                            z4 = true;
                            break;
                        } else {
                            z4 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                default:
                    trackSelectionArr[i2] = selectOtherTrack(rendererCapabilitiesArr[i2].getTrackType(), trackGroupArrayArr[i2], iArr[i2], parameters);
                    break;
            }
        }
        return trackSelectionArr;
    }

    /* access modifiers changed from: protected */
    public TrackSelection selectVideoTrack(RendererCapabilities rendererCapabilities, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, TrackSelection.Factory factory) {
        TrackSelection trackSelection = null;
        if (factory != null) {
            trackSelection = selectAdaptiveVideoTrack(rendererCapabilities, trackGroupArray, iArr, parameters, factory);
        }
        if (trackSelection == null) {
            return selectFixedVideoTrack(trackGroupArray, iArr, parameters);
        }
        return trackSelection;
    }

    private static TrackSelection selectAdaptiveVideoTrack(RendererCapabilities rendererCapabilities, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, TrackSelection.Factory factory) {
        int i = parameters.allowNonSeamlessAdaptiveness ? 24 : 16;
        boolean z = parameters.allowMixedMimeAdaptiveness && (rendererCapabilities.supportsMixedMimeTypeAdaptation() & i) != 0;
        for (int i2 = 0; i2 < trackGroupArray.length; i2++) {
            TrackGroup trackGroup = trackGroupArray.get(i2);
            int[] adaptiveVideoTracksForGroup = getAdaptiveVideoTracksForGroup(trackGroup, iArr[i2], z, i, parameters.maxVideoWidth, parameters.maxVideoHeight, parameters.maxVideoBitrate, parameters.viewportWidth, parameters.viewportHeight, parameters.viewportOrientationMayChange);
            if (adaptiveVideoTracksForGroup.length > 0) {
                return factory.createTrackSelection(trackGroup, adaptiveVideoTracksForGroup);
            }
        }
        return null;
    }

    private static int[] getAdaptiveVideoTracksForGroup(TrackGroup trackGroup, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        int adaptiveVideoTrackCountForMimeType;
        if (trackGroup.length < 2) {
            return NO_TRACKS;
        }
        List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup, i5, i6, z2);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        String str = null;
        if (!z) {
            HashSet hashSet = new HashSet();
            int i7 = 0;
            for (int i8 = 0; i8 < viewportFilteredTrackIndices.size(); i8++) {
                String str2 = trackGroup.getFormat(viewportFilteredTrackIndices.get(i8).intValue()).sampleMimeType;
                if (hashSet.add(str2) && (adaptiveVideoTrackCountForMimeType = getAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i, str2, i2, i3, i4, viewportFilteredTrackIndices)) > i7) {
                    str = str2;
                    i7 = adaptiveVideoTrackCountForMimeType;
                }
            }
        }
        filterAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i, str, i2, i3, i4, viewportFilteredTrackIndices);
        return viewportFilteredTrackIndices.size() < 2 ? NO_TRACKS : Util.toArray(viewportFilteredTrackIndices);
    }

    private static int getAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            int intValue = list.get(i6).intValue();
            if (isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                i5++;
            }
        }
        return i5;
    }

    private static void filterAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list.get(size).intValue();
            if (!isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                list.remove(size);
            }
        }
    }

    private static boolean isSupportedAdaptiveVideoTrack(Format format, String str, int i, int i2, int i3, int i4, int i5) {
        return isSupported(i, false) && (i & i2) != 0 && (str == null || Util.areEqual(format.sampleMimeType, str)) && ((format.width == -1 || format.width <= i3) && ((format.height == -1 || format.height <= i4) && (format.bitrate == -1 || format.bitrate <= i5)));
    }

    private static TrackSelection selectFixedVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) {
        int i;
        TrackGroup trackGroup = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < trackGroupArray.length; i6++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i6);
            List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup2, parameters.viewportWidth, parameters.viewportHeight, parameters.viewportOrientationMayChange);
            int[] iArr2 = iArr[i6];
            for (int i7 = 0; i7 < trackGroup2.length; i7++) {
                if (isSupported(iArr2[i7], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    Format format = trackGroup2.getFormat(i7);
                    boolean z = viewportFilteredTrackIndices.contains(Integer.valueOf(i7)) && (format.width == -1 || format.width <= parameters.maxVideoWidth) && ((format.height == -1 || format.height <= parameters.maxVideoHeight) && (format.bitrate == -1 || format.bitrate <= parameters.maxVideoBitrate));
                    if (z || parameters.exceedVideoConstraintsIfNecessary) {
                        int i8 = z ? 2 : 1;
                        boolean isSupported = isSupported(iArr2[i7], false);
                        if (isSupported) {
                            i8 += 1000;
                        }
                        boolean z2 = i8 > i3;
                        if (i8 == i3) {
                            if (format.getPixelCount() != i5) {
                                i = compareFormatValues(format.getPixelCount(), i5);
                            } else {
                                i = compareFormatValues(format.bitrate, i4);
                            }
                            z2 = (!isSupported || !z) ? i < 0 : i > 0;
                        }
                        if (z2) {
                            trackGroup = trackGroup2;
                            i2 = i7;
                            i3 = i8;
                            i4 = format.bitrate;
                            i5 = format.getPixelCount();
                        }
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup, i2);
    }

    private static int compareFormatValues(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    /* access modifiers changed from: protected */
    public TrackSelection selectAudioTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, TrackSelection.Factory factory) {
        int audioTrackScore;
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroupArray.length; i4++) {
            TrackGroup trackGroup = trackGroupArray.get(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < trackGroup.length; i5++) {
                if (isSupported(iArr2[i5], parameters.exceedRendererCapabilitiesIfNecessary) && (audioTrackScore = getAudioTrackScore(iArr2[i5], parameters.preferredAudioLanguage, trackGroup.getFormat(i5))) > i3) {
                    i = i4;
                    i2 = i5;
                    i3 = audioTrackScore;
                }
            }
        }
        if (i == -1) {
            return null;
        }
        TrackGroup trackGroup2 = trackGroupArray.get(i);
        if (factory != null) {
            int[] adaptiveAudioTracks = getAdaptiveAudioTracks(trackGroup2, iArr[i], parameters.allowMixedMimeAdaptiveness);
            if (adaptiveAudioTracks.length > 0) {
                return factory.createTrackSelection(trackGroup2, adaptiveAudioTracks);
            }
        }
        return new FixedTrackSelection(trackGroup2, i2);
    }

    private static int getAudioTrackScore(int i, String str, Format format) {
        int i2;
        boolean z = (format.selectionFlags & 1) != 0;
        if (formatHasLanguage(format, str)) {
            if (z) {
                i2 = 4;
            } else {
                i2 = 3;
            }
        } else if (z) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        if (isSupported(i, false)) {
            return i2 + 1000;
        }
        return i2;
    }

    private static int[] getAdaptiveAudioTracks(TrackGroup trackGroup, int[] iArr, boolean z) {
        int adaptiveAudioTrackCount;
        int i = 0;
        AudioConfigurationTuple audioConfigurationTuple = null;
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < trackGroup.length; i2++) {
            Format format = trackGroup.getFormat(i2);
            AudioConfigurationTuple audioConfigurationTuple2 = new AudioConfigurationTuple(format.channelCount, format.sampleRate, z ? null : format.sampleMimeType);
            if (hashSet.add(audioConfigurationTuple2) && (adaptiveAudioTrackCount = getAdaptiveAudioTrackCount(trackGroup, iArr, audioConfigurationTuple2)) > i) {
                audioConfigurationTuple = audioConfigurationTuple2;
                i = adaptiveAudioTrackCount;
            }
        }
        if (i <= 1) {
            return NO_TRACKS;
        }
        int[] iArr2 = new int[i];
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroup.length; i4++) {
            if (isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i4), iArr[i4], audioConfigurationTuple)) {
                i3++;
                iArr2[i3] = i4;
            }
        }
        return iArr2;
    }

    private static int getAdaptiveAudioTrackCount(TrackGroup trackGroup, int[] iArr, AudioConfigurationTuple audioConfigurationTuple) {
        int i = 0;
        for (int i2 = 0; i2 < trackGroup.length; i2++) {
            if (isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i2), iArr[i2], audioConfigurationTuple)) {
                i++;
            }
        }
        return i;
    }

    private static boolean isSupportedAdaptiveAudioTrack(Format format, int i, AudioConfigurationTuple audioConfigurationTuple) {
        return isSupported(i, false) && format.channelCount == audioConfigurationTuple.channelCount && format.sampleRate == audioConfigurationTuple.sampleRate && (audioConfigurationTuple.mimeType == null || TextUtils.equals(audioConfigurationTuple.mimeType, format.sampleMimeType));
    }

    /* access modifiers changed from: protected */
    public TrackSelection selectTextTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) {
        int i;
        TrackGroup trackGroup = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroupArray.length; i4++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < trackGroup2.length; i5++) {
                if (isSupported(iArr2[i5], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    Format format = trackGroup2.getFormat(i5);
                    boolean z = (format.selectionFlags & 1) != 0;
                    boolean z2 = (format.selectionFlags & 2) != 0;
                    if (formatHasLanguage(format, parameters.preferredTextLanguage)) {
                        if (z) {
                            i = 6;
                        } else if (!z2) {
                            i = 5;
                        } else {
                            i = 4;
                        }
                    } else if (z) {
                        i = 3;
                    } else if (z2) {
                        if (formatHasLanguage(format, parameters.preferredAudioLanguage)) {
                            i = 2;
                        } else {
                            i = 1;
                        }
                    }
                    if (isSupported(iArr2[i5], false)) {
                        i += 1000;
                    }
                    if (i > i3) {
                        trackGroup = trackGroup2;
                        i2 = i5;
                        i3 = i;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup, i2);
    }

    /* access modifiers changed from: protected */
    public TrackSelection selectOtherTrack(int i, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) {
        TrackGroup trackGroup = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroupArray.length; i4++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < trackGroup2.length; i5++) {
                if (isSupported(iArr2[i5], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    int i6 = (trackGroup2.getFormat(i5).selectionFlags & 1) != 0 ? 2 : 1;
                    if (isSupported(iArr2[i5], false)) {
                        i6 += 1000;
                    }
                    if (i6 > i3) {
                        trackGroup = trackGroup2;
                        i2 = i5;
                        i3 = i6;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup, i2);
    }

    protected static boolean isSupported(int i, boolean z) {
        int i2 = i & 7;
        return i2 == 4 || (z && i2 == 3);
    }

    protected static boolean formatHasLanguage(Format format, String str) {
        return str != null && TextUtils.equals(str, Util.normalizeLanguageCode(format.language));
    }

    private static List<Integer> getViewportFilteredTrackIndices(TrackGroup trackGroup, int i, int i2, boolean z) {
        ArrayList arrayList = new ArrayList(trackGroup.length);
        for (int i3 = 0; i3 < trackGroup.length; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
            return arrayList;
        }
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < trackGroup.length; i5++) {
            Format format = trackGroup.getFormat(i5);
            if (format.width > 0 && format.height > 0) {
                Point maxVideoSizeInViewport = getMaxVideoSizeInViewport(z, i, i2, format.width, format.height);
                int i6 = format.width * format.height;
                if (format.width >= ((int) (((float) maxVideoSizeInViewport.x) * 0.98f)) && format.height >= ((int) (((float) maxVideoSizeInViewport.y) * 0.98f)) && i6 < i4) {
                    i4 = i6;
                }
            }
        }
        if (i4 != Integer.MAX_VALUE) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                int pixelCount = trackGroup.getFormat(((Integer) arrayList.get(size)).intValue()).getPixelCount();
                if (pixelCount == -1 || pixelCount > i4) {
                    arrayList.remove(size);
                }
            }
        }
        return arrayList;
    }

    private static Point getMaxVideoSizeInViewport(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            if ((i3 > i4) != (i > i2)) {
                i = i2;
                i2 = i;
            }
        }
        if (i3 * i2 >= i4 * i) {
            return new Point(i, Util.ceilDivide(i * i4, i3));
        }
        return new Point(Util.ceilDivide(i2 * i3, i4), i2);
    }

    /* access modifiers changed from: package-private */
    public static final class AudioConfigurationTuple {
        public final int channelCount;
        public final String mimeType;
        public final int sampleRate;

        public AudioConfigurationTuple(int i, int i2, String str) {
            this.channelCount = i;
            this.sampleRate = i2;
            this.mimeType = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AudioConfigurationTuple audioConfigurationTuple = (AudioConfigurationTuple) obj;
            return this.channelCount == audioConfigurationTuple.channelCount && this.sampleRate == audioConfigurationTuple.sampleRate && TextUtils.equals(this.mimeType, audioConfigurationTuple.mimeType);
        }

        public int hashCode() {
            return (((this.channelCount * 31) + this.sampleRate) * 31) + (this.mimeType != null ? this.mimeType.hashCode() : 0);
        }
    }
}
