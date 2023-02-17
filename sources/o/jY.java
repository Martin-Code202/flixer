package o;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
public class jY extends AbstractC1917jr {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final jT f7991;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC1894iv f7992;

    /* renamed from: ˋ  reason: contains not printable characters */
    public static jY m7980(Context context, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Handler handler, AbstractC1894iv ivVar, DashManifest dashManifest, long j) {
        return new jY(new C1922jw(context, drmSessionManager, 0), new DefaultTrackSelector(), ivVar, new DashMediaSource(dashManifest, new DefaultDashChunkSource.Factory(new DefaultDataSourceFactory(context, Util.getUserAgent(context, jY.class.getName()))), null, null), handler, j);
    }

    private jY(RenderersFactory renderersFactory, MappingTrackSelector mappingTrackSelector, AbstractC1894iv ivVar, DashMediaSource dashMediaSource, Handler handler, long j) {
        this.f8040 = mappingTrackSelector;
        this.f8039 = ExoPlayerFactory.newSimpleInstance(renderersFactory, this.f8040);
        this.f7992 = ivVar;
        this.f7991 = new jT(this.f7992, handler);
        this.f8039.addListener(this.f7991);
        if (j > 0) {
            this.f8039.seekTo(j);
        }
        m8032(dashMediaSource);
        this.f8039.setVideoDebugListener(this.f7991);
        m8038();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public JSONObject m7983() {
        return this.f7991.m7974();
    }

    @Override // o.AbstractC1917jr
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo7982(long j) {
        long[] r7;
        int binarySearch;
        long j2 = j;
        if ((this.f8039.getCurrentManifest() instanceof jW) && (r7 = ((jW) this.f8039.getCurrentManifest()).m7976()) != null && r7.length > 0 && (binarySearch = Arrays.binarySearch(r7, TimeUnit.MILLISECONDS.toMicros(j))) < 0) {
            int i = (-binarySearch) - 2;
            j2 = i <= 0 ? TimeUnit.MICROSECONDS.toMillis(r7[0]) : TimeUnit.MICROSECONDS.toMillis(r7[i]);
        }
        C1283.m16851("OfflineExoSessionPlayer", "seek to %d s => %d s.", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j2)));
        super.mo7982(j2);
    }

    @Override // o.AbstractC1917jr
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo7981() {
        this.f8039.setVideoDebugListener(null);
        this.f8039.removeListener(this.f7991);
        super.mo7981();
    }
}
