package com.netflix.mediaclient.media;

import o.AK;
import o.C1283;
import org.json.JSONObject;
public final class AudioSubtitleDefaultOrderInfo implements Comparable<AudioSubtitleDefaultOrderInfo> {
    private String audioTrackId;
    private long creationTimeInMs;
    private int preferenceOrder;
    private String subtitleTrackId;

    public AudioSubtitleDefaultOrderInfo(JSONObject jSONObject, long j) {
        this.audioTrackId = AK.m3376(jSONObject, "audioTrackId", (String) null);
        this.subtitleTrackId = AK.m3376(jSONObject, "subtitleTrackId", (String) null);
        this.preferenceOrder = AK.m3386(jSONObject, "preferenceOrder", -1);
        this.creationTimeInMs = j;
    }

    public AudioSubtitleDefaultOrderInfo(String str, String str2, int i) {
        this.audioTrackId = str;
        this.subtitleTrackId = str2;
        this.preferenceOrder = i;
    }

    public String getAudioTrackId() {
        return this.audioTrackId;
    }

    public String getSubtitleTrackId() {
        return this.subtitleTrackId;
    }

    public int getPreferenceOrder() {
        return this.preferenceOrder;
    }

    public long getCreationTimeInMs() {
        return this.creationTimeInMs;
    }

    @Override // java.lang.Object
    public String toString() {
        return "AudioSubtitleDefaultOrderInfo [audioTrackId=" + this.audioTrackId + ", subtitleTrackId=" + this.subtitleTrackId + ", preferenceOrder=" + this.preferenceOrder + ", creationTimeInMs=" + this.creationTimeInMs + "]";
    }

    public int compareTo(AudioSubtitleDefaultOrderInfo audioSubtitleDefaultOrderInfo) {
        if (audioSubtitleDefaultOrderInfo == null) {
            return 1;
        }
        if (this.preferenceOrder == audioSubtitleDefaultOrderInfo.preferenceOrder) {
            return 0;
        }
        if (this.preferenceOrder < audioSubtitleDefaultOrderInfo.preferenceOrder) {
            return -1;
        }
        return 1;
    }

    public static void dumpLog(AudioSubtitleDefaultOrderInfo[] audioSubtitleDefaultOrderInfoArr, String str) {
        if (audioSubtitleDefaultOrderInfoArr == null) {
            C1283.m16850(str, "Defaults are null!");
        }
    }
}
