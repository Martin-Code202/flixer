package com.netflix.mediaclient.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;
public interface Subtitle extends Comparable<Subtitle> {
    public static final int CLOSED_CAPTION_SUBTITLE = 2;
    public static final int COMMENTARY = 4;
    public static final int DESCRIPTIONS = 5;
    public static final int FORCED_NARRATIVE = 6;
    public static final int NONE = 7;
    public static final int PRIMARY_SUBTITLE = 1;
    public static final int SUBTITLES = 3;
    public static final int UNKNOWN_SUBTITLE = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AllowedTrackTypes {
    }

    boolean canDeviceRender();

    String getDownloadableId();

    String getId();

    String getLanguageCodeIso639_1();

    String getLanguageCodeIso639_2();

    String getLanguageDescription();

    int getNccpOrderNumber();

    int getTrackType();

    boolean isCC();

    boolean isForcedNarrativeOrNone();

    JSONObject toJson();
}
