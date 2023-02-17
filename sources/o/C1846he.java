package o;

import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.service.logging.client.model.Event;
import java.util.ArrayList;
import java.util.List;
import o.gY;
/* access modifiers changed from: package-private */
/* renamed from: o.he  reason: case insensitive filesystem */
public class C1846he {
    @SerializedName("name")
    private String name;
    @SerializedName(Event.DATA)
    private List<If> pulses = new ArrayList();
    @SerializedName("url")
    private String url;
    @SerializedName("via")
    private String via;

    /* renamed from: ˎ  reason: contains not printable characters */
    private If f7223;

    /* renamed from: ˏ  reason: contains not printable characters */
    private transient boolean f7224;

    protected C1846he() {
    }

    public C1846he(gY.If r2) {
        this.name = r2.m6637();
        this.url = r2.m6638();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7044(AbstractC0633 r3) {
        if (r3.mo14763() != null) {
            this.via = r3.mo14763();
        }
        if (!this.f7224) {
            this.f7223.m7049(r3);
            if (this.f7223.m7048()) {
                this.pulses.add(this.f7223);
                this.f7223 = null;
                this.f7224 = true;
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m7045(long j) {
        if (!this.f7224) {
            this.f7223.m7047(j);
            if (this.f7223.m7048()) {
                this.pulses.add(this.f7223);
                this.f7223 = null;
                this.f7224 = true;
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7043() {
        this.f7224 = false;
        this.f7223 = new If();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m7046() {
        return this.f7224;
    }

    /* renamed from: o.he$If */
    public static class If {
        @SerializedName("dns")
        private Long dnsLookup;
        @SerializedName("d")
        private Long duration;
        @SerializedName("sc")
        private Integer httpStatusCode;
        @SerializedName("sz")
        private Long payloadSize;
        @SerializedName("tcp")
        private Long tcpConnect;
        @SerializedName("ttfb")
        private Long timeToFirstByte;
        @SerializedName("tls")
        private Long tlsConnect;

        /* access modifiers changed from: package-private */
        /* renamed from: ॱ  reason: contains not printable characters */
        public void m7049(AbstractC0633 r5) {
            this.tcpConnect = r5.mo14766() >= 0 ? Long.valueOf(r5.mo14766()) : null;
            this.tlsConnect = r5.mo14767() >= 0 ? Long.valueOf(r5.mo14767()) : null;
            this.dnsLookup = r5.mo14764() >= 0 ? Long.valueOf(r5.mo14764()) : null;
            this.timeToFirstByte = r5.mo14770() >= 0 ? Long.valueOf(r5.mo14770()) : null;
            this.httpStatusCode = Integer.valueOf(r5.mo14762());
            this.duration = r5.mo14769() >= 0 ? Long.valueOf(r5.mo14769()) : null;
            if (r5.mo14765()) {
                return;
            }
            if (r5.mo14761() == 4 || r5.mo14761() == 6) {
                this.httpStatusCode = -1;
            } else {
                this.httpStatusCode = 0;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public void m7047(long j) {
            this.payloadSize = Long.valueOf(j);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public boolean m7048() {
            return this.httpStatusCode != null && (this.httpStatusCode.intValue() < 200 || this.httpStatusCode.intValue() >= 300 || this.payloadSize != null);
        }
    }
}
