package com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter;

import com.google.gson.annotations.SerializedName;
import o.lC;
public class PlaybackAbortedJson extends lC {
    @SerializedName("abortedevent")
    protected AbortedEvent abortedEvent;
    @SerializedName("groupname")
    protected String groupName;
    @SerializedName("mid")
    protected long movieId;
    @SerializedName("resumeplayreason")
    protected ResumePlayReason resumePlayReason;
    @SerializedName("waittime")
    protected long waitTime;

    public enum AbortedEvent {
        STARTPLAY,
        RESUMEPLAY
    }

    public enum ResumePlayReason {
        REPOS,
        REBUFFER,
        SKIP,
        AUDIO
    }

    protected PlaybackAbortedJson() {
    }

    public PlaybackAbortedJson(String str) {
        super("playbackaborted", str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public PlaybackAbortedJson m1090(Long l) {
        this.movieId = l.longValue();
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public PlaybackAbortedJson m1089(AbortedEvent abortedEvent2) {
        this.abortedEvent = abortedEvent2;
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public PlaybackAbortedJson m1092(long j) {
        this.waitTime = j;
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public PlaybackAbortedJson m1093(ResumePlayReason resumePlayReason2) {
        this.resumePlayReason = resumePlayReason2;
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public PlaybackAbortedJson m1091(long j) {
        super.m8545(j);
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public PlaybackAbortedJson m1088(long j) {
        m8547(j);
        return this;
    }
}
