package o;

import android.os.Handler;
import com.netflix.mediaclient.servicemgr.IPlayer;
import o.iG;
import o.oM;
public class iO implements oM.iF {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final iG f7625 = new iG();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Handler f7626;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Handler m7525() {
        return this.f7626;
    }

    public iO(Handler handler) {
        this.f7626 = handler;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7526(final iG.AbstractC0123 r7, final Object... objArr) {
        synchronized (this.f7625) {
            for (final oM.AbstractC0160 r4 : this.f7625.m7433()) {
                if (r4 != null && r4.ae_()) {
                    m7525().post(new Runnable() { // from class: o.iO.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (r4.ae_()) {
                                r7.mo7439(r4, objArr);
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7530(oM oMVar) {
        m7526(this.f7625.m7437(), oMVar.mo895());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7528() {
        m7526(this.f7625.m7429(), new Object[0]);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m7532() {
        m7526(this.f7625.m7431(), new Object[0]);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m7533(int i, C1987mr mrVar) {
        m7526(this.f7625.m7436(), Integer.valueOf(i));
        m7526(this.f7625.m7438(), mrVar);
    }

    @Override // o.oM.iF
    /* renamed from: ˊ */
    public void mo7418(IPlayer.aux aux) {
        m7526(this.f7625.m7430(), aux);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m7527(boolean z) {
        m7526(this.f7625.m7434(), new Object[0]);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7531() {
        m7526(this.f7625.m7428(), new Object[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m7534(oM.AbstractC0160 r2) {
        this.f7625.m7435(r2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7529(oM.AbstractC0160 r2) {
        this.f7625.m7432(r2);
    }
}
