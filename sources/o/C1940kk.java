package o;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.netflix.mediaclient.service.logging.pdslogging.streaming.IPdsPlayTimes;
import com.netflix.mediaclient.service.player.streamingplayback.StreamingPlaybackErrorCode;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState;
import java.io.IOException;
import o.AbstractC1933kd;
/* renamed from: o.kk  reason: case insensitive filesystem */
public class C1940kk extends AbstractC1916jq implements AdaptiveMediaSourceEventListener {

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f8400;

    /* renamed from: ʼ  reason: contains not printable characters */
    private DecoderCounters f8401;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f8402;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final lS f8403;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean f8404;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final SimpleExoPlayer f8405;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final C1939kj f8406 = new C1939kj();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1933kd f8407;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Handler f8408;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final C1939kj f8409 = new C1939kj();

    /* renamed from: ͺ  reason: contains not printable characters */
    private boolean f8410;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final PriorityTaskManager f8411;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f8412;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final Runnable f8413 = new Runnable() { // from class: o.kk.3
        @Override // java.lang.Runnable
        public void run() {
            C1940kk.this.f8407.mo7498((int) C1940kk.this.f8405.getCurrentPosition());
            if (C1940kk.this.f8402) {
                C1940kk.this.f8408.postDelayed(this, 500);
            }
        }
    };

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f8414;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private DecoderCounters f8415;

