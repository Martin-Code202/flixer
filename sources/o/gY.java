package o;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
/* access modifiers changed from: package-private */
public class gY {
    @SerializedName("ctx")
    private JsonObject context;
    @SerializedName("logblob")
    private String logblob;
    @SerializedName(SignupConstants.Message.NEXT)
    private Long next;
    @SerializedName("pulse_delay")
    private Long pulseDelay;
    @SerializedName("pulse_timeout")
    private Long pulseTimeout;
    @SerializedName("pulses")
    private Integer pulses;
    @SerializedName("urls")
    private If[] urls;

    gY() {
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m6633() {
        if (this.pulses == null || this.pulses.intValue() < 0) {
            return 0;
        }
        return this.pulses.intValue();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public long m6632() {
        if (this.next == null || this.next.longValue() < 0) {
            return 0;
        }
        return this.next.longValue();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m6635() {
        return m6632() > 0;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public If[] m6636() {
        return this.urls == null ? new If[0] : this.urls;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public long m6634() {
        if (this.pulseDelay == null || this.pulseDelay.longValue() < 0) {
            return 0;
        }
        return this.pulseDelay.longValue();
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m6630() {
        return this.logblob == null ? "ftlProbe" : this.logblob;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public JsonObject m6631() {
        return this.context;
    }

    public static class If {
        @SerializedName("name")
        private String name;
        @SerializedName("url")
        private String url;

        /* renamed from: ˊ  reason: contains not printable characters */
        public String m6637() {
            return this.name;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public String m6638() {
            return this.url;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public boolean m6639() {
            return !TextUtils.isEmpty(this.url);
        }
    }
}
