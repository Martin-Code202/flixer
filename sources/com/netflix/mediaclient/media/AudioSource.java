package com.netflix.mediaclient.media;

import com.netflix.mediaclient.media.manifest.Stream;
import java.util.ArrayList;
import java.util.List;
import o.C1283;
import org.json.JSONObject;
public abstract class AudioSource implements Comparable<AudioSource> {
    public static final int ASSISTIVE_AUDIO = 2;
    protected static final String ATTR_BITRATE = "bitrate";
    protected static final String ATTR_DISSALOWED_TIMED_TEXT_TRACK = "disallowedSubtitleTracks";
    protected static final String ATTR_DLID = "downloadable_id";
    protected static final String ATTR_ID = "id";
    protected static final String ATTR_IS_NATIVE = "isNative";
    protected static final String ATTR_LANGUAGE = "language";
    protected static final String ATTR_LANGUAGE_DESCRIPTION = "languageDescription";
    protected static final String ATTR_NUM_CHANNELS = "channels";
    protected static final String ATTR_ORDER = "order";
    protected static final String ATTR_SELECTED = "selected";
    protected static final String ATTR_TRACK_TYPE = "trackType";
    public static final int COMMENTARY_AUDIO = 1;
    public static final int DDPLUS_AUDIO = 4;
    public static final int DOLBY_AC3_AUDIO = 1;
    public static final int HEAAC_AUDIO = 3;
    protected static final String NONE = "none";
    public static final int OGG_VORBIS_AUDIO = 2;
    public static final int PRIMARY_AUDIO = 0;
    protected static final String TAG = "nf_audio_source";
    public static final int UNKNOWN_AUDIO = 3;
    public static final int UNKNOWN_AUDIO_CODEC = -1;
    public static final int WMA_AUDIO = 0;
    protected int bitrate;
    protected int codecType;
    protected String[] disallowedSubtitles;
    protected String dlid;
    protected String id;
    protected boolean isNative;
    protected String languageCodeIso639_1;
    protected String languageCodeIso639_2;
    protected String languageDescription;
    protected int nccpOrderNumber;
    protected int numChannels;
    protected List<Stream> streams = new ArrayList();
    protected int trackType;

    public abstract JSONObject toJson();

    public String getLanguageCodeIso639_1() {
        return this.languageCodeIso639_1;
    }

    public String getLanguageCodeIso639_2() {
        return this.languageCodeIso639_2;
    }

    public String getLanguageDescription() {
        return this.languageDescription;
    }

    public String getLanguageDescriptionDisplayLabel() {
        if (this.numChannels == 6) {
            return this.languageDescription + " (5.1)";
        }
        return this.languageDescription;
    }

    public int getTrackType() {
        return this.trackType;
    }

    public int getCodecType() {
        return this.codecType;
    }

    public boolean isNative() {
        return this.isNative;
    }

    public int getNumChannels() {
        return this.numChannels;
    }

    public int getNccpOrderNumber() {
        return this.nccpOrderNumber;
    }

    public int compareTo(AudioSource audioSource) {
        if (audioSource == null) {
            return -1;
        }
        if (this.trackType > audioSource.trackType) {
            return 1;
        }
        if (this.trackType < audioSource.trackType || this.languageDescription == null) {
            return -1;
        }
        if (audioSource.languageDescription == null) {
            return 1;
        }
        int compare = String.CASE_INSENSITIVE_ORDER.compare(this.languageDescription, audioSource.languageDescription);
        if (compare != 0) {
            return compare;
        }
        int compareTo = this.languageDescription.compareTo(audioSource.languageDescription);
        if (compareTo != 0) {
            return compareTo;
        }
        if (this.numChannels < audioSource.numChannels) {
            return 1;
        }
        if (this.numChannels == audioSource.numChannels) {
            return 0;
        }
        return -1;
    }

    public String getId() {
        return this.id;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public String getDlid() {
        return this.dlid;
    }

    @Override // java.lang.Object
    public String toString() {
        return "AudioSource [id=" + this.id + ", languageCodeIso639_1=" + this.languageCodeIso639_1 + ", languageCodeIso639_2=" + this.languageCodeIso639_2 + ", languageDescription=" + this.languageDescription + ", trackType=" + this.trackType + ", codecType=" + this.codecType + ", isNative=" + this.isNative + ", numChannels=" + this.numChannels + ", dissalowed subtitles # " + this.disallowedSubtitles.length + ", nccpOrderNumber=" + this.nccpOrderNumber + ", dlid=" + this.dlid + "]";
    }

    public String[] getDisallowedSubtitles() {
        return this.disallowedSubtitles;
    }

    public boolean isAllowedSubtitle(Subtitle subtitle) {
        if (this.disallowedSubtitles.length < 1) {
            return true;
        }
        String str = NONE;
        if (subtitle == null) {
            C1283.m16854(TAG, "Checking if subtitle off is allowed");
        } else {
            C1283.m16854(TAG, "Checking if subtitle is allowed");
            str = subtitle.getId();
        }
        for (int i = 0; i < this.disallowedSubtitles.length; i++) {
            if (this.disallowedSubtitles[i] != null && this.disallowedSubtitles[i].equalsIgnoreCase(str)) {
                return false;
            }
        }
        return true;
    }

    public List<Stream> getStreams() {
        return this.streams;
    }

    public static void dumpLog(AudioSource[] audioSourceArr, String str) {
        if (audioSourceArr == null) {
            C1283.m16850(str, "Audios are null!");
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.nccpOrderNumber + 31;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && (obj instanceof AudioSource) && this.nccpOrderNumber == ((AudioSource) obj).nccpOrderNumber;
    }
}
