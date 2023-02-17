package o;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.job.NetflixJob;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState;
import com.netflix.mediaclient.servicemgr.interface_.offline.StopReason;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
/* access modifiers changed from: package-private */
/* renamed from: o.hj  reason: case insensitive filesystem */
public class C1851hj {

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private static final int f7236 = f7237.length;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private static final long[] f7237 = {60000};

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private static final long[] f7238 = {3600000, 14400000};

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private static final int f7239 = (((f7236 + 1) * 3) - 1);

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f7240;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final List<hI> f7241;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final If f7242;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private int f7243;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final AbstractC2078q f7244;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private int f7245;

    /* renamed from: ʾ  reason: contains not printable characters */
    private int f7246 = 0;

    /* renamed from: ʿ  reason: contains not printable characters */
    private final long f7247 = TimeUnit.SECONDS.toMillis(30);

    /* renamed from: ˈ  reason: contains not printable characters */
    private boolean f7248 = true;

    /* renamed from: ˉ  reason: contains not printable characters */
    private long f7249;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Handler f7250;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private boolean f7251;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private final Runnable f7252 = new Runnable() { // from class: o.hj.3
        @Override // java.lang.Runnable
        public void run() {
            if (C1330Bc.m4002(C1851hj.this.f7264)) {
                C1851hj.this.m7060();
            }
            C1851hj.this.m7085();
        }
    };

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private ConnectivityUtils.NetType f7253;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private int f7254;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC2228v f7255;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private final Runnable f7256 = new Runnable() { // from class: o.hj.5
        @Override // java.lang.Runnable
        public void run() {
            C1851hj.this.f7242.mo7111();
        }
    };

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f7257;

    /* renamed from: ˌ  reason: contains not printable characters */
    private final Runnable f7258 = new Runnable() { // from class: o.hj.4
        @Override // java.lang.Runnable
        public void run() {
            C1851hj.this.m7081();
        }
    };

    /* renamed from: ˎ  reason: contains not printable characters */
    private final IClientLogging f7259;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC2023o f7260;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final Map<String, Integer> f7261 = new HashMap();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Handler f7262 = new Handler(Looper.getMainLooper());

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private int f7263;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Context f7264;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private NetflixJob f7265;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private int f7266;

    /* access modifiers changed from: package-private */
    /* renamed from: o.hj$If */
    public interface If {
        /* renamed from: ˊ  reason: contains not printable characters */
        void mo7107();

        /* renamed from: ˋ  reason: contains not printable characters */
        void mo7108();

        /* renamed from: ˎ  reason: contains not printable characters */
        void mo7109();

        /* renamed from: ˏ  reason: contains not printable characters */
        void mo7110();

        /* renamed from: ॱ  reason: contains not printable characters */
        void mo7111();

        /* renamed from: ॱॱ  reason: contains not printable characters */
        void mo7112();

