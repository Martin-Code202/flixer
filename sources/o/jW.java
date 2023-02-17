package o;

import android.net.Uri;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.List;
public class jW extends DashManifest {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final long[] f7989;

    public jW(long j, long j2, long j3, boolean z, long j4, long j5, long j6, UtcTimingElement utcTimingElement, Uri uri, List<Period> list, long[] jArr) {
        super(j, j2, j3, z, j4, j5, j6, utcTimingElement, uri, list);
        this.f7989 = jArr;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public long[] m7976() {
        return this.f7989;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static long[] m7975(byte[] bArr) {
        long j;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        int integerCodeForString = Util.getIntegerCodeForString("sidx");
        int position = wrap.position();
        int i = wrap.getInt();
        if (wrap.getInt() != integerCodeForString) {
            return null;
        }
        int i2 = (wrap.getInt() >> 24) & 255;
        wrap.getInt();
        int i3 = wrap.getInt();
        if (i2 == 0) {
            j = (long) wrap.getInt();
            wrap.getInt();
        } else {
            j = wrap.getLong();
            wrap.getLong();
        }
        wrap.getShort();
        int i4 = wrap.getShort();
        if (i < (i4 * 12) + (wrap.position() - position)) {
            return null;
        }
        long[] jArr = new long[i4];
        long j2 = j;
        for (int i5 = 0; i5 < i4; i5++) {
            wrap.getInt();
            int i6 = wrap.getInt();
            wrap.getInt();
            jArr[i5] = Util.scaleLargeTimestamp(j2, 1000000, (long) i3);
            j2 += (long) i6;
        }
        return jArr;
    }
}
