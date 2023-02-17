package o;

import android.os.SystemClock;
import com.google.android.exoplayer2.util.Clock;
/* renamed from: o.lw  reason: case insensitive filesystem */
public final class C1964lw implements Clock {
    @Override // com.google.android.exoplayer2.util.Clock
    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }
}
