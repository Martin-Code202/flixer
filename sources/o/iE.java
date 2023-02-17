package o;

import android.content.Context;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.netflix.mediaclient.service.user.UserAgent;
public class iE extends AbstractC1052 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final String f7511 = iE.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private final PriorityTaskManager f7512 = new PriorityTaskManager();

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC0661 f7513;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final gU f7514;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C1898iz f7515;

    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractC1893iu f7516;

    /* renamed from: ॱ  reason: contains not printable characters */
    public AbstractC2056pe m7426() {
        return this.f7515;
    }

    public iE(Context context, iT iTVar, C1260 r10, UserAgent userAgent, AbstractC0661 r12) {
        this.f7515 = new C1898iz(context, this, iTVar, r10, userAgent, this.f7512);
        this.f7513 = r12;
        this.f7514 = gU.m6606(context);
    }

    @Override // o.AbstractC1052
    /* renamed from: ˏ */
    public void mo7286(int i) {
        this.f7515.m7794(i);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1052
    /* renamed from: ʽ */
    public void mo1237() {
        this.f7516 = new lT(m16093(), m16101(), this.f7513, this.f7512);
        this.f7515.m7796(this.f7516, w_(), m16095(), this.f7513);
        m16090(AbstractC0367.f13235);
    }

    @Override // o.AbstractC1052
    /* renamed from: ʻ */
    public void mo1236() {
        super.mo1236();
        this.f7515.m7793();
        if (this.f7516 != null) {
            this.f7516.mo7770();
        }
    }

    @Override // o.AbstractC1052
    /* renamed from: ʼ */
    public void mo5196() {
        this.f7514.m6608(m16093());
        this.f7515.m7798();
    }
}
