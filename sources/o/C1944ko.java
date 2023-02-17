package o;

import com.netflix.mediaclient.service.logging.pdslogging.streaming.IPdsPlayTimes;
/* renamed from: o.ko  reason: case insensitive filesystem */
public class C1944ko implements AbstractC0542 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private IPdsPlayTimes.StreamType f8432;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f8433;

    public C1944ko(IPdsPlayTimes.StreamType streamType, String str) {
        this.f8432 = streamType;
        this.f8433 = str;
    }

    @Override // o.AbstractC0542
    /* renamed from: ˏ  reason: contains not printable characters */
    public IPdsPlayTimes.StreamType mo8418() {
        return this.f8432;
    }

    @Override // o.AbstractC0542
    /* renamed from: ˋ  reason: contains not printable characters */
    public String mo8417() {
        return this.f8433;
    }

    public String toString() {
        return "ExoStreamPresenting{type=" + this.f8432 + ", id=" + this.f8433 + "}";
    }
}
