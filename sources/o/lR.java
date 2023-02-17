package o;

import android.os.SystemClock;
public class lR {

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f8555;

    public lR() {
        this(SystemClock.elapsedRealtime());
    }

    lR(long j) {
        this.f8555 = j;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public long m8660() {
        return SystemClock.elapsedRealtime() - this.f8555;
    }
}
