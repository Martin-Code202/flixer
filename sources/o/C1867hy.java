package o;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.service.offline.download.DownloadablePersistentData;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.io.File;
import java.util.List;
import o.hH;
/* renamed from: o.hy  reason: case insensitive filesystem */
public class C1867hy implements hH.If {

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private static final int f7460 = f7461.length;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private static final long[] f7461 = {30000, 60000};

    /* renamed from: ʻ  reason: contains not printable characters */
    private final C1865hw f7462;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final List<C1868hz> f7463;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Handler f7464;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final DownloadablePersistentData f7465;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private int f7466;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC1866hx f7467;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0482 f7468;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final File f7469;

    /* renamed from: ͺ  reason: contains not printable characters */
    private int f7470;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final hB f7471;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final Runnable f7472 = new Runnable() { // from class: o.hy.2
        @Override // java.lang.Runnable
        public void run() {
            C1867hy.this.m7364();
        }
    };

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Context f7473;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private hH f7474;

    public C1867hy(Context context, Looper looper, DownloadablePersistentData downloadablePersistentData, hD hDVar, hB hBVar, File file, C0482 r10, hA hAVar, IClientLogging iClientLogging, AbstractC1866hx hxVar) {
        this.f7473 = context;
        this.f7464 = new Handler(looper);
        this.f7465 = downloadablePersistentData;
        this.f7471 = hBVar;
        this.f7469 = file;
        this.f7468 = r10;
        this.f7467 = hxVar;
        this.f7471.f7061 = this.f7469.length();
        this.f7463 = hDVar.mo6810();
        C1868hz.m7373(this.f7463);
        this.f7462 = new C1865hw(this.f7473, hAVar, iClientLogging, this.f7469);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void m7368() {
        C1283.m16862("nf_cdnUrlDownloader", "startDownload");
        this.f7471.f7061 = this.f7469.length();
        this.f7470 = 0;
        this.f7466 = 0;
        String str = this.f7463.get(0).f7476;
        m7367();
        m7365(str);
    }

    @Override // o.hH.If
    /* renamed from: ˋ */
    public synchronized void mo6938() {
        if (this.f7469.length() >= this.f7465.mSizeOfDownloadable) {
            C1283.m16862("nf_cdnUrlDownloader", "onUrlDownloadSessionEnd download finished.");
            this.f7465.mIsComplete = true;
            this.f7462.m7360(this.f7471.f7061);
        } else {
            C1283.m16862("nf_cdnUrlDownloader", "onUrlDownloadSessionEnd not finished yet.");
        }
        this.f7467.mo6895(this);
        m7367();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m7369() {
        m7367();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m7371() {
        return this.f7465.mIsComplete;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m7370() {
        return !this.f7465.mIsComplete && this.f7474 != null;
    }

    @Override // o.hH.If
    /* renamed from: ˋ */
    public synchronized void mo6939(VolleyError volleyError) {
        int i = -1;
        if (volleyError.f128 != null) {
            i = volleyError.f128.f15527;
        }
        NetflixStatus r6 = BK.m3875(volleyError, null, StatusCode.NET_GENERAL_NETWORK_ERROR);
        m7367();
        if (!ConnectivityUtils.m2954(this.f7473)) {
            C1283.m16862("nf_cdnUrlDownloader", "onNetworkError lost connectivity.. not trying next CDN url.");
            this.f7467.mo6906(this, r6);
        } else if (C1889iq.m7728(i)) {
            C1283.m16844("nf_cdnUrlDownloader", "cdnUrlExpiredOrMoved httpStatusCode=%d", Integer.valueOf(i));
            this.f7467.mo6901(this, r6);
        } else if (C1889iq.m7737(i)) {
            C1283.m16844("nf_cdnUrlDownloader", "isCdnUrlGeoCheckError httpStatusCode=%d", Integer.valueOf(i));
            this.f7467.mo6896(this, r6);
        } else {
            if (i == 416) {
                m7367();
                this.f7469.delete();
                C1276.m16820().mo5729("http 416 error", null);
            }
            m7363();
        }
    }

    @Override // o.hH.If
    /* renamed from: ʽ */
    public synchronized void mo6937() {
        C1283.m16862("nf_cdnUrlDownloader", "onUrlDownloadDiskIOError");
        m7367();
        this.f7467.mo6900(this);
    }

    @Override // o.hH.If
    /* renamed from: ॱ */
    public void mo6941(hH hHVar) {
        this.f7471.f7061 = hHVar.m6933();
    }

    @Override // o.hH.If
    /* renamed from: ˎ */
    public void mo6940(long j) {
        if (this.f7471.f7061 == 0 && j > 0) {
            int i = (j > this.f7465.mSizeOfDownloadable ? 1 : (j == this.f7465.mSizeOfDownloadable ? 0 : -1));
        }
        if (this.f7470 >= 0 && this.f7470 < this.f7463.size()) {
            this.f7462.m7359(this.f7463.get(this.f7470), this.f7471.f7061);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public String m7372() {
        return this.f7465.mDownloadableId;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m7363() {
        if (this.f7470 != 0 || this.f7466 >= f7460) {
            this.f7470++;
            if (this.f7470 < this.f7463.size()) {
                this.f7464.removeCallbacks(this.f7472);
                this.f7464.postDelayed(this.f7472, 5000);
                return;
            }
            C1283.m16850("nf_cdnUrlDownloader", "onCdnRetryRunnable all CDN URL exhausted");
            this.f7467.mo6906(this, new NetflixStatus(StatusCode.DL_ALL_CDN_URLS_FAILED));
            return;
        }
        this.f7464.removeCallbacks(this.f7472);
        this.f7464.postDelayed(this.f7472, f7461[this.f7466]);
        this.f7466++;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼ  reason: contains not printable characters */
    private void m7364() {
        if (this.f7470 < this.f7463.size()) {
            m7365(this.f7463.get(this.f7470).f7476);
        } else {
            this.f7467.mo6906(this, new NetflixStatus(StatusCode.DL_ALL_CDN_URLS_FAILED));
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m7367() {
        this.f7464.removeCallbacksAndMessages(null);
        if (this.f7474 != null) {
            C1283.m16862("nf_cdnUrlDownloader", "doStopDownload");
            this.f7462.m7361(this.f7471.f7061);
            this.f7474.cancel();
            this.f7474 = null;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7365(String str) {
        this.f7464.removeCallbacksAndMessages(null);
        this.f7474 = new hH(str, this.f7469, Request.Priority.NORMAL, this);
        this.f7474.m6931(this.f7468);
    }
}
