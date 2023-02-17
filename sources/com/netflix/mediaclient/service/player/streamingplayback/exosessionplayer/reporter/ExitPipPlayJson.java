package com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter;

import com.google.gson.annotations.SerializedName;
import o.lC;
public class ExitPipPlayJson extends lC {
    @SerializedName("exittype")
    protected ExitType exitType;

    public enum ExitType {
        CONTINUEPLAY,
        ENDSESSION
    }

    protected ExitPipPlayJson() {
    }

    public ExitPipPlayJson(String str) {
        super("exitpipplay", str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public ExitPipPlayJson m1085(long j) {
        m8547(j);
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public ExitPipPlayJson m1087(long j) {
        m8545(j);
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public ExitPipPlayJson m1086(ExitType exitType2) {
        this.exitType = exitType2;
        return this;
    }
}
