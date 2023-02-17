package o;

import android.os.Handler;
import android.util.Pair;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.netflix.mediaclient.service.player.offlineplayback.ExoPlaybackError;
import com.netflix.mediaclient.service.player.offlineplayback.OfflinePlaybackState;
import org.json.JSONObject;
public class jT extends AbstractC1916jq {

    /* renamed from: ʼ  reason: contains not printable characters */
    private Pair<Integer, Integer> f7977 = Pair.create(0, 0);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Handler f7978;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f7979 = 1;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1894iv f7980;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f7981;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f7982;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private jQ f7983;

    public jT(AbstractC1894iv ivVar, Handler handler) {
        this.f7980 = ivVar;
        this.f7978 = handler;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public JSONObject m7974() {
        JSONObject r0;
        if (this.f7983 == null) {
            return null;
        }
        synchronized (this.f7983) {
            r0 = this.f7983.m7967();
        }
        return r0;
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerStateChanged(final boolean z, final int i) {
        this.f7978.post(new Runnable() { // from class: o.jT.3
            @Override // java.lang.Runnable
            public void run() {
                if (i == 3 && i != jT.this.f7979 && !jT.this.f7981) {
                    jT.this.f7980.F_();
                }
                if (i == 3) {
                    if (z) {
                        jT.this.f7980.H_();
                        jT.this.f7981 = true;
                    } else if (jT.this.f7981) {
                        jT.this.f7980.G_();
                    }
                }
                if (i == 2) {
                    jT.this.f7980.mo900(false);
                }
                if (i == 4) {
                    jT.this.f7980.I_();
                    jT.this.f7981 = false;
                }
                jT.this.f7979 = i;
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerError(final ExoPlaybackException exoPlaybackException) {
        this.f7978.post(new Runnable() { // from class: o.jT.4
            @Override // java.lang.Runnable
            public void run() {
                jT.this.f7980.mo908(new ExoPlaybackError(ExoPlaybackError.ExoPlaybackErrorCode.PLAYER_ERROR, exoPlaybackException.toString(), OfflinePlaybackState.PLAYBACK_PLAY.toString(), C1283.m16857(exoPlaybackException)));
            }
        });
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoDecoderInitialized(String str, long j, long j2) {
        this.f7982 = str;
        this.f7983 = new jQ(this.f7982);
    }

    @Override // o.AbstractC1916jq, com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onDroppedFrames(int i, long j) {
        if (this.f7983 != null) {
            this.f7983.m7968(i, j);
        }
    }

    @Override // o.AbstractC1916jq, com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoSizeChanged(int i, int i2, int i3, float f) {
        this.f7977 = Pair.create(Integer.valueOf(i), Integer.valueOf(i2));
    }
}
