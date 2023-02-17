package com.netflix.mediaclient.media;

import android.graphics.Point;
import com.netflix.mediaclient.media.manifest.Stream;
import com.netflix.mediaclient.media.manifest.VideoTrack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class PlayerManifestData {
    private String[] availableBitrates;
    Comparator<Stream> bitrateStreamComparator = new Comparator<Stream>() { // from class: com.netflix.mediaclient.media.PlayerManifestData.1
        public int compare(Stream stream, Stream stream2) {
            if (stream.bitrate > stream2.bitrate) {
                return 1;
            }
            return stream.bitrate < stream2.bitrate ? -1 : 0;
        }
    };
    private long duration;
    private int maxGopSize;
    private PlaybackDisplaySpec playbackDisplaySpec;
    private final String rawVideoProfileType;
    private List<Stream> sortedVideoStreams;
    private final String videoProfileTag;

    public PlayerManifestData(long j, String[] strArr, PlaybackDisplaySpec playbackDisplaySpec2, int i, String str, String str2, List<VideoTrack> list) {
        this.duration = j;
        this.availableBitrates = strArr;
        this.playbackDisplaySpec = playbackDisplaySpec2;
        this.maxGopSize = i;
        this.videoProfileTag = str;
        this.rawVideoProfileType = str2;
        this.sortedVideoStreams = new ArrayList();
        for (Stream stream : list.get(0).streams) {
            this.sortedVideoStreams.add(stream);
        }
        Collections.sort(this.sortedVideoStreams, this.bitrateStreamComparator);
    }

    public static class PlaybackDisplaySpec {
        public Point aspectRatioDimension;
        public Point croppedAspectRatioDimension;

        public PlaybackDisplaySpec(Point point, Point point2) {
            this.aspectRatioDimension = point;
            this.croppedAspectRatioDimension = point2;
        }

        public String toString() {
            return "PlaybackDisplaySpec{ aspectRatioDimension = " + this.aspectRatioDimension + "croppedAspectRatioDimension = " + this.croppedAspectRatioDimension + " }";
        }
    }

    public long getDuration() {
        return this.duration;
    }

    public String[] getAvailableBitrates() {
        return this.availableBitrates;
    }

    public PlaybackDisplaySpec getPlaybackDisplaySpec() {
        return this.playbackDisplaySpec;
    }

    public int getGopMaxSizeInMs() {
        return this.maxGopSize;
    }

    public String getVideoProfileTag() {
        return this.videoProfileTag;
    }

    public String getRawVideoProfileType() {
        return this.rawVideoProfileType;
    }

    public List<Stream> getVideoStreamsInfo() {
        return this.sortedVideoStreams;
    }
}
