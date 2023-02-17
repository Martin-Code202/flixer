package o;

import java.util.concurrent.TimeUnit;
/* renamed from: o.Bi  reason: case insensitive filesystem */
public class C1336Bi {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final long f4648;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f4649;

    /* renamed from: ˎ  reason: contains not printable characters */
    private long f4650;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f4651;

    public C1336Bi(int i, long j) {
        this.f4651 = i;
        this.f4648 = j;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m4022() {
        this.f4649++;
        if (this.f4649 == 1) {
            this.f4650 = System.currentTimeMillis();
        }
        if (this.f4649 > this.f4651 && System.currentTimeMillis() - this.f4650 <= this.f4648) {
            C1283.m16844("nf_RateLimiter", "onNewEvent too fast mEventCounter=%d timeDuration=%d", Integer.valueOf(this.f4649), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.f4650)));
            return true;
        } else if (System.currentTimeMillis() - this.f4650 <= this.f4648) {
            return false;
        } else {
            C1283.m16862("nf_RateLimiter", "onNewEvent time window over, resetting mEventCounter");
            this.f4649 = 0;
            return false;
        }
    }
}
