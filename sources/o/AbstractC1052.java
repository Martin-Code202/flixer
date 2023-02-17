package o;

import android.content.Context;
import android.os.Handler;
import com.netflix.mediaclient.android.app.BackgroundTask;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.BookmarkStore;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.util.gfx.ImageLoader;
/* renamed from: o.ℷ  reason: contains not printable characters */
public abstract class AbstractC1052 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private long f15192;

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC1053 f15193;

    /* renamed from: ˎ  reason: contains not printable characters */
    private If f15194;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Status f15195 = AbstractC0367.f13212;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f15196;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Handler f15197;

    /* renamed from: o.ℷ$If */
    public interface If {
        /* renamed from: ʻ */
        IClientLogging mo15847();

        /* renamed from: ʻॱ */
        AbstractC0933 mo15848();

        /* renamed from: ʼ */
        mU mo15849();

        /* renamed from: ʽ */
        oD mo15850();

        /* renamed from: ˊ */
        C2003ng mo15851();

        /* renamed from: ˊॱ */
        AbstractC1250 mo15852();

        /* renamed from: ˋ */
        Context mo15853();

        /* renamed from: ˋॱ */
        AbstractC2064pm mo15854();

        /* renamed from: ˎ */
        AbstractC1221 mo15855();

        /* renamed from: ˏ */
        UserAgentInterface mo15856();

        /* renamed from: ˏॱ */
        oS mo15857();

        /* renamed from: ͺ */
        AbstractC1853hl mo15858();

        /* renamed from: ॱ */
        AbstractC1194 mo15859();

        /* renamed from: ॱˊ */
        AbstractC1897iy mo15860();

        /* renamed from: ॱˎ */
        BookmarkStore mo15861();

        /* renamed from: ॱॱ */
        oH mo15862();

        /* renamed from: ᐝ */
        AbstractC1899j mo15863();

        /* renamed from: ᐝॱ */
        ImageLoader mo15864();
    }

    /* renamed from: o.ℷ$ˋ  reason: contains not printable characters */
    public interface AbstractC1053 {
        /* renamed from: ˏ */
        void mo15866(AbstractC1052 v, Status status);
    }

    /* renamed from: ʽ */
    public abstract void mo1237();

    /* renamed from: ˊ  reason: contains not printable characters */
    public final synchronized void m16091(If r7, AbstractC1053 r8) {
        C1627cs.m5962(this);
        C1348Bu.m4093();
        C1283.m16851("nf_service_ServiceAgent", "Request to init %s", getClass().getSimpleName());
        if (this.f15196) {
            C1276.m16820().mo5731(new IllegalStateException(getClass().getSimpleName() + " init already called!"));
        } else if (r7 == null) {
            throw new NullPointerException("AgentContext can not be null");
        } else {
            this.f15194 = r7;
            this.f15196 = true;
            this.f15193 = r8;
            this.f15197 = new Handler();
            new BackgroundTask().m285(new Runnable() { // from class: o.ℷ.4
                @Override // java.lang.Runnable
                public void run() {
                    C1283.m16851("nf_service_ServiceAgent", "Initing %s", AbstractC1052.this.getClass().getSimpleName());
                    AbstractC1052.this.f15192 = System.currentTimeMillis();
                    AbstractC1052.this.mo1237();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public final synchronized void m16090(Status status) {
        C1627cs.m5964(this);
        this.f15195 = status;
        C1283.m16866("nf_service_ServiceAgent", "%s InitComplete errorCode=%d took=%d", getClass().getSimpleName(), Integer.valueOf(status.mo302().m271()), Long.valueOf(System.currentTimeMillis() - this.f15192));
        if (this.f15193 != null) {
            this.f15197.post(new Runnable() { // from class: o.ℷ.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC1052.this.f15193.mo15866(AbstractC1052.this, AbstractC1052.this.f15195);
                }
            });
        }
    }

    public synchronized boolean r_() {
        return this.f15195.mo298();
    }

    /* renamed from: ʻ */
    public void mo1236() {
        C1283.m16854("nf_service_ServiceAgent", "Destroying " + getClass().getSimpleName());
        this.f15194 = null;
    }

    /* renamed from: ˏ */
    public void mo7286(int i) {
    }

    /* renamed from: ʼ */
    public void mo5196() {
    }

    public Handler s_() {
        return this.f15197;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public Context m16093() {
        return AbstractApplicationC1258.m16692();
    }

    /* access modifiers changed from: protected */
    public AbstractC1250 t_() {
        If r1 = this.f15194;
        if (r1 != null) {
            return r1.mo15852();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public oS m16096() {
        If r1 = this.f15194;
        if (r1 != null) {
            return r1.mo15857();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ͺ  reason: contains not printable characters */
    public AbstractC0933 m16097() {
        If r1 = this.f15194;
        if (r1 != null) {
            return r1.mo15848();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public ImageLoader m16098() {
        If r1 = this.f15194;
        if (r1 != null) {
            return r1.mo15864();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻॱ  reason: contains not printable characters */
    public UserAgentInterface m16085() {
        If r1 = this.f15194;
        if (r1 != null) {
            return r1.mo15856();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˎ  reason: contains not printable characters */
    public BookmarkStore m16099() {
        If r1 = this.f15194;
        if (r1 != null) {
            return r1.mo15861();
        }
        return null;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public AbstractC1221 m16101() {
        If r1 = this.f15194;
        if (r1 != null) {
            return r1.mo15855();
        }
        return null;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public AbstractC1194 m16100() {
        If r1 = this.f15194;
        if (r1 != null) {
            return r1.mo15859();
        }
        return null;
    }

    public C2003ng u_() {
        If r1 = this.f15194;
        if (r1 != null) {
            return r1.mo15851();
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public AbstractC1899j m16095() {
        If r1 = this.f15194;
        if (r1 != null) {
            return r1.mo15863();
        }
        return null;
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public mU m16089() {
        If r1 = this.f15194;
        if (r1 != null) {
            return r1.mo15849();
        }
        return null;
    }

    public oH v_() {
        If r1 = this.f15194;
        if (r1 != null) {
            return r1.mo15862();
        }
        return null;
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public IClientLogging m16086() {
        If r1 = this.f15194;
        if (r1 != null) {
            return r1.mo15847();
        }
        return null;
    }

    /* renamed from: ʽॱ  reason: contains not printable characters */
    public oD m16087() {
        If r1 = this.f15194;
        if (r1 != null) {
            return r1.mo15850();
        }
        return null;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public AbstractC1853hl m16088() {
        If r1 = this.f15194;
        if (r1 != null) {
            return r1.mo15858();
        }
        return null;
    }

    public AbstractC1897iy w_() {
        If r1 = this.f15194;
        if (r1 != null) {
            return r1.mo15860();
        }
        return null;
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    public AbstractC2064pm m16094() {
        If r1 = this.f15194;
        if (r1 != null) {
            return r1.mo15854();
        }
        return null;
    }

    public boolean x_() {
        return this.f15196;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m16092(NetflixDataRequest netflixDataRequest) {
        AbstractC1250 t_ = t_();
        if (t_ != null) {
            return t_.mo15842(netflixDataRequest);
        }
        C1283.m16850("nf_service_ServiceAgent", "Unable to add data request! Service is null, this should NOT happen!");
        return false;
    }
}
