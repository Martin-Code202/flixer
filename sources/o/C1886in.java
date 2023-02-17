package o;

import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.media.SubtitleUrl;
import com.netflix.mediaclient.service.user.UserAgentInterface;
/* renamed from: o.in  reason: case insensitive filesystem */
public class C1886in {

    /* renamed from: ʻ  reason: contains not printable characters */
    private C1986mq f7765 = new C1986mq();

    /* renamed from: ʽ  reason: contains not printable characters */
    private float f7766;

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC1883ik f7767;

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC1977mh f7768;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final long f7769;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC1981ml f7770;

    /* renamed from: ॱ  reason: contains not printable characters */
    private UserAgentInterface f7771;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private AbstractC2055pd f7772;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private long f7773;

    public C1886in(UserAgentInterface userAgentInterface, AbstractC1977mh mhVar, AbstractC1981ml mlVar, long j, AbstractC2055pd pdVar) {
        if (userAgentInterface == null) {
            throw new IllegalArgumentException("User is null!");
        } else if (mhVar == null) {
            throw new IllegalArgumentException("Player is null!");
        } else {
            this.f7771 = userAgentInterface;
            this.f7768 = mhVar;
            this.f7770 = mlVar;
            this.f7769 = j;
            this.f7772 = pdVar;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m7715(Subtitle subtitle, float f, long j, boolean z) {
        this.f7766 = f;
        this.f7773 = j;
        mP r12 = mP.m8863(this.f7771.mo1377());
        mP r13 = mP.m8863(this.f7771.mo1378());
        m7709(subtitle, z);
        if (subtitle == null) {
            C1283.m16854("nf_subtitles_offline", "no default subtitles");
            this.f7770.mo910();
            return;
        }
        this.f7770.mo910();
        if (subtitle instanceof AbstractC1884il) {
            this.f7767 = C1890ir.m7742(this.f7768, this.f7770, (AbstractC1884il) subtitle, r12, r13, this.f7766, this.f7773, this.f7769, this.f7772, true);
            this.f7767.mo7692();
        } else {
            new IllegalStateException("SubtitleOfflineManager handles only OfflineSubtitle!");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized AbstractC1979mj m7714() {
        return this.f7767;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized C1987mr m7713(long j) {
        AbstractC1883ik ikVar = this.f7767;
        if (ikVar == null || !ikVar.mo8989()) {
            return null;
        }
        return ikVar.mo8732(j);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public Subtitle m7712() {
        AbstractC1883ik ikVar = this.f7767;
        if (ikVar != null) {
            return ikVar.mo7693();
        }
        C1283.m16850("nf_subtitles_offline", "getCurrentSubtitle:: parser is null!");
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void m7711() {
        this.f7767 = null;
        this.f7766 = 0.0f;
        this.f7773 = 0;
        if (this.f7765 != null) {
            this.f7765.m9062();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private synchronized void m7709(Subtitle subtitle, boolean z) {
        if (m7708(subtitle, z)) {
            AbstractC1979mj r5 = m7714();
            if (r5 != null) {
                int r6 = r5.mo8737();
                int r7 = r5.mo8727();
                SubtitleUrl E_ = r5.E_();
                String str = "";
                if (E_ != null) {
                    String downloadableId = E_.getDownloadableId();
                    if (C1349Bv.m4107(downloadableId)) {
                        str = downloadableId;
                    }
                }
                C1283.m16851("nf_subtitles_offline", "QoE: for subtitle %s we where expected to show %d and we showed %d subtitles.", str, Integer.valueOf(r6), Integer.valueOf(r7));
                m7710(str, r6, r7);
            } else {
                C1283.m16865("nf_subtitles_offline", "Parser is null, nothing to report!");
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7710(String str, int i, int i2) {
        this.f7765.m9063(str, i, i2);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m7708(Subtitle subtitle, boolean z) {
        if (!z) {
            return false;
        }
        Subtitle r2 = m7712();
        if (r2 == null) {
            C1283.m16854("nf_subtitles_offline", "isNewSubtitle: current subtitle is null, can not report anything...");
            return false;
        } else if (r2.equals(subtitle)) {
            C1283.m16854("nf_subtitles_offline", "isNewSubtitle: subtitle is not changed, do not report anything...");
            return false;
        } else {
            C1283.m16854("nf_subtitles_offline", "isNewSubtitle: subtitle is changed, report QoE...");
            return true;
        }
    }
}
