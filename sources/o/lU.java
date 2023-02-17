package o;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.netflix.mediaclient.service.player.drm.NfDrmManagerInterface;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import o.oM;
public class lU extends iM {

    /* renamed from: ˉ  reason: contains not printable characters */
    private final C1938ki f8593;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private final PriorityTaskManager f8594;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private final C1962lu f8595;

    public lU(Context context, oM.AbstractC0160 r6, jD jDVar, NfDrmManagerInterface nfDrmManagerInterface, UserAgentInterface userAgentInterface, AbstractC1221 r10, C2003ng ngVar, IClientLogging iClientLogging, Handler handler, Looper looper, long j, oX oXVar, long j2, AbstractC1936kg kgVar, C1932kc kcVar, AbstractC2055pd pdVar, C1938ki kiVar, C1962lu luVar, PriorityTaskManager priorityTaskManager) {
        super(context, r6, jDVar, nfDrmManagerInterface, userAgentInterface, r10, ngVar, iClientLogging, handler, looper, j, oXVar, j2, kgVar, kcVar, pdVar);
        this.f8593 = kiVar;
        this.f8595 = luVar;
        mo899(this.f7781, this.f7784, "ExoStreamingPlaybackSession constructor");
        if (this.f7790 != null) {
            this.f7790.mPlayerName = "ExoPlayer";
        }
        this.f8594 = priorityTaskManager;
    }

    @Override // o.iM
    /* renamed from: ˎˏ */
    public void mo7501() {
        C1348Bu.m4094();
        C1283.m16863(this.f7566, "createSessionPlayerAndStart %d", Long.valueOf(this.f7778));
        m7505();
        m7500();
        this.f7548.m7521();
        this.f7543 = new C1946kq(this.f7785, this.f8593, this.f8595, this, this.f7542, (lH) this.f7546, this.f7786.mo9715().m9854(), this.f8594);
        this.f7539 = this.f7543.mo8371();
        this.f7543.mo8373(this.f7541);
        this.f7546.mo8589("requestManifestStart");
        this.f7789 = System.currentTimeMillis();
        this.f7540.mo7860(Long.valueOf(this.f7778), this, true);
    }

    /* access modifiers changed from: protected */
    @Override // o.iM
    /* renamed from: ˏˎ */
    public lV mo7504() {
        return new lH(this.f7785, this.f7793.mo1512(), this.f7548, this.f7790, this.f7783, this.f7787.mo16537().getDisableStreamingLogblobs(), this.f7786.mo9715().m9854(), this.f7787.d_().mo14447());
    }
}
