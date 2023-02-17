package o;

import android.graphics.Point;
import android.view.View;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
public class xD implements AbstractC1978mi {

    /* renamed from: ˊ  reason: contains not printable characters */
    private oM f11955;

    /* renamed from: ˋ  reason: contains not printable characters */
    private View f11956;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC1978mi f11957;

    public xD(View view) {
        this.f11956 = view;
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˎ */
    public void mo9031() {
        AbstractC1978mi r0 = m12741();
        if (r0 != null) {
            r0.mo9031();
        }
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˏ */
    public synchronized void mo9035(C1987mr mrVar, Point point) {
        ISubtitleDef.SubtitleProfile D_ = mrVar.m9065().D_();
        if (m12740(D_)) {
            C1283.m16854("nf_subtitles", "========> Create new subtitle manager!");
            if (this.f11957 != null) {
                this.f11957.mo9027();
            }
            if (!(D_ == null || this.f11956 == null)) {
                this.f11957 = xC.m12739(D_, this.f11956);
            }
        }
        AbstractC1978mi r3 = m12741();
        if (r3 != null) {
            r3.mo9035(mrVar, point);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m12740(ISubtitleDef.SubtitleProfile subtitleProfile) {
        mo9030();
        return !(this.f11957 != null && this.f11957.mo9029(subtitleProfile));
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˎ */
    public void mo9033(boolean z) {
        AbstractC1978mi r1 = m12741();
        if (r1 != null) {
            r1.mo9033(z);
            if (this.f11956 != null && this.f11955 != null) {
                this.f11955.mo909(z);
            }
        }
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˊ */
    public void mo9027() {
        AbstractC1978mi r1;
        if (this.f11957 != null && (r1 = m12741()) != null) {
            r1.mo9027();
        }
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˏ */
    public void mo9034() {
        AbstractC1978mi r0 = m12741();
        if (r0 != null) {
            r0.mo9034();
        }
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˊ */
    public void mo9028(boolean z) {
        AbstractC1978mi r0 = m12741();
        if (r0 != null) {
            r0.mo9028(z);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private synchronized AbstractC1978mi m12741() {
        if (this.f11957 == null) {
            ISubtitleDef.SubtitleProfile subtitleProfile = null;
            if (this.f11955 != null) {
                subtitleProfile = this.f11955.mo913();
            }
            if (subtitleProfile != null) {
                this.f11957 = xC.m12739(subtitleProfile, this.f11956);
            }
        }
        return this.f11957;
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˋ */
    public ISubtitleDef.SubtitleProfile mo9030() {
        AbstractC1978mi r1 = m12741();
        if (r1 != null) {
            return r1.mo9030();
        }
        return null;
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˊ */
    public boolean mo9029(ISubtitleDef.SubtitleProfile subtitleProfile) {
        AbstractC1978mi r1 = m12741();
        if (r1 != null) {
            return r1.mo9029(subtitleProfile);
        }
        return false;
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˎ */
    public void mo9032(oM oMVar) {
        this.f11955 = oMVar;
        AbstractC1978mi r0 = m12741();
        if (r0 != null) {
            r0.mo9032(oMVar);
        }
    }
}
