package o;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.gson.Gson;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.PlaybackMetadataImpl;
import com.netflix.mediaclient.service.player.streamingplayback.StreamingPlaybackErrorCode;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.CurrentNetworkInfo;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.DlReportJson;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.EndPlayJson;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.ExitPipPlayJson;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.PlaybackAbortedJson;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.PlayerStateMachine;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.ResumePlayJson;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.StartPlayEventJson;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.StateChangedJson;
import com.netflix.mediaclient.service.player.streamingplayback.playbackreporter.ErrorCodeUtils;
import com.netflix.mediaclient.service.player.streamingplayback.playbackreporter.LogAudioSinkType;
import com.netflix.mediaclient.service.player.streamingplayback.playbackreporter.StopReason;
import com.netflix.mediaclient.servicemgr.ExitPipAction;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import com.netflix.mediaclient.servicemgr.Logblob;
import com.netflix.mediaclient.util.activitytracking.ActivityTracker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import o.AbstractC1933kd;
import o.AbstractC1952kz;
import o.lD;
import o.lQ;
import o.lS;
import org.chromium.net.RequestFinishedInfo;
import org.json.JSONObject;
public class lH implements AbstractC1952kz.AbstractC1953iF, lV, lQ.AbstractC0144, PlayerStateMachine.If, lS.AbstractC0146 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final long f8506 = TimeUnit.MINUTES.toMillis(2);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final HandlerThread f8507;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private lR f8508 = new lR();

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f8509;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private C1965lx f8510;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final lQ f8511;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private lL f8512;

    /* renamed from: ʾ  reason: contains not printable characters */
    private lR f8513 = new lR();

    /* renamed from: ʿ  reason: contains not printable characters */
    private EndPlayJson f8514;

    /* renamed from: ˈ  reason: contains not printable characters */
    private DlReportJson f8515;

    /* renamed from: ˉ  reason: contains not printable characters */
    private AbstractC1952kz.If f8516;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Context f8517;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private Map<String, Long> f8518 = new HashMap();

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private AbstractC1952kz.C0142 f8519;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private AbstractC1952kz f8520;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private CurrentNetworkInfo f8521;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f8522;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private lD f8523;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private long f8524;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private C1940kk f8525;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private boolean f8526;

    /* renamed from: ˌ  reason: contains not printable characters */
    private PlayerStateMachine f8527 = new PlayerStateMachine();

    /* renamed from: ˍ  reason: contains not printable characters */
    private lR f8528;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private AbstractC1933kd.iF f8529;

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private final Runnable f8530 = new Runnable() { // from class: o.lH.3
        @Override // java.lang.Runnable
        public void run() {
            Logblob r4;
            if (lH.this.f8541) {
                lH.this.f8542.removeCallbacks(lH.this.f8530);
                return;
            }
            if (!lH.this.f8515.m1057()) {
                synchronized (lH.this.f8515) {
                    r4 = lH.this.f8515.mo8548();
                    lH.this.f8515.m1059();
                }
                lH.this.m8569(r4);
            }
            lH.this.f8542.postDelayed(lH.this.f8530, lH.f8506);
        }
    };

    /* renamed from: ˏ  reason: contains not printable characters */
    private final oQ f8531;

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private lX f8532;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private ActivityTracker f8533;

    /* renamed from: ˑ  reason: contains not printable characters */
    private final Runnable f8534 = new Runnable() { // from class: o.lH.4
        @Override // java.lang.Runnable
        public void run() {
            Logblob r4;
            if (lH.this.f8541) {
                lH.this.f8542.removeCallbacks(lH.this.f8534);
                return;
            }
            if (!lH.this.f8510.m8765()) {
                synchronized (lH.this.f8510) {
                    r4 = lH.this.f8510.mo8548();
                    lH.this.f8510.m8764();
                }
                lH.this.m8569(r4);
            }
            lH.this.f8542.postDelayed(lH.this.f8534, lH.f8506);
        }
    };

    /* renamed from: ͺ  reason: contains not printable characters */
    private IAsePlayerState f8535;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final PlaybackMetadataImpl f8536;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private BandwidthMeter f8537;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private long f8538;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private lR f8539;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private ExoPlayer f8540;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private boolean f8541;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final Handler f8542;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private lM f8543 = new lM();

    public lH(Context context, oQ oQVar, AbstractC1983mn mnVar, PlaybackMetadataImpl playbackMetadataImpl, String str, boolean z, String str2, String str3) {
        this.f8517 = context;
        this.f8531 = oQVar;
        this.f8522 = str;
        this.f8526 = z;
        this.f8536 = playbackMetadataImpl;
        this.f8507 = new HandlerThread("playreport");
        this.f8507.start();
        this.f8542 = new Handler(this.f8507.getLooper());
        this.f8511 = new lQ(context, this.f8542, this);
        this.f8527.m1100(this);
        this.f8512 = new lL(str);
        this.f8514 = new EndPlayJson(str).m1071(str3);
        this.f8515 = new DlReportJson(str, 0);
        this.f8510 = new C1965lx(str);
        this.f8509 = str2;
        mo8591();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m8595(AbstractC1952kz kzVar) {
        this.f8520 = kzVar;
        kzVar.mo8357(this);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m8605(AbstractC1949kt ktVar) {
        this.f8512.m8629(ktVar.mo8383());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8583(ExoPlayer exoPlayer) {
        this.f8540 = exoPlayer;
        this.f8527.m1104(exoPlayer);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m8594(C1940kk kkVar) {
        this.f8525 = kkVar;
        kkVar.m8412().m8677(this);
        kkVar.m8412().m8676(this.f8521);
        if (this.f8543.m8649()) {
            kkVar.m8412().m8674();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8590(AbstractC1951ky kyVar, kA kAVar) {
        long msToUs = C.msToUs(m8574());
        List<C1948ks> r8 = kAVar.mo8178(1, msToUs);
        List<C1948ks> r9 = kAVar.mo8178(2, msToUs);
        if (!r8.isEmpty() || !r9.isEmpty()) {
            long j = 0;
            long j2 = 0;
            for (C1948ks ksVar : r8) {
                j = Math.max(j, ksVar.m8445() - msToUs);
            }
            for (C1948ks ksVar2 : r9) {
                j2 = Math.max(j2, ksVar2.m8445() - msToUs);
            }
            this.f8512.m8646(true, C.usToMs(j), C.usToMs(j2));
            return;
        }
        this.f8512.m8646(false, -1, -1);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m8601(IAsePlayerState iAsePlayerState) {
        this.f8535 = iAsePlayerState;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8588(BandwidthMeter bandwidthMeter) {
        this.f8537 = bandwidthMeter;
    }

    @Override // o.AbstractC1952kz.AbstractC1953iF
    /* renamed from: ˏ */
    public void mo8461(AbstractC1952kz.If r6) {
        C1283.m16848("nf_playreport", "onCDNSwitch(%s)", r6);
        if (this.f8516 == null) {
            this.f8512.m8625(r6);
        }
        m8569(new C1967lz(this.f8522).m8775(this.f8508.m8660()).m8773(this.f8516).m8774(r6).mo8548());
        this.f8516 = r6;
        if (this.f8525 != null) {
            this.f8525.m8412().m8675(r6.f8472);
        }
    }

    @Override // o.AbstractC1952kz.AbstractC1953iF
    /* renamed from: ˋ */
    public void mo8459(AbstractC1952kz.C0142 r6) {
        C1283.m16848("nf_playreport", "onStreamSwitch(%s)", r6);
        if (this.f8519 == null) {
            this.f8512.m8627(r6);
        } else {
            m8569(new lA(this.f8522).m8543(this.f8508.m8660()).m8544(this.f8519).m8542(r6).mo8549(m8564(), this.f8535).mo8548());
        }
        this.f8519 = r6;
    }

    @Override // o.AbstractC1952kz.AbstractC1953iF
    /* renamed from: ˊ */
    public void mo8458(int[] iArr, int i, long j, long j2, int i2, int i3) {
        if (this.f8543.m8652()) {
            long j3 = 0;
            if (this.f8535 != null) {
                j3 = this.f8535.mo1008()[1].m1022();
            }
            PlayerStateMachine.State r18 = this.f8527.m1101();
            synchronized (this.f8510) {
                if (this.f8510.m8763(2, iArr)) {
                    Logblob r20 = this.f8510.mo8548();
                    this.f8510.m8764();
                    m8569(r20);
                }
                this.f8510.m8766(2, r18, iArr, this.f8508.m8660(), i, j, j2, j3, i2, i3);
            }
        }
    }

    @Override // o.AbstractC1952kz.AbstractC1953iF
    /* renamed from: ˎ */
    public void mo8460() {
        mo8589("startPlayback");
    }

    @Override // o.lQ.AbstractC0144
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo8611(int i, int i2) {
        C1283.m16848("nf_playreport", "onVolumeChanged(%s, %s)", Integer.valueOf(i), Integer.valueOf(i2));
        m8569(new lO(this.f8522).m8655(this.f8508.m8660()).m8657(m8574()).m8654(i2).m8656(i).mo8549(m8564(), this.f8535).mo8548());
    }

    @Override // o.lV
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8586(long j, long j2, String str, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C1283.m16848("nf_playreport", "userPlay(%s, %s, %s, %s)", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(elapsedRealtime), str, Long.valueOf(j3));
        this.f8538 = j;
        this.f8539 = new lR(elapsedRealtime);
        this.f8512.m8644(j2);
    }

    @Override // o.lV
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo8582() {
        C1283.m16846("nf_playreport", "userPause()");
    }

    @Override // o.lV
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8593(StopReason stopReason, long j) {
        C1283.m16848("nf_playreport", "userStop(%s, %s)", stopReason, Long.valueOf(j));
        if (stopReason == StopReason.SEEK || stopReason == StopReason.SKIP) {
            lJ r5 = new lJ(this.f8522).m8615(this.f8508.m8660()).m8617(m8574()).m8616(j);
            if (this.f8527.m1098()) {
                r5.m8618(this.f8527.m1103());
            }
            m8569(r5.mo8548());
            this.f8527.m1099();
            return;
        }
        this.f8514.m1066(EndPlayJson.EndReason.STOPPED);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m8599() {
        C1283.m16846("nf_playreport", "onPlaybackStarted()");
        m8570();
        m8577();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8610() {
        C1283.m16846("nf_playreport", "onPaused()");
        m8569(new StateChangedJson(this.f8522).m1124(this.f8508.m8660()).m1122(m8574()).m1123(true).mo8548());
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x000f: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v0 java.lang.String) */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m8607(boolean z) {
        Object[] objArr = new Object[1];
        objArr[0] = z ? "media" : "subtitle";
        C1283.m16848("nf_playreport", "onRebuffering(%s)", objArr);
        m8569(new lE(this.f8522).m8556(this.f8516).m8554(m8574()).m8555(this.f8508.m8660()).m8557(z).mo8549(m8564(), this.f8535).mo8548());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8584() {
        Long l;
        Long l2;
        C1283.m16846("nf_playreport", "onPlaybackResumed()");
        if (this.f8527.m1098()) {
            m8569(new StateChangedJson(this.f8522).m1124(this.f8508.m8660()).m1122(m8574()).m1123(false).mo8548());
        } else if (this.f8527.m1101() != PlayerStateMachine.State.AUDIO) {
            ResumePlayJson r0 = new ResumePlayJson(this.f8522).m1115(Long.valueOf(this.f8538));
            if (this.f8537 == null) {
                l = null;
            } else {
                l = Long.valueOf(this.f8537.getBitrateEstimate() / 1000);
            }
            ResumePlayJson r02 = r0.m1111(l);
            if (this.f8513 == null) {
                l2 = null;
            } else {
                l2 = Long.valueOf(this.f8513.m8660());
            }
            ResumePlayJson r5 = r02.m1112(l2).m1117(Long.valueOf(this.f8527.m1103())).m1114(this.f8516).m1110(this.f8521).m1109(this.f8508.m8660()).m1116(m8574());
            r5.mo8549(m8564(), this.f8535);
            switch (this.f8527.m1101()) {
                case REBUFFERING:
                case SUBTITLE_STALLED:
                    r5.m1113(ResumePlayJson.Reason.REBUFFER);
                    m8577();
                    break;
                case SEEKING:
                    r5.m1113(ResumePlayJson.Reason.REPOS);
                    m8577();
                    break;
                case SKIPPING:
                    r5.m1113(ResumePlayJson.Reason.SKIP);
                    m8577();
                    break;
            }
            m8569(r5.mo8548());
        } else if (this.f8523 != null) {
            this.f8523.m8552(this.f8527.m1103());
            m8569(this.f8523.mo8548());
            this.f8523 = null;
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m8570() {
        Long l;
        Long l2;
        String str;
        AbstractC1952kz.C0143 r1;
        lL r0 = this.f8512.m8641(Long.valueOf(this.f8539.m8660()));
        if (this.f8537 == null) {
            l = null;
        } else {
            l = Long.valueOf(this.f8537.getBitrateEstimate() / 1000);
        }
        lL r02 = r0.m8640(l);
        if (this.f8513 == null) {
            l2 = null;
        } else {
            l2 = Long.valueOf(this.f8513.m8660());
        }
        lL r03 = r02.m8623(l2).m8634(Long.valueOf(this.f8538)).m8639(this.f8508.m8660()).m8636(this.f8518).m8642(m8576());
        if (this.f8543 == null) {
            str = null;
        } else {
            str = this.f8543.m8651();
        }
        lL r04 = r03.m8635(str);
        if (this.f8520 == null) {
            r1 = null;
        } else {
            r1 = this.f8520.mo8355();
        }
        m8569(r04.m8643(r1).m8624(this.f8509).mo8549(m8564(), this.f8535).mo8548());
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private long m8564() {
        if (this.f8540 == null) {
            return 0;
        }
        return Math.max(0L, this.f8540.getBufferedPosition() - this.f8540.getCurrentPosition());
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private String m8576() {
        IAsePlayerState.C1288iF iFVar = this.f8535 == null ? null : this.f8535.mo1009()[0];
        if (iFVar != null) {
            return iFVar.m1019();
        }
        return null;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m8577() {
        synchronized (this.f8518) {
            if (!this.f8518.isEmpty()) {
                StartPlayEventJson r4 = new StartPlayEventJson(this.f8522).m1118(this.f8508.m8660()).m1120(this.f8518).m1119(this.f8543.m8651());
                switch (this.f8527.m1101()) {
                    case REBUFFERING:
                        r4.m1121(StartPlayEventJson.Reason.REBUFFER);
                        break;
                    case SEEKING:
                        r4.m1121(StartPlayEventJson.Reason.REPOS);
                        break;
                    case SKIPPING:
                        r4.m1121(StartPlayEventJson.Reason.SKIP);
                        break;
                    case INITIALIZING:
                        r4.m1121(StartPlayEventJson.Reason.START);
                        break;
                }
                m8569(r4.mo8548());
                this.f8518.clear();
            }
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m8613() {
        C1283.m16846("nf_playreport", "onDestroy()");
        this.f8541 = true;
        this.f8511.m8659();
        this.f8507.quitSafely();
    }

    @Override // o.lV
    /* renamed from: ʻ  reason: contains not printable characters */
    public void mo8578() {
        C1283.m16846("nf_playreport", "setUsedLDL(true)");
        this.f8512.m8630((Boolean) true);
    }

    @Override // o.lV
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8587(long j, String str) {
        C1283.m16848("nf_playreport", "setManifestCacheHit(%s, %s)", Long.valueOf(j), str);
        this.f8512.m8638((Boolean) true);
        this.f8512.m8631(Long.valueOf(j));
        this.f8512.m8632(str);
    }

    @Override // o.lV
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8589(String str) {
        C1283.m16848("nf_playreport", "reportKeyStartplayEvent(%s)", str);
        synchronized (this.f8518) {
            if (!this.f8518.containsKey(str)) {
                this.f8518.put(str, Long.valueOf(this.f8508.m8660()));
            }
        }
    }

    @Override // o.lV
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo8600(long j, AbstractC1933kd.iF iFVar) {
        C1283.m16848("nf_playreport", "onDownstreamFormatChanged(%s, %s)", Long.valueOf(j), iFVar);
        if (this.f8529 != null) {
            lK r6 = new lK(this.f8522).m8622(j).m8619(this.f8508.m8660()).m8620(iFVar.f8380, iFVar.f8379 / 1000).m8621(this.f8529.f8380, this.f8529.f8379 / 1000);
            r6.mo8549(m8564(), this.f8535);
            m8569(r6.mo8548());
            m8573();
        }
        this.f8529 = iFVar;
        this.f8528 = new lR();
    }

    @Override // o.lV
    /* renamed from: ᐝ  reason: contains not printable characters */
    public void mo8614() {
        DecoderCounters decoderCounters;
        String str;
        DecoderCounters decoderCounters2;
        String str2;
        EndPlayJson r0 = new lI(this.f8522).m1065(this.f8521).m1080(m8574()).m1075(this.f8508.m8660()).m1076(Long.valueOf(this.f8538)).m1078(this.f8532, this.f8527.m1101().m1108());
        if (this.f8525 == null) {
            decoderCounters = null;
        } else {
            decoderCounters = this.f8525.m8413();
        }
        EndPlayJson r02 = r0.m1068(decoderCounters);
        if (this.f8525 == null) {
            str = null;
        } else {
            str = this.f8525.m8407();
        }
        EndPlayJson r03 = r02.m1081(str);
        if (this.f8525 == null) {
            decoderCounters2 = null;
        } else {
            decoderCounters2 = this.f8525.m8404();
        }
        EndPlayJson r04 = r03.m1070(decoderCounters2);
        if (this.f8525 == null) {
            str2 = null;
        } else {
            str2 = this.f8525.m8406();
        }
        m8569(r04.m1077(str2).m1064(m8561()).mo8548());
    }

    @Override // o.lV
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8592(long j) {
        m8569(new lG(this.f8522).m8560(this.f8508.m8660()).m8559(m8574()).mo8548());
    }

    @Override // o.lV
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo8612(ExitPipAction exitPipAction, long j) {
        ExitPipPlayJson r3 = new ExitPipPlayJson(this.f8522).m1085(this.f8508.m8660()).m1087(m8574());
        switch (exitPipAction) {
            case CONTINUEPLAY:
                r3.m1086(ExitPipPlayJson.ExitType.CONTINUEPLAY);
                break;
            case STOP:
                r3.m1086(ExitPipPlayJson.ExitType.ENDSESSION);
                break;
        }
        m8569(r3.mo8548());
    }

    @Override // o.lV
    /* renamed from: ʼ  reason: contains not printable characters */
    public void mo8579() {
        C1283.m16846("nf_playreport", "subtitleRebuffer()");
        if (C0901.m15634()) {
            this.f8527.m1102();
        }
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m8573() {
        this.f8514.m1079(this.f8516.f8472, this.f8529, this.f8528.m8660());
    }

    @Override // o.lV
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8585(long j) {
        C1283.m16848("nf_playreport", "setTrackingId(%s)", Long.valueOf(j));
        this.f8512.m8626(j);
    }

    @Override // o.lV
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8597(JSONObject jSONObject) {
        C1283.m16846("nf_playreport", "setManifest()");
        this.f8512.m8628(jSONObject);
    }

    @Override // o.lV
    /* renamed from: ʽ  reason: contains not printable characters */
    public lX mo8580() {
        return this.f8532;
    }

    @Override // o.lV
    /* renamed from: ˊ  reason: contains not printable characters */
    public lX mo8581(ISubtitleDef.SubtitleFailure subtitleFailure, Status status) {
        C1283.m16848("nf_playreport", "reportSubtitleFailure(%s, %s)", subtitleFailure, status);
        this.f8532 = ErrorCodeUtils.m1128(subtitleFailure, status);
        return this.f8532;
    }

    @Override // o.lV
    /* renamed from: ˏ  reason: contains not printable characters */
    public lX mo8598(StreamingPlaybackErrorCode streamingPlaybackErrorCode, Status status) {
        C1283.m16848("nf_playreport", "reportTransactionFailure(%s, %s)", streamingPlaybackErrorCode, status);
        this.f8532 = ErrorCodeUtils.m1127(streamingPlaybackErrorCode, status);
        return this.f8532;
    }

    @Override // o.lV
    /* renamed from: ॱ  reason: contains not printable characters */
    public lX mo8609(String str) {
        C1283.m16848("nf_playreport", "reportDrmSessionFailure(%s)", str);
        this.f8532 = ErrorCodeUtils.m1129(str);
        return this.f8532;
    }

    @Override // o.lV
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void mo8591() {
        C1283.m16846("nf_playreport", "updateNetworkInterfaceParams()");
        CurrentNetworkInfo r2 = CurrentNetworkInfo.m1036(this.f8517);
        if (this.f8521 == null) {
            this.f8512.m8645(r2);
        }
        if (!r2.equals(this.f8521)) {
            m8569(new lN(this.f8522).m8653(r2).mo8548());
            this.f8521 = r2;
            if (this.f8525 != null) {
                this.f8525.m8412().m8676(r2);
            }
        }
    }

    @Override // o.lV
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo8604(String str, long j, String str2) {
        String str3;
        DecoderCounters decoderCounters;
        String str4;
        DecoderCounters decoderCounters2;
        String str5;
        C1283.m16848("nf_playreport", "playbackClosed(%s, %s, %s)", str, Long.valueOf(j), str2);
        this.f8530.run();
        this.f8534.run();
        if (this.f8527.m1101() == PlayerStateMachine.State.INITIALIZING && this.f8532 != null) {
            this.f8512.m8637(this.f8532);
            m8570();
        } else if (this.f8532 == null && this.f8527.m1101().m1108()) {
            m8577();
            PlaybackAbortedJson r5 = new PlaybackAbortedJson(this.f8522).m1090(Long.valueOf(this.f8538)).m1088(this.f8508.m8660()).m1091(m8574()).m1092(this.f8527.m1103());
            if (this.f8527.m1101() != PlayerStateMachine.State.INITIALIZING) {
                r5.m1089(PlaybackAbortedJson.AbortedEvent.RESUMEPLAY);
                switch (this.f8527.m1101()) {
                    case REBUFFERING:
                    case SUBTITLE_STALLED:
                        r5.m1093(PlaybackAbortedJson.ResumePlayReason.REBUFFER);
                        break;
                    case SEEKING:
                        r5.m1093(PlaybackAbortedJson.ResumePlayReason.REPOS);
                        break;
                    case SKIPPING:
                        r5.m1093(PlaybackAbortedJson.ResumePlayReason.SKIP);
                        break;
                    case AUDIO:
                        r5.m1093(PlaybackAbortedJson.ResumePlayReason.AUDIO);
                        break;
                }
            } else {
                r5.m1089(PlaybackAbortedJson.AbortedEvent.STARTPLAY);
            }
            m8569(r5.mo8548());
        }
        if (this.f8527.m1101() != PlayerStateMachine.State.INITIALIZING) {
            if (this.f8527.m1101() == PlayerStateMachine.State.PLAYING) {
                m8573();
            }
            EndPlayJson r0 = this.f8514.m1065(this.f8521).m1080(m8574()).m1075(this.f8508.m8660()).m1076(Long.valueOf(this.f8538)).m1078(this.f8532, this.f8527.m1101().m1108()).m1064(m8561());
            if (this.f8543 == null) {
                str3 = null;
            } else {
                str3 = this.f8543.m8651();
            }
            r0.m1069(str3).m1082(m8562()).m1067(LogAudioSinkType.m1131(this.f8517));
            if (this.f8525 != null) {
                lS r52 = this.f8525.m8412();
                EndPlayJson endPlayJson = this.f8514;
                if (this.f8525 == null) {
                    decoderCounters = null;
                } else {
                    decoderCounters = this.f8525.m8413();
                }
                EndPlayJson r02 = endPlayJson.m1068(decoderCounters);
                if (this.f8525 == null) {
                    str4 = null;
                } else {
                    str4 = this.f8525.m8407();
                }
                EndPlayJson r03 = r02.m1081(str4);
                if (this.f8525 == null) {
                    decoderCounters2 = null;
                } else {
                    decoderCounters2 = this.f8525.m8404();
                }
                EndPlayJson r04 = r03.m1070(decoderCounters2);
                if (this.f8525 == null) {
                    str5 = null;
                } else {
                    str5 = this.f8525.m8406();
                }
                r04.m1077(str5).m1073(r52.m8672()).m1074(r52.m8682()).m1072(r52.m8679()).m1062(r52.m8680());
            }
            m8569(this.f8514.mo8548());
        }
        m8613();
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private long m8574() {
        if (this.f8540 != null) {
            return this.f8540.getCurrentPosition();
        }
        return this.f8512.m8633();
    }

    @Override // o.lV
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo8603(String str, int i, String str2, int i2) {
        C1283.m16848("nf_playreport", "audioTrackSwitchStarted(%s, %s, %s, %s)", str, Integer.valueOf(i), str2, Integer.valueOf(i2));
        this.f8523 = new lD(this.f8522).m8550(new lD.Cif(str, i)).m8551(new lD.Cif(str2, i2)).m8553(this.f8508.m8660());
        this.f8527.m1105();
    }

    @Override // o.lV
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo8606(JSONObject jSONObject, AbstractC1221 r6) {
        C1283.m16848("nf_playreport", "setStreamingConfig(%s)", jSONObject);
        this.f8543 = (lM) new Gson().fromJson(jSONObject.toString(), (Class<Object>) lM.class);
        this.f8543.m8648();
        if (this.f8525 != null && this.f8543.m8649()) {
            this.f8525.m8412().m8674();
        }
        if (this.f8543.m8650() || this.f8543.m8649()) {
            this.f8542.postDelayed(this.f8530, f8506);
        }
        if (this.f8543.m8652()) {
            this.f8542.postDelayed(this.f8534, f8506);
        }
        if (this.f8543.m8647() && ActivityTracker.m3046(r6, this.f8517)) {
            this.f8533 = new ActivityTracker(this.f8517);
        }
    }

    @Override // com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.PlayerStateMachine.If
    /* renamed from: ˏ */
    public void mo1107(PlayerStateMachine.State state, PlayerStateMachine.State state2) {
        if (state2.m1108()) {
            this.f8513 = new lR();
        }
        switch (state2) {
            case REBUFFERING:
                m8607(false);
                break;
            case SUBTITLE_STALLED:
                m8607(true);
                break;
            case PLAYING:
                if (state != PlayerStateMachine.State.INITIALIZING) {
                    m8584();
                    break;
                } else {
                    m8599();
                    break;
                }
            case PAUSED:
                m8610();
                break;
        }
        if (state == PlayerStateMachine.State.PLAYING) {
            this.f8524 += this.f8527.m1103();
            m8573();
        }
        if (state2 == PlayerStateMachine.State.PLAYING) {
            this.f8528 = new lR();
        }
    }

    @Override // com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.PlayerStateMachine.If
    /* renamed from: ˋ */
    public void mo1106(lX lXVar) {
        C1283.m16848("nf_playreport", "onPlayerError(%s)", lXVar);
        this.f8532 = lXVar;
    }

    @Override // o.lS.AbstractC0146
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8596(RequestFinishedInfo requestFinishedInfo, DataSpec dataSpec, lS.IF r12) {
        if (this.f8543 == null) {
            return;
        }
        if (this.f8543.m8649() || (this.f8543.m8650() && DlReportJson.m1047(requestFinishedInfo))) {
            synchronized (this.f8515) {
                this.f8515.m1058(this.f8508.m8660(), this.f8521, requestFinishedInfo, dataSpec, r12);
            }
        }
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private long m8561() {
        if (this.f8527.m1101() == PlayerStateMachine.State.PLAYING) {
            return this.f8524 + this.f8527.m1103();
        }
        return this.f8524;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m8569(Logblob logblob) {
        if (this.f8526) {
            C1283.m16854("nf_playreport", "dropping logblob event. disabled via config");
        } else {
            this.f8531.mo5226(logblob);
        }
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    private Map<String, Object> m8562() {
        try {
            if (this.f8533 == null) {
                return null;
            }
            this.f8533.m3050();
            Map<String, Object> r0 = this.f8533.m3051();
            this.f8533 = null;
            return r0;
        } catch (Exception e) {
            C1276.m16820().mo5730(e);
            return null;
        }
    }

    @Override // o.lV
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo8602(String str) {
        this.f8514.m1063(str);
    }

    @Override // o.lV
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public int mo8608() {
        if (this.f8537 == null) {
            return 0;
        }
        return (int) (this.f8537.getBitrateEstimate() / 1000);
    }
}
