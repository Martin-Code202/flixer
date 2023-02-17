package o;

import android.content.Context;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.chromium.net.RequestFinishedInfo;
import org.json.JSONException;
/* access modifiers changed from: package-private */
/* renamed from: o.ٻ  reason: contains not printable characters */
public class C0595 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC0646 f13887;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Context f13888;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final List<AbstractC0677> f13889 = new CopyOnWriteArrayList();

    public C0595(Context context) {
        this.f13888 = context;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m14732(AbstractC0677 r2) {
        this.f13889.add(r2);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m14731(AbstractC0677 r2) {
        this.f13889.remove(r2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m14730(RequestFinishedInfo requestFinishedInfo) {
        if (this.f13887 != null) {
            RequestFinishedInfo.Metrics metrics = requestFinishedInfo.getMetrics();
            Long l = null;
            Long l2 = null;
            if (metrics != null) {
                l = metrics.getSentByteCount();
                l2 = metrics.getReceivedByteCount();
            }
            NetworkRequestType networkRequestType = null;
            for (Object obj : requestFinishedInfo.getAnnotations()) {
                if (obj instanceof NetworkRequestType) {
                    networkRequestType = (NetworkRequestType) obj;
                }
            }
            if (networkRequestType == null) {
                networkRequestType = C0655.m14819(requestFinishedInfo.getUrl()) ? NetworkRequestType.CONTENT_BOXART : null;
            }
            this.f13887.mo474(networkRequestType, requestFinishedInfo.getUrl(), l, l2);
        }
        ApplicationPerformanceMetricsLogging r2 = m14727();
        boolean r3 = m14728(requestFinishedInfo, r2);
        boolean z = !this.f13889.isEmpty();
        if (r3 || z) {
            C0678 r5 = new C0678(this.f13888, requestFinishedInfo);
            if (z) {
                for (AbstractC0677 r0 : this.f13889) {
                    r0.mo7028(r5);
                }
            }
            if (r3) {
                try {
                    r2.mo1490(r5.mo14768(), r5.m14916());
                } catch (JSONException e) {
                }
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean m14728(RequestFinishedInfo requestFinishedInfo, ApplicationPerformanceMetricsLogging applicationPerformanceMetricsLogging) {
        String url;
        if (applicationPerformanceMetricsLogging == null || (url = requestFinishedInfo.getUrl()) == null || !C0655.m14819(url)) {
            return false;
        }
        if (!applicationPerformanceMetricsLogging.mo1499(url)) {
            C1283.m16854("nf_cr_stats", "onCronetRequestFinished assetRequest not pending");
            return false;
        }
        C1283.m16851("nf_cr_stats", "onCronetRequestFinished %s", url);
        if (requestFinishedInfo.getFinishedReason() == 2) {
            return false;
        }
        return true;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private ApplicationPerformanceMetricsLogging m14727() {
        return BW.m3931();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m14729(AbstractC0646 r1) {
        this.f13887 = r1;
    }
}
