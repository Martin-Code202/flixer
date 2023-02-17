package o;

import com.google.android.exoplayer2.C;
/* renamed from: o.ku  reason: case insensitive filesystem */
public class C1950ku {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final long f8459;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final long f8460;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final long f8461;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final long f8462;

    public C1950ku(long j, long j2, long j3, long j4) {
        this.f8461 = j;
        this.f8460 = j2;
        this.f8459 = j3;
        this.f8462 = j4;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public long m8441() {
        return this.f8461;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public long m8442() {
        return this.f8460;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public long m8443() {
        return this.f8459;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public long m8444() {
        return this.f8459 + this.f8462;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public long m8440() {
        return this.f8462;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public long m8445() {
        return this.f8461 + this.f8460;
    }

    public String toString() {
        return "ChunkInfo{pts=(" + C.usToMs(m8441()) + "ms," + C.usToMs(m8445()) + "ms), bytes=(" + m8443() + "," + m8444() + ")}";
    }
}
