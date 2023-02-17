package o;

import com.netflix.mediaclient.servicemgr.PlayerPrefetchSource;
/* renamed from: o.pc  reason: case insensitive filesystem */
public class C2054pc {

    /* renamed from: ˊ  reason: contains not printable characters */
    public final long f9378;

    /* renamed from: ˋ  reason: contains not printable characters */
    public final oX f9379;

    /* renamed from: ˎ  reason: contains not printable characters */
    public final PlayerPrefetchSource f9380;

    /* renamed from: ˏ  reason: contains not printable characters */
    public final long f9381;

    /* renamed from: ॱ  reason: contains not printable characters */
    public final String f9382;

    public C2054pc(String str, long j, PlayerPrefetchSource playerPrefetchSource, oX oXVar) {
        this.f9382 = str;
        this.f9378 = j;
        this.f9381 = Long.parseLong(str);
        this.f9380 = playerPrefetchSource;
        this.f9379 = oXVar;
    }

    public String toString() {
        return "PlayerPrepareRequest{mVideoId='" + this.f9382 + "', mPrefetchSource=" + this.f9380 + ", mPlayContext=" + this.f9379 + ", mPlayableId=" + this.f9381 + ", mBookmark=" + this.f9378 + '}';
    }
}
