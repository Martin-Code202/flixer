package o;

import android.content.Context;
import android.os.Handler;
import android.util.Range;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.AdaptiveStreamingEngineFactory;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState;
import java.util.concurrent.TimeUnit;
import o.kT;
/* renamed from: o.kl  reason: case insensitive filesystem */
public class C1941kl extends AbstractC1917jr implements IAsePlayerState {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final IAsePlayerState.If f8417;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C1937kh f8418;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final kv f8419;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C1940kk f8420;

    public C1941kl(Context context, Handler handler, AbstractC1933kd kdVar, kS kSVar, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, long j, kK kKVar, kA kAVar, kF kFVar, C1938ki kiVar, lH lHVar, C1962lu luVar, String str, PriorityTaskManager priorityTaskManager) {
        int r9;
        this.f8417 = new IAsePlayerState.If(kSVar.m8323(), C2036ol.m9673());
        if (kiVar.mo8384() != null && C1947kr.m8433(kiVar.mo8384().m8436()) && (r9 = kiVar.m8387(kSVar.m8323())) > 0 && r9 < Integer.MAX_VALUE) {
            this.f8417.m1012(new Range<>(0, Integer.valueOf(r9)));
        }
        this.f8419 = AdaptiveStreamingEngineFactory.m1005(kKVar, kAVar, this, kFVar, kiVar, str);
        this.f8040 = (MappingTrackSelector) this.f8419.m8449();
        this.f8039 = ExoPlayerFactory.newSimpleInstance(new C1922jw(context, drmSessionManager, 0), this.f8419.m8449(), this.f8419.m8450());
        kZ kZVar = (kZ) this.f8419.m8447();
        this.f8420 = new C1940kk(handler, kdVar, this.f8039, priorityTaskManager);
        lHVar.m8583(this.f8039);
        lHVar.m8601(this);
        lHVar.m8594(this.f8420);
        lHVar.m8595(kZVar);
        lHVar.m8605(kiVar);
        lHVar.m8588(this.f8419.m8451());
        kKVar.m8236(this.f8420.m8412());
        kT.iF iFVar = new kT.iF(new C1960lr(this.f8419.m8452(), this.f8419.m8448(), this.f8420, luVar, this.f8419.m8446()), this.f8419.m8453(), this.f8420.m8411(), this.f8420.m8408());
        this.f8039.addListener(this.f8420);
        m8416(kSVar, iFVar, handler, this.f8420, this.f8419.m8453(), j);
        this.f8039.setVideoDebugListener(this.f8420);
        this.f8039.setAudioDebugListener(this.f8420);
        this.f8418 = null;
        lHVar.m8590(kKVar, kAVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8416(kS kSVar, kT.iF iFVar, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener, C1943kn knVar, long j) {
        m8032(new kR(kSVar, iFVar, handler, adaptiveMediaSourceEventListener, knVar));
        this.f8039.seekTo(j);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8414(long j) {
        this.f8039.seekTo(j);
    }

    @Override // o.AbstractC1917jr
    /* renamed from: ˊ */
    public void mo7981() {
        this.f8039.setVideoDebugListener(null);
        this.f8039.removeListener(this.f8420);
        this.f8420.m8410();
        if (this.f8418 != null) {
            this.f8418.m8380();
        }
        super.mo7981();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8415(int i, int i2) {
        this.f8417.m1012(new Range<>(Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState
    /* renamed from: ᐝ */
    public IAsePlayerState.AsePlayerState mo1011() {
        switch (this.f8039.getPlaybackState()) {
            case 1:
            default:
                return IAsePlayerState.AsePlayerState.ASE_PLAYER_IDLE;
            case 2:
                return IAsePlayerState.AsePlayerState.ASE_PLAYER_BUFFERING;
            case 3:
                if (this.f8039.getCurrentPosition() == this.f8039.getBufferedPosition()) {
                    return IAsePlayerState.AsePlayerState.ASE_PLAYER_BUFFERING;
                }
                return this.f8039.getPlayWhenReady() ? IAsePlayerState.AsePlayerState.ASE_PLAYER_PLAYING : IAsePlayerState.AsePlayerState.ASE_PLAYER_PAUSED;
            case 4:
                return IAsePlayerState.AsePlayerState.ASE_PLAYER_ENDED;
        }
    }

    @Override // com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState
    /* renamed from: ʻ */
    public long mo1007() {
        return TimeUnit.MILLISECONDS.toMicros(this.f8039.getCurrentPosition());
    }

    @Override // com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState
    /* renamed from: ʼ */
    public IAsePlayerState.Cif[] mo1008() {
        return this.f8420.m8409(this.f8039.getCurrentPosition());
    }

    @Override // com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState
    /* renamed from: ˏॱ */
    public IAsePlayerState.C1288iF[] mo1009() {
        return this.f8420.m8405();
    }

    @Override // com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState
    /* renamed from: ॱˊ */
    public IAsePlayerState.If mo1010() {
        return this.f8417;
    }
}
