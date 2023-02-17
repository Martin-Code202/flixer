package o;

import android.net.Uri;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement;
import com.netflix.mediaclient.service.player.StreamProfileType;
import java.util.List;
public class kS extends DashManifest {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final StreamProfileType f8316;

    /* renamed from: ˋ  reason: contains not printable characters */
    private long f8317 = 0;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Long f8318;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final kH f8319;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final kF f8320;

    public kS(long j, long j2, long j3, boolean z, long j4, long j5, long j6, UtcTimingElement utcTimingElement, Uri uri, List<Period> list, kF kFVar, kH kHVar, StreamProfileType streamProfileType, Long l) {
        super(j, j2, j3, z, j4, j5, j6, utcTimingElement, uri, list);
        this.f8320 = kFVar;
        this.f8319 = kHVar;
        this.f8316 = streamProfileType;
        this.f8318 = l;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Long m8322() {
        return this.f8318;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public kF m8325() {
        return this.f8320;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public kH m8324() {
        return this.f8319;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public StreamProfileType m8323() {
        return this.f8316;
    }
}
