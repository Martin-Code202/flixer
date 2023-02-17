package o;

import android.os.Handler;
import android.os.HandlerThread;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.media.SubtitleTrackData;
import com.netflix.mediaclient.service.player.subtitles.SubtitleDownloadManager;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class iN implements AbstractC1983mn {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final AbstractC2055pd f7608;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final AbstractC1977mh f7609;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final AbstractC1981ml f7610;

    /* renamed from: ˊ  reason: contains not printable characters */
    private float f7611;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final SubtitleDownloadManager f7612;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Subtitle f7613;

    /* renamed from: ˏ  reason: contains not printable characters */
    private long f7614;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Map<String, SubtitleTrackData> f7615 = new HashMap();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Handler f7616;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private HandlerThread f7617;

    public iN(Handler handler, AbstractC1977mh mhVar, AbstractC1981ml mlVar, UserAgentInterface userAgentInterface, AbstractC1221 r14, long j, AbstractC2055pd pdVar) {
        this.f7609 = mhVar;
        this.f7610 = mlVar;
        this.f7608 = pdVar;
        this.f7612 = new SubtitleDownloadManager(handler, mhVar, mlVar, r14, userAgentInterface, j, pdVar);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m7521() {
        this.f7617 = new HandlerThread("SubtitleAudioTrackManagerWorkerThread", 0);
        this.f7617.start();
        this.f7616 = new Handler(this.f7617.getLooper());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void m7519() {
        if (this.f7616 != null) {
            this.f7616.removeCallbacksAndMessages(null);
        }
        if (this.f7617 != null) {
            this.f7617.quit();
            this.f7617 = null;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private synchronized void m7515(Runnable runnable) {
        if (!(this.f7617 == null || this.f7616 == null)) {
            this.f7616.post(runnable);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void m7520(List<SubtitleTrackData> list, String str, long j, float f) {
        this.f7614 = j;
        this.f7611 = f;
        this.f7615.clear();
        if (list == null) {
            C1283.m16854("nf_subtitles", "no subtitle tracks available. ");
            this.f7609.mo7750(null, null);
            if (this.f7608.mo9712()) {
                this.f7610.mo910();
            }
            return;
        }
        for (SubtitleTrackData subtitleTrackData : list) {
            this.f7615.put(subtitleTrackData.getId(), subtitleTrackData);
        }
        if (!C1349Bv.m4113(str)) {
            final SubtitleTrackData subtitleTrackData2 = this.f7615.get(str);
            this.f7613 = subtitleTrackData2.getSubtitleInfo();
            this.f7609.mo7750(subtitleTrackData2.getDownloadId(), subtitleTrackData2.getMediaId());
            m7515(new Runnable() { // from class: o.iN.2
                @Override // java.lang.Runnable
                public void run() {
                    iN.this.f7612.m1149(subtitleTrackData2, iN.this.f7611, iN.this.f7614, iN.this.f7614, false);
                }
            });
        } else {
            C1283.m16854("nf_subtitles", "No initial subtitle, report as such");
            this.f7609.mo7750(null, null);
            if (this.f7608.mo9712()) {
                this.f7610.mo910();
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void m7522(int i) {
        AbstractC1979mj r1 = this.f7612.m1147();
        if (r1 != null) {
            r1.mo8733(i);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized C1987mr m7523(long j) {
        AbstractC1979mj r1 = this.f7612.m1147();
        if (r1 == null) {
            return null;
        }
        return r1.mo8732(j);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized Subtitle m7518(final Subtitle subtitle, final long j, final boolean z) {
        final SubtitleTrackData r7;
        r7 = m7514(subtitle);
        m7515(new Runnable() { // from class: o.iN.5
            @Override // java.lang.Runnable
            public void run() {
                if (r7 != null) {
                    C1283.m16854("nf_subtitles", "new subtitle: " + r7);
                    if (!z && iN.this.f7608.mo9712()) {
                        iN.this.f7610.mo911();
                    }
                    if (z || !iN.this.f7608.mo9714()) {
                        iN.this.f7609.mo7750(r7.getDownloadId(), r7.getMediaId());
                    }
                    iN.this.f7612.m1149(r7, iN.this.f7611, iN.this.f7614, j, iN.this.m7509(subtitle, z));
                    return;
                }
                C1283.m16854("nf_subtitles", "subtitle track is either null or the same as before, do not change");
                if (z || !iN.this.f7608.mo9714()) {
                    iN.this.f7609.mo7750(null, null);
                }
            }
        });
        return r7 != null ? subtitle : null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private Subtitle m7516() {
        return this.f7613;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized ISubtitleDef.SubtitleProfile m7524() {
        if (this.f7612.m1147() == null) {
            return null;
        }
        return this.f7612.m1147().D_();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m7509(Subtitle subtitle, boolean z) {
        if (!z) {
            return false;
        }
        Subtitle r2 = m7516();
        if (r2 == null) {
            C1283.m16854("nf_subtitles", "isNewSubtitle: current subtitle is null, can not report anything...");
            return false;
        } else if (r2.equals(subtitle)) {
            C1283.m16854("nf_subtitles", "isNewSubtitle: subtitle is not changed, do not report anything...");
            return false;
        } else {
            C1283.m16854("nf_subtitles", "isNewSubtitle: subtitle is changed, report QoE...");
            return true;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private SubtitleTrackData m7514(Subtitle subtitle) {
        if (subtitle == null) {
            return null;
        }
        if (this.f7613 != null && C1349Bv.m4126(this.f7613.getId(), subtitle.getId())) {
            return null;
        }
        this.f7613 = subtitle;
        return this.f7615.get(subtitle.getId());
    }
}
