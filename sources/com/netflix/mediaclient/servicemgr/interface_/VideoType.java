package com.netflix.mediaclient.servicemgr.interface_;
public enum VideoType {
    MOVIE("movies", 0),
    SHOW("shows", 1),
    SEASON("seasons", 2),
    EPISODE("episodes", 3),
    CHARACTERS("characters", 4),
    SERIES("series", 5),
    UNAVAILABLE("unavailable", 6),
    UNKNOWN("", 7);
    
    private final int key;
    private final String value;

    private VideoType(String str, int i) {
        this.value = str;
        this.key = i;
    }

    public static VideoType create(String str) {
        VideoType[] values = values();
        for (VideoType videoType : values) {
            if (videoType.value.equalsIgnoreCase(str)) {
                return videoType;
            }
        }
        return UNKNOWN;
    }

    public static VideoType create(int i) {
        VideoType[] values = values();
        for (VideoType videoType : values) {
            if (videoType.key == i) {
                return videoType;
            }
        }
        return UNKNOWN;
    }

    public String getValue() {
        return this.value;
    }

    public int getKey() {
        return this.key;
    }

    public static boolean isPresentationTrackingType(VideoType videoType) {
        return MOVIE == videoType || SHOW == videoType || SERIES == videoType || SEASON == videoType || EPISODE == videoType;
    }
}