        /* renamed from: ᐝ  reason: contains not printable characters */
        void mo7113();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m7103() {
        return this.f7251;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m7096(boolean z) {
        this.f7257 = z;
        if (!this.f7257) {
            this.f7251 = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7098() {
        this.f7251 = true;
        this.f7250.removeCallbacksAndMessages(null);
        this.f7250.post(new Runnable() { // from class: o.hj.2
            @Override // java.lang.Runnable
            public void run() {
                C1851hj.this.m7078();
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m7095() {
        this.f7251 = false;
        this.f7250.removeCallbacksAndMessages(null);
        this.f7250.postDelayed(new Runnable() { // from class: o.hj.1
            @Override // java.lang.Runnable
            public void run() {
                C1851hj.this.m7079();
            }
        }, 10000);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ͺ  reason: contains not printable characters */
    private void m7079() {
        if (!this.f7251) {
            this.f7242.mo7107();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m7078() {
        this.f7242.mo7113();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7099() {
        if (this.f7255.mo11321(this.f7265.m577())) {
            this.f7255.mo11319(this.f7265.m577());
        }
        m7082();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7091() {
        this.f7261.clear();
        m7058();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m7105() {
        this.f7259.mo1504().mo5775("onDownloadResumeJobDone");
        this.f7255.mo11322(NetflixJob.NetflixJobId.DOWNLOAD_RESUME, false);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m7089() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f7249 < 5000 ? 5000 : 1000;
        C1283.m16863("nf_downloadController", "handleConnectivityChange delay by=%d", Long.valueOf(j));
        this.f7249 = currentTimeMillis;
        this.f7250.removeCallbacks(this.f7258);
        this.f7250.postDelayed(this.f7258, j);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m7081() {
        if (this.f7248) {
            this.f7248 = false;
            C1283.m16862("nf_downloadController", "mNetworkChangeRunnable delaying the first network change event by " + TimeUnit.MILLISECONDS.toSeconds(this.f7247));
            this.f7250.removeCallbacks(this.f7252);
            this.f7250.postDelayed(this.f7252, this.f7247);
            return;
        }
        m7085();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private void m7085() {
        m7062();
        if (this.f7253 == null) {
            this.f7242.mo7110();
            C1283.m16862("nf_downloadController", "mNetworkChangeRunnable, no network.");
        } else if (this.f7265.m578(this.f7264)) {
            C1283.m16862("nf_downloadController", "handleNetworkChanged, retry the download.");
            this.f7242.mo7109();
        } else if (!this.f7265.m574(this.f7264)) {
            this.f7242.mo7108();
            C1283.m16862("nf_downloadController", "handleNetworkChanged, can't execute the job, stop downloads.");
        } else {
            C1283.m16850("nf_downloadController", "handleNetworkChanged, this shouldn't happen.");
        }
    }

    C1851hj(Context context, AbstractC2023o oVar, AbstractC2078q qVar, List<hI> list, Looper looper, If r9, boolean z, IClientLogging iClientLogging, AbstractC1250 r12, boolean z2) {
        this.f7264 = context;
        this.f7255 = AbstractApplicationC1258.getInstance().mo258();
        this.f7260 = oVar;
        this.f7244 = qVar;
        this.f7250 = new Handler(looper);
        this.f7242 = r9;
        this.f7241 = list;
        this.f7259 = iClientLogging;
        this.f7265 = NetflixJob.m568(m7094());
        r12.mo15841(NetflixJob.NetflixJobId.DOWNLOAD_RESUME, new Cif());
        if (z2) {
            m7087();
        } else {
            m7082();
        }
        this.f7240 = false;
        this.f7257 = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m7104(hI hIVar) {
        if (hIVar.mo6881() != DownloadState.Stopped) {
            C1283.m16862("nf_downloadController", "canThisPlayableBeResumedByUser no, state=" + hIVar.mo6881());
            return false;
        }
        m7065();
        if (this.f7243 > 0) {
            C1283.m16863("nf_downloadController", "canThisPlayableBeResumedByUser no, mInProgressCount=%d", Integer.valueOf(this.f7243));
            return false;
        } else if (this.f7265.m578(this.f7264)) {
            return true;
        } else {
            C1283.m16862("nf_downloadController", "canThisPlayableBeResumedByUser no, downloadResumeJob says no.");
            if (!this.f7265.m574(this.f7264)) {
                hIVar.mo6890().setDownloadStateStopped(StopReason.NotAllowedOnCurrentNetwork);
            }
            m7083();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʻ  reason: contains not printable characters */
    public void m7088() {
        if (!this.f7240) {
            this.f7250.removeCallbacksAndMessages(null);
            this.f7240 = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public hI m7106() {
        C1283.m16863("nf_downloadController", "getNextPlayableForDownload mIndexOfNextPlayable=%d", Integer.valueOf(this.f7246));
        if (this.f7257) {
            C1283.m16862("nf_downloadController", "getNextPlayableForDownload mDownloadsAreStoppedByUser=true");
            return null;
        } else if (this.f7251) {
            C1283.m16862("nf_downloadController", "getNextPlayableForDownload mIsStreaming=true");
            return null;
        } else if (this.f7241.size() <= 0) {
            C1283.m16863("nf_downloadController", "getNextPlayableForDownload all done. mOfflinePlayableList.size=%d", Integer.valueOf(this.f7241.size()));
            return null;
        } else {
            m7065();
            if (this.f7245 == this.f7241.size()) {
                C1283.m16863("nf_downloadController", "getNextPlayableForDownload all downloaded, mCompletedCount=%d", Integer.valueOf(this.f7245));
                return null;
            } else if (this.f7243 > 0) {
                C1283.m16863("nf_downloadController", "getNextPlayableForDownload already downloading, mInProgressCount=%d", Integer.valueOf(this.f7243));
                return null;
            } else if (!this.f7265.m578(this.f7264)) {
                C1283.m16862("nf_downloadController", "getNextPlayableForDownload can't execute, downloadResumeJob says no.");
                m7083();
                return null;
            } else {
                for (int size = this.f7241.size(); size > 0; size--) {
                    if (this.f7246 >= this.f7241.size()) {
                        this.f7246 = 0;
                    }
                    if (C1889iq.m7735(this.f7241.get(this.f7246))) {
                        hI hIVar = this.f7241.get(this.f7246);
                        C1283.m16863("nf_downloadController", "getNextPlayableForDownload found with errorCount=%d playableId=%s", m7072(hIVar.mo6915()), hIVar.mo6915());
                        return hIVar;
                    }
                    this.f7246++;
                }
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m7101(String str) {
        this.f7261.remove(str);
        m7070();
        m7063();
        m7058();
        m7087();
        this.f7250.removeCallbacks(this.f7256);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7092(String str) {
        this.f7261.remove(str);
        if (this.f7241.size() == 0) {
            m7058();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7093(String str, Status status) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7100(String str) {
        m7062();
        if (this.f7253 != null) {
            this.f7263++;
            C1283.m16863("nf_downloadController", "onNetworkError mNumberOfNetworkErrorsInCurrentDLWindow=%d", Integer.valueOf(this.f7263));
            m7065();
            int i = (this.f7254 * (f7236 + 1)) - 1;
            if (i > f7239) {
                i = f7239;
            }
            if (i < 2) {
                i = 2;
            }
            C1283.m16863("nf_downloadController", "maxErrorsInDlWindow=%d", Integer.valueOf(i));
            if (this.f7263 <= i) {
                int r6 = m7074(str);
                if (r6 > f7236) {
                    this.f7246++;
                    this.f7261.put(str, 1);
                    r6 = 1;
                }
                m7076(f7237[(r6 - 1) % f7237.length]);
                return;
            }
            m7069();
        } else if (this.f7255.mo11321(this.f7265.m577())) {
            C1283.m16862("nf_downloadController", "onNetworkError networkConnected=no, download resume job already scheduled.");
        } else {
            C1283.m16862("nf_downloadController", "onNetworkError networkConnected=no, scheduling download resume job");
            m7083();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʽ  reason: contains not printable characters */
    public void m7090() {
        C1283.m16862("nf_downloadController", "onStorageError removing the back-off timer");
        this.f7250.removeCallbacks(this.f7256);
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m7058() {
        this.f7262.post(new Runnable() { // from class: o.hj.9
            @Override // java.lang.Runnable
            public void run() {
                if (C1851hj.this.f7255.mo11321(C1851hj.this.f7265.m577())) {
                    C1283.m16862("nf_downloadController", "Checking if some SmartDownloads needs to kick in");
                    if (!C0880.m15595() || C2094qo.f9607.m10099().size() == 0) {
                        C1851hj.this.f7255.mo11319(C1851hj.this.f7265.m577());
                        C1283.m16862("nf_downloadController", "cancelDownloadResumeJob cancelled");
                    }
                }
            }
        });
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m7082() {
        this.f7260.mo8790(this.f7244);
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m7087() {
        this.f7260.mo8791(this.f7244);
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m7083() {
        m7067(0);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m7067(long j) {
        if (this.f7255.mo11321(this.f7265.m577())) {
            this.f7255.mo11319(this.f7265.m577());
        }
        this.f7265.m572(j);
        this.f7255.mo11320(this.f7265);
        C1283.m16863("nf_downloadController", "DownloadResumeJob scheduled minimumDelay=%d", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void m7097() {
        m7067(5000);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m7102(boolean z) {
        boolean r5 = m7094();
        C1283.m16863("nf_downloadController", "setRequiresUnmeteredNetwork oldValue=%b newValue=%b", Boolean.valueOf(r5), Boolean.valueOf(z));
        if (r5 != z) {
            C1339Bl.m4048(this.f7264, "download_requires_unmetered_network", z);
            this.f7265 = NetflixJob.m568(z);
            if (this.f7255.mo11321(this.f7265.m577())) {
                this.f7255.mo11319(this.f7265.m577());
                m7083();
            }
            m7064();
        }
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    private void m7064() {
        m7085();
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    private void m7065() {
        this.f7245 = 0;
        this.f7243 = 0;
        this.f7254 = 0;
        for (hI hIVar : this.f7241) {
            if (hIVar.mo6881() == DownloadState.Complete) {
                this.f7245++;
            } else if (hIVar.mo6881() == DownloadState.InProgress) {
                this.f7243++;
            }
        }
        this.f7254 = this.f7241.size() - this.f7245;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public boolean m7094() {
        return C1339Bl.m4051(this.f7264, "download_requires_unmetered_network", true);
    }

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private void m7062() {
        if (ConnectivityUtils.m2970(this.f7264)) {
            this.f7253 = ConnectivityUtils.m2958(this.f7264);
        } else {
            this.f7253 = null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private long m7071(long j) {
        return j + ((((long) new Random().nextInt(30)) * j) / 100);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7076(long j) {
        this.f7250.removeCallbacks(this.f7256);
        long r6 = m7071(j);
        C1283.m16844("nf_downloadController", "scheduleBackOffTimer for seconds=%d", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(r6)));
        this.f7250.postDelayed(this.f7256, r6);
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    private void m7063() {
        C1283.m16862("nf_downloadController", "resetDLWindow");
        this.f7263 = 0;
        m7060();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼॱ  reason: contains not printable characters */
    private void m7060() {
        C1283.m16862("nf_downloadController", "resetDownloadResumeJobBackOffTime");
        this.f7266 = 0;
        C1339Bl.m4042(this.f7264, "download_back_off_window_index", 0);
    }

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private void m7069() {
        m7070();
        this.f7263 = 0;
        this.f7266 = C1339Bl.m4037(this.f7264, "download_back_off_window_index", 0);
        if (this.f7266 < f7238.length) {
            m7067(m7071(f7238[this.f7266]));
            this.f7266++;
            C1339Bl.m4042(this.f7264, "download_back_off_window_index", this.f7266);
            return;
        }
        C1283.m16844("nf_downloadController", "scheduleNextDLWindow exhausted all DL windows mIndexOfDlWindowBackOffTime=%d", Integer.valueOf(this.f7266));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private int m7074(String str) {
        Integer valueOf = Integer.valueOf(m7072(str).intValue() + 1);
        this.f7261.put(str, valueOf);
        return valueOf.intValue();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private Integer m7072(String str) {
        Integer num = this.f7261.get(str);
        if (num == null) {
            return 0;
        }
        return num;
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private void m7070() {
        this.f7246 = 0;
        m7068();
    }

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private void m7068() {
        for (Map.Entry<String, Integer> entry : this.f7261.entrySet()) {
            entry.setValue(0);
        }
    }

    /* renamed from: o.hj$if  reason: invalid class name */
    class Cif implements AbstractC2051p {

        /* renamed from: ˋ  reason: contains not printable characters */
        final Runnable f7274 = new Runnable() { // from class: o.hj.if.1
            @Override // java.lang.Runnable
            public void run() {
                C1851hj.this.f7242.mo7112();
            }
        };

        /* renamed from: ॱ  reason: contains not printable characters */
        private final C1336Bi f7276 = new C1336Bi(10, TimeUnit.MINUTES.toMillis(10));

        Cif() {
        }

        @Override // o.AbstractC2051p
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo7115(NetflixJob.NetflixJobId netflixJobId) {
            C1283.m16863("nf_downloadController", "onNetflixStartJob jobId=%s", netflixJobId.toString());
            switch (netflixJobId) {
                case DOWNLOAD_RESUME:
                    boolean r5 = this.f7276.m4022();
                    C1283.m16863("nf_downloadController", "onNetflixStartJob tooFast=%b", Boolean.valueOf(r5));
                    if (!r5) {
                        C1851hj.this.f7250.removeCallbacks(this.f7274);
                        C1851hj.this.f7250.postDelayed(this.f7274, 30000);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        @Override // o.AbstractC2051p
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo7114(NetflixJob.NetflixJobId netflixJobId) {
            C1283.m16863("nf_downloadController", "onNetflixStopJob jobId=%s", netflixJobId.toString());
        }
    }
}
