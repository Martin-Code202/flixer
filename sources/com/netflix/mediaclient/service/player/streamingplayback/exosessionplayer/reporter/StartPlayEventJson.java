package com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import o.lC;
public class StartPlayEventJson extends lC {
    @SerializedName("eventlist")
    public Map<String, Long> eventList;
    @SerializedName("groupname")
    protected String groupname;
    @SerializedName("reason")
    protected Reason reason;

    public enum Reason {
        START,
        REPOS,
        REBUFFER,
        SKIP
    }

    protected StartPlayEventJson() {
    }

    public StartPlayEventJson(String str) {
        super("startplayevents", str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public StartPlayEventJson m1119(String str) {
        if (TextUtils.isEmpty(str)) {
            this.groupname = "control";
        } else {
            this.groupname = str;
        }
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public StartPlayEventJson m1118(long j) {
        m8547(j);
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public StartPlayEventJson m1121(Reason reason2) {
        this.reason = reason2;
        return this;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public StartPlayEventJson m1120(Map<String, Long> map) {
        this.eventList = new HashMap(map);
        return this;
    }
}
