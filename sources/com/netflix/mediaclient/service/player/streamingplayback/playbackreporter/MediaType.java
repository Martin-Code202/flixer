package com.netflix.mediaclient.service.player.streamingplayback.playbackreporter;

import java.util.HashMap;
import java.util.Map;
public enum MediaType {
    UNKNOWN_STREAM(-1),
    AUDIO_STREAM(0),
    VIDEO_STREAM(1),
    TEXT_STREAM(2);
    

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static Map<Integer, MediaType> f1968 = new HashMap();

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f1969;

    static {
        MediaType[] values = values();
        for (MediaType mediaType : values) {
            f1968.put(Integer.valueOf(mediaType.f1969), mediaType);
        }
    }

    private MediaType(int i) {
        this.f1969 = i;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static MediaType m1133(int i) {
        return f1968.get(Integer.valueOf(i));
    }
}
