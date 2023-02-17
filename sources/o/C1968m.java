package o;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import com.netflix.mediaclient.service.job.NetflixJob;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/* renamed from: o.m  reason: case insensitive filesystem */
public class C1968m implements AbstractC2051p, AbstractC2023o {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final long f8663 = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final C1336Bi f8664;

    /* renamed from: ʼ  reason: contains not printable characters */
    private NetflixJob f8665;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final IClientLogging f8666;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Handler f8667;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final long f8668 = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Context f8669;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final Runnable f8670 = new Runnable() { // from class: o.m.3
        @Override // java.lang.Runnable
        public void run() {
            C1968m.this.m8780();
        }
    };

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC2228v f8671;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Set<AbstractC2078q> f8672 = new HashSet();

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean f8673 = false;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final SparseArray<AbstractC2078q> f8674 = new SparseArray<>();

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final Runnable f8675 = new Runnable() { // from class: o.m.2
        @Override // java.lang.Runnable
        public void run() {
            C1968m.this.m8785();
        }
    };

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final Runnable f8676 = new Runnable() { // from class: o.m.5
        @Override // java.lang.Runnable
        public void run() {
            C1968m.this.m8778();
        }
    };

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final AbstractC1221 f8677;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f8678;

    public C1968m(Context context, AbstractC2228v vVar, AbstractC1221 r7, IClientLogging iClientLogging) {
        this.f8669 = context;
        this.f8667 = new Handler();
        this.f8671 = vVar;
        this.f8677 = r7;
        this.f8666 = iClientLogging;
        this.f8665 = NetflixJob.m570(m8788());
        this.f8664 = new C1336Bi(10, TimeUnit.MINUTES.toMillis(10));
        if (!this.f8671.mo11321(NetflixJob.NetflixJobId.NETFLIX_MAINTENANCE)) {
            this.f8671.mo11320(this.f8665);
        }
    }

    @Override // o.AbstractC2051p
    /* renamed from: ॱ */
    public void mo7115(NetflixJob.NetflixJobId netflixJobId) {
        boolean z;
        if (!ConnectivityUtils.m2954(this.f8669)) {
            this.f8667.post(this.f8675);
        } else if (this.f8664.m4022()) {
            m8779();
        } else {
            C1996n.m9110(this.f8666.mo1512());
            ArrayList<AbstractC2078q> arrayList = new ArrayList();
            synchronized (this.f8672) {
                arrayList.addAll(this.f8672);
            }
            synchronized (this.f8674) {
                this.f8674.clear();
            }
            for (AbstractC2078q qVar : arrayList) {
                this.f8678++;
                synchronized (this.f8674) {
                    this.f8674.put(this.f8678, qVar);
                }
                qVar.mo7293(this.f8678);
            }
            synchronized (this.f8674) {
                z = this.f8674.size() == 0;
            }
            if (z) {
                this.f8667.post(this.f8675);
            }
        }
    }

    @Override // o.AbstractC2051p
    /* renamed from: ˊ */
    public void mo7114(NetflixJob.NetflixJobId netflixJobId) {
        C1996n.m9109(this.f8666.mo1512());
        ArrayList<AbstractC2078q> arrayList = new ArrayList();
        synchronized (this.f8672) {
            arrayList.addAll(this.f8672);
        }
        synchronized (this.f8674) {
            this.f8674.clear();
        }
        for (AbstractC2078q qVar : arrayList) {
            qVar.mo7292();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m8792() {
        synchronized (this.f8672) {
            this.f8672.clear();
        }
        synchronized (this.f8674) {
            this.f8674.clear();
        }
        this.f8667.removeCallbacksAndMessages(null);
    }

    @Override // o.AbstractC2023o
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8791(AbstractC2078q qVar) {
        synchronized (this.f8672) {
            this.f8672.add(qVar);
        }
    }

    @Override // o.AbstractC2023o
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo8790(AbstractC2078q qVar) {
        synchronized (this.f8672) {
            this.f8672.remove(qVar);
        }
    }

    @Override // o.AbstractC2023o
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8793(AbstractC2078q qVar, int i) {
        boolean z;
        synchronized (this.f8674) {
            this.f8674.remove(i);
            z = this.f8674.size() == 0;
        }
        if (z) {
            this.f8667.post(this.f8675);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private long m8788() {
        return TimeUnit.HOURS.toMillis((long) this.f8677.mo16551());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m8785() {
        this.f8667.removeCallbacks(this.f8676);
        long r3 = m8784(this.f8669, -1);
        long r5 = m8788();
        if (r5 <= 0) {
            m8789();
        } else if (r3 != r5) {
            m8789();
            this.f8665 = NetflixJob.m570(r5);
            m8781();
        } else {
            this.f8666.mo1504().mo5775("onMaintenanceJobDone");
            this.f8671.mo11322(NetflixJob.NetflixJobId.NETFLIX_MAINTENANCE, false);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m8789() {
        if (this.f8671.mo11321(NetflixJob.NetflixJobId.NETFLIX_MAINTENANCE)) {
            this.f8671.mo11319(NetflixJob.NetflixJobId.NETFLIX_MAINTENANCE);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8781() {
        if (!this.f8671.mo11321(NetflixJob.NetflixJobId.NETFLIX_MAINTENANCE)) {
            this.f8671.mo11320(this.f8665);
            m8782(this.f8669, this.f8665.m579());
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m8779() {
        if (!this.f8673) {
            this.f8673 = true;
            this.f8667.postDelayed(this.f8670, this.f8668);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʽ  reason: contains not printable characters */
    private void m8780() {
        this.f8673 = false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻ  reason: contains not printable characters */
    private void m8778() {
        AbstractC2078q qVar;
        synchronized (this.f8674) {
            qVar = this.f8674.size() > 0 ? this.f8674.get(0) : null;
        }
        if (qVar != null) {
            throw new RuntimeException("Failed to call notifyMaintenanceActionDone by " + qVar.getClass().getName());
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static long m8784(Context context, long j) {
        return C1339Bl.m4044(context, "maintenace_job_period", j);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m8782(Context context, long j) {
        C1339Bl.m4043(context, "maintenace_job_period", j);
    }
}
