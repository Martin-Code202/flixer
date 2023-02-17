package o;

import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import org.json.JSONObject;
/* renamed from: o.gf  reason: case insensitive filesystem */
public class C1820gf {

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f6958 = -1;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f6959 = false;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f6960;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6961;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f6962;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6963;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6964;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private String f6965;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f6966;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f6967 = -1;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f6968 = -1;

    public C1820gf(JSONObject jSONObject) {
        this.f6964 = jSONObject.optString("xid");
        this.f6966 = jSONObject.optString("catalogId");
        this.f6958 = jSONObject.optInt(SessionEndedEvent.DURATION, -1);
        this.f6968 = jSONObject.optInt("time", -1);
        this.f6967 = jSONObject.optInt("volume", -1);
        this.f6961 = jSONObject.optString("currentState");
        this.f6962 = jSONObject.optString("episodeId");
        this.f6963 = AK.m3376(jSONObject, "autoAdvanceIncrement", "0");
        this.f6960 = jSONObject.optString("postplayState");
        if (C0908.m15705()) {
            this.f6959 = jSONObject.optBoolean("isInSkipIntroWindow");
            this.f6965 = jSONObject.optString("skipIntroText");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m6658() {
        return this.f6961;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m6657() {
        return this.f6964;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m6656() {
        return this.f6966;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m6654() {
        return this.f6962;
    }

    public String toString() {
        return "PlayerCurrentState [currentState=" + this.f6961 + ", xid=" + this.f6964 + ", catalogId=" + this.f6966 + ", episodeId=" + this.f6962 + ", isInSkipIntroWindow=" + this.f6959 + "]";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m6655() {
        return this.f6968;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public int m6660() {
        return this.f6958;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public int m6653() {
        return this.f6967;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public String m6659() {
        return this.f6960;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean m6652() {
        return this.f6959;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m6651() {
        return this.f6965;
    }
}