    public C1940kk(Handler handler, AbstractC1933kd kdVar, SimpleExoPlayer simpleExoPlayer, PriorityTaskManager priorityTaskManager) {
        this.f8408 = handler;
        this.f8407 = kdVar;
        this.f8405 = simpleExoPlayer;
        this.f8403 = new lS(handler);
        this.f8411 = priorityTaskManager;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m8410() {
        this.f8402 = false;
        if (this.f8411 != null) {
            synchronized (this.f8411) {
                this.f8411.remove(0);
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1939kj m8411() {
        return this.f8409;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1939kj m8408() {
        return this.f8406;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public lS m8412() {
        return this.f8403;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m8407() {
        return this.f8414;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public DecoderCounters m8413() {
        return this.f8401;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public String m8406() {
        return this.f8400;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public DecoderCounters m8404() {
        return this.f8415;
    }

    @Override // o.AbstractC1916jq, com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoEnabled(DecoderCounters decoderCounters) {
        this.f8407.mo7496("videoEnabled");
        this.f8401 = decoderCounters;
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoDecoderInitialized(String str, long j, long j2) {
        this.f8407.mo7496("videoDecoderInitialized");
        this.f8414 = str;
    }

    @Override // o.AbstractC1916jq, com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onRenderedFirstFrame(Surface surface) {
        this.f8407.mo7496("renderedFrame");
        C1283.m16851("ASE-stats", "onRenderedFirstFrame %d", Long.valueOf(this.f8405.getCurrentPosition()));
    }

    @Override // o.AbstractC1916jq, com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioDecoderInitialized(String str, long j, long j2) {
        this.f8407.mo7496("audioDecoderInitialized");
        this.f8400 = str;
    }

    @Override // o.AbstractC1916jq, com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioEnabled(DecoderCounters decoderCounters) {
        this.f8407.mo7496("audioEnabled");
        this.f8415 = decoderCounters;
    }

    @Override // o.AbstractC1916jq, com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioInputFormatChanged(Format format) {
        this.f8407.mo7496("audioInputChanged");
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerStateChanged(boolean z, int i) {
        switch (i) {
            case 1:
            default:
                return;
            case 2:
                this.f8404 = true;
                this.f8407.mo900(false);
                return;
            case 3:
                if (this.f8404) {
                    this.f8407.J_();
                }
                if (!this.f8402) {
                    this.f8407.F_();
                    this.f8402 = true;
                    if (z) {
                        this.f8407.H_();
                        this.f8408.post(this.f8413);
                    }
                } else if (z) {
                    C1283.m16851("ASE-stats", "playerStarted %d", Long.valueOf(this.f8405.getCurrentPosition()));
                    this.f8407.H_();
                    this.f8408.post(this.f8413);
                } else if (this.f8404) {
                    this.f8405.setPlayWhenReady(true);
                } else {
                    this.f8407.G_();
                    this.f8408.removeCallbacks(this.f8413);
                }
                this.f8404 = false;
                return;
            case 4:
                this.f8407.I_();
                this.f8408.removeCallbacks(this.f8413);
                return;
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        this.f8407.mo908(new C1934ke(StreamingPlaybackErrorCode.MEDIA_PLAYBACK_ERROR));
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0025: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v1 java.lang.String) */
    @Override // com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener
    public void onLoadStarted(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3) {
        if (!this.f8410 && i2 == 2 && j >= 0) {
            this.f8405.seekTo(j);
            this.f8410 = true;
        }
        Object[] objArr = new Object[5];
        objArr[0] = i2 == 2 ? "V" : "A";
        objArr[1] = Integer.valueOf(format.bitrate);
        objArr[2] = Long.valueOf(dataSpec.length);
        objArr[3] = Long.valueOf(j == -9223372036854775807L ? -1 : j);
        objArr[4] = Long.valueOf(j2 == -9223372036854775807L ? -1 : j2);
        C1283.m16851("ASE-stats", "MediaSource onLoadStarted %s bitrate = %d size = %d start = %dms end = %dms", objArr);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0010: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v1 java.lang.String) */
    @Override // com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener
    public void onLoadCompleted(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        Object[] objArr = new Object[4];
        objArr[0] = i2 == 2 ? "V" : "A";
        objArr[1] = Integer.valueOf(format.bitrate);
        objArr[2] = Long.valueOf(j == -9223372036854775807L ? -1 : j);
        objArr[3] = Long.valueOf(j2 == -9223372036854775807L ? -1 : j2);
        C1283.m16851("ASE-stats", "MediaSource onLoadCompleted %s bitrate = %d start = %dms end = %dms", objArr);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0010: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v1 java.lang.String) */
    @Override // com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener
    public void onLoadCanceled(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        Object[] objArr = new Object[2];
        objArr[0] = i2 == 2 ? "V" : "A";
        objArr[1] = Integer.valueOf(format.bitrate);
        C1283.m16851("ASE-stats", "MediaSource onLoadCanceled %s %d", objArr);
        m8399(i2, j, dataSpec);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0010: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v1 java.lang.String) */
    @Override // com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener
    public void onLoadError(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
        Object[] objArr = new Object[2];
        objArr[0] = i2 == 2 ? "V" : "A";
        objArr[1] = Integer.valueOf(format.bitrate);
        C1283.m16864("ASE-stats", iOException, "MediaSource onLoadError %s %d", objArr);
    }

    @Override // com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener
    public void onDownstreamFormatChanged(int i, Format format, int i2, Object obj, long j) {
        if (i == 2) {
            this.f8407.mo7502(j, new AbstractC1933kd.iF(format.id, (long) format.bitrate));
            this.f8407.mo7503(new C1944ko(IPdsPlayTimes.StreamType.VIDEO, format.id));
        } else if (i == 1) {
            this.f8407.mo7503(new C1944ko(IPdsPlayTimes.StreamType.AUDIO, format.id));
        }
    }

    @Override // o.AbstractC1916jq, com.google.android.exoplayer2.Player.EventListener
    public void onLoadingChanged(boolean z) {
        if (this.f8411 != null) {
            synchronized (this.f8411) {
                if (z) {
                    this.f8411.add(0);
                } else {
                    this.f8411.remove(0);
                }
                this.f8412 = z;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public IAsePlayerState.Cif[] m8409(long j) {
        IAsePlayerState.Cif[] ifVarArr = new IAsePlayerState.Cif[2];
        ifVarArr[1] = this.f8406.m8394(j);
        ifVarArr[0] = this.f8409.m8394(j);
        return ifVarArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʼ  reason: contains not printable characters */
    public IAsePlayerState.C1288iF[] m8405() {
        IAsePlayerState.C1288iF[] iFVarArr = new IAsePlayerState.C1288iF[2];
        iFVarArr[1] = this.f8406.m8397();
        iFVarArr[0] = this.f8409.m8397();
        return iFVarArr;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8399(int i, long j, DataSpec dataSpec) {
        if (j < 0) {
            return;
        }
        if (i == 2) {
            this.f8406.m8396((long) i, dataSpec);
        } else if (i == 1) {
            this.f8409.m8396((long) i, dataSpec);
        }
    }
}
