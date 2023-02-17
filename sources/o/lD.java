package o;

import com.google.gson.annotations.SerializedName;
/* access modifiers changed from: package-private */
public class lD extends lC {
    @SerializedName("newtrackinfo")
    protected Cif newTrackInfo;
    @SerializedName("oldtrackinfo")
    protected Cif oldTrackInfo;
    @SerializedName("switchdelay")
    protected Long switchDelay;

    protected lD() {
    }

    public lD(String str) {
        super("audioswitch", str);
    }

    /* renamed from: o.lD$if  reason: invalid class name */
    public static class Cif {
        @SerializedName("chan")
        protected int channels;
        @SerializedName("lang")
        protected String language;

        public Cif(String str, int i) {
            this.language = str;
            this.channels = i;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public lD m8550(Cif ifVar) {
        this.oldTrackInfo = ifVar;
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public lD m8551(Cif ifVar) {
        this.newTrackInfo = ifVar;
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public lD m8553(long j) {
        m8547(j);
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public lD m8552(long j) {
        this.switchDelay = Long.valueOf(j);
        return this;
    }
}
