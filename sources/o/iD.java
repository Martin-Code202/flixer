package o;

import android.os.Handler;
import com.netflix.mediaclient.servicemgr.IPlayer;
import o.iG;
import o.oM;
public class iD implements oM.iF {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Handler f7505;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final iG f7506 = new iG();

    public iD(Handler handler) {
        this.f7505 = handler;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7416(Runnable runnable) {
        this.f7505.post(runnable);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m7415(final iG.AbstractC0123 r6, final Object... objArr) {
        synchronized (this.f7506) {
            for (final oM.AbstractC0160 r3 : this.f7506.m7433()) {
                if (r3 != null && r3.ae_()) {
                    m7416(new Runnable() { // from class: o.iD.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (r3.ae_()) {
                                r6.mo7439(r3, objArr);
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m7421(oM oMVar) {
        m7415(this.f7506.m7437(), oMVar.mo895());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7424() {
        m7415(this.f7506.m7429(), new Object[0]);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7417() {
        m7415(this.f7506.m7431(), new Object[0]);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7422(int i, C1987mr mrVar) {
        m7415(this.f7506.m7436(), Integer.valueOf(i));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m7425(C1987mr mrVar) {
        m7415(this.f7506.m7438(), mrVar);
    }

    @Override // o.oM.iF
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo7418(IPlayer.aux aux) {
        m7415(this.f7506.m7430(), aux);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m7420() {
        m7415(this.f7506.m7428(), new Object[0]);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7423(oM.AbstractC0160 r2) {
        this.f7506.m7435(r2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7419(oM.AbstractC0160 r2) {
        this.f7506.m7432(r2);
    }
}
