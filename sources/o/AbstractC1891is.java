package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.PlaybackMetadataImpl;
import com.netflix.mediaclient.media.SubtitleUrl;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import o.C1348Bu;
import o.oM;
/* renamed from: o.is  reason: case insensitive filesystem */
public abstract class AbstractC1891is implements oM, AbstractC1977mh {

    /* renamed from: ˈ  reason: contains not printable characters */
    private static long f7774;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected static AbstractC1891is f7775;

    /* renamed from: ʻ  reason: contains not printable characters */
    protected final C2003ng f7776;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    protected boolean f7777;

    /* renamed from: ʼ  reason: contains not printable characters */
    public final long f7778;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected final AbstractC2007nk f7779;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected final UserAgentInterface f7780;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected oX f7781;

    /* renamed from: ˋ  reason: contains not printable characters */
    public iH f7782;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected String f7783;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected long f7784;

    /* renamed from: ˏ  reason: contains not printable characters */
    public final Context f7785;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected AbstractC2055pd f7786 = AbstractC2055pd.f9383;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected final AbstractC1221 f7787;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected AudioSource[] f7788;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    protected long f7789 = 0;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    protected final PlaybackMetadataImpl f7790 = null;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected AbstractC1617ck f7791;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    protected AbstractC0128 f7792;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected final IClientLogging f7793;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final oJ f7794;

    /* renamed from: o.is$ˋ  reason: contains not printable characters */
    public interface AbstractC0128 {
        /* renamed from: ॱ */
        void mo933();
    }

    /* renamed from: ʻॱ */
    public abstract boolean mo889();

    /* renamed from: ˊ */
    public abstract void mo899(oX oXVar, long j, String str);

    /* renamed from: ˋॱ */
    public abstract boolean mo912();

    /* renamed from: ˏ */
    public abstract void mo920(AbstractC0128 v);

    /* renamed from: ˏॱ */
    public abstract boolean mo922();

    /* renamed from: ͺ */
    public abstract boolean mo923();

    /* renamed from: ᐝ */
    public abstract IPlayer.aux mo930();

    public AbstractC1891is(Context context, IClientLogging iClientLogging, C2003ng ngVar, UserAgentInterface userAgentInterface, AbstractC1221 r7, oJ oJVar, oX oXVar, long j, long j2, AbstractC2055pd pdVar) {
        this.f7785 = context;
        this.f7793 = iClientLogging;
        this.f7780 = userAgentInterface;
        this.f7787 = r7;
        this.f7779 = ngVar;
        this.f7776 = ngVar;
        this.f7794 = oJVar;
        this.f7781 = oXVar;
        this.f7778 = j;
        this.f7784 = j2;
        this.f7786 = pdVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7756(iH iHVar) {
        this.f7782 = iHVar;
    }

    /* renamed from: ˊ */
    public String mo896() {
        return this.f7783;
    }

    @Override // o.oM
    /* renamed from: ˏ  reason: contains not printable characters */
    public long mo7754() {
        return this.f7778;
    }

    @Override // o.oM
    /* renamed from: ˋ  reason: contains not printable characters */
    public AudioSource[] mo7753() {
        return this.f7788;
    }

    @Override // o.AbstractC1977mh
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo7755(String str, SubtitleUrl subtitleUrl, ISubtitleDef.SubtitleFailure subtitleFailure, boolean z, Status status, String[] strArr) {
        this.f7793.mo1512().mo5226(new jB(str, subtitleUrl, subtitleFailure, z, mo891(), status, strArr, mo922()));
    }

    @Override // o.AbstractC1977mh
    /* renamed from: ॱ  reason: contains not printable characters */
    public oJ mo7759() {
        return this.f7794;
    }

    @Override // o.AbstractC1977mh
    /* renamed from: ʻ  reason: contains not printable characters */
    public AbstractC2007nk mo7747() {
        return this.f7779;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public AbstractC2055pd m7748() {
        return this.f7786;
    }

    @Override // o.AbstractC1977mh
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo7750(String str, String str2) {
        m7746(str, str2);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7746(String str, String str2) {
        this.f7791.mo639(Long.valueOf(this.f7783).longValue(), str, str2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public AudioSource m7749(String str) {
        if (this.f7788 == null) {
            return null;
        }
        AudioSource[] audioSourceArr = this.f7788;
        for (AudioSource audioSource : audioSourceArr) {
            if (C1349Bv.m4126(str, audioSource.getId())) {
                return audioSource;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m7761() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            m7745();
        } else {
            C1348Bu.If.m4098(new Runnable() { // from class: o.is.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC1891is.this.m7745();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˍ  reason: contains not printable characters */
    private void m7745() {
        if (this.f7782 != null) {
            this.f7782.mo7441();
            this.f7782 = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7757(oM.iF iFVar, IPlayer.aux aux) {
        if (f7774 == 0) {
            f7774 = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - f7774 > 45000) {
            m7743();
            iFVar.mo7418(mo930());
            return;
        }
        iFVar.mo7418(aux);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    protected static void m7743() {
        f7774 = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m7752(oM.iF iFVar, IPlayer.aux aux) {
        C1348Bu.If.m4098(new Runnable() { // from class: o.is.4
            @Override // java.lang.Runnable
            public void run() {
                C1283.m16854("nf_AbstractPlaybackSession", "reportFatalError will close the session");
                AbstractC1891is.this.mo920(new AbstractC0128() { // from class: o.is.4.4
                    @Override // o.AbstractC1891is.AbstractC0128
                    /* renamed from: ॱ */
                    public void mo933() {
                        C1283.m16862("nf_AbstractPlaybackSession", "reportFatalError close done");
                    }
                });
            }
        });
        iFVar.mo7418(aux);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public void m7760() {
        AbstractC1891is isVar = f7775;
        if (this == isVar) {
            C1283.m16863("nf_AbstractPlaybackSession", "resetLastActiveSession currentSessionId=%d lastSessionId=%d", Long.valueOf(this.f7778), Long.valueOf(isVar.f7778));
            f7775 = null;
        } else if (isVar != null) {
            C1283.m16863("nf_AbstractPlaybackSession", "resetLastActiveSession not resetting, currentSessionId=%d lastSessionId=%d", Long.valueOf(this.f7778), Long.valueOf(isVar.f7778));
        }
        m7743();
    }

    @Override // o.oM
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo7758(boolean z) {
        this.f7777 = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public boolean m7751() {
        return this.f7777;
    }
}
