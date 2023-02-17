package o;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.android.volley.Request;
import com.netflix.mediaclient.net.NetflixCronetProvider;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.chromium.net.ExperimentalCronetEngine;
/* renamed from: o.দ  reason: contains not printable characters */
public class C0658 implements AbstractC0661 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f14000;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Context f14001;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0595 f14002;

    /* renamed from: ॱ  reason: contains not printable characters */
    private ExperimentalCronetEngine f14003;

    public C0658(Context context) {
        this.f14001 = context;
        if (!NetflixCronetProvider.m466(context)) {
            this.f14000 = true;
        }
        this.f14002 = new C0595(context);
        ExperimentalCronetEngine r1 = C0655.m14817(context);
        r1.addRequestFinishedListener(C0623.m14754(this.f14002));
        this.f14003 = r1;
    }

    @Override // o.AbstractC0661
    /* renamed from: ˋ  reason: contains not printable characters */
    public HttpURLConnection mo14823(URL url) {
        return (HttpURLConnection) this.f14003.openConnection(url);
    }

    @Override // o.AbstractC0661
    /* renamed from: ˊ  reason: contains not printable characters */
    public AbstractC0644 mo14822(String str, Request.Priority priority, Map<String, String> map, Object obj) {
        return new C0671(this.f14003, str, priority, map, obj);
    }

    @Override // o.AbstractC0661
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo14825(AbstractC0677 r2) {
        if (this.f14002 != null) {
            this.f14002.m14732(r2);
        }
    }

    @Override // o.AbstractC0661
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo14828(AbstractC0677 r2) {
        if (this.f14002 != null) {
            this.f14002.m14731(r2);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m14827(AbstractC0646 r2) {
        if (this.f14002 != null) {
            this.f14002.m14729(r2);
        }
    }

    @Override // o.AbstractC0661
    /* renamed from: ˊ  reason: contains not printable characters */
    public int mo14821() {
        int downstreamThroughputKbps;
        if (this.f14003 == null || (downstreamThroughputKbps = this.f14003.getDownstreamThroughputKbps()) <= 0) {
            return -1;
        }
        return downstreamThroughputKbps;
    }

    @Override // o.AbstractC0661
    /* renamed from: ˎ  reason: contains not printable characters */
    public C0482 mo14824(AbstractC1001 r9, AbstractC0419 r10, int i, boolean z, String str) {
        C0665 r7 = new C0665(this.f14001, this.f14003, z);
        if (r7.m14860()) {
            i = 1;
        }
        return new C0482(r9, r10, i, new C1165(new Handler(Looper.getMainLooper())), str, r7);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m14826() {
        return this.f14000;
    }
}
