package o;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.netflix.mediaclient.service.player.drm.NfDrmManagerInterface;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import o.oM;
public class lT implements AbstractC1893iu {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final PriorityTaskManager f8589;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C1938ki f8590;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C1962lu f8591;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC0661 f8592;

    public lT(Context context, AbstractC1221 r3, AbstractC0661 r4, PriorityTaskManager priorityTaskManager) {
        this.f8591 = new C1962lu(context);
        this.f8590 = new C1938ki(context, r3, r4);
        this.f8592 = r4;
        this.f8589 = priorityTaskManager;
    }

    @Override // o.AbstractC1893iu
    /* renamed from: ˋ */
    public AbstractC1891is mo7768(Context context, oM.AbstractC0160 r24, jD jDVar, NfDrmManagerInterface nfDrmManagerInterface, UserAgentInterface userAgentInterface, AbstractC1221 r28, C2003ng ngVar, IClientLogging iClientLogging, Handler handler, Looper looper, long j, oX oXVar, long j2, Pair<Long, Long> pair, AbstractC1936kg kgVar, C1932kc kcVar, AbstractC2055pd pdVar) {
        return new lU(context, r24, jDVar, nfDrmManagerInterface, userAgentInterface, r28, ngVar, iClientLogging, handler, looper, j, oXVar, j2, kgVar, kcVar, pdVar, this.f8590, this.f8591, this.f8589);
    }

    @Override // o.AbstractC1893iu
    /* renamed from: ˋ */
    public AbstractC1936kg mo7769(Context context, AbstractC1221 r4, AbstractC2056pe peVar) {
        return new lP(context, r4, peVar, this.f8590);
    }

    @Override // o.AbstractC1893iu
    /* renamed from: ˊ */
    public kM mo7767(Context context, jE jEVar) {
        return new kM(context, this.f8590, jEVar, this.f8589, this.f8592);
    }

    @Override // o.AbstractC1893iu
    /* renamed from: ˎ */
    public void mo7770() {
        this.f8590.m8392();
    }
}
