package com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter;

import com.google.gson.annotations.SerializedName;
import o.lC;
public class StateChangedJson extends lC {
    @SerializedName("newstate")
    public State newstate;
    @SerializedName("oldstate")
    public State oldstate;

    enum State {
        PAUSED,
        PLAYING
    }

    protected StateChangedJson() {
    }

    public StateChangedJson(String str) {
        super("statechanged", str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public StateChangedJson m1123(boolean z) {
        if (z) {
            this.oldstate = State.PLAYING;
            this.newstate = State.PAUSED;
        } else {
            this.oldstate = State.PAUSED;
            this.newstate = State.PLAYING;
        }
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public StateChangedJson m1124(long j) {
        super.m8547(j);
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public StateChangedJson m1122(long j) {
        super.m8545(j);
        return this;
    }
}
