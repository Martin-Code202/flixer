package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Util;
import java.util.UUID;
public final class C {
    public static final int CHANNEL_OUT_7POINT1_SURROUND = (Util.SDK_INT < 23 ? 1020 : 6396);
    public static final UUID CLEARKEY_UUID = new UUID(1186680826959645954L, -5988876978535335093L);
    public static final UUID PLAYREADY_UUID = new UUID(-7348484286925749626L, -6083546864340672619L);
    public static final UUID UUID_NIL = new UUID(0, 0);
    public static final UUID WIDEVINE_UUID = new UUID(-1301668207276963122L, -6645017420763422227L);

    public static long usToMs(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }

    public static long msToUs(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : 1000 * j;
    }
}
